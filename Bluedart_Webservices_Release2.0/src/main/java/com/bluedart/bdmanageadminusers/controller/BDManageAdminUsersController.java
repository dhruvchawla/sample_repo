package com.bluedart.bdmanageadminusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.bdmanageadminusers.dto.AdminUserResponseDto;
import com.bluedart.bdmanageadminusers.dto.BDAdminDto;
import com.bluedart.bdmanageadminusers.dto.NotificationDto;
import com.bluedart.bdmanageadminusers.dto.UserSearchDto;
import com.bluedart.bdmanageadminusers.dto.ValidUserDto;
import com.bluedart.bdmanageadminusers.service.BDManageAdminUsersService;
import com.bluedart.common.dto.StatusDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author PR334023
 * REST controller to Manage Admin users by BlueDart admin
 *
 */
@RestController
public class BDManageAdminUsersController {
	
	@Autowired
	private BDManageAdminUsersService bdManageAdminUsersService;
	
	/**
	 * Method to list admin users
	 * @param bdAdminSearchDto   
	 * @return
	 */
	@RequestMapping(value = "/bdmanageadminusers/listAdminUsers", method = RequestMethod.POST)
	public ResponseEntity<AdminUserResponseDto> listAdminUsers(@RequestBody UserSearchDto bdAdminSearchDto){
		AdminUserResponseDto adminUserResponseDto = null;
		adminUserResponseDto = bdManageAdminUsersService.listAdminUsers(bdAdminSearchDto);
		adminUserResponseDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(adminUserResponseDto, HttpStatus.OK);
	}
	
	/**
	 * Method to validate Employee code
	 * @param employeeCode
	 * @return
	 */
	@RequestMapping(value = "/bdmanageadminusers/validateEmployeeCode/{employeeCode}/{adminRegion}/{usertype}/{superAdminFlag}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<ValidUserDto> validateEmployeeCode(@PathVariable("employeeCode")String employeeCode,
										@PathVariable("adminRegion") String adminRegion, @PathVariable("usertype") String userType, @PathVariable("superAdminFlag") String superAdminFlag){
		System.out.println("---------Property------------ : "+System.getProperty("uat_c2pc"));
		ValidUserDto validUserDto = null;
		validUserDto = bdManageAdminUsersService.validateEmployeeCode(employeeCode,adminRegion,userType,superAdminFlag);
		validUserDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validUserDto, HttpStatus.OK);
	}
	
	/**
	 * Method to create admin user
	 * @param bdAdminDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanageadminusers/createAdminUser", method = RequestMethod.POST)
	public ResponseEntity<ValidUserDto> createAdminUser(@RequestBody BDAdminDto bdAdminDto){
		ValidUserDto validUserDto = null;
		validUserDto = bdManageAdminUsersService.createAdminUser(bdAdminDto);
		validUserDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validUserDto, HttpStatus.OK);
	}
	
	/**
	 * Method update admin user details
	 * @param bdAdminDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanageadminusers/editAdminUser", method = RequestMethod.POST)
	public ResponseEntity<ValidUserDto> editAdminUser(@RequestBody BDAdminDto bdAdminDto){
		ValidUserDto validUserDto = null;
		validUserDto = bdManageAdminUsersService.editAdminUser(bdAdminDto);
		validUserDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validUserDto, HttpStatus.OK);
	}
	
	/**
	 * Method to send email notification
	 * @param notificationDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanageadminusers/sendEmailNotification", method = RequestMethod.POST)
	public ResponseEntity<Boolean> sendEmailNotification(@RequestBody NotificationDto notificationDto){
		return new ResponseEntity(bdManageAdminUsersService.sendEmailNotification(notificationDto), HttpStatus.OK); 
	}
	
	/**
	 * 
	 * @param bdAdminDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanageadminusers/createSuperAdmin", method = RequestMethod.POST)
	public ResponseEntity<ValidUserDto> createSuperAdmin(@RequestBody BDAdminDto bdAdminDto){
		ValidUserDto validUserDto = null;
		validUserDto = bdManageAdminUsersService.createSuperAdmin(bdAdminDto);
		validUserDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validUserDto, HttpStatus.OK);
	}
	
	/**
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private StatusDto ManageAdminUsersException(DataBaseException serviceException) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(serviceException.getErrorCode());
		statusDto.setStatusMessage(serviceException.getErrorMessage());
		return statusDto;
	}
	
	/**
	 * 
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private StatusDto ManageAdminUsersException(BlueDartException serviceException) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(serviceException.getErrorCode());
		statusDto.setStatusMessage(serviceException.getErrorMessage());
		return statusDto;
	}
	
}