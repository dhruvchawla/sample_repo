package com.bluedart.forgetpwd.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.service.OTPService;
import com.bluedart.forgetpwd.dao.ForgotPasswordDao;
import com.bluedart.forgetpwd.dto.ForgotPasswordResponseDto;
import com.bluedart.forgetpwd.service.ForgotPasswordService;
/**
 * 
 * @author PR334023
 *
 */
@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService{
	
	@Autowired
	private OTPService otpService;

	@Autowired
	private ForgotPasswordDao forgotPasswordDao;
	
	@Override
	public ForgotPasswordResponseDto sendForgotPasswordOTP(String mailID) {
		long otpLength = otpService.generateOTP(6);
		return forgotPasswordDao.sendForgotPasswordOTP(mailID, otpLength);
	}

	@Override
	public ForgotPasswordResponseDto changeNewPassword(ForgotPasswordResponseDto forgotPwdDto) {
		return forgotPasswordDao.changeNewPassword(forgotPwdDto);
	}

	@Override
	public ForgotPasswordResponseDto checkExistingLoginId(String loginId) {
		return forgotPasswordDao.checkExistingLoginId(loginId);
	}
}