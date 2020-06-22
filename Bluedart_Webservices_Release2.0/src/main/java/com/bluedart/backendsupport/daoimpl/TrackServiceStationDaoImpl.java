/**
 * 
 */
package com.bluedart.backendsupport.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bluedart.backendsupport.dao.TrackServiceStationDao;
import com.bluedart.backendsupport.dto.ServiceStationDTO;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.FinderServiceFault;
import com.bluedart.utils.Constants;
import com.bluedart.utils.Converter;

import oracle.jdbc.OracleTypes;


/**
 * @author Velayutham Balasubramanian
 * @Description This Class contains all the methods related to Location Finder for Backend for supporting Windows 8 Mobile Applications.
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class TrackServiceStationDaoImpl extends BaseDaoImpl implements TrackServiceStationDao {
	private static Log logger = LogFactory.getLog(TrackServiceStationDaoImpl.class);
	
	private List<ServiceStationDTO> stationDTOsResult = null;
	private List<ServiceStationDTO> locationDTOsResult = null;

	/*
	 * @author Velayutham Balasubramanian
	 * 
	 * @Description This Method fetches serivice station details for a specific
	 * pincode
	 * 
	 * @see
	 * com.wipro.bluedart.dao.ServiceStationDao#getServiceStationsByPincode(java
	 * .lang.String)
	 */
	@Transactional
	@Override
	public List<ServiceStationDTO> getServiceStationsByPincode(String pincode) throws BlueDartException {
		
		logger.info(pincode);
		if (StringUtils.isEmpty(pincode)) {
			FinderServiceFault fault = getFaultInstance(Constants.FINDER_INPUT_ERRORCODE,
					"The Entered pincode is incorrect");
			throw new BlueDartException("Input Error", "Pincode is incorrect");
		}
		String getServiceStationsByPincodeSQL = "{call UPROFILE4.LOC_FINDER_NEW.pininfo_list(?,?)}";
		try {
			logger.info("Service station data fetched based on pincode");
			stationDTOsResult = getSession().doReturningWork(new ReturningWork< List<ServiceStationDTO> >() {
				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public List<ServiceStationDTO> execute(Connection connection) throws SQLException {
					try {
						callableStatement = connection.prepareCall(getServiceStationsByPincodeSQL);
						callableStatement.setString(1, pincode);
						callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						ServiceStationDTO stationDTO = null;
						stationDTOsResult = new ArrayList<>();
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
							stationDTO.setState(rs.getString("CSTATE"));
							logger.info(rs.getString("CSTATE"));
							// -------------------------------
							// Service Details----------------
							// -------------------------------
							stationDTO.setDomesticPriorityService(
									getServiceDetailsString(String.valueOf(rs.getString("CDPSERV"))));
							stationDTO.setInternationalPriorityService(
									getServiceDetailsString(String.valueOf(rs.getString("CIPSERV"))));
							stationDTO.setJumboBoxService(
									getServiceDetailsString(String.valueOf(rs.getString("CIPSERV"))));
							stationDTO.setDoorToDoorService(
									getServiceDetailsString(String.valueOf(rs.getString("CAPESERV"))));

							StringBuilder doorToAirportService = new StringBuilder(stationDTO.getDoorToDoorService());
							char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET
									.contains(stationDTO.getAreaCity().toUpperCase()) ? 'Y' : 'N';
							doorToAirportService.setCharAt(3, aircityFlag);

							stationDTO.setAirportToDoorService(
									"O" + doorToAirportService.charAt(3) + "I" + doorToAirportService.charAt(1));
							stationDTO.setDoorToAirportService(doorToAirportService.toString());
							stationDTO.setSmartBoxService(
									getServiceDetailsString(String.valueOf(rs.getString("CAPESERV"))));
							stationDTO.setDartSurfaceLineService(
									getServiceDetailsString(String.valueOf(rs.getString("CSFCSERV"))));
							stationDTO.setAirportToAirportService(
									Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase())
									? "OYIY" : "ONIN");

							stationDTOsResult.add(stationDTO);
							
						}
					} catch(Exception ex){
						
						logger.error("EXCEPTION TYPE :",ex);
				
					}
					finally {
					
						logger.debug("-----------------getServiceStationsByPincode finally -----------------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return stationDTOsResult;
				}
			});
		} catch (HibernateException exp) {
			logger.error("EXCEPTION TYPE :",exp);
	
			
			logger.error("Error Occured when calling pininfo procedure" + exp.getMessage());
			FinderServiceFault locationServiceFault = getFaultInstance(Constants.FINDER_DB_ERROR, exp.getMessage());
			throw new BlueDartException(Constants.FINDER_DB_ERROR_MSG, exp.getMessage());
		}

		return stationDTOsResult;
	}

