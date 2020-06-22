package com.bluedart.common.serviceImpl;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bluedart.common.service.OTPService;
import com.bluedart.exception.BlueDartException;

@Service
public class OTPServiceImpl implements OTPService  {

	private static final Logger logger = Logger.getLogger(OTPServiceImpl.class);
	@Override
	public long generateOTP(int length) {
		// TODO Auto-generated method stub
		long otp = 0;
		try {
			Random randomNumber = new Random(System.currentTimeMillis());
			int j =10;		
			for(int i=2;i<length;i++) {
				j = j* 10;
			}
			otp = (long) (1 + randomNumber.nextInt(2)) * j + randomNumber.nextInt(j); 
		}
		catch(Exception e) {
			logger.error(e);
			throw new BlueDartException("-1","Not able to Generate OTP");
		}
		return otp;
	}
}
