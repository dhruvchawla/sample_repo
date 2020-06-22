package com.bluedart.trackingapi.daoimpl;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.ImageDartAwbNo;
import com.bluedart.common.dto.ImageDartDto;
import com.bluedart.common.entity.TrackingAPIImageDart;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.trackingapi.dao.ImageDartDao;
import com.bluedart.utils.CopyUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.BLOB;

/**
 * 
 * @author DH839598
 *
 */
@Repository
public class TrackAPIImageDartDaoImpl extends BaseDaoImpl implements ImageDartDao {
	
	private static final Logger logger = Logger.getLogger(TrackAPIImageDartDaoImpl.class);
	
	

	@Override
	public Blob getPodImage(String awbNo, String ndc) {
		logger.info(" ImageDartDaoImpl : getPodImage ");
	
		Blob podImage = null;
		try{
			ImageDartDto imageDartDto = new ImageDartDto();
			Integer ndcInt = Integer.parseInt(ndc);
			Criteria criteria = getSession().createCriteria(TrackingAPIImageDart.class);
			criteria.add(Restrictions.eq("awbNo", awbNo ));
			criteria.add(Restrictions.eq("ndcNumber", ndcInt ));
			TrackingAPIImageDart imageDart = (TrackingAPIImageDart) criteria.uniqueResult();
			if(imageDart!=null){
				CopyUtils.copy(imageDart, imageDartDto);
				podImage = imageDartDto.getImageOfAwb();
			}
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
		//	logger.error(exception);
			throw new BlueDartException();
		}  finally{
			logger.debug("---------finally-----------");
		}
		logger.info(" ImageDartDaoImpl : getPodImage " + podImage);
		return podImage;
	}

	@Override
	public BLOB getPodImage(String loginId, String awbNo, String ndc) {
		logger.trace(" ImageDartDaoImpl : getPodImage ");
		
		
		BLOB Blob = null;
		try{
		Blob = getSession().doReturningWork(new ReturningWork<BLOB>() {
			@Override
			public BLOB execute(Connection connection) throws SQLException {
				CallableStatement callableStatement = null;
				BLOB blob = null;
				 try{
				callableStatement = connection.prepareCall("{call tPKG_IMAGEDART.GETIMAGE(?, ?, ?, ?)}");
				callableStatement.clearParameters();
				((OracleCallableStatement) callableStatement).setString(1, loginId);
				((OracleCallableStatement) callableStatement).setString(2, awbNo);
				((OracleCallableStatement) callableStatement).setInt(3, Integer.parseInt(ndc));
				((OracleCallableStatement) callableStatement).registerOutParameter(4, 2004);
				callableStatement.execute();

				 blob = ((OracleCallableStatement) callableStatement).getBLOB(4);
				 }catch(Exception exception){
					 logger.error("EXCEPTION TYPE :",exception);
				 }
				 finally{
					 logger.debug("---------getPodImage finally-----------");
					 CloseConnections.closeCallableStatement(callableStatement);
				 }
				 return blob;
				
			}
		});
		}catch(Exception exception){
			 logger.error("EXCEPTION TYPE :",exception);
			logger.error(exception.getMessage());
		} finally {
			
			logger.info(" ImageDartDaoImpl : getPodImage ");
		}
		return Blob;
	}

	@Override
	public List<ImageDartAwbNo> validatePodImages(List<String> awbNos, String ndc) {
		logger.trace(" ImageDartDaoImpl : validatePodImages ");
		ImageDartAwbNo imageDartAwbNo = null;
		List<ImageDartAwbNo> imageDartAwbNoList = new ArrayList<>();
		try{
			StringBuilder commaSepValueBuilder = new StringBuilder();
			for(String string : awbNos){
				commaSepValueBuilder.append(string);
				commaSepValueBuilder.append(",");
			}
			
			String awbNo =  removeLastComma(commaSepValueBuilder.toString());
			Integer ndcInt = Integer.parseInt(ndc);
			String sqlQuery = "select * from AWBIMAGE where CAWBNO IN("+awbNo+") and NDC ="+ndcInt;
			SQLQuery query = getSession().createSQLQuery(sqlQuery);
			List<Object[]> objects = query.list();
			for (Object[] obj : objects) {
				imageDartAwbNo = new ImageDartAwbNo();
				imageDartAwbNo.setAwbNo(obj[1].toString());
				imageDartAwbNoList.add(imageDartAwbNo);
			}
		} catch (Exception exception) {
			 logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new BlueDartException();
		}  finally {
			 logger.info("-------Finally block of validatePodImages --------");
		}
		logger.info(" ImageDartDaoImpl : validatePodImages ");
		return imageDartAwbNoList;
	}
	
	private String removeLastComma(String givenStr){
		return givenStr.substring(0, givenStr.length() - 1);
	}
}
