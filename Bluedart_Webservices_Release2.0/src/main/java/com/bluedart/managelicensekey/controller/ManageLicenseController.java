package com.bluedart.managelicensekey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.dto.StatusDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.managelicensekey.dto.LicenseKeyStatusDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeyDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeySearchDto;
import com.bluedart.managelicensekey.service.ManageLicenseService;
import com.bluedart.manageparcelshoppodusers.dto.NotificationsDto;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DI334021
 *
 */
@RestController
public class ManageLicenseController {

	@Autowired 
	private ManageLicenseService manageLicenseService;
	
	/**
	 * Get users list
	 * @param manageLicenseKeySearchDto1
	 * @return
	 */
    @RequestMapping(value = "/manageLicenseKey/getUsersList", method = RequestMethod.POST)
	public ManageLicenseKeyDto getUsers(@RequestBody ManageLicenseKeySearchDto manageLicenseKeySearchDto1)
	{
		ManageLicenseKeyDto manageLicenseKeyDto = manageLicenseService.getUsers(manageLicenseKeySearchDto1);
		manageLicenseKeyDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageLicenseKeyDto;
	}
	
	/**
	 * Method to Generate Licensekey
	 * @param loginId
	 * @param apiType
	 * @param version
	 * @param emailId
	 * @param adminEmailId
	 * @return
	 */
    @RequestMapping(value = "/manageLicenseKey/generateLicenseKey/{userName}/{apiType}/{version}/{emailId}/{adminEmailId}/{loginId}", method = RequestMethod.GET)
	public LicenseKeyStatusDto generateLicenseKey(@PathVariable String userName, @PathVariable String apiType,@PathVariable String version,@PathVariable String emailId,@PathVariable String adminEmailId, @PathVariable String loginId)
	{
		return manageLicenseService.generateLicenseKey(userName,apiType,version,emailId,adminEmailId,loginId);
	}
    
	/**
	 * Method to delete license key
	 * @param loginId
	 * @param apiType
	 * @param licenseKey
	 * @return
	 * @throws LicenseManagementServiceException
	 */
	@RequestMapping(value = "/manageLicenseKey/deleteLicenseKey/{apiType}/{licenseKey}/{licenseKeyId}/{emailId}/{adminEmailId}/{loginId}/{userName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LicenseKeyStatusDto deleteLicenseKey(@PathVariable String apiType,@PathVariable String licenseKey,@PathVariable String licenseKeyId,@PathVariable String emailId,@PathVariable String adminEmailId, @PathVariable String loginId,
			@PathVariable String userName)
	{
		return manageLicenseService.deleteLicenseKey(apiType,licenseKey,licenseKeyId,emailId,adminEmailId,loginId,userName);
	}
	
	/**
	 * Method to send email notification
	 * @param notificationsDto
	 * @return
	 */
	public Boolean sendEmailNotifications(NotificationsDto notificationsDto)
	{
		Boolean emailNotificationSent =  false;
		return emailNotificationSent;
	}
	
	/**
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private StatusDto manageLicenseException(DataBaseException serviceException) {
		StatusDto errorDto = new StatusDto();
		errorDto.setStatusCode(serviceException.getErrorCode());
		errorDto.setStatusMessage(serviceException.getErrorMessage());
		return errorDto;
	}
	
	/**
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private StatusDto manageLicenseException(BlueDartException serviceException) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(serviceException.getErrorCode());
		statusDto.setStatusMessage(serviceException.getErrorMessage());
		return statusDto;
	}
}