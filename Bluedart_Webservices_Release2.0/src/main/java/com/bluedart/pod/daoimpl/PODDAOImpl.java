package com.bluedart.pod.daoimpl;
/**
 * 
 */


import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;

import org.hibernate.SQLQuery;
import org.hibernate.jdbc.ReturningWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.common.webservice.SavePODEntryHandler;
import com.bluedart.exception.BlueDartException;
import com.bluedart.pod.dao.PODdao;
import com.bluedart.pod.dto.InOutboundDTO;
import com.bluedart.pod.dto.InboundOutboundFilterDTO;
import com.bluedart.pod.dto.PODDto;
import com.bluedart.pod.dto.PacklistDTO;
import com.bluedart.pod.dto.ProdlistDTO;
import com.bluedart.pod.dto.SavePodEntryDto;
import com.bluedart.pod.dto.ShipmentTrackingDto;
import com.bluedart.pod.dto.SpslistDTO;
import com.bluedart.pod.exception.BusinessRuntimeException;
import com.bluedart.pod.exception.PODServiceException;
import com.bluedart.utils.Constants;


@Repository
public class PODDAOImpl extends BaseDaoImpl implements PODdao {
  private static final  Logger loggerinfo = LoggerFactory.getLogger(PODDAOImpl.class);

	
	private Properties properties = new Properties();

	@Autowired
	private InboundPODDBManager inboundPODDBManager;

	protected Object awbnos;
	
