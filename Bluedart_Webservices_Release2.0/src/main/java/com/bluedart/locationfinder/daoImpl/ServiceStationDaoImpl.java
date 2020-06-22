package com.bluedart.locationfinder.daoImpl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.OracleConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.locationfinder.dao.ServiceStationDao;
import com.bluedart.locationfinder.dto.LocationFinderDto;
import com.bluedart.locationfinder.dto.ServiceStationDTO;
import com.bluedart.utils.Constants;
import com.bluedart.utils.Converter;
import com.bluedart.utils.ErrorMessageStatusCode;


/**
 * @author Subhransu kumar Maharana
 * @CreateDate June 27, 2016
 * @Description This Class contains all the methods related to Location Finder
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class ServiceStationDaoImpl extends BaseDaoImpl implements ServiceStationDao {
	private static Log locationFinderLogger = LogFactory.getLog(ServiceStationDaoImpl.class);
	
	@Autowired
	private Environment locationFinderEnv;

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method fetches service station details for a specific
	 * pincode
	 * 
	 * @see
	 * com.wipro.bluedart.dao.ServiceStationDao#getServiceStationsByPincode(java
	 * .lang.String)
	 */
	@Transactional(readOnly=true)
	@Override
	public LocationFinderDto getServiceStationsByPincode(String pincode) {
		locationFinderLogger.debug(" ServiceStationDaoImpl : getServiceStationsByPincode");
		LocationFinderDto locationFinderDto = new LocationFinderDto();
		
		List<ServiceStationDTO> stationDTOsResult = new ArrayList<>();

		String getServiceStationsByPincodeSQL = "{call UPROFILE4.LOC_FINDER_NEW.pininfo_list(?,?)}";
		
		try {	
			getSession().doWork(new Work() {
				CallableStatement callableStatement = null;
				ResultSet rs = null;
				
				@Override
				public void execute(Connection connection) throws SQLException {
					try {
						System.out.println("Inside try");
						callableStatement = connection.prepareCall(getServiceStationsByPincodeSQL);
						callableStatement.setString(1, pincode);
						callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						ServiceStationDTO stationDTO;
						while (rs.next()) {
							stationDTO = new ServiceStationDTO();

							stationDTO.setPincode(rs.getString("careapin"));
							stationDTO.setAddress1(rs.getString("careaadr1"));
							stationDTO.setAddress2(rs.getString("careaadr2"));
							stationDTO.setAddress3(rs.getString("careaadr3"));
							stationDTO.setLatitude(rs.getString("CLATITUDE"));
							stationDTO.setLongitude(rs.getString("CLONGITUDE"));
							stationDTO.setContact1(rs.getString("ccontact1"));
							stationDTO.setContact2(rs.getString("ccontact2"));
							stationDTO.setTelNo(rs.getString("CTEL"));
							stationDTO.setFax(rs.getString("cfax"));
							stationDTO.setAreaZone(rs.getString("CAZONE"));
							stationDTO.setSfcZone(rs.getString("CSFCZN"));
							stationDTO.setAreaCode(rs.getString("carea"));
							stationDTO.setAreaCity(rs.getString("CAREACITY"));
							stationDTO.setLocationType(rs.getString("CLOCTYPE"));
							stationDTO.setStationTelNo(rs.getString("CSTELE"));
							stationDTO.setState(rs.getString(Constants.STATE_COL));
							// -------------------------------
							// Service Details----------------
							// -------------------------------
							stationDTO.setDomesticPriorityService(
									getServiceDetailsString(String.valueOf(rs.getString("CDPSERV"))));
							stationDTO.setInternationalPriorityService(
									getServiceDetailsString(String.valueOf(rs.getString(Constants.INTERNATIONAL_PRIORITY_SERVICE_COL))));
							stationDTO.setJumboBoxService(
									getServiceDetailsString(String.valueOf(rs.getString(Constants.INTERNATIONAL_PRIORITY_SERVICE_COL))));
							stationDTO.setDoorToDoorService(
									getServiceDetailsString(String.valueOf(rs.getString(Constants.APEX_PRIORITY_SERVICE_COL))));

							StringBuilder doorToAirportService = new StringBuilder(stationDTO.getDoorToDoorService());
							char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET
									.contains(stationDTO.getAreaCity().toUpperCase()) ? Constants.Y : Constants.N;
							doorToAirportService.setCharAt(3, aircityFlag);

							stationDTO.setAirportToDoorService(
									Constants.O + doorToAirportService.charAt(3) + Constants.I_STRING + doorToAirportService.charAt(1));
							stationDTO.setDoorToAirportService(doorToAirportService.toString());
							stationDTO.setSmartBoxService(
									getServiceDetailsString(String.valueOf(rs.getString(Constants.APEX_PRIORITY_SERVICE_COL))));
							stationDTO.setDartSurfaceLineService(
									getServiceDetailsString(String.valueOf(rs.getString("CSFCSERV"))));
							stationDTO.setAirportToAirportService(
									Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase())
						 					? Constants.OYIY : Constants.ONIN);
							
							stationDTO.setServFlag(rs.getString("cservflag"));
							stationDTOsResult.add(stationDTO);
							System.out.println("End");
						}
					}
					catch(Exception e){
						e.printStackTrace();
						locationFinderLogger.error("EXCEPTION TYPE :",e);
						
						//locationFinderLogger.error("Error Occured when calling pininfo procedure_info" + e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}
					finally {
						locationFinderLogger.debug("----------------getServiceStationsByPincode Finally----------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}

			}); 
		} 		
		catch (Exception exp) {
			exp.printStackTrace();
			locationFinderLogger.error("EXCEPTION TYPE :",exp);
			
			locationFinderLogger.error("Error Occured when calling pininfo procedure" + exp.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}

		locationFinderDto.setServiceStationDTOList(stationDTOsResult);		
		return locationFinderDto;
	}

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method fetches the list of serviceStation for entered
	 * list of pincodes
	 */
	@Transactional(readOnly=true)
	@Override
	public LocationFinderDto getServiceStationsByMultiplePincodes(List<String> pincodes){
		locationFinderLogger.debug(" ServiceStationDaoImpl : getServiceStationsByMultiplePincodes");
		LocationFinderDto locationFinderDto = new LocationFinderDto();

		List<ServiceStationDTO> stationDTOsResult = new ArrayList<>();

		String getServiceStationsByPincodesSQL = "{call UPROFILE4.LOC_FINDER_NEW.PININFO_multiple(?,?)}";
		try {
			getSession().doWork(new Work() {
				CallableStatement cs = null;
				OracleConnection oracleConnection = null;

				@Override
				public void execute(Connection connection) throws SQLException {
					try {
						oracleConnection = (OracleConnection) connection.getMetaData().getConnection();
						Struct[] structArray = new Struct[pincodes.size()];
						for (int j = 0; j < structArray.length; j++) {
							String[] str = { pincodes.get(j) };
							Struct struct = oracleConnection.createStruct(locationFinderEnv.getProperty("pininfoCollc.input.obj"),
									str);
							structArray[j] = struct;
						}
						Array arrayParam = oracleConnection
								.createOracleArray(locationFinderEnv.getProperty("pininfoCollc.input.type"), structArray);
						cs = oracleConnection.prepareCall(getServiceStationsByPincodesSQL);
						cs.setArray(1, arrayParam);
						cs.registerOutParameter(2, OracleTypes.ARRAY, locationFinderEnv.getProperty("pininfoCollc.output.type"));
						cs.execute();
						Array resultArray = cs.getArray(2);
						Object[] arrOfServiceStations = (Object[]) resultArray.getArray();
						ServiceStationDTO dto;
						for (Object serviceStationObj : arrOfServiceStations) {
							dto = new ServiceStationDTO();
							Struct struct2 = (Struct) serviceStationObj;
							Object[] fields = struct2.getAttributes();

							dto.setPincodeInput(Converter.objToString(fields[0]));
							dto.setAreaCode(Converter.objToString(fields[1]));
							dto.setAddress1(Converter.objToString(fields[2]));
							dto.setAddress2(Converter.objToString(fields[3]));
							dto.setAddress3(Converter.objToString(fields[4]));
							dto.setPincode(Converter.objToString(fields[5]));
							dto.setTelNo(Converter.objToString(fields[6]));
							dto.setFax(Converter.objToString(fields[7]));
							dto.setContact1(Converter.objToString(fields[8]));
							dto.setContact2(Converter.objToString(fields[9]));
							dto.setDomesticPriorityService(getServiceDetailsString(Converter.objToString(fields[10])));
							dto.setAreaZone(Converter.objToString(fields[11]));
							dto.setSfcZone(Converter.objToString(fields[12]));
							// Bapserv
							// BSFCserv
							dto.setAreaCity(Converter.objToString(fields[15]));
							// CLOCTYPE
							dto.setInternationalPriorityService(
									getServiceDetailsString(Converter.objToString(fields[17])));
							dto.setDartSurfaceLineService(getServiceDetailsString(Converter.objToString(fields[18])));
							dto.setDoorToDoorService(getServiceDetailsString(Converter.objToString(fields[19])));
							dto.setRegionalPriorityService(getServiceDetailsString(Converter.objToString(fields[20])));
							dto.setLocationTelNo(Converter.objToString(fields[21]));
							dto.setStationTelNo(Converter.objToString(fields[21]));
							// CSERVFLAG
							dto.setLatitude(Converter.objToString(fields[23]));
							dto.setLongitude(Converter.objToString(fields[24]));
							dto.setState(Converter.objToString(fields[25]));

							// -------------------------------
							// Service Details----------------
							// -------------------------------

							dto.setJumboBoxService(getServiceDetailsString(Converter.objToString(fields[17])));

							StringBuilder doorToAirportService = new StringBuilder(dto.getDoorToDoorService());
							char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET
									.contains(dto.getAreaCity().toUpperCase()) ? Constants.Y : Constants.N;
							doorToAirportService.setCharAt(3, aircityFlag);

							dto.setAirportToDoorService(
									Constants.O + doorToAirportService.charAt(3) + Constants.I_STRING + doorToAirportService.charAt(1));
							dto.setDoorToAirportService(doorToAirportService.toString());
							dto.setSmartBoxService(getServiceDetailsString(Converter.objToString(fields[19])));
							dto.setAirportToAirportService(
									Constants.FINDER_AIRPORT_CITIES_SET.contains(dto.getAreaCity().toUpperCase())
											? Constants.OYIY : Constants.ONIN);
							dto.setServFlag(Converter.objToString(fields[22]));	
							// ------------------------------------------------------------------------
							stationDTOsResult.add(dto);
						}
					} catch(Exception e){
						locationFinderLogger.error("EXCEPTION TYPE :",e);
						
						locationFinderLogger.error("Error Occured when calling pininfo_multiple procedure" + e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}finally {
				
						locationFinderLogger.debug("----------------getServiceStationsByMultiplePincodes Finally----------");
					CloseConnections.closeCallableStatement(cs);
				}
				}
				
			});
		} catch (Exception exp) {
			
			locationFinderLogger.error("EXCEPTION TYPE :",exp);
			
			locationFinderLogger.error("Error Occured when calling pininfo_multiple procedure" + exp.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 

		locationFinderDto.setServiceStationDTOList(stationDTOsResult);
		return locationFinderDto;

	}
	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method is used to get the area code based on location name
	 * specific CityName
	 * @param locationName
	 */
	@Transactional
	@Override
	public AreaDTO getAreaCodes(String locationName){
		locationFinderLogger.debug(" ServiceStationDaoImpl : getAreaCodes");
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select CAREA, CSCRCD, CAREACITY from areamst where coldname=? and nvl(cdpserv,'*') <> 'N' union ")
				.append("select CAREA, CSCRCD, CAREACITY from areamst where careadesc=? and nvl(cdpserv,'*') <> 'N' union ")
				.append("select CAREA, CSCRCD, CAREACITY from areamst where cscrcddesc=? and nvl(cdpserv,'*') <> 'N' union ")
				.append("select p.CAREA,p.CSCRCD,a.CAREACITY from pincdmst p,areamst a WHERE a.carea = p.carea AND a.cscrcd = p.cscrcd AND p.cpindesc=?");
		AreaDTO areaDTOResult;
		try {
			areaDTOResult = getSession().doReturningWork(new ReturningWork<AreaDTO>() {
				@Override
				public AreaDTO execute(Connection connection) throws SQLException {
					AreaDTO areaDTO = null;
					ResultSet rs = null;
					PreparedStatement pStmt =null;
					pStmt = connection.prepareStatement(sqlQuery.toString());
					pStmt.setString(1, locationName.toUpperCase());
					pStmt.setString(2, locationName.toUpperCase());
					pStmt.setString(3, locationName.toUpperCase());
					pStmt.setString(4, locationName.toUpperCase());
					try {
						rs = pStmt.executeQuery();
						if (rs != null && rs.next()) {
							areaDTO = new AreaDTO();
							areaDTO.setCarea(rs.getString(1));
							areaDTO.setCscrcd(rs.getString(2));
							areaDTO.setCareacity(rs.getString(3));
							return areaDTO;
						}
						return areaDTO;
					} catch (HibernateException e) {
						
						locationFinderLogger.error("EXCEPTION TYPE :",e);
						
						return null;
					} finally {
						locationFinderLogger.debug("----------------getAreaCodes Finally----------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closePreparedStatement(pStmt);
					}
				}
			});
		} catch(Exception e){
			locationFinderLogger.error("EXCEPTION TYPE :",e);
			
			locationFinderLogger.error("Error Occured in getAreaCodes method " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}

		return areaDTOResult;

	}

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method checks for International Serviceability for
	 * specific CityName
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public LocationFinderDto checkInternationalServiceability(String intlPincode, String cityName, String countryCode){
		
		locationFinderLogger.debug(" ServiceStationDaoImpl : checkInternationalServiceability");
		LocationFinderDto locationFinderDto = new LocationFinderDto();

		String pinSubctmstQuery = "select * from WEBMASTER.SUBCTMST where CCNTRYCODE = ? and  CPINFROM<=? and CPINTO>=? and nvl(CPRODSERV,'*')!='G' ORDER BY CONFWD,NFWDDAYS";
		String ctmstQuery = "SELECT * FROM CITYMST WHERE BINTLSERV='T' and CCNTRYCODE = ?  AND CCITYNAME LIKE ? ORDER BY 1";
		String subctmstQuery = "SELECT * FROM (SELECT DISTINCT CCITYCODE,SUBSTR(CSUBCTCODE,1,2) CSUBCTCODE,CONFWD,NFWDDAYS FROM SUBCTMST WHERE nvl(CPRODSERV,'*') !='N' and CCNTRYCODE = ? AND CCITYNAME = ? ORDER BY CONFWD,NFWDDAYS) WHERE ROWNUM <= 1";

		boolean isServicedResult;
		try {
			isServicedResult = getSession().doReturningWork(new ReturningWork<Boolean>() {
				@Override
				public Boolean execute(Connection connection) throws SQLException {
					PreparedStatement pstmt = null;
					ResultSet rset = null;
					try {
						Pattern pincodePattern = Pattern.compile("[0-9]{0,20}");
						Matcher pinMatcher = pincodePattern.matcher(intlPincode);
						if (!StringUtils.isEmpty(intlPincode) && (pinMatcher.matches())) {
							pstmt = connection.prepareStatement(pinSubctmstQuery);
							pstmt.setString(1, countryCode);
							pstmt.setString(2, intlPincode);
							pstmt.setString(3, intlPincode);
							rset = pstmt.executeQuery();
							if (rset.next())
								return true;
						}

						pstmt = connection.prepareStatement(ctmstQuery);
						pstmt.setString(1, countryCode.toUpperCase());
						pstmt.setString(2, cityName.toUpperCase() + "%");
						rset = pstmt.executeQuery();
						if (rset != null) {
							if (rset.next()) {
								return true;
							} else {
								pstmt = connection.prepareStatement(subctmstQuery);
								pstmt.setString(1, countryCode.toUpperCase());
								pstmt.setString(2, cityName.toUpperCase());
								rset = pstmt.executeQuery();
								if (rset.next())
									return true;

							}
						}
					} catch (Exception e) {
						locationFinderLogger.error("EXCEPTION TYPE :",e);
						
						locationFinderLogger.error("Error Occured while executing query" + e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}finally {
						locationFinderLogger.debug("----------------checkInternationalServiceability Finally----------");
						CloseConnections.closeResultSet(rset);
						CloseConnections.closePreparedStatement(pstmt);
					} 
					return false;
				}
			});
		} catch(Exception e){
			locationFinderLogger.error("EXCEPTION TYPE :",e);
			
			locationFinderLogger.error("Error Occured in checkInternationalServiceability method" + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		locationFinderDto.setInternationalServiceabilityCheck(isServicedResult);
		return locationFinderDto;

	}

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method checks for serviceability based on location name
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public boolean checkServiceability(String location) {
		locationFinderLogger.debug(" ServiceStationDaoImpl : checkServiceability");
		ArrayList<String> list = new ArrayList<>();
		String getListLocationSql = "{call loc_finder.locinfo1(?,?)}";
		try {
			getSession().doWork(new Work() {
				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public void execute(Connection connection) throws SQLException {
					try {
						callableStatement = connection.prepareCall(getListLocationSql);
						callableStatement.setString(1, location);
						callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						while (rs.next()) {
							list.add(rs.getString("cpindesc"));
						}
					} catch(Exception e){
						locationFinderLogger.error("EXCEPTION TYPE :",e);
					}
					finally {
						locationFinderLogger.debug("----------------checkServiceability Finally----------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					} 
				}
			});
		} catch(Exception e){
			
			locationFinderLogger.error("EXCEPTION TYPE :",e);
			
			locationFinderLogger.error("Error Occured when calling procedure" + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		return list.isEmpty();
	}

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method is used to get international city codes
	 * 
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public String getInternationalCityCode(String pincode, String countryCode, String cityName){
		locationFinderLogger.debug(" ServiceStationDaoImpl : getInternationalCityCode");
		System.out.println("Inside getInternationalCityCode method : satrt");
		String pinSubctmstQuery = "select CCITYCODE from WEBMASTER.SUBCTMST where CCNTRYCODE = ? and  CPINFROM<=? and CPINTO>=? and nvl(CPRODSERV,'*')!='G' ORDER BY CONFWD,NFWDDAYS";
		String subctmstQuery = "SELECT * FROM (SELECT DISTINCT CCITYCODE,SUBSTR(CSUBCTCODE,1,2) CSUBCTCODE,CONFWD,NFWDDAYS FROM SUBCTMST WHERE nvl(CPRODSERV,'*') !='N' and CCNTRYCODE = ? AND CCITYNAME = ? ORDER BY CONFWD,NFWDDAYS) WHERE ROWNUM <= 1";
		String citymstQuery = "SELECT DISTINCT CCITYCODE,SUBSTR(CCITYCODE,1,2)||'0' CSUBCTCODE,'N' CONFWD,0 NFWDDAYS FROM CITYMST WHERE CCNTRYCODE = ? AND CCITYNAME = ?";
		//String citymstQuery = "SELECT DISTINCT CCITYCODE,SUBSTR(CCITYCODE,1,2)||'0' CSUBCTCODE,'N' CONFWD,0 NFWDDAYS FROM SUBCTMST WHERE CCNTRYCODE = ? AND CCITYNAME = ?";
		String cityCode;
		try {
			cityCode = getSession().doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) throws SQLException {
					PreparedStatement pStmt = null;
					ResultSet rs = null;
					Pattern pincodePattern = Pattern.compile("[0-9]{0,20}");
					Matcher pinMatcher = pincodePattern.matcher(pincode);
					try {
						if (!StringUtils.isEmpty(pincode) && (pinMatcher.matches())) {
							pStmt = connection.prepareStatement(pinSubctmstQuery);
							pStmt.setString(1, countryCode.toUpperCase());
							pStmt.setString(2, pincode);
							pStmt.setString(3, pincode);
							rs = pStmt.executeQuery();
							if (rs.next()) {
								locationFinderLogger.debug("getting city code from pincode.." + rs.getString(1));
								return rs.getString(1);
							}
						}
						pStmt = connection.prepareStatement(subctmstQuery);
						pStmt.setString(1, countryCode.toUpperCase());
						pStmt.setString(2, cityName.toUpperCase());
						rs = pStmt.executeQuery();
						if (rs != null) {
							if (rs.next()) {
								locationFinderLogger.debug("1: getting city code from locationname.." + rs.getString(1));// CCITYCODE
								return rs.getString(1);
							} else {
								pStmt = connection.prepareStatement(citymstQuery);
								pStmt.setString(1, countryCode.toUpperCase());
								pStmt.setString(2, cityName.toUpperCase());
								rs = pStmt.executeQuery();
								if (rs != null) {
									while (rs.next()) {
										locationFinderLogger.debug("2: getting city code from locationname.." + rs.getString(1));// CCITYCODE
										return rs.getString(1);
									}
								}
							}
						}
					} catch(Exception e){
						locationFinderLogger.error("EXCEPTION TYPE :",e);
					}
					finally {
						locationFinderLogger.debug("----------------getInternationalCityCode Finally----------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closePreparedStatement(pStmt);
					} 
					System.out.println("Inside getInternationalCityCode method : end");
					return "";
				}
			});
		} catch(Exception e){
			
			locationFinderLogger.error("EXCEPTION TYPE :",e);
			
			locationFinderLogger.error("Error Occured in getInternationalCityCode method" + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		return cityCode;
	}

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method is used to get service stations using location name
	 * 
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public LocationFinderDto getServiceStationsByLocationName(boolean isCity, String locationName,
			String cityName, String state){
		locationFinderLogger.debug(" ServiceStationDaoImpl : getServiceStationsByLocationName");
		Set<ServiceStationDTO> stationDTOsResultSet = new HashSet<>();

		LocationFinderDto locationFinderDto = new LocationFinderDto();
		String getServiceStationsByLocationSQL = "{call UPROFILE4.LOC_FINDER_NEW.LOCINFO_list(?,?)}";
		try {
			getSession().doWork(new Work() {
				CallableStatement callableStatement = null;

				@Override
				public void execute(Connection connection) throws SQLException {
					callableStatement = connection.prepareCall(getServiceStationsByLocationSQL);
					callableStatement.setString(1, locationName.toUpperCase());
					callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
					callableStatement.execute();
					ResultSet rs = (ResultSet) callableStatement.getObject(2);

					ServiceStationDTO stationDTO;
					StringBuilder doorToAirportService = null;
					Pattern cityPattern = Pattern.compile(".*" + cityName.toUpperCase() + ".*");
					Pattern oldCityNamePattern = Pattern.compile(".*" + cityName.toUpperCase() + ".*");
					Matcher cityMatcher = null;
					Matcher oldCityNameMatcher = null;
					String dbCityName = null;
					String dbStateName = null;
					String dbCityOldName = null;
					try {
						while (rs.next()) {
							locationFinderLogger.debug(isCity + "," + locationName + "," + cityName + "," + state);

							dbCityName = Converter.objToString(rs.getString("CAREACITY"));
							dbStateName = Converter.objToString(rs.getString(Constants.STATE_COL));
							dbCityOldName = Converter.objToString(rs.getString("COLDNAME"));
							if(!isCity){
								boolean showFirstRecordFlag = false;
								cityMatcher = cityPattern.matcher(dbCityName);
								oldCityNameMatcher = oldCityNamePattern.matcher(dbCityOldName);
									if (!StringUtils.isEmpty(cityName)) {
										if (StringUtils.isEmpty(state)) {
											if (!cityMatcher.matches())
												locationFinderLogger.debug("city not matching skipping");
											continue;
										} else {
											Pattern statePattern = Pattern
													.compile(".*" + state.toUpperCase().split(" ")[0] + ".*");
											Matcher stateMatcher = statePattern.matcher(dbStateName);
											if (!stateMatcher.matches()) {
												locationFinderLogger.debug("State not matching skipping");
												continue;
											}
											if (!cityMatcher.matches()) {
												locationFinderLogger.debug("city not matching skipping");
												if(!oldCityNameMatcher.matches())
													showFirstRecordFlag = true;
 											}
										}
									}
								stationDTO = new ServiceStationDTO();
	
								stationDTO.setStationCode(Converter.objToString(rs.getString("CSCRCD")));
								stationDTO.setPincode(Converter.objToString(rs.getString("careapin")));
								stationDTO.setStationName(Converter.objToString(rs.getString("cscrcddesc")));
								stationDTO.setAddress1(Converter.objToString(rs.getString("careaadr1")));
								stationDTO.setAddress2(Converter.objToString(rs.getString("careaadr2")));
								stationDTO.setAddress3(Converter.objToString(rs.getString("careaadr3")));
								stationDTO.setLatitude(Converter.objToString(rs.getString("CLATITUDE")));
								stationDTO.setLongitude(Converter.objToString(rs.getString("CLONGITUDE")));
								stationDTO.setAreaZone(Converter.objToString(rs.getString("CAZONE")));
								stationDTO.setContact1(Converter.objToString(rs.getString("ccontact1")));
								stationDTO.setContact2(Converter.objToString(rs.getString("ccontact2")));
								stationDTO.setTelNo(Converter.objToString(rs.getString("CTEL")));
								stationDTO.setLocationTelNo(Converter.objToString(rs.getString("CLOCTELNO")));
								stationDTO.setFax(Converter.objToString(rs.getString("cfax")));
								stationDTO.setSfcZone(Converter.objToString(rs.getString("CSFCZN")));
								stationDTO.setAreaCode(Converter.objToString(rs.getString("carea")));
								stationDTO.setAreaCity(dbCityName);
								stationDTO.setState(dbStateName);
								stationDTO.setLocationType(Converter.objToString(rs.getString("CLOCTYPE")));
							
								// --------------------
								// Service Details
								// --------------------
								    stationDTO.setDomesticPriorityService(
										  getServiceDetailsString(String.valueOf(rs.getString("CDPSERV"))));
								  stationDTO.setRegionalPriorityService(
										getServiceDetailsString(String.valueOf(rs.getString("CRPSERV"))));
								stationDTO.setInternationalPriorityService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.INTERNATIONAL_PRIORITY_SERVICE_COL))));
								stationDTO.setJumboBoxService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.INTERNATIONAL_PRIORITY_SERVICE_COL))));
								stationDTO.setDoorToDoorService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.APEX_PRIORITY_SERVICE_COL))));
	
								doorToAirportService = new StringBuilder(stationDTO.getDoorToDoorService());
								char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET
										.contains(stationDTO.getAreaCity().toUpperCase()) ? Constants.Y : Constants.N;
								doorToAirportService.setCharAt(3, aircityFlag);
	
								stationDTO.setAirportToDoorService(
										Constants.O + doorToAirportService.charAt(3) + Constants.I_STRING + doorToAirportService.charAt(1));
								stationDTO.setDoorToAirportService(doorToAirportService.toString());
								stationDTO.setSmartBoxService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.APEX_PRIORITY_SERVICE_COL))));
								stationDTO.setDartSurfaceLineService(
										getServiceDetailsString(String.valueOf(rs.getString("CSFCSERV"))));
								stationDTO.setAirportToAirportService(
										Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase())
												? Constants.OYIY : Constants.ONIN);
	
								rs.getString("bapeserv");
								rs.getString("bsfcserv");
								rs.getString("cscrcddesc");
								rs.getString("cscrcd");
								rs.getString("CQUERYFLAG");
	
								stationDTO.setServFlag(Converter.objToString(rs.getString("cservflag")));
								
								locationFinderLogger.debug(Converter.objToString(rs.getString(Constants.STATE_COL)));
								locationFinderLogger.debug(stationDTO.getState());
								stationDTOsResultSet.add(stationDTO);
								if(showFirstRecordFlag){
									break;
								}
								break;
							}
							else{
								stationDTO = new ServiceStationDTO();
								stationDTO.setStationCode(Converter.objToString(rs.getString("CSCRCD")));
								stationDTO.setPincode(Converter.objToString(rs.getString("careapin")));
								stationDTO.setStationName(Converter.objToString(rs.getString("cscrcddesc")));
								stationDTO.setAddress1(Converter.objToString(rs.getString("careaadr1")));
								stationDTO.setAddress2(Converter.objToString(rs.getString("careaadr2")));
								stationDTO.setAddress3(Converter.objToString(rs.getString("careaadr3")));
								stationDTO.setLatitude(Converter.objToString(rs.getString("CLATITUDE")));
								stationDTO.setLongitude(Converter.objToString(rs.getString("CLONGITUDE")));
								stationDTO.setAreaZone(Converter.objToString(rs.getString("CAZONE")));
								stationDTO.setContact1(Converter.objToString(rs.getString("ccontact1")));
								stationDTO.setContact2(Converter.objToString(rs.getString("ccontact2")));
								stationDTO.setTelNo(Converter.objToString(rs.getString("CTEL")));
								stationDTO.setLocationTelNo(Converter.objToString(rs.getString("CLOCTELNO")));
								stationDTO.setFax(Converter.objToString(rs.getString("cfax")));
								stationDTO.setSfcZone(Converter.objToString(rs.getString("CSFCZN")));
								stationDTO.setAreaCode(Converter.objToString(rs.getString("carea")));
								stationDTO.setAreaCity(dbCityName);
								stationDTO.setState(dbStateName);
								stationDTO.setLocationType(Converter.objToString(rs.getString("CLOCTYPE")));

								// --------------------
								// Service Details
								// --------------------
								    stationDTO.setDomesticPriorityService(
										  getServiceDetailsString(String.valueOf(rs.getString("CDPSERV"))));
								  stationDTO.setRegionalPriorityService(
										getServiceDetailsString(String.valueOf(rs.getString("CRPSERV"))));
								stationDTO.setInternationalPriorityService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.INTERNATIONAL_PRIORITY_SERVICE_COL))));
								stationDTO.setJumboBoxService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.INTERNATIONAL_PRIORITY_SERVICE_COL))));
								stationDTO.setDoorToDoorService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.APEX_PRIORITY_SERVICE_COL))));

								doorToAirportService = new StringBuilder(stationDTO.getDoorToDoorService());
								char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET
										.contains(stationDTO.getAreaCity().toUpperCase()) ? Constants.Y : Constants.N;
								doorToAirportService.setCharAt(3, aircityFlag);

								stationDTO.setAirportToDoorService(
										Constants.O + doorToAirportService.charAt(3) + Constants.I_STRING + doorToAirportService.charAt(1));
								stationDTO.setDoorToAirportService(doorToAirportService.toString());
								stationDTO.setSmartBoxService(
										getServiceDetailsString(String.valueOf(rs.getString(Constants.APEX_PRIORITY_SERVICE_COL))));
								stationDTO.setDartSurfaceLineService(
										getServiceDetailsString(String.valueOf(rs.getString("CSFCSERV"))));
								stationDTO.setAirportToAirportService(
										Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase())
												? Constants.OYIY : Constants.ONIN);

								rs.getString("bapeserv");
								rs.getString("bsfcserv");
								rs.getString("cscrcddesc");
								rs.getString("cscrcd");
								rs.getString("CQUERYFLAG");
								
								stationDTO.setServFlag(Converter.objToString(rs.getString("cservflag")));
								
								locationFinderLogger.debug(Converter.objToString(rs.getString(Constants.STATE_COL)));
								locationFinderLogger.debug(stationDTO.getState());
								stationDTOsResultSet.add(stationDTO);
							}
							// Taking 1st result only
							/*if (!isCity)
								break;*/
						}
					}finally {
						locationFinderLogger.debug("----------------getServiceStationsByLocationName Finally----------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					} 
				}

			});
		} catch (Exception exp) {
			locationFinderLogger.error("EXCEPTION TYPE :",exp);
			
			locationFinderLogger.error("Error Occured when calling pininfo procedure" + exp.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}

		locationFinderDto.setServiceStationDTOList(new ArrayList<>(stationDTOsResultSet));
		return locationFinderDto;
	}

	
	/**
	 * This method is used to get the serviceability details
	 * @param serv
	 * @return
	 */
	protected String getServiceDetailsString(String serv) {
		if (Constants.O.equalsIgnoreCase(serv))
			return Constants.OYIN;
		else if (Constants.I_STRING.equalsIgnoreCase(serv))
			return Constants.ONIY;
		else if (Constants.N_STRING.equalsIgnoreCase(serv))
			return Constants.ONIN;
		else
			return Constants.OYIY;
	}

	/*
	 * @author Subhransu Maharana
	 * 
	 * @Description This Method fetches the list of nearest ServiceStations
	 * within the given radius from the entered location's geocode i.e lat long
	 * 
	 * @see
	 * com.wipro.bluedart.dao.ServiceStationDao#getNearbyServiceStationsByParam(
	 * java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Transactional(readOnly=true)
	@Override
	public LocationFinderDto getNearbyServiceStationsByParam(String lat, String lng, String state, int count,
			int distance, String type){
		locationFinderLogger.debug(" ServiceStationDaoImpl : getNearbyServiceStationsByParam");
		LocationFinderDto locationFinderDto = new LocationFinderDto();
		locationFinderLogger.debug("Lat : " + lat + "Long : " + lng + "State :" + state);
		List<ServiceStationDTO> serviceStationDTOResult = null;
		ServiceStationDTO stationDTO;

		try {
			StringBuilder getNearBySQL1 = new StringBuilder();
			getNearBySQL1.append("SELECT CAREA, CSCRCD, CLATITUDE, CLONGITUDE, CAREA1, CSCRCD1, CAREAADR1, CAREAADR2, CAREAADR3, CCONTACT1, CCONTACT2, CDPSERV, CRPSERV, CSFCSERV, CIPSERV, DISTANCE,CAREAPIN,CAREACITY,CAPESERV,CTEL,CLOCTYPE FROM ")
					.append("  ( ")
					.append( "    SELECT L.CAREA, L.CSCRCD, L.CLATITUDE, L.CLONGITUDE, A.CAREA CAREA1, A.CSCRCD CSCRCD1, A.CAREAADR1, A.CAREAADR2, A.CAREAADR3, A.CCONTACT1, A.CCONTACT2, A.CDPSERV, A.CRPSERV, A.CSFCSERV, A.CIPSERV, A.CAREAPIN, A.CAREACITY,A.CAPESERV,A.CTEL,A.CLOCTYPE,")
					.append( "    ( 6371 * acos ( cos ( degree2radian(:qLattitude) ) * cos( degree2radian( TO_NUMBER(trim(L.CLATITUDE)) ) ) * cos( degree2radian( TO_NUMBER(trim(L.CLONGITUDE)) ) - degree2radian(:qLongitude) ) + sin ( degree2radian(:qLattitude) ) * sin( degree2radian( TO_NUMBER(trim(L.CLATITUDE)) ) ) ) ) AS DISTANCE")
					.append( "    FROM LATLONGMST L, AREAMST A  WHERE A.CSTATE=:state AND nvl(A.CDPSERV,'*') != 'N' AND nvl(CLOCTYPE,'*') !=:type AND L.CSCRCD  = A.CSCRCD")
					.append( "    ORDER BY DISTANCE  FETCH FIRST :count ROWS ONLY  ) WHERE DISTANCE < :distance");
			Query query = getSession().createSQLQuery(getNearBySQL1.toString());
			query.setParameter("qLattitude", lat);
			query.setParameter("qLongitude", lng);
			query.setParameter("state", state.toUpperCase());
			query.setParameter("count", count);
			query.setParameter("distance", distance);
			query.setParameter("type", (Constants.DELIVERY).equalsIgnoreCase(type) ? Constants.C : Constants.Z);

			List<Object[]> rows = query.list();

			if (rows == null)
				return (LocationFinderDto) Collections.emptyList();
			serviceStationDTOResult = new ArrayList<>();

			for (Object[] row : rows) {
				stationDTO = new ServiceStationDTO();

				stationDTO.setLatitude(Converter.objToString(row[2]));
				stationDTO.setLongitude(Converter.objToString(row[3]));
				stationDTO.setAddress1(Converter.objToString(row[6]));
				stationDTO.setAddress2(Converter.objToString(row[7]));
				stationDTO.setAddress3(Converter.objToString(row[8]));
				stationDTO.setContact1(Converter.objToString(row[9]));
				stationDTO.setContact2(Converter.objToString(row[10]));
				stationDTO.setDomesticPriorityService(getServiceDetailsString(Converter.objToString(row[11])));
				stationDTO.setRegionalPriorityService(getServiceDetailsString(Converter.objToString(row[12])));
				stationDTO.setDartSurfaceLineService(Converter.objToString(row[13]));
				stationDTO.setInternationalPriorityService(getServiceDetailsString(Converter.objToString(row[14])));
				stationDTO.setPincode(Converter.objToString(row[16]));
				stationDTO.setAreaCity(Converter.objToString(row[17]));
				stationDTO.setDoorToDoorService(getServiceDetailsString(Converter.objToString(row[18])));
				stationDTO.setTelNo(Converter.objToString(row[19]));

				// -------------------------------
				// Service Details----------------
				// -------------------------------
				stationDTO.setJumboBoxService(getServiceDetailsString(Converter.objToString(row[14])));

				StringBuilder doorToAirportService = new StringBuilder(stationDTO.getDoorToDoorService());
				char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase())
						? Constants.Y : Constants.N;
				doorToAirportService.setCharAt(3, aircityFlag);
				stationDTO.setAirportToDoorService(
						Constants.O + doorToAirportService.charAt(3) + Constants.I_STRING + doorToAirportService.charAt(1));
				stationDTO.setDoorToAirportService(doorToAirportService.toString());
				stationDTO.setSmartBoxService(getServiceDetailsString(Converter.objToString(row[18])));
				stationDTO.setDartSurfaceLineService(getServiceDetailsString(Converter.objToString(row[12])));
				stationDTO.setAirportToAirportService(
						Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase()) ? Constants.OYIY
								: Constants.ONIN);
				serviceStationDTOResult.add(stationDTO);
			}
		} catch (Exception exp) {
			
			locationFinderLogger.error("EXCEPTION TYPE :",exp);
			
			locationFinderLogger.error("Error occured while quering " + exp.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 

		locationFinderDto.setServiceStationDTOList(serviceStationDTOResult);
		return locationFinderDto;
		
	}

	/**
	 * This method is used to to close result set
	 * @param resultSet
	 */
/*	private void releaseResult(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
			locationFinderLogger.error("Error Occured when closing result set" + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
	}*/
	
}
