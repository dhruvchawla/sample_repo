package com.bluedart.mobiledart.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.exception.BlueDartException;
import com.bluedart.mobiledart.dto.MobileDartDto;
import com.bluedart.mobiledart.service.MobileDartService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.SpringApplicationContext;
/*
 * @author CH848113
 */
@RestController
public class MobileDartController {
	
	private static final String MOBILE_DART_SERVICE =  "mobileDartService";
	
	@RequestMapping(value = "/mobiledart/smsRequest", method = RequestMethod.POST)
	public MobileDartDto smsRequest(@RequestBody MobileDartDto mobileDartDto ) {
		MobileDartService mailMobileDartService;
		MobileDartDto mobileDart = null;
		if(mobileDartDto.getAction().equalsIgnoreCase(Constants.TRACK)){
			mailMobileDartService = (MobileDartService) SpringApplicationContext.getBean(MOBILE_DART_SERVICE);
			mobileDart = mailMobileDartService.trackByAwb(mobileDartDto.getAwbNumbers());
			return mobileDart;
		}else if(mobileDartDto.getAction().equalsIgnoreCase(Constants.INTIMATEME)){
			mailMobileDartService = (MobileDartService) SpringApplicationContext.getBean(MOBILE_DART_SERVICE);
			mobileDart = mailMobileDartService.intimateMe(mobileDartDto.getAwbNumbers(), mobileDartDto.getMobileNumber());
			return mobileDart;
		}else if(mobileDartDto.getAction().equalsIgnoreCase(Constants.AUTOSORRY)){
			mailMobileDartService = (MobileDartService) SpringApplicationContext.getBean(MOBILE_DART_SERVICE);
			mobileDart = mailMobileDartService.reverseSMS(mobileDartDto.getReverseMessage(), mobileDartDto.getMobileNumber());
			return mobileDart;
		}else{
			mobileDart= new MobileDartDto();
			mobileDart.setError("Please select your  Option properly.");
			throw new BlueDartException("No proper action.","000");
			
		}
	}
}