	@Override
	@Transactional
	public PODDto getPodDetails(String wayBillNumber,String loginId) throws PODServiceException {
		
		PODDto podDTO = null;
		try {
			podDTO = inboundPODDBManager.getShipmentDetails(wayBillNumber,loginId);
			return podDTO;
		} catch (Exception exception) {
			loggerinfo.error("EXCEPTION TYPE :",exception);
		//	loggerinfo.error("", exception);
			throw new BusinessRuntimeException(exception.getMessage());
		} 
	}

@Override
@Transactional
	public InboundOutboundFilterDTO renderInboundPage(String loginId) {

InboundOutboundFilterDTO inboundOutboundFilterDTO=null;
try {
	properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
	
	inboundOutboundFilterDTO = getSession().doReturningWork(new ReturningWork<InboundOutboundFilterDTO>(){
		
		@Override
		public InboundOutboundFilterDTO execute(Connection connection) throws SQLException {
			InboundOutboundFilterDTO inboundOutboundFilterDTO=new InboundOutboundFilterDTO();
			Map<String, Class<?>> map = connection.getTypeMap();
			
			CallableStatement callableStatement = null;
			try {
				map.put(properties.getProperty(Constants.SPSOBJ),Class.forName(Constants.SpslistDTO));			
				map.put(properties.getProperty(Constants.PRODUCTOBJ), Class.forName(Constants.ProdlistDTO));
				map.put(properties.getProperty(Constants.PACKTYPE_OBJ), Class.forName(Constants.PacklistDTO));

			connection.setTypeMap(map);
			callableStatement = connection.prepareCall(
					"{call UPROFILE4.POD_MANG_TRACK_TRACE.INBOUNDOUTBOUNDFILTER(?, ?, ?, ?, ? , ? )}");

			
			callableStatement.clearParameters();
			((OracleCallableStatement) callableStatement).setString(1, loginId);
			((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
					properties.getProperty(Constants.SPSLIST));
			
			((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
					properties.getProperty(Constants.PRODLIST));
			
			((OracleCallableStatement) callableStatement).registerOutParameter(4, java.sql.Types.ARRAY,
					properties.getProperty(Constants.PACKLIST));
			((OracleCallableStatement) callableStatement).registerOutParameter(5,java.sql.Types.VARCHAR);
			((OracleCallableStatement) callableStatement).registerOutParameter(6,java.sql.Types.NUMERIC);
			callableStatement.execute();
			
			ARRAY spsArray = ((OracleCallableStatement) callableStatement).getARRAY(2);
			ARRAY prodAray = ((OracleCallableStatement) callableStatement).getARRAY(3);
			ARRAY packAray = ((OracleCallableStatement) callableStatement).getARRAY(4);
			
			String vType = ((OracleCallableStatement) callableStatement).getString(5);
			int security = ((OracleCallableStatement) callableStatement).getInt(6);
			inboundOutboundFilterDTO.setSecurity(security);
			if(spsArray != null && spsArray.length() != 0){
				List<SpslistDTO> serviceProductServiceList = getServiceProductServiceList(spsArray);
				inboundOutboundFilterDTO.setServiceProductServiceList(serviceProductServiceList);
			}
			
			if (prodAray != null && prodAray.length() != 0){
				List<ProdlistDTO> prodList=getProdList(prodAray) ;
				inboundOutboundFilterDTO.setProdList(prodList);
			}
			if (packAray != null && packAray.length() != 0) {
				List<PacklistDTO> packtypeList=getPacktypeList(packAray);
				inboundOutboundFilterDTO.setPacktypeList(packtypeList);
			}
			
			if(vType!=null){
				inboundOutboundFilterDTO.setValueType(vType);
			}
			} catch (Exception exception) {
				loggerinfo.error("EXCEPTION TYPE :",exception);
				throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}finally{
			loggerinfo.debug("-----------------renderInboundPage finally---------------");
			CloseConnections.closeCallableStatement(callableStatement);
		}
			return inboundOutboundFilterDTO;
		}	
});
} catch (IOException e) {
	loggerinfo.error("EXCEPTION TYPE :",e);
	throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
}
return inboundOutboundFilterDTO;
}

	private List<SpslistDTO> getServiceProductServiceList(ARRAY spsArray) throws SQLException {
	List<SpslistDTO> spslistDTOs=new ArrayList<>();
	Object[] object = (Object[]) spsArray.getArray();
	SpslistDTO spslistDTO;
	for (int i = 0; i < spsArray.length(); i++) {
		spslistDTO = new SpslistDTO();
		spslistDTO = (SpslistDTO) object[i];
		spslistDTOs.add(spslistDTO);
	}
	return spslistDTOs;
}

private List<ProdlistDTO>  getProdList(ARRAY prodAray) throws SQLException {
	List<ProdlistDTO> prodlistDTOs=new ArrayList<>();
	Object[] object = (Object[]) prodAray.getArray();
	ProdlistDTO prodlistDTO;
	for (int i = 0; i < prodAray.length(); i++) {
		prodlistDTO = new ProdlistDTO();
		prodlistDTO = (ProdlistDTO) object[i];
		prodlistDTOs.add(prodlistDTO);
	}
	
	return prodlistDTOs;
}

private List<PacklistDTO>   getPacktypeList(ARRAY packAray) throws SQLException {
	List<PacklistDTO> packlistDTOs=new ArrayList<>();
	
	Object[] object = (Object[]) packAray.getArray();
	PacklistDTO packlistDTO ;
	for (int i = 0; i < packAray.length(); i++) {
		packlistDTO = new PacklistDTO();
		packlistDTO = (PacklistDTO) object[i];
		packlistDTOs.add(packlistDTO);
	}
	return packlistDTOs;	
	}

	
@Override
@Transactional
	public SavePodEntryDto savePodDetails(SavePodEntryDto pODEntryDTO) {
		SavePodEntryDto savePodEntryDto = new SavePodEntryDto();
		try {
			savePodEntryDto = SavePODEntryHandler.savePODEntryDetails(pODEntryDTO);
		} catch (Exception e) {
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		} 
		return savePodEntryDto;
	}
@Override
@Transactional
	public ShipmentTrackingDto getOutboundRecords(InOutboundDTO outboundDto)
			throws PODServiceException {
		ShipmentTrackingDto customQueryDto = null;
		try {
			 customQueryDto = inboundPODDBManager.fetchOutboundPODDetails(outboundDto);
			return customQueryDto;
		} catch (Exception exception) {
			loggerinfo.error("EXCEPTION TYPE :",exception);
			//loggerinfo.error("", exception);
			throw new BusinessRuntimeException(exception.getMessage());
		} 
	}
@Override
@Transactional
	public ShipmentTrackingDto getInboundRecords(InOutboundDTO inboundDTO) throws PODServiceException {
		
		ShipmentTrackingDto shipmentTrackingDto = new ShipmentTrackingDto();
		try {
			shipmentTrackingDto = inboundPODDBManager.fetchInboundPODDetails(inboundDTO);
		} catch (Exception exception) {
			loggerinfo.error("EXCEPTION TYPE :",exception);
		//	loggerinfo.error("", exception);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		} 
		return shipmentTrackingDto;
	}

	@Override
	@Transactional
	public PODDto validateStatusCode(String statusCode) {
		String returnValue = null;
		PODDto pod = new PODDto();
		try{
			SQLQuery query = getSession().createSQLQuery("SELECT CSTATDESC FROM STATMST WHERE CSTATCODE = :VSTATCODE and CSTATTYPE = 'T' ");
			query.setParameter("VSTATCODE", statusCode);
			List statusCodes = query.list();
			
			if(!statusCodes.isEmpty()){
				returnValue = statusCodes.get(0).toString();
			}
			else{
				returnValue = "Invalid Status Code";
			}
			pod.setStatusDesc(returnValue);
		}
		catch(Exception e){
			loggerinfo.error("EXCEPTION TYPE :",e);
			//loggerinfo.info("Exception: " + e);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return pod;		
	}



}
