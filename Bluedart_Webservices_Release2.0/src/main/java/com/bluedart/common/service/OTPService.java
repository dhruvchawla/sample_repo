package com.bluedart.common.service;

import com.bluedart.exception.BlueDartException;

public interface OTPService {

	public long generateOTP(int length) throws BlueDartException;
}
