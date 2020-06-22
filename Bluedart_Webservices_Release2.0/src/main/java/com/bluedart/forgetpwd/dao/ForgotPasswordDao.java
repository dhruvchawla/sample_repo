package com.bluedart.forgetpwd.dao;

import com.bluedart.forgetpwd.dto.ForgotPasswordResponseDto;
import com.bluedart.exception.BlueDartException;

/**
 * 
 * @author PR334023
 *
 */
public interface ForgotPasswordDao {
	
	public ForgotPasswordResponseDto sendForgotPasswordOTP(String mailID, long otpLength);
	
	public ForgotPasswordResponseDto changeNewPassword(ForgotPasswordResponseDto forgotPwdDto) throws BlueDartException;

	public ForgotPasswordResponseDto checkExistingLoginId(String loginId) throws BlueDartException;

}
