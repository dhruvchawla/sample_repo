package com.bluedart.trackingapi.daoimpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.PodDto;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.TrackDto;
import com.bluedart.common.dto.TrackingAPIDto;
import com.bluedart.common.dto.TrackingAPILicenseDto;
import com.bluedart.common.entity.ApiLicense;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.trackingapi.dao.TrackingApiLicenceManagementDao;
import com.bluedart.utils.Constants;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.StringUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;


/**
 * 
 * @author SI334034
 * This class is used to manage the tracking api license
 *
 */
@Repository
public class TrackingApiLicenceManagementDaoImpl extends BaseDaoImpl implements TrackingApiLicenceManagementDao{

	private static final Logger logger = Logger.getLogger(TrackingApiLicenceManagementDaoImpl.class);

	

	private TrackingAPILicenseDto apiLicenseDto = null;


	private Properties properties = new Properties();


	/**
	 * 
	 * @param loginId
	 * @param type
	 * @return
	 * This method is used to get the license key.
	 * 
	 */
	private ApiLicense getApiLicense(String loginId, String type) {
		logger.trace(" TrackingApiLicenceManagementDaoImpl : getApiLicense ");
		
		ApiLicense apiLicense = null;
		try {
			apiLicense = new ApiLicense();
			if(loginId != null && type != null){
				Criteria criteria = getSession().createCriteria(ApiLicense.class);
				criteria.add(Restrictions.eq("loginId", loginId));
				criteria.add(Restrictions.eq("apiType", type));
				criteria.add(Restrictions.eq("status", 1));
				apiLicense = (ApiLicense) criteria.uniqueResult();
			}
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new BlueDartException();
		} finally {
			logger.debug("---------getApiLicense finally-----------");
		}
		//logger.info(" TrackingApiLicenceManagementDaoImpl : getApiLicense ");
		return apiLicense;
	}


