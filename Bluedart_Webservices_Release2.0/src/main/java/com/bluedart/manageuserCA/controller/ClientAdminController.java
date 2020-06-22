package com.bluedart.manageuserCA.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.manageuserCA.daoImpl.ClientAdminDaoImpl;
import com.bluedart.manageuserCA.dto.ClientAdminResponseDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.manageuserCA.service.ClientAdminService;


@RestController
public class ClientAdminController {
	
	
	private static final Logger logger = Logger.getLogger(ClientAdminController.class);
	@Autowired
	private ClientAdminService clientAdminService;
	
	/**
	 * @description Method to create new corporate user.
	 * @param userBasicDetails
	 * @return
	 */
	@RequestMapping(value = "clientadmin/createnewuser", method = RequestMethod.POST)
	public ResponseEntity<ClientAdminResponseDto> createNewUser(@RequestBody UserBasicDetailsDto userBasicDetails) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.createNewUser(userBasicDetails);
		clResponseDto.setStatusCode("OK");		
		return new ResponseEntity(clResponseDto, HttpStatus.OK);
	}
	
	/**
	 * @description Method to delete corporate user.
	 * @param userLoginId
	 * @param adminLoginId
	 * @return
	 */
	@RequestMapping(value = "clientadmin/deleteuser/{userLoginId}/{adminLoginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto deleteUser(@PathVariable String userLoginId,@PathVariable String adminLoginId) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.deleteUser(userLoginId, adminLoginId);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}
	
	/**
	 * @description Method to view corporate users based on the starting letter of their name.
	 * @param loginId
	 * @param letter
	 * @return
	 */
	@RequestMapping(value = "clientadmin/viewusers/{loginId}/{letter}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto viewUsers(@PathVariable String loginId,@PathVariable String letter) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.viewUsers(loginId, letter);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}
	
	/**
	 * @description method to get details of a particular corporate user.
	 * @param loginId
	 * @return
	 * @throws ClientAdminServiceException
	 */
	@RequestMapping(value = "clientadmin/getsingleuser/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto getSingleUser(@PathVariable String loginId) throws BlueDartException {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.getSingleUser(loginId);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}

	/**
	 * @description method to modify corporate user.
	 * @param userBasicDetails
	 * @return
	 */
	@RequestMapping(value = "clientadmin/modifyuserclientadmin", method = RequestMethod.POST)
	public ResponseEntity<ClientAdminResponseDto> modifyUserClientAdmin(@RequestBody UserBasicDetailsDto userBasicDetails) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.modifyUserClientAdmin(userBasicDetails);
		clResponseDto.setStatusCode("OK");
		return new ResponseEntity(clResponseDto, HttpStatus.OK);
	}
	
	/**
	 * @description method to reset password for corporate user.
	 * @param loginId
	 * @param emailId
	 * @param adminLoginId
	 * @return
	 */
	@RequestMapping(value = "clientadmin/resetpassword/{loginId}/{emailId}/{adminLoginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto resetPassword(@PathVariable String loginId,@PathVariable String emailId,@PathVariable String adminLoginId) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.resetPassword(loginId, emailId, adminLoginId);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}
	
	/**
	 * @description method to get features.
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "clientadmin/loadfeatures/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto loadFeatures(@PathVariable String loginId) {
		logger.info("Inside the controller"+loginId);
		ClientAdminResponseDto clResponseDto = clientAdminService.getFeatures(loginId);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}
	
	/**
	 * @description method to send mail.
	 * @param emailId
	 * @param loginId
	 * @param password
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "clientadmin/sendmail/{emailId}/{loginId}/{password}/{status}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto sendMail(@PathVariable String emailId, @PathVariable String loginId, @PathVariable String password, @PathVariable String status) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.sendMail(emailId, loginId, password, status);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}
	
	/**
	 * @description method to get affiliates.
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "clientadmin/getaffiliates/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientAdminResponseDto getAffiliates(@PathVariable String loginId) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.getAffiliates(loginId);
		clResponseDto.setStatusCode("OK");
		return clResponseDto;
	}
	
	@RequestMapping(value = "clientadmin/createnewuserPermission", method = RequestMethod.POST)
	public ResponseEntity<ClientAdminResponseDto> createnewuserPermission(@RequestBody UserBasicDetailsDto userBasicDetails) {
		ClientAdminResponseDto clResponseDto = null;
		clResponseDto = clientAdminService.createnewuserPermission(userBasicDetails);
		clResponseDto.setStatusCode("OK");		
		return new ResponseEntity(clResponseDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param clException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private ClientAdminResponseDto myError(BlueDartException clException) {
		ClientAdminResponseDto clResponseDto = new ClientAdminResponseDto();
		clResponseDto.setStatusCode(clException.getErrorCode());
		clResponseDto.setErrorMessage(clException.getErrorMessage());
	    return clResponseDto;
	}

	
}