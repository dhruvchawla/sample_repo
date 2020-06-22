package com.bluedart.forgetpwd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.forgetpwd.dto.ForgotPasswordResponseDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.forgetpwd.service.ForgotPasswordService;
/**
 * 
 * @author PR334023
 * REST controller for Corporate Forgot Password functionality
 *
 */
@RestController
public class ForgotPasswordController {     
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	/**
	 * 
	 * @param forgotPwdDto
	 * @return
	 */
	@RequestMapping(value = "forgotpassword/sendforgotpasswordotp", method = RequestMethod.POST)
	public ResponseEntity<ForgotPasswordResponseDto> sendforgotpasswordotp(@RequestBody ForgotPasswordResponseDto forgotPwdDto) {
		ForgotPasswordResponseDto foDto = null;
		foDto = forgotPasswordService.sendForgotPasswordOTP(forgotPwdDto.getMailId());
		foDto.setStatusCode("OK");
		return new ResponseEntity(foDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param forgotPwdDto
	 * @return
	 */
	@RequestMapping(value = "forgotpassword/changenewpassword", method = RequestMethod.POST)
	public ResponseEntity<ForgotPasswordResponseDto> changeNewPassword(@RequestBody ForgotPasswordResponseDto forgotPwdDto) {
		ForgotPasswordResponseDto foDto = null;
		foDto = forgotPasswordService.changeNewPassword(forgotPwdDto);
		foDto.setStatusCode("OK");
		return new ResponseEntity(foDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "forgotpassword/checkexistingloginid/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ForgotPasswordResponseDto checkexistingloginid(@PathVariable String loginId) {
		ForgotPasswordResponseDto foDto = null;
		foDto = forgotPasswordService.checkExistingLoginId(loginId);
		foDto.setStatusCode("OK");
		return foDto;
	}
	/**
	 * 
	 * @param foException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private ForgotPasswordResponseDto myError(BlueDartException foException) {
		ForgotPasswordResponseDto foResponseDto = new ForgotPasswordResponseDto();
		foResponseDto.setStatusCode(foException.getErrorCode());
		foResponseDto.setErrorMessage(foException.getErrorMessage());
	    return foResponseDto;
	}
	/**
	 * 
	 * @param foException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private ForgotPasswordResponseDto mailError(BlueDartException foException) {
		ForgotPasswordResponseDto foResponseDto = new ForgotPasswordResponseDto();
		foResponseDto.setStatusCode(foException.getErrorCode());
		foResponseDto.setErrorMessage(foException.getErrorMessage());
	    return foResponseDto;
	}
	
}