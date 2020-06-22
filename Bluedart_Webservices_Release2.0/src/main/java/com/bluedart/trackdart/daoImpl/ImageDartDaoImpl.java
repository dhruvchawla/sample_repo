package com.bluedart.trackdart.daoImpl;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.entity.ImageDart;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.trackdart.dao.ImageDartDao;
import com.bluedart.trackdart.dto.ImageDartDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.StringUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BLOB;
/**
 * 
 * @author DH839598
 *
 */
@Repository
public class ImageDartDaoImpl extends BaseDaoImpl implements ImageDartDao {

	private static final Logger log = Logger.getLogger(ImageDartDaoImpl.class);

	@Transactional
	@Override 
	public List<ImageDartDto> validateAndGetPodImages(String awbNos, String ndc,String loginId) {
		log.debug(" ImageDartDaoImpl : validatePodImages");
		
		
		
		ImageDartDto imageDartDto = null;
		Map<String,String> awbNumbersMap = new HashMap();;
		List<ImageDartDto> imageDartDtoList = new ArrayList<>();
		byte[] blobAsBytes = null;
		try {
			//String awbWithPerm="",awbWithoutPerm="";
			Integer ndcInt = Integer.parseInt(ndc);
			
			String sqlQuery;
			if (ndcInt == 0) {
				sqlQuery = "select * from AWBIMAGE where CAWBNO IN(" + awbNos + ") and NDC =" + ndcInt;
			} else if(ndcInt == 1) {
				sqlQuery = "select * from AWBIMAGE where CAWBNO IN(" + awbNos + ") and NDC >" + 0;
			}else{
				sqlQuery = "select * from AWBIMAGE where CAWBNO IN(" + awbNos + ") and NDC >=" + 0;
			} 

			if (StringUtils.hasValid(loginId) && !"null".equalsIgnoreCase(loginId)) {
				awbNumbersMap =  getDCImagePermission(loginId, awbNos);
		    }
			SQLQuery query = getSession().createSQLQuery(sqlQuery);
			List<Object[]> objects = query.list();
			for (Object[] obj : objects) {
				imageDartDto = new ImageDartDto();
				Blob blob = (Blob) obj[0];
				int blobLength = (int) blob.length();
				blobAsBytes = blob.getBytes(1, blobLength);
				String wayBillNumber =obj[1].toString();
			
				imageDartDto.setAwbNo(wayBillNumber);
				if(awbNumbersMap != null && !(awbNumbersMap.isEmpty()) && awbNumbersMap.containsKey(wayBillNumber) && awbNumbersMap.get(wayBillNumber) != null){
				if(awbNumbersMap.get(wayBillNumber).equalsIgnoreCase("Y")){
					imageDartDto.setImagePermission(true);
				}else if(awbNumbersMap.get(wayBillNumber).equalsIgnoreCase("N")){
					imageDartDto.setImagePermission(false);
				}else{
					imageDartDto.setImagePermission(false);
				}
				}else{
					imageDartDto.setImagePermission(false);
				}
				boolean isDCImage = false;
				if (obj[3] != null) {
					int ndcValue = Integer.parseInt(obj[3].toString());
						if (ndcValue > 0) {
							isDCImage = true;
						}
				}
				imageDartDto.setByteImage(blobAsBytes);
				imageDartDto.setDCImage(isDCImage);
				imageDartDtoList.add(imageDartDto);
				
			}
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return imageDartDtoList;
	}

	@Transactional
	@Override
	public List<Blob> getPodImage(String awbNos, String ndc) {
		log.debug(" ImageDartDaoImpl : getPodImage");
		Blob podImage = null;
		List<Blob> blobList = null;
		List<String> awbNoList = null;
		try {
			awbNoList = new ArrayList<>(Arrays.asList(awbNos.trim().split(",")));
			blobList = new ArrayList<>();
			Integer ndcInt = Integer.parseInt(ndc);
			for (String awbNo : awbNoList) {
				Criteria criteria = getSession().createCriteria(ImageDart.class);
				criteria.add(Restrictions.eq("awbNo", awbNo));
				criteria.add(Restrictions.eq("ndcNumber", ndcInt));
				ImageDart imageDart = (ImageDart) criteria.uniqueResult();

				if (null != imageDart) {
					podImage = imageDart.getImageOfAwb();
					blobList.add(podImage);
				}
			}
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} finally {
			blobList = null;
		}
		return blobList;
	}

	@Transactional
	@Override
	public BLOB getPodImage(String loginId, String awbNo, String ndc) {
		log.debug(" ImageDartDaoImpl : getPodImage ");
	
		BLOB Blob = null;
		try {
			Blob = getSession().doReturningWork(new ReturningWork<BLOB>() {
				@Override
				public BLOB execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					try{
					callableStatement = connection.prepareCall("{call tPKG_IMAGEDART.GETIMAGE(?, ?, ?, ?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setString(1, loginId);
					((OracleCallableStatement) callableStatement).setString(2, awbNo);
					((OracleCallableStatement) callableStatement).setInt(3, Integer.parseInt(ndc));
					((OracleCallableStatement) callableStatement).registerOutParameter(4, 2004);
					callableStatement.execute();

					BLOB blob = ((OracleCallableStatement) callableStatement).getBLOB(4);

					return blob;
					}catch(Exception exception){
						log.error("EXCEPTION TYPE :",exception);
						log.error("----------getPodImage---------"+exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
	
					}finally{
						log.debug("----------getPodImage finally---------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			log.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} finally {
		}
		return Blob;
	}
	
	
	@Transactional
	
	public Map<String,String> getDCImagePermission(String loginId, String awbNo) {
		
		Map<String,String> imageAwbNos = new HashMap();
		
		try{
			Map<String,String> imageAwbNo = new HashMap(); ;
			
			Properties properties = new Properties();
			
			try { 
				properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
			} catch (IOException e) {
				log.error("EXCEPTION TYPE :",e);
				 log.error(e.getMessage());
				 throw new DataBaseException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
			}
	  
			List<String> awbnos = new ArrayList<>(Arrays.asList(awbNo.replace("\'", "").split(",")));
			 
			imageAwbNos = getSession().doReturningWork(new ReturningWork<Map<String,String>>() {
				@Override
				public Map<String,String> execute(Connection connection) throws SQLException {
					CallableStatement callableStatement= null;
					ResultSet result = null;
					try{
					String[] listOfValidAwbNos = null;
					if (!StringUtils.isNullOrEmpty(awbnos)) {
						listOfValidAwbNos = awbnos.toArray(new String[awbnos.size()]);
					}
					ArrayDescriptor descAwbnoList = ArrayDescriptor
							.createDescriptor(properties.getProperty(Constants.NUMLIST), connection);
					ARRAY awbnoList = new ARRAY(descAwbnoList, connection, listOfValidAwbNos);
					callableStatement = connection.prepareCall("{call uprofile4.TNT_MANG_new.getdcpodPERMISSION(?, ?, ?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setString(1, loginId.toUpperCase());
					((OracleCallableStatement) callableStatement).setArray(2, awbnoList);
					
					((OracleCallableStatement) callableStatement).registerOutParameter(3, OracleTypes.CURSOR);
					callableStatement.execute();
					
					result = (ResultSet) callableStatement.getObject(3);
					if (null != result) {
						
						while (result.next()) {
								imageAwbNo.put(result.getString(1),result.getString(2) );
						}
					}
					
						return imageAwbNo;
				}catch(Exception exception){
					log.error("EXCEPTION TYPE :",exception);
					log.error("----------getDCImagePermission---------"+exception.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());

				}finally{
					log.debug("----------getDCImagePermission finally---------");
					CloseConnections.closeResultSet(result);
					CloseConnections.closeCallableStatement(callableStatement);
				}
				}
				
			});
			   
		}catch(Exception e){
			log.error("EXCEPTION TYPE :",e);
			log.error("----------getDCImagePermission---------"+e.getMessage());
		}
		

		return imageAwbNos;
	}

}
