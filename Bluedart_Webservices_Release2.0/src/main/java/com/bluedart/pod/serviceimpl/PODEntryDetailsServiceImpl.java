package com.bluedart.pod.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.pod.dao.PODdao;
import com.bluedart.pod.dto.InOutboundDTO;
import com.bluedart.pod.dto.InboundOutboundDto;
import com.bluedart.pod.dto.InboundOutboundFilterDTO;
import com.bluedart.pod.dto.PODDto;
import com.bluedart.pod.dto.SavePodEntryDto;
import com.bluedart.pod.dto.ShipmentTrackingDto;
import com.bluedart.pod.exception.PODServiceException;
import com.bluedart.pod.service.PODService;

/**
 * @author AK765612
 *
 */
@Service
public class PODEntryDetailsServiceImpl implements PODService {
	
	@Autowired
	private PODdao podDetailsDao;

	@Override
	public PODDto getPodDetails(String wayBillNumber,String loginId) throws PODServiceException {
		return podDetailsDao.getPodDetails(wayBillNumber,loginId);
	}

	@Override
	public ShipmentTrackingDto getInboundRecords(InOutboundDTO inboundDTO) throws PODServiceException {
		return podDetailsDao.getInboundRecords(inboundDTO);
	}

	@Override
	public InboundOutboundFilterDTO renderInboundPage(String loginId) {
		return podDetailsDao.renderInboundPage(loginId);

	}

	@Override
	public SavePodEntryDto savePodDetails(SavePodEntryDto pODEntryDTO) {
		return podDetailsDao.savePodDetails(pODEntryDTO);
	}
	
	@Override
	public ShipmentTrackingDto getOutboundRecords(InOutboundDTO outboundDto) throws PODServiceException{
	return podDetailsDao.getOutboundRecords(outboundDto);
	}
	
	@Override
	public PODDto validateStatusCode(String statusCode) {
		return podDetailsDao.validateStatusCode(statusCode);
	}
	
	
}
