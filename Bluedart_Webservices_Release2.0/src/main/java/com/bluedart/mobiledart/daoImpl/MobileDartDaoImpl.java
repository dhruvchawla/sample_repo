package com.bluedart.mobiledart.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.TrackDto;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.mobiledart.dao.MobileDartDao;
import com.bluedart.utils.Constants;
import com.bluedart.utils.StringUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
/*
 * @author CH848113
 */

@Repository
@PropertySource("classpath:procedure.properties")
public class MobileDartDaoImpl extends BaseDaoImpl implements MobileDartDao{
	private static final Logger log = Logger.getLogger(MobileDartDaoImpl.class);

	private String[] awbNos = null ;
	
	@Autowired
	Environment environment;

	@Transactional
	@Override
	public int intimateMe(List<String> awbNumbers, String mobileNumber){
		int retValue = -1;
		
		if (!StringUtils.isNullOrEmpty(awbNumbers)) {
			awbNos = awbNumbers.toArray(new String[awbNumbers.size()]);
		}
		try {
			 retValue = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					int retValue = -1;
					CallableStatement callableStatement = null;
					try{
					ArrayDescriptor descAwbnoList = ArrayDescriptor.createDescriptor(environment.getProperty(Constants.NUMLIST),
							connection);
					ARRAY awbNumbers = new ARRAY(descAwbnoList, connection, awbNos);
					callableStatement = connection.prepareCall("{call tnt_mang.intimateMeSMS(?, ?, ? )}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setARRAY(1, awbNumbers);
					((OracleCallableStatement) callableStatement).setString(2, mobileNumber);
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.INTEGER);
					callableStatement.execute();
					retValue = ((OracleCallableStatement) callableStatement).getInt(3);
					}catch(Exception exception){
						log.error("EXCEPTION TYPE :",exception);
						log.error("-----------------intimateMe exception blocak-------------------------");
					}finally{
						log.debug("---------------------intimateMe finally-----------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return retValue;
				}
			});
		}
		catch (DataBaseException exception) {
			log.error("EXCEPTION TYPE :",exception);
			log.info(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		} 
	
		
		return retValue;
	}
	
	@Transactional
	@Override
	public int reverseSMS(String message, String mobileNumber){
		int retValue = -1;
		try {
			 retValue = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					int retValue = 0;
					CallableStatement callableStatement = null;
					try{
					callableStatement = connection
							.prepareCall("{call tnt_mang.UpdateReversSMS(?, ?, ?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setString(1, mobileNumber);
					((OracleCallableStatement) callableStatement).setString(2, message);
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.INTEGER);
					callableStatement.execute();
					retValue = ((OracleCallableStatement) callableStatement).getInt(3);
					}catch(Exception exception){
						log.error("EXCEPTION TYPE :",exception);
						log.error("--------------reverseSMS exception block--------------------");
					}finally{
						log.debug("----------------------reverseSMS finally----------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					
					return retValue;
				}
			});
		}
		catch (DataBaseException exception) {
			log.error("EXCEPTION TYPE :",exception);
			log.info(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		} 
		
		return retValue;
		
	}
	
	@Transactional
	public TrackDto intimateMe(){
		TrackDto trackDto = null;
		try{
		trackDto = getSession().doReturningWork(new ReturningWork<TrackDto>() {
			@Override
			public TrackDto execute(Connection connection) throws SQLException {
				TrackDto trackDto = new TrackDto();
				Map<String, Class<?>> map = connection.getTypeMap();
				CallableStatement callableStatement = null;
				try {
					map.put(environment.getProperty(Constants.SHIPOBJ), Class.forName(Constants.SHIPMENT_DTO));
					map.put(environment.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
				} catch (Exception exception) {
					throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
				}
				connection.setTypeMap(map);
				try
				{
				callableStatement = connection.prepareCall("{call tnt_mang.getDeliveredSms(?,?)}");
			
				((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
						environment.getProperty(Constants.PODLIST));
				((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
						environment.getProperty(Constants.SHIPLIST));
			
				callableStatement.execute();
				//ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
				ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
				if (null != shipArayList  && shipArayList.length() != 0 ) {
					List<ShipmentDto> shipmentList = getShipmentDetails(shipArayList);
					trackDto.setShipmentList(shipmentList);
				}
				/*if (podArrayList != null && podArrayList.length() != 0) {
					List<PodDto> podList = getPodDetails(podArrayList);
					trackDto.setPodList(podList);
				}*/		
				
				}catch(Exception exception){
					log.error("EXCEPTION TYPE :",exception);
					log.error("------------------intimateMe exception block------------------");
				}finally{
					log.debug("-------------------------intimateMe finally------------------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				
				return trackDto;
			}
		});
		}
		catch(DataBaseException exception){
			log.info(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return trackDto;
		
	}
	
	
	private List<ShipmentDto> getShipmentDetails(ARRAY shipList) throws SQLException {
		List<ShipmentDto> shipmentList = new ArrayList<>();
		Object[] object = (Object[]) shipList.getArray();
		ShipmentDto shipment = null;
		for (int i = 0; i < shipList.length(); i++) {
			shipment = (ShipmentDto) object[i];
			shipmentList.add(shipment);
		}
		return shipmentList;
	}
	
	/*private List<PodDto> getPodDetails(ARRAY podList) throws SQLException {
		List<PodDto> podObjList = new ArrayList<>();
		Object[] object = (Object[]) podList.getArray();
		PodDto pod = null;
		for (int i = 0; i < podList.length(); i++) {
			pod = new PodDto();
			pod = (PodDto) object[i];
			podObjList.add(pod);
		}
		return podObjList;
	}*/
	
	

}
