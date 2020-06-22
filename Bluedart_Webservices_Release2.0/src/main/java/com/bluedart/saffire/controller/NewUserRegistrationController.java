package com.bluedart.saffire.controller;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.dto.TrackDto;
import com.bluedart.ebusinesssolutions.dto.EBusinessSolutionsDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.saffire.dto.NewUserRegistrationDTO;
import com.bluedart.saffire.service.NewUserRegistrationService;
import com.bluedart.trackdart.controller.TrackDartController;
import com.bluedart.utils.Constants;


@RestController
public class NewUserRegistrationController {

	@Autowired
	private NewUserRegistrationService newUserRegistrationService;


	private static final Logger logger = Logger.getLogger(NewUserRegistrationController.class);

/*	@RequestMapping(value = "/safireingration/savenewuser", method = RequestMethod.POST,headers="Accept=application/json")
	public NewUserRegistrationDTO saveUserRegistration(@RequestBody NewUserRegistrationDTO newUserRegistrationDTO) throws RemoteException {
		logger.info("Entered in the saveUserRegistration Controller method");
		return newUserRegistrationService.saveNewUserRegistration(newUserRegistrationDTO);		
	}*/

	@RequestMapping(value ="/safireintegration/sendotp/{length}/{mobilenumber}", method = RequestMethod.GET,headers = "Accept=application/json")
	public NewUserRegistrationDTO getOTPAndSendSMS(@PathVariable("length") int length,@PathVariable("mobilenumber") String mobilenumber )throws RemoteException{
		long otp = 0;
		NewUserRegistrationDTO newUserRegistrationDTO = new NewUserRegistrationDTO();
		logger.info("Entered in the sendOTP Controller method");
		newUserRegistrationDTO = newUserRegistrationService.getOTPAndSendSMS(length,mobilenumber);		
		return newUserRegistrationDTO;
	}


	@RequestMapping(value ="/newUserTest", method = RequestMethod.GET,headers = "Accept=application/json")
	public String newUser( )throws RemoteException{
		return "Welcome to test";
	}
	
	/**
	 * 
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private NewUserRegistrationDTO TrackDartException(DataBaseException serviceException) {
		NewUserRegistrationDTO errorDto = new NewUserRegistrationDTO();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMessage(serviceException.getErrorMessage());
		return errorDto;
	}
	
	/**
	 * 
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private NewUserRegistrationDTO TrackDartException(BlueDartException serviceException) {
		NewUserRegistrationDTO errorDto = new NewUserRegistrationDTO();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMessage(serviceException.getErrorMessage());
		return errorDto;
	}
	
	@RequestMapping(value = "/safireingration/savenewuser", method = RequestMethod.POST)
	public NewUserRegistrationDTO  submitUserRegisterationData(@RequestBody NewUserRegistrationDTO newUserRegisteration) throws BlueDartException{
	

		NewUserRegistrationDTO newUserRegisterationDto = new NewUserRegistrationDTO();
		newUserRegisterationDto.setEmailSent(newUserRegistrationService.submitUserRegisterationData(newUserRegisteration));
		newUserRegisterationDto.setStatusCode(Constants.SUCESSCODE);
		newUserRegisterationDto.setStatusMessage(Constants.SUCESSMESSAGE);
		newUserRegisterationDto.setResult(Constants.RESULT);		
		return newUserRegisterationDto;
		
	}
}
