package com.bluedart.logindetail.dao;

import java.util.List;

import com.bluedart.logindetail.dto.LoginDetailDto;
import com.bluedart.logindetail.dto.StatusDto;


public interface LoginDetailDao {

	LoginDetailDto getLoginDetails(String loginId);

	LoginDetailDto getLoginPermissionDetails(String loginId);

	//LoginDetailDto getPermissionByAffilliates(String areaCode, String countryCode);

	 public LoginDetailDto getAllPermissions(String loginId, List<String> permissionsList);
	
	 public boolean saveUserSessionDetails(String sessionId, String areaCode, String custCode, String loginId);
	 
	 public StatusDto isValidUser(String loginId, String password, String flag);
	 
	 public StatusDto fetchLoginDetails(String loginId, String flag);
}
