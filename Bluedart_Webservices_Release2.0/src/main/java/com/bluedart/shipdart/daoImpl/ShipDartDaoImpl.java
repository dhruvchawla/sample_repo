package com.bluedart.shipdart.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.TrackingAPILicenseDto;
import com.bluedart.common.entity.ShipDartLog;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.shipdart.dao.ShipDartDao;
import com.bluedart.shipdart.dto.AreaMstDto;
import com.bluedart.shipdart.dto.CityMstDto;
import com.bluedart.shipdart.dto.CustMstDto;
import com.bluedart.shipdart.dto.MasterListDto;
import com.bluedart.shipdart.dto.PincodeMstDto;
import com.bluedart.shipdart.dto.ShipDartDto;
import com.bluedart.shipdart.dto.ShipDartLogDto;
import com.bluedart.shipdart.dto.StatusDto;
import com.bluedart.shipdart.dto.TrackAwbDto;
import com.bluedart.trackingapi.dao.TrackingApiLicenceManagementDao;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author CH851827
 *
 */
@Repository
public class ShipDartDaoImpl extends BaseDaoImpl implements ShipDartDao{

	private static final Logger logger = Logger.getLogger(ShipDartDaoImpl.class);

	SimpleDateFormat formatter = new SimpleDateFormat(Constants.PICKUP_DATE_FORMAT);	
	
	@Autowired
	private TrackingApiLicenceManagementDao trackingApi;
	
	@Autowired
	private MISLogDao misLogDao;
	
	ShipDartDto shipDartDto = null;	
	TrackAwbDto trackDto = null;
	
	TrackingAPILicenseDto licenseDto = null;	
	MasterListDto masterListDto = null;	
	ShipDartLogDto shipDartLogDto;
	ShipDartLog shipDartLog = null;
	StatusDto statusDto = null;

	String flag = null;	
	SQLQuery query = null;
	
	/**
	 * For querying the DB to get the SDMaster.zip details
	 * 
	 * @param trackAwbDto
	 * @return ShipDartDto
	 */
	@Override
	@Transactional
	public MasterListDto downloadFile(TrackAwbDto trackAwbDto){
		
		logger.info(" ShipDartDaoImpl :: downloadFile ");
			
	    masterListDto = new MasterListDto();						
		try{		
			if((null != trackAwbDto) && (null != trackAwbDto.getLoginId()) && (null != trackAwbDto.getLicKey()))
			{			
			   licenseDto = trackingApi.showLicenseKey(trackAwbDto.getLoginId(), Constants.TYPE);
			  			   
			 if((null != licenseDto.getLicense()) && (licenseDto.getLicense().trim().length()>0)
					 && (licenseDto.getLicense().equals(trackAwbDto.getLicKey())))
			  {
				masterListDto = downloadFile(getSession(), trackAwbDto.getLoginId());
				masterListDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
			  }
			 else{
				 masterListDto.setStatusCode(Constants.SHIPDART_ERROR); 
			 }
		    }
			else if(null != trackAwbDto){	
				masterListDto = downloadFile(getSession(), trackAwbDto.getLoginId());
				masterListDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		   	}
		  }
		catch (Exception exception) {
			logger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}	
		return masterListDto;	
	 }
	
