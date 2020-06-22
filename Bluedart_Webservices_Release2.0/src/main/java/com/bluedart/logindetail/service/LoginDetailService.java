package com.bluedart.logindetail.service;

import java.util.List;

import com.bluedart.logindetail.dto.LoginDetailDto;
import com.bluedart.logindetail.dto.StatusDto;



public interface LoginDetailService {

	LoginDetailDto getLoginDetails(String loginId,String featureName);

	LoginDetailDto getLoginPermissionDetails(String loginId);
	
	public LoginDetailDto getAllPermissions(String loginId, List<String> permissionsList,String featureName);

	public boolean saveUserSessionDetails(String sessionId, String areaCode, String custCode, String loginId);
	 
	public StatusDto isValidUser(String loginId, String password, String flag);
	
	public StatusDto fetchLoginDetails(String loginId,String flag);
	 
}
