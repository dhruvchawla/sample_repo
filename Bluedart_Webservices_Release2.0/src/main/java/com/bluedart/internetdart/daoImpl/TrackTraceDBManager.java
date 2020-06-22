package com.bluedart.internetdart.daoImpl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.PodDto;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.internetdart.dto.SearchDto;
import com.bluedart.internetdart.dto.ViewOnlineDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;

/**
 * 
 * @author DH839598
 *
 */
@Component
@PropertySource("classpath:procedure.properties")
public class TrackTraceDBManager extends BaseDaoImpl {

	private static final Logger log = Logger.getLogger(TrackTraceDBManager.class);

	@Autowired
	private Environment environment;

	/**
	 * 
	 * @param session
	 * @param loginId
	 * @param fromDate
	 * @param toDate
	 * @param prodCode
	 * @param status
	 * @param origin
	 * @param dest
	 * @param sortBy
	 * @param sortOrder
	 * @param pageSize
	 * @param pageNo
	 * @param reqScanFlag
	 * @param reqAffiliatesFlag
	 * @return
	 * @throws IOException
	 */
	@Transactional
	public ViewOnlineDto trackByLoginID(java.sql.Date fromDate, java.sql.Date toDate, SearchDto searchDto) {
		log.debug("TrackTraceDBManager : trackByLoginID");
		ViewOnlineDto trackDto = null;
		try {
			trackDto = getSession().doReturningWork(new ReturningWork<ViewOnlineDto>() {
				@Override
				public ViewOnlineDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement= null;
					ViewOnlineDto trackDto = new ViewOnlineDto();
					try{
					List commonDto = null;
					List<PodDto> podList = null;
					List<ShipmentDto> shipmentList = null;
					Map<String, Class<?>> map = connection.getTypeMap();
					try {
						map.put(environment.getProperty(Constants.SHIPOBJ), Class.forName(Constants.SHIPMENT_DTO));
						map.put(environment.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
					} catch (Exception exception) {
						//log.error(exception);
						log.error("EXCEPTION TYPE :",exception);
						
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}
					connection.setTypeMap(map);
					callableStatement = connection.prepareCall(
							"{call tnt_mang.trackByLoginID(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )}");
					callableStatement.clearParameters();

					((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
							environment.getProperty(Constants.PODLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
							environment.getProperty(Constants.SHIPLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.NUMERIC);
					((OracleCallableStatement) callableStatement).setString(4, searchDto.getLoginId());
					((OracleCallableStatement) callableStatement).setDate(5, fromDate);
					((OracleCallableStatement) callableStatement).setDate(6, toDate);
					if (searchDto.getProdCode() != null && searchDto.getProdCode().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(7, searchDto.getProdCode());
					} else {
						((OracleCallableStatement) callableStatement).setString(7, "");
					}

					if (searchDto.getStatus() != null && searchDto.getStatus().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(8, searchDto.getStatus());
					} else {
						((OracleCallableStatement) callableStatement).setString(8, "");
					}

					((OracleCallableStatement) callableStatement).setString(9, searchDto.getOrigin());
					((OracleCallableStatement) callableStatement).setString(10, searchDto.getDest());
					((OracleCallableStatement) callableStatement).setString(11, searchDto.getSortBy());
					((OracleCallableStatement) callableStatement).setString(12, searchDto.getSortOrder());
					((OracleCallableStatement) callableStatement).setInt(13, searchDto.getPageSize().intValue());
					((OracleCallableStatement) callableStatement).setInt(14, searchDto.getPageNo().intValue());
					((OracleCallableStatement) callableStatement).setInt(15, searchDto.getReqScanFlag());
					((OracleCallableStatement) callableStatement).setInt(16, searchDto.getReqAffiliatesFlag());
					callableStatement.execute();

					ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
					ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
					long recordSize = ((OracleCallableStatement) callableStatement).getLong(3);
					// No Record
					if (recordSize <= 0) {
						trackDto.setRecordSize(recordSize);
						trackDto.setLimitExceeded(false);
						return trackDto;
					}
					// More then Config record size
					String thresholdLimitStr = environment.getProperty("THRESHOLD_LIMIT");
					if (Integer.parseInt(thresholdLimitStr) > recordSize) {
						trackDto.setRecordSize(recordSize);
						trackDto.setLimitExceeded(false);

						if (shipArayList != null && shipArayList.length() != 0) {
							commonDto = Arrays.asList((Object[]) shipArayList.getArray());
							shipmentList = new ArrayList<>(commonDto);
							trackDto.setShipmentList(shipmentList);
						}

						if (podArrayList != null && podArrayList.length() != 0) {
							commonDto = Arrays.asList((Object[]) podArrayList.getArray());
							podList = new ArrayList<>(commonDto);
							trackDto.setPodList(podList);
						}
					} else {
						trackDto.setRecordSize(recordSize);
						trackDto.setLimitExceeded(true);
						return trackDto;
					}
					}catch(Exception exception){
						log.error("EXCEPTION TYPE :",exception);
						
						log.error("----------trackByLoginID---------"+exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						log.debug("----------trackByLoginID finally---------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return trackDto;
				}
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return trackDto;
	}

	/**
	 * 
	 * @param session
	 * @param custCode
	 * @param areaCode
	 * @param fromDate
	 * @param toDate
	 * @param prodCode
	 * @param status
	 * @param dest
	 * @param sortBy
	 * @param sortOrder
	 * @param pageSize
	 * @param pageNo
	 * @param secLevel
	 * @param requiredFlag
	 * @return
	 * @throws IOException
	 */
	// This Procedure used by pod also
	@Transactional
	public ViewOnlineDto trackByCustCode(String custCode, String areaCode, java.sql.Date fromDate, java.sql.Date toDate,
			SearchDto searchDto) {
		log.debug("TrackTraceDBManager : trackByCustCode");
		ViewOnlineDto trackDto = null;
		try {
			trackDto = getSession().doReturningWork(new ReturningWork<ViewOnlineDto>() {
				@Override
				public ViewOnlineDto execute(Connection connection) throws SQLException {
					List commonDto = null;
					List<PodDto> podList = null;
					List<ShipmentDto> shipmentList = null;
					ViewOnlineDto trackDto = new ViewOnlineDto();
					CallableStatement callableStatement = null;
					try{
					Map<String, Class<?>> map = connection.getTypeMap();
					try {
						map.put(environment.getProperty(Constants.SHIPOBJ), Class.forName(Constants.SHIPMENT_DTO));
						map.put(environment.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
					} catch (Exception exception) {
						log.error("EXCEPTION TYPE :",exception);
						
						//log.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}
					connection.setTypeMap(map);
					callableStatement = connection.prepareCall(
							"{call TNT_MANG_NEW.trackByCustCode(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? )}");
					callableStatement.clearParameters();

					((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
							environment.getProperty(Constants.PODLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
							environment.getProperty(Constants.SHIPLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.NUMERIC);
					((OracleCallableStatement) callableStatement).setString(4, custCode);
					((OracleCallableStatement) callableStatement).setString(5, areaCode);
					((OracleCallableStatement) callableStatement).setDate(6, fromDate);
					((OracleCallableStatement) callableStatement).setDate(7, toDate);

					if (searchDto.getProdCode() != null && searchDto.getProdCode().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(8, searchDto.getProdCode());
					} else {
						((OracleCallableStatement) callableStatement).setString(8, "");
					}

					if (searchDto.getStatus() != null && searchDto.getStatus().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(9, searchDto.getStatus());
					} else {
						((OracleCallableStatement) callableStatement).setString(9, "");
					}

					((OracleCallableStatement) callableStatement).setString(10, searchDto.getOrigin());
					((OracleCallableStatement) callableStatement).setString(11, searchDto.getDest());
					((OracleCallableStatement) callableStatement).setString(12, searchDto.getSortBy());
					((OracleCallableStatement) callableStatement).setString(13, searchDto.getSortOrder());
					((OracleCallableStatement) callableStatement).setInt(14, searchDto.getPageSize().intValue());
					((OracleCallableStatement) callableStatement).setInt(15, searchDto.getPageNo().intValue());
					((OracleCallableStatement) callableStatement).setInt(16, searchDto.getSecLevel());
					((OracleCallableStatement) callableStatement).setInt(17, searchDto.getReqAffiliatesFlag());
					callableStatement.execute();

					ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
					ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
					long recordSize = ((OracleCallableStatement) callableStatement).getLong(3);

					if (recordSize <= 0) {
						trackDto.setRecordSize(recordSize);
						trackDto.setLimitExceeded(false);
						return trackDto;
					}

					// More then Config record size
					String thresholdLimitStr = environment.getProperty("THRESHOLD_LIMIT");
					if (Integer.parseInt(thresholdLimitStr) > recordSize) {
						trackDto.setRecordSize(recordSize);
						trackDto.setLimitExceeded(false);

						if (shipArayList != null && shipArayList.length() != 0) {
							commonDto = Arrays.asList((Object[]) shipArayList.getArray());
							shipmentList = new ArrayList<>(commonDto);
							trackDto.setShipmentList(shipmentList);
						}

						if (podArrayList != null && podArrayList.length() != 0) {
							commonDto = Arrays.asList((Object[]) podArrayList.getArray());
							podList = new ArrayList<>(commonDto);
							trackDto.setPodList(podList);
						}
					} else {
						trackDto.setRecordSize(recordSize);
						trackDto.setLimitExceeded(true);
						return trackDto;
					}
					
				}catch(Exception exception){
					log.error("EXCEPTION TYPE :",exception);
					
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
							ErrorMessageStatusCode.DATABASE_DOWN.getDescription());

				}finally{
					log.debug("----------trackByCustCode finally---------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
					return trackDto;
				}
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return trackDto;
	}

	/**
	 * 
	 * @param session
	 * @param trackById
	 * @param secLevel
	 * @param loginid
	 * @param custCC
	 * @param custAC
	 * @param dateFrom
	 * @param dateTo
	 * @param prodCode
	 * @param status
	 * @param orgAreaCode
	 * @param dstAreaCode
	 * @param sortBy
	 * @param sortOrder
	 * @return
	 */
	@Transactional
	public int getRDShipments(String trackById, int secLevel, String loginid, String custCC, String custAC,
			java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode, String status, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder) {
		log.debug("TrackTraceDBManager : getRDShipments");
		int retValue = 0;
		try {
			retValue = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					int retValue = 0;
					CallableStatement callableStatement = null;
					try{
					callableStatement = connection
							.prepareCall("{call UPROFILE4.intdRDPro(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
					callableStatement.clearParameters();

					((OracleCallableStatement) callableStatement).setString(1, trackById);
					((OracleCallableStatement) callableStatement).setLong(2, secLevel);
					((OracleCallableStatement) callableStatement).setString(3, custCC);
					((OracleCallableStatement) callableStatement).setString(4, custAC);
					((OracleCallableStatement) callableStatement).setString(5, orgAreaCode);
					((OracleCallableStatement) callableStatement).setDate(6, dateFrom);
					((OracleCallableStatement) callableStatement).setDate(7, dateTo);
					((OracleCallableStatement) callableStatement).setString(8, status);
					((OracleCallableStatement) callableStatement).setString(9, prodCode);
					((OracleCallableStatement) callableStatement).setString(10, dstAreaCode);
					((OracleCallableStatement) callableStatement).setString(11, sortOrder);
					((OracleCallableStatement) callableStatement).setString(12, sortBy);
					((OracleCallableStatement) callableStatement).setString(13, loginid);
					((OracleCallableStatement) callableStatement).registerOutParameter(14, Types.INTEGER);
					callableStatement.execute();

					retValue = ((OracleCallableStatement) callableStatement).getInt(14);
				}catch(Exception exception){
					log.error("EXCEPTION TYPE :",exception);
					
					log.error("----------getRDShipments---------"+exception.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
							ErrorMessageStatusCode.DATABASE_DOWN.getDescription());

				}finally{
					log.debug("----------getRDShipments finally---------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
					
					
					return retValue;
				}
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return retValue;
	}

	/**
	 * 
	 * @param loginId
	 * @param flag
	 * @return
	 */
	@Transactional
	public int checkFlag(String loginId, String flag) {
		log.debug("TrackTraceDBManager : checkFlag");
		int retValue = -1;
		try {
			retValue = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					int retValue = 0;
					CallableStatement callableStatement = null;
					try{
					callableStatement = connection
							.prepareCall("{call UPROFILE4.TNT_MANG_NEW.internetdart_count_chk(?, ?, ?)}");
					callableStatement.clearParameters();

					((OracleCallableStatement) callableStatement).setString(1, loginId);
					((OracleCallableStatement) callableStatement).setInt(2, Integer.parseInt(flag));
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.INTEGER);
					callableStatement.execute();

					retValue = ((OracleCallableStatement) callableStatement).getInt(3);
					
					
				}catch(Exception exception){
					log.error("EXCEPTION TYPE :",exception);
					
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
							ErrorMessageStatusCode.DATABASE_DOWN.getDescription());

				}finally{
					log.debug("----------checkFlag finally---------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
					return retValue;
				}
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return retValue;
	}
}
