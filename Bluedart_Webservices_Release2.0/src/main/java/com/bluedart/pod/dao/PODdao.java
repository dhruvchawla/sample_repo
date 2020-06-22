package com.bluedart.pod.dao;

import org.springframework.stereotype.Component;

import com.bluedart.pod.dto.InOutboundDTO;
import com.bluedart.pod.dto.InboundOutboundDto;
import com.bluedart.pod.dto.InboundOutboundFilterDTO;
import com.bluedart.pod.dto.PODDto;
import com.bluedart.pod.dto.SavePodEntryDto;
import com.bluedart.pod.dto.ShipmentTrackingDto;
import com.bluedart.pod.exception.PODServiceException;


/**
 * @author AK765612
 *
 */
@Component
public interface PODdao {
	
	public InboundOutboundFilterDTO renderInboundPage(String loginId);
	public PODDto getPodDetails(String wayBillNumber,String loginId) throws PODServiceException;
	public SavePodEntryDto savePodDetails(SavePodEntryDto pODEntryDTO);
	public PODDto validateStatusCode(String statusCode);
	
	public ShipmentTrackingDto getInboundRecords(InOutboundDTO inboundDTO) throws PODServiceException;

	public ShipmentTrackingDto getOutboundRecords(InOutboundDTO outboundDto) throws PODServiceException;
	
	
}