	/**
	 * To track the Shipment details based on Awb Nos
	 * 
	 * @param session
	 * @param awbnos
	 * @param loginId
	 * @param reqScanFlag
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws TrackingAPIServiceException 
	 */
	@Override
	@Transactional
	public TrackingAPIDto getTrackByAwbNoList(List<String> awbNos, String loginId, int reqScanFlag, String lickey, String verno)
			throws IOException, BlueDartException {
		logger.trace(" TrackingAPILicenseManagementDaoImpl : getTrackByAwbNoList ");
		long lStartTime = System.currentTimeMillis();
		//logger.info(" Query Execution Start Time in currentTimeMillis ===========> " + lStartTime);
		properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
		String type = "T";
		TrackingAPIDto trackingAPIDto = null;
		try{
			trackingAPIDto = getSession().doReturningWork(new ReturningWork<TrackingAPIDto>() {
				@Override
				public TrackingAPIDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					Map<String, Class<?>> map = connection.getTypeMap();

					Boolean errorFlag =false;
					TrackingAPIDto trackingAPIDto = new TrackingAPIDto();
					TrackDto trackDto = new TrackDto();
					trackingAPIDto.setTrackDto(trackDto);
				try{
					try {
						apiLicenseDto = showLicenseKey(loginId, type);
					}catch (NullPointerException ex) {
						logger.error("EXCEPTION TYPE :",ex);
						logger.error(ex.getMessage());
					}

					if( apiLicenseDto!= null && apiLicenseDto.getLicense().equals(lickey) ) {
					
						try {
							map.put(properties.getProperty(Constants.SHIPOBJ), Class.forName(Constants.SHIPMENT_DTO));
							map.put(properties.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
						} catch (Exception exception) {
							logger.error(exception);
							try {
								throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE, "Service Down");
							} catch (BlueDartException serviceException) {
								logger.error("EXCEPTION TYPE :",exception);
								//logger.error(serviceException);
							}
						}
						connection.setTypeMap(map);

						String[] listOfValidAwbNos = null;
						if (!StringUtils.isNullOrEmpty(awbNos)) {
							listOfValidAwbNos = awbNos.toArray(new String[awbNos.size()]);
						}

						ArrayDescriptor descAwbnoList = ArrayDescriptor.createDescriptor(properties.getProperty(Constants.NUMLIST),
								connection);
						ARRAY awbnoList = new ARRAY(descAwbnoList, connection, listOfValidAwbNos);

						
						if(loginId.equalsIgnoreCase("BOM03609")) {
							callableStatement = connection
									.prepareCall("{call tnt_mang.trackByAwbnosWithClient_Amazon(?,?,?,?,?,?,?)}");
						}else {
							callableStatement = connection
									.prepareCall("{call tnt_mang.trackByAwbnosWithClientFilter(?,?,?,?,?,?,?)}");
						}
						callableStatement.clearParameters();
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
								properties.getProperty(Constants.PODLIST));
						((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
								properties.getProperty(Constants.SHIPLIST));
						((OracleCallableStatement) callableStatement).setArray(3, awbnoList);
						((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
								properties.getProperty(Constants.NUMLIST));
						((OracleCallableStatement) callableStatement).setString(4, loginId);
						((OracleCallableStatement) callableStatement).setInt(5, reqScanFlag);
						((OracleCallableStatement) callableStatement).setString(6, lickey);
						((OracleCallableStatement) callableStatement).setString(7, verno);

						callableStatement.execute();

						ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
						ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);

						long lEndTime = System.currentTimeMillis();
						//logger.info(" Query Execution End Time in currentTimeMillis ===========> " + (lEndTime - lStartTime));


						long lStartTime_1 = System.currentTimeMillis();
						//logger.info(" Query Data convert into Java List Start ===========> " + lStartTime_1);
						if (shipArayList != null && shipArayList.length() != 0) {
							List<ShipmentDto> shipmentList = getShipmentDetails(shipArayList);
							trackingAPIDto.getTrackDto().setShipmentList(shipmentList);
						}
						if (podArrayList != null && podArrayList.length() != 0) {
							List<PodDto> podList = getPodDetails(podArrayList);
							trackingAPIDto.getTrackDto().setPodList(podList);
						}

						int sceLevel = 0;
						try {
							sceLevel =  findSecurityLevel(getSession(), loginId);
						} catch (Exception exception) {
							logger.error("EXCEPTION TYPE :",exception);
							//logger.error(exception);
							throw new BlueDartException();
						}

						trackingAPIDto.setSecLevel(sceLevel);

						long lEndTime_1 = System.currentTimeMillis();
						
						
						//logger.info(" Query Data convert into Java List End ===========> " + (lEndTime_1 - lStartTime_1));
					}else {
						errorFlag = true;
						trackingAPIDto.setErrorDetails("License Mismatch");
						trackingAPIDto.setErrorFlag(errorFlag);
					}
				}catch(Exception e){
					logger.error("EXCEPTION TYPE :",e);
				}
				finally{
					logger.debug("---------getTrackByAwbNoList finally-----------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
					return trackingAPIDto;
				}
			});
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE :",exception);
			logger.error(exception.getMessage());
			trackingAPIDto.setErrorDetails("Service Down");
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE, "Service Down");
		}
		//logger.info(" TrackingAPILicenseManagementDaoImpl : getTrackByAwbNoList ");
		return trackingAPIDto;
	}

