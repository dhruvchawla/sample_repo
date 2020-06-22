package com.bluedart.manageparcelshoppodusers.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.manageparcelshoppodusers.daoImpl.ManageParcelShopPODUsersDaoImpl;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersAuditDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersNotificationsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto;
import com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * ManageParcelShopPODUsersController
 * @author DI334021
 *
 */
@RestController
public class ManageParcelShopPODUsersController {

	@Autowired
	ManageParcelShopPODUsersService manageParcelShopPODUsersService;	
	
	private static Logger log = Logger.getLogger(ManageParcelShopPODUsersDaoImpl.class.getName());
	
	/**
	 * Method to delete audit log
	 * @param auditSequenceList
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/deleteauditlog/{auditSequenceList}", method = RequestMethod.GET)
	public ManageParcelShopPODUsersAuditDto deleteAuditLog(@PathVariable ArrayList<String> auditSequenceList)
	{
		log.debug("ManageParcelShopPODUsersController : deleteAuditLog");
		ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersAuditDto = manageParcelShopPODUsersService.deleteAuditLog(auditSequenceList);
		manageParcelShopPODUsersAuditDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersAuditDto;
	}
	
	
	//-----------------------------------------Get Parcel Shops-----------------------------------------------------------
	
	/**
	 * Method to get parcel shops.
	 * @param region
	 * @param area
	 * @param searchParcelShopName
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/getparcelshops/{region}/{area}/{searchParcelShopName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ManageParcelShopPODUsersDto getParcelShopsList(@PathVariable String region, @PathVariable String area, @PathVariable String searchParcelShopName) {
		
		log.debug("ManageParcelShopPODUsersController : getParcelShopsList");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.getParcelShopsList(region, area, searchParcelShopName);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	//-----------------------------------------Get Service Centers--------------------------------------------------------
	
	/**
	 * Method to get service centers.
	 * @param region
	 * @param area
	 * @param searchServiceCenterCode
	 * @param searchServiceCenterName
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/getservicecenters/{region}/{area}/{searchServiceCenterCode}/{searchServiceCenterName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ManageParcelShopPODUsersDto getServiceCentersList(@PathVariable String region,@PathVariable String area,@PathVariable String searchServiceCenterCode, @PathVariable String searchServiceCenterName) {
		
		log.debug("ManageParcelShopPODUsersController : getServiceCentersList");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.getServiceCentersList(region,area,searchServiceCenterCode,searchServiceCenterName);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	
	//----------------------------------------Create Parcel Shop POD User-------------------------------------------------

	/**
	 * Method to get create parcel shop/POD user.
	 * @param parcelShopPODUsersDetailsDto
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/createparcelshoppodUser", method = RequestMethod.POST)
     public ManageParcelShopPODUsersDto createParcelShopPODUser(@RequestBody ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto )
     {
		log.debug("ManageParcelShopPODUsersController : createParcelShopPODUser");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.createParcelShopPODUser(parcelShopPODUsersDetailsDto);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
     }
	
	//----------------------------------------GET User Details------------------------------------------------------------
	
	/**
	 * Method to get parcel shop/POD user details.
	 * @param loginId
	 * @param region
	 * @param podStatus
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/getparcelshoppoduserdetails/{loginId}/{region}/{podStatus}", method = RequestMethod.GET)
	 public ManageParcelShopPODUsersDto getParcelShopPODUserDetails(@PathVariable String loginId,@PathVariable ArrayList<String> region,@PathVariable String podStatus)
	 {
		log.debug("ManageParcelShopPODUsersController : getParcelShopPODUserDetails");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.getParcelShopPODUserDetails(loginId,region,podStatus);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	 }
	
	//----------------------------------------Deactivate Parcel Shop POD User-------------------------------------------------
	
	/**
	 * Method to deactivate parcel shop/POD user.
	 * @param parcelShopPODUsersSearchResultDto
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/deactivateparcelshoppoduser", method = RequestMethod.POST)
	public ManageParcelShopPODUsersDto deactivateParcelShopPODUser(@RequestBody ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto)
	{
		log.debug("ManageParcelShopPODUsersController : deactivateParcelShopPODUser");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.deactivateParcelShopPODUser(parcelShopPODUsersSearchResultDto);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	
	//----------------------------------------Reactivate Shop POD User--------------------------------------------------------
	
	/**
	 * Method to reactivate parcel shop/POD user.
	 * @param parcelShopPODUsersSearchResultDto
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/reactivateparcelshoppoduser", method = RequestMethod.POST)
	public ManageParcelShopPODUsersDto reactivateParcelShopPODUser(@RequestBody ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto)
	{
		log.debug("ManageParcelShopPODUsersController : reactivateParcelShopPODUser");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.reactivateParcelShopPODUser(parcelShopPODUsersSearchResultDto);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	
	//----------------------------------------Get Parcel Shop POD Users List-------------------------------------------------
	
	/**
	 * Method to get parcel shop/POD users.
	 * @param parcelShopPODUsersSearchDto
	 * @return
	 */ // /manageparcelshoppodusers/getParcelShopPODUsers 
	@RequestMapping(value = "/manageparcelshoppodusers/getparcelshoppodusers", method = RequestMethod.POST)
	public ManageParcelShopPODUsersDto getParcelShopPODUsers(@RequestBody ParcelShopPODUsersSearchDto parcelShopPODUsersSearchDto)
	{
		log.debug("ManageParcelShopPODUsersController : getParcelShopPODUsers");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.getParcelShopPODUsers(parcelShopPODUsersSearchDto);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	
	
	//----------------------------------------Update Parcel Shop POD User-------------------------------------------------

	/**
	 * Method to update parcel shop/POD user.
	 * @param parcelShopPODUsersDetailsDto
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/updateparcelshoppoduser", method = RequestMethod.POST)
    public ManageParcelShopPODUsersDto updateParcelShopPODUser(@RequestBody ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto)
	{
		log.debug("ManageParcelShopPODUsersController : updateParcelShopPODUser");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.updateParcelShopPODUser(parcelShopPODUsersDetailsDto);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	
	//----------------------------------------Get Areas-----------------------------------------------------------------
	
	/**
	 * Method to get areas based on region.
	 * @param region
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/getarearegionlist/{region}", method = RequestMethod.GET)
	public ManageParcelShopPODUsersDto getAreaRegionList(@PathVariable ArrayList<String> region)
	{
		log.debug("ManageParcelShopPODUsersController : getAreaRegionList");
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = manageParcelShopPODUsersService.getAreaRegionList(region);
		manageParcelShopPODUsersDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersDto;
	}
	
	
	/**
	 * Method to save audit log details.
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/manageparcelshoppoduserssaveauditlogdetails", method = RequestMethod.POST)
	public ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersSaveAuditLogDetails(@RequestBody ManageParcelShopPODUsersAuditDto dto)
	{
		log.debug("ManageParcelShopPODUsersController : manageParcelShopPODUsersSaveAuditLogDetails");
		ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersAuditDto = manageParcelShopPODUsersService.manageParcelShopPODUsersSaveAuditLogDetails(dto);
		manageParcelShopPODUsersAuditDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return manageParcelShopPODUsersAuditDto;
		
	}
	
	/**
	 * Method to send email notifications.
	 * @param manageParcelShopPODUsersNotificationsDto
	 * @return
	 */
	@RequestMapping(value = "/manageparcelshoppodusers/sendemail", method = RequestMethod.GET)
	public String sendEmailManageParcelShopPODUser(@RequestBody ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto)
	{
		log.debug("ManageParcelShopPODUsersController : sendEmailManageParcelShopPODUser");
		String emailStatus = manageParcelShopPODUsersService.sendEmailManageParcelShopPODUser(manageParcelShopPODUsersNotificationsDto);
		return emailStatus;
		
	}
	
	//----------------------------------------Exception Handling---------------------------------------------------------------------------------------------------

	/**
	 * Method for exception handling.DataBaseException.
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private ManageParcelShopPODUsersDto manageParcelShopPODUserDataBaseException(DataBaseException serviceException) {
		
		log.debug("ManageParcelShopPODUsersController : manageParcelShopPODUserDataBaseException");
		
		ManageParcelShopPODUsersDto errorDto = new ManageParcelShopPODUsersDto();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMsg(serviceException.getErrorMessage());
		return errorDto;
	}
	
	/**
	 * Method for exception handling.BlueDartException.
	 * @param serviceException
	 * @return
	 * @Description Called when BlueDartException occurs.
	 */
	@ExceptionHandler(BlueDartException.class)
	private ManageParcelShopPODUsersDto manageParcelShopPODUserBluedartException(BlueDartException serviceException) {
		
		log.debug("ManageParcelShopPODUsersController : manageParcelShopPODUserBluedartException");
		
		ManageParcelShopPODUsersDto errorDto = new ManageParcelShopPODUsersDto();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMsg(serviceException.getErrorMessage());
		return errorDto;
	}
	
}
