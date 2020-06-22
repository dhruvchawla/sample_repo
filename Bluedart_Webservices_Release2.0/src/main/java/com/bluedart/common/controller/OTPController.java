package com.bluedart.common.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.service.OTPService;
import com.bluedart.exception.BlueDartException;

@RestController
public class OTPController {

	
	@Autowired
	private OTPService otpService; 
	
	private static final Logger logger = Logger.getLogger(OTPController.class);
	
	@RequestMapping(value = "/otp/generateOTP/{length}", method = RequestMethod.GET)
	public long generateOTP(@PathVariable("length") int length) {
		long otp = 0;
		try {
			otp = otpService.generateOTP(length);
		} catch (BlueDartException e) {
			logger.error(e.getErrorMessage());
		}
		return otp;
	}
}
