package com.bluedart.managelicensekey.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//import com.bluedart.exception.LicenseManagementServiceException;
import com.bluedart.managelicensekey.dao.ManageLicenseDao;
import com.bluedart.managelicensekey.dto.LicenseKeyStatusDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeyDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeySearchDto;
import com.bluedart.managelicensekey.service.ManageLicenseService;
import com.bluedart.manageparcelshoppodusers.dto.NotificationsDto;
/**
 * 
 * @author DI334021
 *
 */
@Service
public class ManageLicenseServiceImpl implements ManageLicenseService {

	 
	@Autowired 
	ManageLicenseDao manageLicenseDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.service.ManageLicenseService#getUsers(com.bluedart.managelicensekey.dto.ManageLicenseKeySearchDto)
	 */
	@Override
	public ManageLicenseKeyDto getUsers(ManageLicenseKeySearchDto manageLicenseKeySearchDto){
		return manageLicenseDao.getUsers(manageLicenseKeySearchDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.service.ManageLicenseService#generateLicenseKey(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LicenseKeyStatusDto generateLicenseKey(String userName, String apiType, String version,String emailId,String adminEmailId, String loginId) {
		return manageLicenseDao.generateLicenseKey(userName, apiType, version,emailId,adminEmailId,loginId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.service.ManageLicenseService#deleteLicenseKey(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LicenseKeyStatusDto deleteLicenseKey(String apiType, String licenseKey,String licenseKeyId,String emailId,String adminEmailId,String loginId, String userName) {
		return manageLicenseDao.deleteLicenseKey(apiType, licenseKey, licenseKeyId,emailId,adminEmailId, loginId, userName);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.service.ManageLicenseService#sendEmailNotifications(com.bluedart.managelicensekey.dto.NotificationsDto)
	 */
	@Override
	public Boolean sendEmailNotifications(NotificationsDto notificationsDto) {
		return null;
	}

	
	
	
	
	
	
}
