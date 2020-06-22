/**
 * 
 */
package com.bluedart.pod.daoimpl;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.exception.BlueDartException;
import com.bluedart.pod.dto.InOutboundDTO;
import com.bluedart.pod.dto.PODDto;
import com.bluedart.pod.dto.ShipmentTrackingDto;
import com.bluedart.pod.exception.PODServiceException;
import com.bluedart.trackdart.dao.FindSecurityLevelDao;
import com.bluedart.utils.Constants;

/**
 * @author AK765612
 *
 */
@Component
public class InboundPODDBManager extends BaseDaoImpl{

	private static final Logger loggerinfo = Logger.getLogger(InboundPODDBManager.class);

	@Autowired
	FindSecurityLevelDao findSecurityLevelDao;

	@Autowired
	private InboundOutBoundDBManager inboundOutBoundDBManager;

	public ShipmentTrackingDto fetchInboundPODDetails(InOutboundDTO inboundDTO) throws PODServiceException {
		ShipmentTrackingDto shipTrack = new ShipmentTrackingDto();
		String datefrom=inboundDTO.getFromPickUpDate();
		String todate=inboundDTO.getToPickUpDate();
		String report=inboundDTO.getReportAsOn();
		try {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fromDate = sdf1.parse(datefrom);
		java.util.Date endDate = sdf1.parse(todate);
		java.util.Date reporton = sdf1.parse(report);
			
			
		java.sql.Date fromPickUpDate = new java.sql.Date(fromDate.getTime());  
			java.sql.Date toDate = new java.sql.Date(endDate.getTime());
			java.sql.Date reportAsOn = new java.sql.Date(reporton.getTime());
			shipTrack = inboundOutBoundDBManager.trackPodInbound(fromPickUpDate, toDate,reportAsOn,inboundDTO);
			
			
		} catch (Exception e) {
			loggerinfo.error("EXCEPTION TYPE :",e);
			//loggerinfo.info("Exception: " + e);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
				return shipTrack;
		}
		

	public PODDto getShipmentDetails(String wayBillNumber,String loginId) throws PODServiceException {
		return inboundOutBoundDBManager.getShipmentDetails(wayBillNumber,loginId);
	}
	
	public ShipmentTrackingDto fetchOutboundPODDetails(
			InOutboundDTO outboundDto) throws PODServiceException {
		ShipmentTrackingDto shipTrack = new ShipmentTrackingDto();
		
		String datefrom=outboundDto.getFromPickUpDate();
		String todate=outboundDto.getToPickUpDate();
	
		try {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
		java.util.Date fromDate = sdf1.parse(datefrom);
		java.util.Date endDate = sdf1.parse(todate);
			
			java.sql.Date fromPickUpDate = new java.sql.Date(fromDate.getTime());  
			java.sql.Date toDate = new java.sql.Date(endDate.getTime());
			shipTrack = inboundOutBoundDBManager.trackPodOutbound(fromPickUpDate, toDate,outboundDto);
		} catch (Exception e) {
			loggerinfo.error("EXCEPTION TYPE :",e);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
				return shipTrack;
		}
	
		}

