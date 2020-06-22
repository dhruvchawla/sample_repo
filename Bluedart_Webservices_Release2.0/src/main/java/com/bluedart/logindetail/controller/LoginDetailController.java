package com.bluedart.logindetail.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.logindetail.dto.LoginDetailDto;
import com.bluedart.logindetail.dto.StatusDto;
import com.bluedart.logindetail.service.LoginDetailService;
import com.bluedart.trackdart.service.FindSecurityLevelService;

@RestController
public class LoginDetailController {  

	private static final Logger logger = Logger.getLogger(LoginDetailController.class);

	@Autowired
	private LoginDetailService loginService;
	
	@Autowired
	private FindSecurityLevelService findSecurityLevelService;
	

	@RequestMapping(value = "/getLoginRegionDetails/{loginId}/{featureName}", method = RequestMethod.GET,headers="Accept=application/json")
	public LoginDetailDto getLoginDetails(@PathVariable("loginId") String loginId,@PathVariable("featureName") String featureName) {
		logger.debug("Calling getPODEntryDetails");
		LoginDetailDto loginDetails= new LoginDetailDto();
		try {
			loginDetails =  loginService.getLoginDetails(loginId,featureName);
		
		} catch (Exception ex) {
			logger.debug("Error Occurred: "+ ex);
		}
		return loginDetails;
	}

	@RequestMapping(value = "/getLoginPermissionDetails/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public LoginDetailDto getLoginPermissionDetails(@PathVariable("loginId") String loginId) {
		logger.debug("Calling getPODEntryDetails");
		LoginDetailDto loginDetails= new LoginDetailDto();
		try {
			loginDetails =  loginService.getLoginPermissionDetails(loginId);
		
		} catch (Exception ex) {
			logger.debug("Error Occurred: "+ ex);
		}
		return loginDetails;
	}

	/**
	 * @param loginDetailDto
	 * @return
	 */
	@RequestMapping(value = "/getloginpermissiondetails/getdashboardpermissions", method = RequestMethod.POST)
	public LoginDetailDto getAllPermissions(@RequestBody LoginDetailDto loginDetailDto){
		LoginDetailDto loginDetails = new LoginDetailDto();
		try {
			loginDetails = loginService.getAllPermissions(loginDetailDto.getLoginId(), loginDetailDto.getRegionList(),loginDetailDto.getFeatureName());
		} catch (Exception exception) {
			logger.error(exception);
		}
		return loginDetails;
	}
	
	/**
	 * @param sessionId
	 * @param areaCode
	 * @param custCode
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/savesessiondetails/{sessionId}/{areaCode}/{custCode}/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public boolean saveUserSessionDetails(@PathVariable("sessionId") String sessionId, @PathVariable("areaCode") String areaCode, 
			@PathVariable("custCode") String custCode, @PathVariable("loginId") String loginId) {
		boolean sessionSavedResponse = false;
		try {
			sessionSavedResponse = loginService.saveUserSessionDetails(sessionId, areaCode, custCode, loginId);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return sessionSavedResponse;
	}
	
	/**
	 * @param loginId
	 * @param passWord
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "/isvaliduser/{loginId}/{password}/{flag}", method = RequestMethod.GET,headers="Accept=application/json")
	public StatusDto isValidUser(@PathVariable("loginId") String loginId, @PathVariable("password") String password, 
			@PathVariable("flag") String flag) {
		StatusDto statusDto = new StatusDto();
		try {
			statusDto = loginService.isValidUser(loginId, password, flag);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return statusDto;
	}
	
	@RequestMapping(value = "/getloginDetails/{loginId}/{flag}", method = RequestMethod.GET,headers="Accept=application/json")
	public StatusDto loginDetails(@PathVariable("loginId") String loginId ,
			@PathVariable("flag") String flag) {
		StatusDto statusDto = new StatusDto();
		try {
			statusDto = loginService.fetchLoginDetails(loginId, flag);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return statusDto;
	}
	
	
	/**
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/getsecuritylevel/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public Integer getSecurityLevel(@PathVariable("loginId") String loginId) {
		int secLevel = -1;
		try {
			secLevel = findSecurityLevelService.findSecurityLevel(loginId);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return secLevel;
	}

}