	/**
	 * To save the DownloadLog into the DB
	 * 
	 * @param loginId
	 * @param fileSize
	 * @return ShipDartDto
	 */		
	@Override
	@Transactional
	public StatusDto saveDownloadLog(String loginId, long fileSize){
		logger.info(" ShipdartDaoImpl :: saveDownloadLog ");
		
		shipDartDto = new ShipDartDto();		
		shipDartLog = new ShipDartLog();
		statusDto = new StatusDto();
				  
		try {
			String[] dt = DateUtil.getDateAndTime();	
			 
			if ((null != loginId)&&(0 != fileSize)){
				shipDartLog.setLoginId(loginId);
				shipDartLog.setFileName(Constants.SDMASTER);
				shipDartLog.setFileSize(fileSize);
				shipDartLog.setFileType(Constants.FILE_TYPE);
				shipDartLog.setStatus(Constants.FILE_STATUS);
				shipDartLog.setUploadDate(formatter.parse(dt[0]));
				shipDartLog.setUploadTime(dt[1]);
				
				getSession().save(shipDartLog);				
			
				flag = Constants.SHIPDART_SUCCESS;
			}	
		} 		
		catch (Exception exception) {
			flag = Constants.SHIPDART_ERROR;
			logger.error(exception.getMessage());
	  	 throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
	
		misLogDao.saveMIS(Constants.SHIPDART, loginId);
		logger.info(" ShipDartDaoImpl : saveDownloadLog ");
				
		statusDto.setFlag(flag);
		return statusDto;
	}
	
	/**
	 * To save and get the upload Log details from the DB
	 * 
	 * @param trackAwbDto
	 * @return ShipDartDto
	 */	
	@Override
	@Transactional
	public String saveGetUploadLog(ShipDartLogDto shipDartLogDto){
		logger.debug(" ShipdartDaoImpl :: saveUploadLog ");
		
		shipDartLog = new ShipDartLog();		
		try {
		String[] dt=DateUtil.getDateAndTime();
		
			if (null != shipDartLogDto){	
				
				shipDartLog.setLoginId(shipDartLogDto.getLoginId());
				shipDartLog.setFileName(shipDartLogDto.getFileName());
				shipDartLog.setFileSize(shipDartLogDto.getFileSize());
				shipDartLog.setFileType(shipDartLogDto.getFileType());
				shipDartLog.setStatus(shipDartLogDto.getStatus());
				shipDartLog.setUploadDate(formatter.parse(dt[0]));
				shipDartLog.setUploadTime(dt[1]);
				
                getSession().save(shipDartLog);
                
				flag = Constants.SHIPDART_SUCCESS;				
				misLogDao.saveMIS(Constants.SHIPDART, shipDartLogDto.getLoginId());
			}	
		
		} catch (Exception exception) {
			flag = Constants.SHIPDART_ERROR;
			logger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 				
		logger.debug("ShipDartDaoImpl :: saveUploadLog");
		
		return flag;
	}
		
	/**
	 * To save and get the Upload Log details from the DB
	 * 
	 * @param loginId
	 * @param logs
	 * @param fileType 
	 * @return ShipDartDto
	 */	
	@Override
	@Transactional
	public ShipDartDto getLogs(String loginId, String logs, String fileType){
		
		logger.debug("ShipdartDaoImpl :: getLogs");
	
		List<ShipDartLogDto> shipdartLogDtoList = new ArrayList<>();		
		shipDartDto = new ShipDartDto();
		try
		{
		 if(fileType.equalsIgnoreCase(Constants.FILE_TYPE)){
		     query = getSession().createSQLQuery(" select * from (Select * from uploadlog_t where LOGINID = "
					+ "'"+loginId+"' and FILETYPE = 'K' order by UPLOADDATE desc,UPLOADTIME desc)"
							+ " where rownum <= '"+logs+"' "); 
		  }		
		  List<Object[]> shipdartLogList= query.list();		
		
		  for(Object[] shipdart:shipdartLogList)	{
			  shipDartLogDto = new ShipDartLogDto();
			  
			  shipDartLogDto.setLoginId(shipdart[0].toString());
			  shipDartLogDto.setFileName(null!=shipdart[1]?shipdart[1].toString():"null");
			  shipDartLogDto.setUploadDate(formatter.format(shipdart[2]));
			  shipDartLogDto.setUploadTime(shipdart[3].toString());
			  shipDartLogDto.setFileSize(Long.parseLong(shipdart[4].toString()));
			  shipDartLogDto.setStatus(null!=shipdart[5]?shipdart[5].toString():"null");
			  shipDartLogDto.setFileType(shipdart[6].toString());
			  shipdartLogDtoList.add(shipDartLogDto);
			
		   }
		   shipDartDto.setShipdartLogDtoList(shipdartLogDtoList);
		 	  
		 }
		catch (Exception exception) {
			logger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 		
		logger.debug("ShipDartDaoImpl :: getUploadLog");
		
		return shipDartDto;
	}
	
	/**
	 * To get the WayBillRequisition details from the DB
	 * 
	 * @param trackAwbDto
	 * @return ShipDartDto
	 */
	@Override
	@Transactional
	public ShipDartDto showUsage(TrackAwbDto trackAwbDto){		
		logger.debug(" ShipDartDaoImpl:: showUsage ");	
		
		trackDto = new TrackAwbDto();
		shipDartDto =  new ShipDartDto();
		
		licenseDto = trackingApi.showLicenseKey(trackAwbDto.getLoginId(), Constants.TYPE);					
		if((null != licenseDto.getLicense()) && (licenseDto.getLicense().trim().length()>0) && (licenseDto.getLicense().equals(trackAwbDto.getLicKey()))){
		  try {		
			  trackDto = getSession().doReturningWork(new ReturningWork<TrackAwbDto>() {
					@Override
					public TrackAwbDto execute(Connection connection) throws SQLException {							
						CallableStatement callableStatement = null;		
						try{
						String procedureCall = "{ call uprofile4.PKG_SHIPDART.SD_GETAWBNOS(?,?,?,?,?,?)}";
						callableStatement = connection.prepareCall(procedureCall);						
						callableStatement.clearParameters();	
						
						callableStatement.setString(1, trackAwbDto.getLoginId());
						logger.info("---------LOGINID------"+ trackAwbDto.getLoginId());
						callableStatement.setString(2, trackAwbDto.getProdCode());
						logger.info("---------PRODCODE------"+ trackAwbDto.getProdCode());
						callableStatement.setString(3, trackAwbDto.getAwbStartNo());
						logger.info("---------AEBSTARTNO------"+ trackAwbDto.getAwbStartNo());
						callableStatement.setString(4, trackAwbDto.getAwbEndNo());
						logger.info("---------AEBENDNO------"+ trackAwbDto.getAwbEndNo());
						callableStatement.registerOutParameter(3, Constants.AWBSTARTNO);
						callableStatement.registerOutParameter(4, Constants.AWBENDNO);
						callableStatement.registerOutParameter(6, Constants.ERRORCODE);	
						
						callableStatement.setInt(5, trackAwbDto.getQty());	
						logger.info("---------SETQTY------"+ trackAwbDto.getQty());
						
						callableStatement.execute();	
						
						trackAwbDto.setAwbStartNo(callableStatement.getString(3));
						logger.info("---------OUTAwbStartNo------"+ trackAwbDto.getAwbStartNo());
						trackAwbDto.setAwbEndNo(callableStatement.getString(4));
						logger.info("---------OUTawbend------"+ trackAwbDto.getAwbEndNo());
						trackAwbDto.setErrorCode(callableStatement.getInt(6));	
						logger.info("---------OUTerrorCode------"+ trackAwbDto.getErrorCode());				
					
						}catch(Exception exception){
							
						}finally{
							logger.debug("---------------showUsage finally--------------");
							CloseConnections.closeCallableStatement(callableStatement);
						}
					return trackAwbDto;
				   } });}
			 catch (Exception exception) {
				logger.error(exception.getMessage());
			    throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
							ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			}	
		}							
		else {
			 trackAwbDto.setErrorCode(4);
			 trackAwbDto.setErrorMessage(Constants.LICENSE_ERROR);
		}
		 logger.debug("ShipDartDaoImpl :: showUsage");
		 
		 shipDartDto.setTrackAwbDto(trackAwbDto);		 		 
		return shipDartDto;			
	}
	
 private MasterListDto downloadFile(Session session, String loginId){
	
	masterListDto = new MasterListDto();	
	StringBuilder areaQuery = new StringBuilder();
	
	long startTime1 = System.currentTimeMillis();
	try{
        areaQuery.append("SELECT distinct ");
		areaQuery.append("RPAD(CAREA,3,' ') CAREA,");
		areaQuery.append("RPAD(NVL(CAREADESC,' '),25,' ') CAREADESC,");
	    areaQuery.append("RPAD(NVL(CSCRCD,' '),3,' ') CSCRCD,");
	    areaQuery.append("RPAD(NVL(CSCRCDDESC,' '),25,' ') CSCRCDDESC,");
	    areaQuery.append("RPAD(NVL(CSTATE,' '),30,' ') CSTATE,");
	    areaQuery.append("RPAD(NVL(CTEL,' '),30,' ') CTEL,");
		areaQuery.append("RPAD(NVL(CFAX,' '),7,' ') CFAX,");
		areaQuery.append("RPAD(NVL(BEMBARGO,' '),1,' ') BEMBARGO,");
		areaQuery.append("RPAD(NVL(CDPSERV,' '),1,' ') CDPSERV,");
		areaQuery.append("RPAD(NVL(CIPSERV,' '),1,' ') CIPSERV,");
		areaQuery.append("RPAD(NVL(CAPESERV,' '),1,' ') CAPESERV,");
		areaQuery.append("RPAD(NVL(CSFCSERV,' '),1,' ') CSFCSERV,");
		areaQuery.append("RPAD(NVL(CCLUSTER,' '),3,' ') CCLUSTER,");
		areaQuery.append("RPAD(NVL(CLOCTYPE,' '),1,' ') CLOCTYPE,");
		areaQuery.append("RPAD(NVL(CCODSERV,' '),1,' ') CCODSERV,");
		areaQuery.append("RPAD(NVL(CFODSERV,' '),1,' ') CFODSERV,");
		areaQuery.append("RPAD(NVL(CCRDSERV,' '),1,' ') CCRDSERV,");
		areaQuery.append("RPAD(NVL(CPBAGDST,' '),3,' ') CPBAGDST,");
		areaQuery.append("RPAD(NVL(CIATACODE,' '),3,' ') CIATACODE,");
		areaQuery.append("RPAD(NVL(CDPZNB,' '),1,' ') CDPZNB,");
		areaQuery.append("RPAD(NVL(CREGION,' '),6,' ') CREGION,");
		areaQuery.append("RPAD(NVL(BCMPLOC,' '),1,' ') BCMPLOC,");
		areaQuery.append("RPAD(NVL(CCNTRYCODE,' '),2,' ') CCNTRYCODE,");
		areaQuery.append("RPAD(NVL(CRPSERV,' '),1,' ') CRPSERV,");
		areaQuery.append("RPAD(NVL(CRPASERV, ' '),1,' ') CRPASERV,");
		areaQuery.append("RPAD(NVL(CRAPXSERV,' '),1,' ') CRAPXSERV,");
		areaQuery.append("RPAD(NVL(CRSFCSERV,' '),1,' ') CRSFCSERV");
		areaQuery.append(" FROM WEBMASTER.AREAMST"); 
			  				    		 	 
	     SQLQuery sqlQuery1 = session.createSQLQuery(areaQuery.toString());
	 	 
	 	 long endTime1 = System.currentTimeMillis();
	 	 		 	 
	 	 AreaMstDto areaMstDto;
	     List<Object[]> objects1 = sqlQuery1.list();
	     logger.debug("That took " + (endTime1 - startTime1) + " milliseconds");
	 	     
		 List<AreaMstDto> areaMstDtoList = new ArrayList<>();			 
		 for (Object[] dataStream : objects1) {
				areaMstDto = new AreaMstDto();
				
				areaMstDto.setCarea(dataStream[0].toString());
				areaMstDto.setCareadesc(dataStream[1].toString());
				areaMstDto.setCscrcd(dataStream[2].toString());
				areaMstDto.setCscrcddesc(dataStream[3].toString());
				areaMstDto.setCstate(dataStream[4].toString());
				areaMstDto.setCtel(dataStream[5].toString());
				areaMstDto.setCfax(dataStream[6].toString());
				areaMstDto.setBembargo(dataStream[7].toString());
				areaMstDto.setCdpserv(dataStream[8].toString());
				areaMstDto.setCipserv(dataStream[9].toString());
				areaMstDto.setCapeserv(dataStream[10].toString());
				areaMstDto.setCsfcserv(dataStream[11].toString());
				areaMstDto.setCcluster(dataStream[12].toString());
				areaMstDto.setCloctype(dataStream[13].toString());
				areaMstDto.setCcodserv(dataStream[14].toString());
				areaMstDto.setCfodserv(dataStream[15].toString());
				areaMstDto.setCcrdserv(dataStream[16].toString());
				areaMstDto.setCpbagdst(dataStream[17].toString());
				areaMstDto.setCiatacode(dataStream[18].toString());
				areaMstDto.setCdpznb(dataStream[19].toString());
				areaMstDto.setCregion(dataStream[20].toString());
				areaMstDto.setBcmploc(dataStream[21].toString());
				areaMstDto.setCcntrycode(dataStream[22].toString());
				areaMstDto.setCrpserv(dataStream[23].toString());
				areaMstDto.setCrpaserv(dataStream[24].toString());
				areaMstDto.setCrapxserv(dataStream[25].toString());
				areaMstDto.setCrsfcserv(dataStream[26].toString());
												
				areaMstDtoList.add(areaMstDto);
			}
		    
		    masterListDto.setAreaMstDtoList(areaMstDtoList);
							
			logger.debug(" ShipDartDBManager :: AreaMaster Size " + areaMstDtoList.size());
			
			StringBuilder custQuery = new StringBuilder();
  			
			long startTime2 = System.currentTimeMillis();
			
            custQuery.append("SELECT distinct ");
			custQuery.append("RPAD(NVL(A.CAREA,' '),3,' ') CAREA,");
			custQuery.append("RPAD(NVL(A.CCUSTCODE,' '),6,' ') CCUSTCODE,");
		    custQuery.append("RPAD(NVL(A.CSCRCD,' '),3,' ') CSCRCD,");
		    custQuery.append("RPAD(NVL(A.CCUSTNAME,' '),30,' ') CCUSTNAME,");
		    custQuery.append("RPAD(NVL(A.CCONTACT,' '),30,' ') CCONTACT,");
		    custQuery.append("RPAD(NVL(A.CCUSTADR1,' '),30,' ') CCUSTADR1,");
			custQuery.append("RPAD(NVL(A.CCUSTADR2,' '),30,' ') CCUSTADR2,");
			custQuery.append("RPAD(NVL(A.CCUSTADR3,' '),30,' ') CCUSTADR3,");
			custQuery.append("RPAD(NVL(A.CCUSTPIN,' '),6,' ') CCUSTPIN,");
			custQuery.append("RPAD(NVL(A.CCUSTTEL,' '),15,' ') CCUSTTEL,");
			custQuery.append("RPAD(NVL(A.CCUSTTLX,' '),10,' ') CCUSTTLX,");
			custQuery.append("RPAD(NVL(A.CCUSTFAX,' '),10,' ') CCUSTFAX,");
			custQuery.append("RPAD(NVL(A.CCSHCRD,' '),1,' ') CCSHCRD,");
			custQuery.append("RPAD(NVL(A.BOFFCR,' '),1,' ') BOFFCR,");
			custQuery.append("RPAD(NVL(A.BSPSLAB,' '),1,' ') BSPSLAB,");
			custQuery.append("RPAD(NVL(A.CWGTFLG,' '),10,' ') CWGTFLG,");
			custQuery.append("RPAD(NVL(A.CPFLAG,' '),10,' ') CPFLAG");
			custQuery.append(" FROM CUSTMST A,AFFILIATES_T B");
			custQuery.append(" WHERE B.LOGINID = '" + loginId + "'");
			custQuery.append(" AND A.CAREA = B.AFF_AC AND A.CCUSTCODE = B.AFF_CC");
					  						
			SQLQuery sqlQuery2 = session.createSQLQuery(custQuery.toString());
			CustMstDto custMstDto;
			long endTime2 = System.currentTimeMillis();
			
			List<Object[]> objects2 = sqlQuery2.list();
			logger.debug("That took " + (endTime2 - startTime2) + " milliseconds");
					
					List<CustMstDto> custMstDtoList = new ArrayList<>();
											
					for (Object[] dataStream : objects2) {
						custMstDto = new CustMstDto();
						
						custMstDto.setCarea(dataStream[0].toString());
						custMstDto.setCcustcode(dataStream[1].toString());
						custMstDto.setCscrcd(dataStream[2].toString());
						custMstDto.setCcustname(dataStream[3].toString());
						custMstDto.setCcontact(dataStream[4].toString());
						custMstDto.setCcustadr1(dataStream[5].toString());
						custMstDto.setCcustadr2(dataStream[6].toString());
						custMstDto.setCcustadr3(dataStream[7].toString());
						custMstDto.setCcustpin(dataStream[8].toString());
						custMstDto.setCcusttel(dataStream[9].toString());
						custMstDto.setCcusttlx(dataStream[10].toString());
						custMstDto.setCcustfax(dataStream[11].toString());
						custMstDto.setCcshcrd(dataStream[12].toString());
						custMstDto.setBoffcr(dataStream[13].toString());
						custMstDto.setBspslab(dataStream[14].toString());
						custMstDto.setCwgtflg(dataStream[15].toString());
						custMstDto.setCpflag(dataStream[16].toString());
						
						custMstDtoList.add(custMstDto);
					}
					masterListDto.setCustMstDtoList(custMstDtoList);
							
			logger.debug(" ShipDartDBManager :: CustomerMaster Size " + custMstDtoList.size());
						
			StringBuilder cityQuery = new StringBuilder();
			long startTime3 = System.currentTimeMillis();
			
			cityQuery.append("SELECT distinct ");
			cityQuery.append("RPAD(A.CCITYCODE,3,' ') CCITYCODE,");
			cityQuery.append("RPAD(NVL(A.CCITYNAME,' '),20,' ') CCITYNAME,");
			cityQuery.append("RPAD(NVL(A.CCNTRYCODE,' '),2,' ') CCNTRYCODE,");
			cityQuery.append("RPAD(NVL(B.CCNTRYNAME,' '),20,' ') CCNTRYNAME");
			cityQuery.append(" FROM CITYMST A,CNTRYMST B");	
			cityQuery.append(" WHERE A.CCNTRYCODE = B.CCNTRYCODE");
		
			
		   	SQLQuery sqlQuery3 = session.createSQLQuery(cityQuery.toString());
		   	CityMstDto cityMstDto;
		   	long endTime3 = System.currentTimeMillis();
		   	
					List<Object[]> objects3 = sqlQuery3.list();
				logger.info("That took " + (endTime3 - startTime3) + " milliseconds");
					
					List<CityMstDto> cityMstDtoList = new ArrayList<>();
					for (Object[] dataStream : objects3) {
						cityMstDto = new CityMstDto();
																				
						cityMstDto.setCcitycode(dataStream[0].toString());
						cityMstDto.setCcityname(dataStream[1].toString());
						cityMstDto.setCcntrycode(dataStream[2].toString());
						cityMstDto.setCcntryname(dataStream[3].toString());
						
						cityMstDtoList.add(cityMstDto);
					}
					masterListDto.setCityMstDtoList(cityMstDtoList);
					
			logger.debug(" ShipDartDBManager :: CityMaster Size " + cityMstDtoList.size());
			
			StringBuilder pincdQuery = new StringBuilder();
			long startTime4 = System.currentTimeMillis();
						
			pincdQuery.append("SELECT distinct ");
			pincdQuery.append("RPAD(CPINCODE,6,' ') CPINCODE,");
			pincdQuery.append("RPAD(NVL(CPINDESC,' '),25,' ') CPINDESC,");
			pincdQuery.append("RPAD(CAREA,3,' ') CAREA,");
			pincdQuery.append("RPAD(NVL(CSCRCD,' '),3,' ') CSCRCD,");
			pincdQuery.append("RPAD(NVL(CSERVFLAG,' '),1,' ') CSERVFLAG,");
			pincdQuery.append("RPAD(NVL(CCRCRDSCR,' '),3,' ') CCRCRDSCR,");
			pincdQuery.append("RPAD(NVL(CFLAG,' '),30,' ') CFLAG");
			pincdQuery.append(" FROM PINCDMST");
			pincdQuery.append(" WHERE NVL(CFLAG,'*') <> 'N'  AND ((instr(cprodcode, 'D') > 0) AND nvl(CSERVFLAG, 'X') = 'O')");
			pincdQuery.append(" OR (nvl(CSERVFLAG, 'X') != 'O')");
			    
		    
			SQLQuery sqlQuery4 = session.createSQLQuery(pincdQuery.toString());
			PincodeMstDto pincodeMstDto;
			long endTime4 = System.currentTimeMillis();
			
					List<Object[]> objects4 = sqlQuery4.list();
					logger.info("That took " + (endTime4 - startTime4) + " milliseconds");
					
					List<PincodeMstDto> pincodeMstDtoList = new ArrayList<>();
					for (Object[] dataStream : objects4) {
						pincodeMstDto = new PincodeMstDto();
						
						pincodeMstDto.setCpincode(dataStream[0].toString());
						pincodeMstDto.setCpindesc(dataStream[1].toString());
						pincodeMstDto.setCarea(dataStream[2].toString());
						pincodeMstDto.setCscrcd(dataStream[3].toString());
						pincodeMstDto.setCservflag(dataStream[4].toString());
						pincodeMstDto.setCcrcrdscr(dataStream[5].toString());
						pincodeMstDto.setCflag(dataStream[6].toString());
						
						pincodeMstDtoList.add(pincodeMstDto);
					}					
					masterListDto.setPincodeMstDtoList(pincodeMstDtoList);													
													
			logger.debug(" ShipDartDBManager :: PincodeMaster Size " + pincodeMstDtoList.size());	
	}catch (Exception exception) {
		logger.error(exception.getMessage());
		throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
				ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
	}
	return masterListDto;			
   }
 @Override
	@Transactional
	public ShipDartDto validateLicenseKey(TrackAwbDto trackAwbDto) {
		logger.debug(" ShipdartDaoImpl :: saveUploadLog ");
        try{
		//shipDartLog = new ShipDartLog();
		shipDartDto=new ShipDartDto();
		licenseDto = trackingApi.showLicenseKey(trackAwbDto.getLoginId(), Constants.TYPE);
		if (licenseDto!=null && (null != licenseDto.getLicense()) && (licenseDto.getLicense().trim().length() > 0)
				&& (licenseDto.getLicense().equals(trackAwbDto.getLicKey()))) {
			shipDartDto.setStatusCode("1");
		} else {
			//shipDartLog.setStatus("-1");
			shipDartDto.setStatusCode("-1");
			shipDartDto.setStatusMessage(Constants.LICENSE_ERROR);
		}}
        catch(Exception e){
        	shipDartDto.setStatusCode("-1");
			shipDartDto.setStatusMessage(Constants.LICENSE_ERROR);
        }
		shipDartDto.setshipDartDto(shipDartDto); 		 
		return shipDartDto;	
		
}
}


