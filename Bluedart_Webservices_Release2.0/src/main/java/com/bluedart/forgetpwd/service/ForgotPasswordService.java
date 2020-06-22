package com.bluedart.forgetpwd.service;

import com.bluedart.forgetpwd.dto.ForgotPasswordResponseDto;

/**
 * 
 * @author PR334023
 *
 */
public interface ForgotPasswordService {

	public ForgotPasswordResponseDto sendForgotPasswordOTP(String mailID);
	
	public ForgotPasswordResponseDto changeNewPassword(ForgotPasswordResponseDto forgotPwdDto);
	
	public ForgotPasswordResponseDto checkExistingLoginId(String loginId);
}
