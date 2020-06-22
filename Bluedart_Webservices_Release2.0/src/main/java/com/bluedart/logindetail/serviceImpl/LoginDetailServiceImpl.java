package com.bluedart.logindetail.serviceImpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.logindetail.dao.LoginDetailDao;
import com.bluedart.logindetail.dto.LoginDetailDto;
import com.bluedart.logindetail.dto.StatusDto;
import com.bluedart.logindetail.service.LoginDetailService;


@Service
public class LoginDetailServiceImpl implements LoginDetailService {
	private static final Logger logger = Logger.getLogger(LoginDetailServiceImpl.class); 

	@Autowired
	private LoginDetailDao loginDao;
	
	@Autowired
	private MISLogDao misLogDao;

	@Override
	public LoginDetailDto getLoginDetails(String loginId,String featureName) {
		saveMISLog(featureName,loginId.toUpperCase(),null,null,null);	
		return loginDao.getLoginDetails(loginId);
	}

	@Override
	public LoginDetailDto getLoginPermissionDetails(String loginId) {
		
		return  loginDao.getLoginPermissionDetails(loginId);
	}

	@Override
	public LoginDetailDto getAllPermissions(String loginId,
			List<String> permissionsList,String featureName) {
		saveMISLog(featureName,loginId.toUpperCase(),null,null,null);
		return loginDao.getAllPermissions(loginId, permissionsList);
	}

	@Override
	public boolean saveUserSessionDetails(String sessionId, String areaCode,
			String custCode, String loginId) {
		//if(areaCode.equalsIgnoreCase("null") || areaCode.equalsIgnoreCase("") || areaCode==""){
		if(areaCode.equalsIgnoreCase("null") || areaCode.equalsIgnoreCase("") || StringUtils.isEmpty(areaCode)){	
			areaCode = "-";
		}
		//if(custCode.equalsIgnoreCase("null") || custCode=="" || custCode.equalsIgnoreCase("") ){
		if(custCode.equalsIgnoreCase("null")  || custCode.equalsIgnoreCase("") || StringUtils.isEmpty(custCode)){
			custCode = "-";
		}
		return loginDao.saveUserSessionDetails(sessionId, areaCode, custCode, loginId);
	}
	
	@Override
	public StatusDto isValidUser(String loginId, String password, String flag) {
		return loginDao.isValidUser(loginId, password, flag);
	}

	@Override
	public StatusDto fetchLoginDetails(String loginId, String flag) {
		// TODO Auto-generated method stub
		return loginDao.fetchLoginDetails(loginId, flag);
	}	
	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.info("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.info("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
		
}
