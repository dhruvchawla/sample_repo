package com.bluedart.pod.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.pod.constant.ResourceRequestMappingConstants;
import com.bluedart.pod.dto.IdentificationTypeDto;
import com.bluedart.pod.dto.InOutboundDTO;
import com.bluedart.pod.dto.InboundOutboundDto;
import com.bluedart.pod.dto.InboundOutboundFilterDTO;
import com.bluedart.pod.dto.RelationTypeDto;
import com.bluedart.pod.dto.SavePodEntryDto;
import com.bluedart.pod.dto.ShipmentTrackingDto;
import com.bluedart.pod.exception.PODServiceException;
import com.bluedart.pod.service.PODService;
import com.bluedart.pod.dto.PODDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.WSFaultFactory;



@RestController
public class PODController {

	private static final Logger logger = Logger.getLogger(PODController.class);

	@Autowired
	private PODService podDetailsService;
	
	@RequestMapping(value ="/podinout/getInboundOutboundfilter/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public InboundOutboundFilterDTO renderInOutboundPage(@PathVariable("loginId") String loginId) throws PODServiceException{
  
		InboundOutboundFilterDTO inboundOutboundFilterDTO=null;
		try {
			inboundOutboundFilterDTO =  podDetailsService.renderInboundPage(loginId);
		} catch(Exception e) {
			logger.info( e);
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), e);
		}
		return inboundOutboundFilterDTO;
	}

	@RequestMapping(value = "/podinout/validateStatusCode/{statusCode}", method = RequestMethod.GET,headers="Accept=application/json")
	public PODDto validateStatusCode(@PathVariable("statusCode") String statusCode) throws PODServiceException{
		PODDto pod =null;
		try{
			pod = podDetailsService.validateStatusCode(statusCode);
		} catch (Exception ex) {
			logger.info(ex);
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), ex);
		}
		
		return pod;
	}
	
	@RequestMapping(value = "/podinout/getPodDetails/{wayBillNumber}/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public PODDto getPodDetails(@PathVariable("wayBillNumber") String wayBillNumber, @PathVariable("loginId") String loginId) throws PODServiceException {
		logger.info("Calling getPODEntryDetails");
		PODDto entryDTO = new PODDto();
		try {
			entryDTO = podDetailsService.getPodDetails(wayBillNumber,loginId);
			
		} catch (Exception ex) {
			logger.info(ex);
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), ex);
		}
		
		return entryDTO; 
	}	

	@RequestMapping(value = ResourceRequestMappingConstants.SAVE_POD_ENTRY, method = RequestMethod.POST)
    public SavePodEntryDto savePodDetails(@RequestBody SavePodEntryDto pODEntryDTO) throws PODServiceException {
		SavePodEntryDto savePodEntryDto = new SavePodEntryDto();
			try { 
				savePodEntryDto = podDetailsService.savePodDetails(pODEntryDTO);
			} catch (Exception ex) {
				logger.info(ex);
				throw new PODServiceException(Constants.SERVICE_DOWN,
						WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), ex);
			}
		return savePodEntryDto;    
    }
	
	@RequestMapping(value = ResourceRequestMappingConstants.INBOUND_SHIPMENT_DETAILS, method = RequestMethod.POST)
	public ShipmentTrackingDto getInboundRecords(@RequestBody InOutboundDTO inboundDTO) throws PODServiceException {
		ShipmentTrackingDto shipment = new ShipmentTrackingDto();
		try {
			shipment = podDetailsService.getInboundRecords(inboundDTO);
		} catch (Exception e) {
			logger.info(e);
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), e);
		}
		return shipment;  
	}
	
	@RequestMapping(value = ResourceRequestMappingConstants.OUTBOUND_SHIPMENT_DETAILS, method = RequestMethod.POST)
	public ShipmentTrackingDto getOutboundRecords(@RequestBody InOutboundDTO outboundDto) throws PODServiceException {
		ShipmentTrackingDto shipment = new ShipmentTrackingDto();
		try {
			shipment = podDetailsService.getOutboundRecords(outboundDto);
		} catch (Exception e) {
			logger.info(e);
			throw new PODServiceException(Constants.SERVICE_DOWN,
					WSFaultFactory.getInstance(Constants.DB_DOWN_ERROR_CODE, Constants.SERVICE_DOWN), e);
		}
		return shipment;
	}

	
}
