package com.bluedart.mobiledart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.mobiledart.dto.MobileDartDto;
import com.bluedart.mobiledart.helper.MobileDartHelper;
import com.bluedart.mobiledart.service.MobileDartService;
/*
 * @author CH848113
 */

@Service
public class MobileDartServiceImpl implements MobileDartService{

	@Autowired
	private MobileDartHelper mobileDartHandler;
	
	
	@Override
	public MobileDartDto trackByAwb(List<String> awbNumbers)  {
		return mobileDartHandler.trackByAwb(awbNumbers);
	}
	
	@Override
	public MobileDartDto intimateMe(List<String> awbNumbers, String mobileNumber) {
		return mobileDartHandler.intimateMe(awbNumbers, mobileNumber);
	}
	
	@Override
	public MobileDartDto reverseSMS(String message, String mobileNumber) {
		return mobileDartHandler.reverseSMS(message, mobileNumber);
	}

	@Override
	public boolean intimateMe() {
		return mobileDartHandler.intimateMe();
	}

	
	


	

}
