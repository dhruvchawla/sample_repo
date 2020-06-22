package com.bluedart.managelicensekey.service;

import com.bluedart.managelicensekey.dto.LicenseKeyStatusDto;
//import com.bluedart.exception.LicenseManagementServiceException;
import com.bluedart.managelicensekey.dto.ManageLicenseKeyDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeySearchDto;
import com.bluedart.manageparcelshoppodusers.dto.NotificationsDto;

/**
 * 
 * @author DI334021
 *
 */
public interface ManageLicenseService {

	/**
	 * @param manageLicenseKeySearchDto
	 * @return
	 */
	public ManageLicenseKeyDto getUsers(ManageLicenseKeySearchDto manageLicenseKeySearchDto);
	/**
	 * @param loginId
	 * @param apiType
	 * @param version
	 * @param emailId
	 * @param adminEmailId
	 * @return
	 */
	public LicenseKeyStatusDto generateLicenseKey(String userName, String apiType, String version,String emailId,String adminEmailId, String loginId);
	/**
	 * @param apiType
	 * @param licenseKey
	 * @param licenseKeyId
	 * @param emailId
	 * @param adminEmailId
	 * @param loginId
	 * @return
	 */
	public LicenseKeyStatusDto deleteLicenseKey(String apiType, String licenseKey,String licenseKeyId,String emailId,String adminEmailId,String loginId, String userName);
	/**
	 * 
	 * @param notificationsDto
	 * @return
	 */
	public Boolean sendEmailNotifications(NotificationsDto notificationsDto);
	
}