	/**
	 * To track the Shipment details based on the Ref Nos
	 * 
	 * @param session
	 * @param awbnos
	 * @param loginId
	 * @param reqScanFlag
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws TrackingAPIServiceException 
	 */
	@Override
	@Transactional
	public TrackingAPIDto getTrackByRefNoList( List<String> refNos, String loginId, int reqScanFlag, String lickey, String verno )
			throws IOException, BlueDartException {
		logger.trace(" TrackingAPILicenseManagementDaoImpl : getTrackByRefNoList ");
		long lStartTime = System.currentTimeMillis();
		//logger.info(" Query Execution Start Time in currentTimeMillis ===========> " + lStartTime);
		properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
		String type = "T";
		TrackingAPIDto trackingAPIDto = null;
		try{
			trackingAPIDto = getSession().doReturningWork(new ReturningWork<TrackingAPIDto>() {
				@Override
				public TrackingAPIDto execute(Connection connection) throws SQLException {
					Map<String, Class<?>> map = connection.getTypeMap();
					Boolean errorFlag = false;
					CallableStatement callableStatement = null;
					TrackingAPIDto trackingAPIDto = new TrackingAPIDto();
					TrackDto trackDto = new TrackDto(); 
					trackingAPIDto.setTrackDto(trackDto);
					try{
					try {
						apiLicenseDto = showLicenseKey(loginId, type);
					}catch (NullPointerException ex) {
						logger.error("EXCEPTION TYPE :",ex);
						logger.error(ex.getMessage());
					}
					
					if( apiLicenseDto!= null && apiLicenseDto.getLicense().equals(lickey) ) {
						try {
							map.put(properties.getProperty(Constants.SHIPOBJ), Class.forName(Constants.SHIPMENT_DTO));
							map.put(properties.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
						} catch (Exception exception) {
							logger.error(exception);
							try {
								throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE, "Service Down");
							} catch (BlueDartException serviceException) {
								logger.error("EXCEPTION TYPE :",exception);
								//logger.error(serviceException);
							}
						}
						connection.setTypeMap(map);

						String[] listOfValidRefNos = null;
						if (!StringUtils.isNullOrEmpty(refNos)) {
							listOfValidRefNos = refNos.toArray(new String[refNos.size()]);
						}

						ArrayDescriptor descAwbnoList = ArrayDescriptor.createDescriptor(properties.getProperty(Constants.NUMLIST),
								connection);
						ARRAY awbnoList = new ARRAY(descAwbnoList, connection, listOfValidRefNos);

						callableStatement = connection
								.prepareCall("{call tnt_mang.trackByRefnosWithClientFilter(?,?,?,?,?,?,?)}");
						

						callableStatement.clearParameters();
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
								properties.getProperty(Constants.PODLIST));
						((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
								properties.getProperty(Constants.SHIPLIST));
						((OracleCallableStatement) callableStatement).setArray(3, awbnoList);
						((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
								properties.getProperty(Constants.NUMLIST));
						((OracleCallableStatement) callableStatement).setString(4, loginId);
						((OracleCallableStatement) callableStatement).setInt(5, reqScanFlag);
						((OracleCallableStatement) callableStatement).setString(6, lickey);
						((OracleCallableStatement) callableStatement).setString(7, verno);

						callableStatement.execute();

						ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
						ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);

						long lEndTime = System.currentTimeMillis();
						//logger.info(" Query Execution End Time in currentTimeMillis ===========> " + (lEndTime - lStartTime));


						long lStartTime_1 = System.currentTimeMillis();
						//logger.info(" Query Data convert into Java List Start ===========> " + lStartTime_1);
						if (shipArayList != null && shipArayList.length() != 0) {
							List<ShipmentDto> shipmentList = getShipmentDetails(shipArayList);
							trackingAPIDto.getTrackDto().setShipmentList(shipmentList);
						}
						if (podArrayList != null && podArrayList.length() != 0) {
							List<PodDto> podList = getPodDetails(podArrayList);
							trackingAPIDto.getTrackDto().setPodList(podList);
						}

						int sceLevel = 0;
						try {
							sceLevel =  findSecurityLevel(getSession(), loginId);
						} catch (Exception exception) {
							logger.error("EXCEPTION TYPE :",exception);
							//logger.error(exception);
							throw new BlueDartException(exception.getMessage(), "");
						}

						trackingAPIDto.setSecLevel(sceLevel);

						long lEndTime_1 = System.currentTimeMillis();
						//logger.info(" Query Data convert into Java List End ============> " + (lEndTime_1 - lStartTime_1));
					}else {
						errorFlag = true;
						trackingAPIDto.setErrorDetails("License Mismatch");
						trackingAPIDto.setErrorFlag(errorFlag);
					}
					}catch(Exception e){
						logger.error("EXCEPTION TYPE :",e);
					}
					finally{
						logger.debug("---------getTrackByRefNoList finally-----------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return trackingAPIDto;
				}
			});
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE :",exception);
			logger.error(exception.getMessage());
		}
		//logger.info(" TrackTraceDBManager : getTrackByAwbNoList "+trackingAPIDto);
		return trackingAPIDto;
	}


	/**
	 * To get list of Shipment details
	 * 
	 * @param shipList
	 * @param trackDto
	 * @return
	 * @throws SQLException
	 */
	private List<ShipmentDto> getShipmentDetails(ARRAY shipList) throws SQLException {
		logger.trace(" TrackTraceDBManager ::: getShipmentDetails ");
		List<ShipmentDto> shipmentList = new ArrayList<>();
		Object[] object = (Object[]) shipList.getArray();
		ShipmentDto shipment;
		for (int i = 0; i < shipList.length(); i++) {
			shipment = new ShipmentDto();
			shipment = (ShipmentDto) object[i];
			shipmentList.add(shipment);
		}
		//logger.info(" TrackTraceDBManager ::: getShipmentDetails ");
		return shipmentList;
	}

	/**
	 * To get list POD details
	 * 
	 * @param podList
	 * @param trackDto
	 * @return
	 * @throws SQLException
	 */
	private List<PodDto> getPodDetails(ARRAY podList) throws SQLException {
		logger.trace(" TrackTraceDBManager ::: getPodDetails ");
		List<PodDto> podObjList = new ArrayList<>();
		Object[] object = (Object[]) podList.getArray();
		PodDto pod;
		for (int i = 0; i < podList.length(); i++) {
			pod = new PodDto();
			pod = (PodDto) object[i];
			podObjList.add(pod);
		}
		//logger.info(" TrackTraceDBManager ::: getPodDetails ");
		return podObjList;
	}

	/**
	 * 
	 * @param session
	 * @param loginId
	 * @return
	 * @throws IOException
	 */
	private Integer findSecurityLevel(Session session, String loginId ) throws IOException {
		logger.trace(" FindSecurityLevelDaoImpl ::: findSecurityLevel ");
		Integer secLevel = session.doReturningWork(new ReturningWork<Integer>() {
			@Override
			public Integer execute(Connection connection) throws SQLException {
				int secLevel = 0;
				CallableStatement callableStatement = null;
				try{
				callableStatement = connection.prepareCall("{ call ADMIN.getsecuritylevel(?,?)}");
				callableStatement.clearParameters();

				((OracleCallableStatement) callableStatement).setString(1, loginId);
				((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
				callableStatement.execute();

				secLevel = ((OracleCallableStatement) callableStatement).getInt(2);
				
				}catch(Exception e){
					logger.error("EXCEPTION TYPE :",e);
				}
				finally{
					logger.debug("---------findSecurityLevel finally-----------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return secLevel;
			}
		});
		//logger.info(" FindSecurityLevelDaoImpl ::: findSecurityLevel " + secLevel);
		return secLevel;
	}


	/**
	 * This method is used to get the license key
	 */
	@Override
	public TrackingAPILicenseDto showLicenseKey(String userLoginId, String type){
		logger.trace(" TrackingApiLicenceManagementDaoImpl : showLicenseKey ");
		ApiLicense apiLicense = getApiLicense(userLoginId, type);
		TrackingAPILicenseDto apiLicenseDto = null;
		
		if(apiLicense !=null){
			apiLicenseDto = new TrackingAPILicenseDto();
			CopyUtils.copy(apiLicense, apiLicenseDto);	
		}
		
		//logger.info(" TrackingApiLicenceManagementDaoImpl : showLicenseKey ");
		return apiLicenseDto;
	}
}