/*	private void releaseConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}*/





	@Transactional
	@Override
	public List<ServiceStationDTO> getServiceStationsByLocationName(String locationName) throws BlueDartException {

		String getServiceStationsByLocationSQL = "{call UPROFILE4.LOC_FINDER_NEW.LOCINFO_LIST(?,?)}";
		try {
			logger.info("Service station data fetched based on location name");
			locationDTOsResult = getSession().doReturningWork(new ReturningWork< List<ServiceStationDTO> >() {
				CallableStatement callableStatement = null;
				ResultSet rs = null;
				@Override
				public List<ServiceStationDTO> execute(Connection connection) throws SQLException {
					callableStatement = connection.prepareCall(getServiceStationsByLocationSQL);
					callableStatement.setString(1, locationName.toUpperCase());
					callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
					callableStatement.execute();
					rs = (ResultSet) callableStatement.getObject(2);
					locationDTOsResult = new ArrayList<>();
					ServiceStationDTO stationDTO = null;
					StringBuilder doorToAirportService = null;
					String dbCityName = null;
					String dbStateName = null;
					try {
						while (rs.next()) {

							dbCityName = Converter.objToString(rs.getString("CAREACITY"));
							dbStateName = Converter.objToString(rs.getString("CSTATE"));

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
							stationDTO.setLocationName(Converter.objToString(rs.getString("CSCRCDDESC")), dbCityName);
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
									getServiceDetailsString(String.valueOf(rs.getString("CIPSERV"))));
							stationDTO.setJumboBoxService(
									getServiceDetailsString(String.valueOf(rs.getString("CIPSERV"))));
							stationDTO.setDoorToDoorService(
									getServiceDetailsString(String.valueOf(rs.getString("CAPESERV"))));

							doorToAirportService = new StringBuilder(stationDTO.getDoorToDoorService());
							char aircityFlag = Constants.FINDER_AIRPORT_CITIES_SET
									.contains(stationDTO.getAreaCity().toUpperCase()) ? 'Y' : 'N';
							doorToAirportService.setCharAt(3, aircityFlag);

							stationDTO.setAirportToDoorService(
									"O" + doorToAirportService.charAt(3) + "I" + doorToAirportService.charAt(1));
							stationDTO.setDoorToAirportService(doorToAirportService.toString());
							stationDTO.setSmartBoxService(
									getServiceDetailsString(String.valueOf(rs.getString("CAPESERV"))));
							stationDTO.setDartSurfaceLineService(
									getServiceDetailsString(String.valueOf(rs.getString("CSFCSERV"))));
							stationDTO.setAirportToAirportService(
									Constants.FINDER_AIRPORT_CITIES_SET.contains(stationDTO.getAreaCity().toUpperCase())
									? "OYIY" : "ONIN");

							rs.getString("bapeserv");
							rs.getString("bsfcserv");
							rs.getString("cscrcddesc");
							rs.getString("cscrcd");
							rs.getString("CQUERYFLAG");

							logger.info(Converter.objToString(rs.getString("CSTATE")));
							logger.info(stationDTO.getState());
							locationDTOsResult.add(stationDTO);
						}
					}catch(Exception exp){
						logger.error("EXCEPTION TYPE :",exp);
				
					}
					
					finally {
						logger.debug("-----------------getServiceStationsByLocationName finally -----------------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return locationDTOsResult;
				}

			});
		} catch (HibernateException exp) {
			logger.error("EXCEPTION TYPE :",exp);
	
			
			logger.error("Error Occured when calling pininfo procedure" + exp.getMessage());
			FinderServiceFault locationServiceFault = getFaultInstance(Constants.FINDER_DB_ERROR, exp.getMessage());
			throw new BlueDartException(Constants.FINDER_DB_ERROR_MSG, exp.getMessage());
		} 

		return locationDTOsResult;
	}

	/**
	 * @param valueOf
	 * @return
	 */
	protected String getServiceDetailsString(String serv) {
		if ("O".equalsIgnoreCase(serv))
			return "OYIN";
		else if ("I".equalsIgnoreCase(serv))
			return "ONIY";
		else
			return "OYIY";
	}

	private FinderServiceFault getFaultInstance(String errorCode, String errorMsg) {
		FinderServiceFault fault = new FinderServiceFault();
		fault.setFaultCode(errorCode);
		fault.setFaultString(errorMsg);
		return fault;
	}

/*	private void releaseResult(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
		}
		;
	}*/

}
