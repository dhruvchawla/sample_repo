package com.bluedart.pod.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;

import org.hibernate.HibernateException;
import org.hibernate.jdbc.ReturningWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.common.webservice.SavePODEntryHandler;
import com.bluedart.exception.BlueDartException;
import com.bluedart.pod.dto.IdentificationTypeDto;
import com.bluedart.pod.dto.InOutboundDTO;
import com.bluedart.pod.dto.PODDto;
import com.bluedart.pod.dto.PodObjDto;
import com.bluedart.pod.dto.RelationTypeDto;
import com.bluedart.pod.dto.ShipmentDto;
import com.bluedart.pod.dto.ShipmentTrackingDto;
import com.bluedart.pod.exception.PODServiceException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.WSFaultFactory;


@Component
public class InboundOutBoundDBManager extends BaseDaoImpl {
	private static final  Logger loggerinfo = LoggerFactory.getLogger(InboundOutBoundDBManager.class);

	private Properties properties = new Properties();

	private long recSize = 0;
	
@Transactional
	public ShipmentTrackingDto trackPodInbound(java.sql.Date fromPickUpDate,java.sql.Date toDate,java.sql.Date reportAsOn,
			InOutboundDTO inboundDTO) throws PODServiceException {
	loggerinfo.trace(" InboundOutBoundDBManager : getTrackByAwbNoList ");
		ShipmentTrackingDto inboundDetailsObj = null;
		
		    
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
			inboundDetailsObj = getSession().doReturningWork(new ReturningWork<ShipmentTrackingDto>() {
				@Override
				public ShipmentTrackingDto execute(Connection connection) throws SQLException {
					ShipmentTrackingDto inboundDetailsObj = new ShipmentTrackingDto();
					
					Map<String, Class<?>> map = connection.getTypeMap();
					CallableStatement callableStatement = null;
					try {
						String userType = inboundDTO.getUserType();
						String procedure = null;
						
						if(userType.trim().equals("POD_USER")){
							procedure = Constants.POD_USER_INBOUND;
						}
						else{
							procedure = Constants.PARCEL_INBOUND;
						}
						
						map.put(properties.getProperty(Constants.SHIPOBJ_POD), Class.forName(Constants.SHIPMENT_DTO_POD));
						map.put(properties.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO_POD));
					connection.setTypeMap(map);
					callableStatement = connection.prepareCall(procedure);

					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
							properties.getProperty(Constants.PODLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
							properties.getProperty(Constants.SHIPLIST_POD));
					((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.NUMERIC);
					((OracleCallableStatement) callableStatement).setString(4, inboundDTO.getLoginId());

					((OracleCallableStatement) callableStatement).setString(5,inboundDTO.getDestination());
					((OracleCallableStatement) callableStatement).setDate(6, fromPickUpDate);
					((OracleCallableStatement) callableStatement).setDate(7, toDate);
					((OracleCallableStatement) callableStatement).setString(8, inboundDTO.getOrigin());
					((OracleCallableStatement) callableStatement).setString(9, inboundDTO.getCustCode());
					
					
					if (inboundDTO.getShipperCode() != null && inboundDTO.getShipperCode().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(10, inboundDTO.getShipperCode()); 
					} else {
						((OracleCallableStatement) callableStatement).setString(10, null);
					}

					if (inboundDTO.getStatusType() != null && inboundDTO.getStatusType().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(11, inboundDTO.getStatusType());
					} else {
						((OracleCallableStatement) callableStatement).setString(11, null);
					}
					((OracleCallableStatement) callableStatement).setDate(12,
							new java.sql.Date(((new GregorianCalendar()).getTime()).getTime()));
					((OracleCallableStatement) callableStatement).setString(13, inboundDTO.getSortBy());
					((OracleCallableStatement) callableStatement).setString(14, inboundDTO.getInOrder());
					((OracleCallableStatement) callableStatement).setInt(15, inboundDTO.getShipmentPerPage()); 
					((OracleCallableStatement) callableStatement).setInt(16, inboundDTO.getPageNumber()); // pageNumber
					((OracleCallableStatement) callableStatement).setInt(17, inboundDTO.getSecLevel());
					((OracleCallableStatement) callableStatement).setInt(18, inboundDTO.getReqScanFlag());
					((OracleCallableStatement) callableStatement).setString(19, inboundDTO.getValueAddedService());// Passing an
																												//additional service.
					((OracleCallableStatement) callableStatement).setString(20, inboundDTO.getParcelShopCode());
					((OracleCallableStatement) callableStatement).setString(21, inboundDTO.getDestServiceCenterCode());
					callableStatement.execute();

					ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
					ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
					long recordSize = ((OracleCallableStatement) callableStatement).getLong(3);
					if (recordSize <= 0) {
					inboundDetailsObj.setRecordSize(recordSize);
						return inboundDetailsObj;
					}

					inboundDetailsObj.setRecordSize(recordSize);

					long lEndTime = System.currentTimeMillis();
					long lStartTime = System.currentTimeMillis();
					loggerinfo.info(
							" Query Execution End Time in currentTimeMillis ===========> " + (lEndTime - lStartTime));

					loggerinfo.info(" Query Data convert into Java List Start ===========> " + lStartTime);

					if (shipArayList != null && shipArayList.length() != 0) {
						List<ShipmentDto> shipmentList = getShipmentDetails(shipArayList);
						inboundDetailsObj.setShipmentList(shipmentList);
					}
					if (podArrayList != null && podArrayList.length() != 0) {
						List<PodObjDto> podList = getPodDetails(podArrayList);
						inboundDTO.setPodList(podList);
					}

					long lEndTimer = System.currentTimeMillis();
					loggerinfo.info(" Query Data convert into Java List End ===========> " + (lEndTimer - lStartTime));
					
					} catch (Exception exception) {
						loggerinfo.error("EXCEPTION TYPE :",exception);
						loggerinfo.error("---------------trackPodInbound exception ---------------------");
						throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
				
				} 
					finally{
						logger.debug("---------------trackPodInbound finally ---------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return inboundDetailsObj;
				}
			});
		}catch (Exception exception) {
			loggerinfo.error("EXCEPTION TYPE :",exception);
			loggerinfo.error(exception.getMessage());
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), exception);
		}
		return inboundDetailsObj;
	 
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
		loggerinfo.trace(" InboundOutBoundDBManager ::: getShipmentDetails ");
		List<ShipmentDto> shipmentList = new ArrayList<>();
		Object[] object = (Object[]) shipList.getArray();
		ShipmentDto shipment;
		for (int i = 0; i < shipList.length(); i++) {
			
			shipment = new ShipmentDto();
			shipment = (ShipmentDto) object[i];
			if(shipment.getDpudate() != null){
			shipment.setDpudate(DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipment.getDpudate()), "dd/MM/yyyy"));
			}
			if(shipment.getDstatdate() != null){
			shipment.setDstatdate(DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipment.getDstatdate()), "dd/MM/yyyy"));
			}
			shipmentList.add(shipment);
		}
		loggerinfo.info(" InboundOutBoundDBManager ::: getShipmentDetails ");
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
	private List<PodObjDto> getPodDetails(ARRAY podList) throws SQLException {
		loggerinfo.trace(" InboundOutBoundDBManager ::: getPodDetails ");
		List<PodObjDto> podObjList = new ArrayList<>();
		Object[] object = (Object[]) podList.getArray();
		PodObjDto pod;
		for (int i = 0; i < podList.length(); i++) {
			pod = new PodObjDto();
			pod = (PodObjDto) object[i];
			podObjList.add(pod);
		}
		loggerinfo.info(" InboundOutBoundDBManager ::: getPodDetails ");
		return podObjList;
	}

	/**
	 * @return the recSize
	 */
	public long getRecSize() {
		return recSize;
	}

	/**
	 * @param recSize
	 *            the recSize to set
	 */
	public void setRecSize(long recSize) {
		this.recSize = recSize;
	}
	
	@Transactional
	public PODDto getShipmentDetails(String wayBillNumber,String loginId)  {
		PODDto entryFormResult = null;
		
		try {
			entryFormResult = getSession().doReturningWork(new ReturningWork<PODDto>() {
				@Override
				public PODDto execute(Connection connection) throws SQLException {
					PODDto podEntryFormDetails = new PODDto();
					CallableStatement callStatement = null;
					 ResultSet	rs = null;
					 ResultSet	rs1 = null;
					try {
						callStatement = connection
								.prepareCall("{call uprofile4.PKGPODSTATUS.PrcGetShipmentDetails_Search(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						callStatement.clearParameters();
					
						callStatement.setString(1, wayBillNumber);  // 14468937836, 50420539595 , 14805749582
						
						((OracleCallableStatement) callStatement).registerOutParameter(1,Types.VARCHAR); 
						callStatement.setString(2, loginId);//NGP00011, AUR00011
						
						((OracleCallableStatement) callStatement).registerOutParameter(3, Types.NUMERIC); 
						((OracleCallableStatement) callStatement).registerOutParameter(4, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(5, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(6, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(7, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(8, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(9, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(10, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(11, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(12, Types.VARCHAR); 
						((OracleCallableStatement) callStatement).registerOutParameter(13, Types.VARCHAR);
						((OracleCallableStatement) callStatement).registerOutParameter(14, Types.VARCHAR);
						((OracleCallableStatement) callStatement).registerOutParameter(15, Types.DATE);
						((OracleCallableStatement) callStatement).registerOutParameter(16, Types.VARCHAR);
						((OracleCallableStatement) callStatement).registerOutParameter(17, OracleTypes.CURSOR);
						((OracleCallableStatement) callStatement).registerOutParameter(18, OracleTypes.CURSOR);
						
						((OracleCallableStatement) callStatement).registerOutParameter(19, Types.VARCHAR);
						((OracleCallableStatement) callStatement).registerOutParameter(20, Types.NUMERIC);
						
						callStatement.execute();
					  	rs = (ResultSet) callStatement.getObject(17);
					  	rs1 = (ResultSet) callStatement.getObject(18);
					 List<RelationTypeDto> relDescDtoList = new ArrayList<>();
					  RelationTypeDto descDto  ;
					  List<IdentificationTypeDto> idDescDtoList = new ArrayList<>();
					  IdentificationTypeDto idDescDto;
					  
					if(rs != null && rs1!= null){  
					  while (rs.next()) {
						  descDto = new RelationTypeDto();
						  descDto.relationDesc=rs.getString("CRELATDESC");
						  descDto.relationDescCode = rs.getString("crelatcode");
						  relDescDtoList.add(descDto);
					  }
					
					  while (rs1.next()) {
						  idDescDto = new IdentificationTypeDto();
						  idDescDto.identificationDesc = rs1.getString("CIDDESC");
						  idDescDto.identificationType = rs1.getString("cidtype");
						  idDescDtoList.add(idDescDto);
			  		  }	
					  podEntryFormDetails.setRelationTypeDto(relDescDtoList);
					  podEntryFormDetails.setIdentificationTypeDto(idDescDtoList);
					  
					}
						podEntryFormDetails.setAwbNo(callStatement.getString(1));
						podEntryFormDetails.setRec(callStatement.getInt(3));
						podEntryFormDetails.setProductCode(callStatement.getString(4));
						podEntryFormDetails.setOriginCode(callStatement.getString(5));
						podEntryFormDetails.setDestCode(callStatement.getString(6));
						podEntryFormDetails.setParcelShop(callStatement.getString(7));
						podEntryFormDetails.setShipperCode(callStatement.getString(8));
						podEntryFormDetails.setSenderName(callStatement.getString(9));
						podEntryFormDetails.setConsignee(callStatement.getString(10));
						podEntryFormDetails.setPickupDate(callStatement.getString(11));
						podEntryFormDetails.setWeight(callStatement.getDouble(12));
						podEntryFormDetails.setValueAddedServices(callStatement.getString(13));
						podEntryFormDetails.setLocation(callStatement.getString(14));
						podEntryFormDetails.setStatusDate(callStatement.getDate(15));
						podEntryFormDetails.setStatusTime(callStatement.getString(16));
						//podEntryFormDetails.setEmployeeCode(callStatement.getString(19));
						podEntryFormDetails.setMessage(callStatement.getString(19));
						podEntryFormDetails.setOut(callStatement.getString(20));
						
						String searchVal= podEntryFormDetails.getMessage();
						System.out.println("searchVal: " + searchVal);
						if( searchVal.equalsIgnoreCase("Success") || searchVal.equalsIgnoreCase("CREDIT") ){
							PODDto c2pc = new PODDto();
						c2pc =	SavePODEntryHandler.getAwbSryAltInstruction(podEntryFormDetails);
						podEntryFormDetails.setSryAltInsError(c2pc.getSryAltInsError());
						podEntryFormDetails.setSryAltInsStatus(c2pc.getSryAltInsStatus());
						}else{
							podEntryFormDetails.setSryAltInsError(false);
							podEntryFormDetails.setSryAltInsStatus(null);
						}
						
					}catch(Exception e){
						loggerinfo.error("EXCEPTION TYPE :",e);
						//loggerinfo.info("Exception: " + e);
						throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
						
					} finally {
						logger.debug("---------------getShipmentDetails finally ---------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeResultSet(rs1);
						CloseConnections.closeCallableStatement(callStatement);
					}
					return podEntryFormDetails;
				}
			});
		} catch (HibernateException exp) {
			loggerinfo.error("EXCEPTION TYPE :",exp);
			loggerinfo.error("Error Occured when calling pininfo procedure" + exp.getMessage());
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		} 
		return entryFormResult;
	}

	@Transactional
	public ShipmentTrackingDto trackPodOutbound(java.sql.Date fromPickUpDate,java.sql.Date toDate,
			InOutboundDTO outboundDTO) throws PODServiceException {
		loggerinfo.trace(" InboundOutBoundDBManager : getTrackByAwbNoList ");
		long lStartTime = System.currentTimeMillis();
		@SuppressWarnings("unused")
		ShipmentTrackingDto outboundDetailsObj = null;
		
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
			outboundDetailsObj = getSession().doReturningWork(new ReturningWork<ShipmentTrackingDto>() {
				@Override
				public ShipmentTrackingDto execute(Connection connection) throws SQLException {
					ShipmentTrackingDto outboundDetailsObj = new ShipmentTrackingDto();
					
					Map<String, Class<?>> map = connection.getTypeMap();
					CallableStatement callableStatement = null;
					try {
						
						map.put(properties.getProperty(Constants.SHIPOBJ_POD), Class.forName(Constants.SHIPMENT_DTO_POD));
						map.put(properties.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO_POD));

					connection.setTypeMap(map);
					callableStatement = connection.prepareCall(
							"{call UPROFILE4.POD_MANG_TRACK_TRACE.TRACKPODOUTBOUND(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)}");

					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
							properties.getProperty(Constants.PODLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
							properties.getProperty(Constants.SHIPLIST_POD));
					((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.NUMERIC);
					((OracleCallableStatement) callableStatement).setString(4, outboundDTO.getLoginId());
					((OracleCallableStatement) callableStatement).setDate(5, fromPickUpDate);
					((OracleCallableStatement) callableStatement).setDate(6, toDate);
					((OracleCallableStatement) callableStatement).setString(7, outboundDTO.getOrigin());
					((OracleCallableStatement) callableStatement).setString(8, outboundDTO.getCustCode());
					((OracleCallableStatement) callableStatement).setString(9, outboundDTO.getDestination().toUpperCase());
					if (outboundDTO.getShipperCode() != null && outboundDTO.getShipperCode().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(10, outboundDTO.getShipperCode()); 
					} else {
						((OracleCallableStatement) callableStatement).setString(10, "");
					}

					if (outboundDTO.getStatusType() != null && outboundDTO.getStatusType().length() > 0) {
						((OracleCallableStatement) callableStatement).setString(11, outboundDTO.getStatusType());
					} else {
						((OracleCallableStatement) callableStatement).setString(11, "");
					}
					((OracleCallableStatement) callableStatement).setString(12, outboundDTO.getSortBy());
					((OracleCallableStatement) callableStatement).setString(13, outboundDTO.getInOrder());
					((OracleCallableStatement) callableStatement).setInt(14, outboundDTO.getShipmentPerPage()); 
																												
					((OracleCallableStatement) callableStatement).setInt(15, outboundDTO.getPageNumber()); 
					((OracleCallableStatement) callableStatement).setInt(16, outboundDTO.getSecLevel());
					((OracleCallableStatement) callableStatement).setInt(17, outboundDTO.getReqScanFlag());
					((OracleCallableStatement) callableStatement).setString(18, outboundDTO.getValueAddedService());
					((OracleCallableStatement) callableStatement).setString(19, outboundDTO.getParcelShopCode());
					((OracleCallableStatement) callableStatement).setString(20, outboundDTO.getDestServiceCenterCode());
					callableStatement.execute();

					ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
					ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
					long recordSize = ((OracleCallableStatement) callableStatement).getLong(3);
					if (recordSize <= 0) {
					outboundDetailsObj.setRecordSize(recordSize);
						return outboundDetailsObj;
					}
					outboundDetailsObj.setRecordSize(recordSize);

					long lEndTime = System.currentTimeMillis();
					loggerinfo.info(
							" Query Execution End Time in currentTimeMillis ===========> " + (lEndTime - lStartTime));

					long lStartTimer = System.currentTimeMillis();
					loggerinfo.info(" Query Data convert into Java List Start ===========> " + lStartTimer);

					if (shipArayList != null && shipArayList.length() != 0) {
						List<ShipmentDto> shipmentList = getShipmentDetails(shipArayList);
						outboundDetailsObj.setShipmentList(shipmentList);
					}
					if (podArrayList != null && podArrayList.length() != 0) {
						List<PodObjDto> podList = getPodDetails(podArrayList);
						outboundDTO.setPodList(podList);
					}

					long lEndTimer = System.currentTimeMillis();
					loggerinfo.info(" Query Data convert into Java List End ===========> " + (lEndTimer- lStartTimer));
					
					} catch (Exception exception) {
						loggerinfo.error("EXCEPTION TYPE :",exception);
						//loggerinfo.error("" + exception);
						throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
					} 
					finally{
						loggerinfo.debug("-----------------trackPodOutbound finally---------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return outboundDetailsObj;
				}
			});
		}catch (Exception exception) {
			loggerinfo.error("EXCEPTION TYPE :",exception);
			loggerinfo.error(exception.getMessage());
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), exception);
		}
		
		return outboundDetailsObj;
	}

}
