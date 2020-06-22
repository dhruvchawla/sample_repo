package com.bluedart.manageparcelshoppodusers.serviceImpl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao;
import com.bluedart.manageparcelshoppodusers.daoImpl.ManageParcelShopPODUsersDaoImpl;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersAuditDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersNotificationsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto;
import com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService;
import com.bluedart.utils.Constants;


/**
 * ManageParcelShopPODUsersServiceImpl
 * @author DI334021
 *
 */
@Service
public class ManageParcelShopPODUsersServiceImpl implements ManageParcelShopPODUsersService {
	
	private static Logger log = Logger.getLogger(ManageParcelShopPODUsersDaoImpl.class.getName());

	@Autowired
	ManageParcelShopPODUsersDao manageParcelShopPODUsersDao;
	
	@Autowired
	private MISLogDao misLogDao;
	
	
	//REMOVE LATER WHILEPASSING REALY VALUES FROM LIFERAY SIDE
	String ipAddress = "";
	String loginId = "";
	
	
	
	/*
	 * Method to get parcel shops.
	 *  (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#getParcelShopsList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ManageParcelShopPODUsersDto getParcelShopsList(String region, String area,String searchParcelShopName) {
		
		log.debug("ManageParcelShopPODUsersServiceImpl : getParcelShopsList");
		return manageParcelShopPODUsersDao.getParcelShopsList(region, area, searchParcelShopName);
	}

	/* 
	 * Method to get service centers.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#getServiceCentersList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ManageParcelShopPODUsersDto getServiceCentersList(String region,String area,String searchServiceCenterCode,String searchServiceCenterName) {
		
		log.debug("ManageParcelShopPODUsersServiceImpl : getServiceCentersList");

		return manageParcelShopPODUsersDao.getServiceCentersList(region,area,searchServiceCenterCode,searchServiceCenterName);
	}

	/* 
	 * Method to create parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#createParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto)
	 */
	@Override
	public ManageParcelShopPODUsersDto createParcelShopPODUser(
			ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : createParcelShopPODUser");

		misLog(Constants.FEATURE_NAME_MANAGE_PARCELSHOP_POD_USERS,parcelShopPODUsersDetailsDto.getLoginId());
		return manageParcelShopPODUsersDao.createParcelShopPODUser(parcelShopPODUsersDetailsDto);
	}

	/* 
	 * Method to get parcel hop/POD user details.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#getParcelShopPODUserDetails(java.lang.String, java.util.ArrayList, java.lang.String)
	 */
	@Override
	public ManageParcelShopPODUsersDto getParcelShopPODUserDetails(String loginId,ArrayList<String> region,String podStatus) {
		log.debug("ManageParcelShopPODUsersServiceImpl : getParcelShopPODUserDetails");

		return manageParcelShopPODUsersDao.getParcelShopPODUserDetails(loginId, region, podStatus);
	}

	/* 
	 * Method to deactivate parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#deactivateParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto)
	 */
	@Override
	public ManageParcelShopPODUsersDto deactivateParcelShopPODUser(ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : deactivateParcelShopPODUser");

		misLog(Constants.FEATURE_NAME_MANAGE_PARCELSHOP_POD_USERS,parcelShopPODUsersSearchResultDto.getLoggedInAdminLoginId());
		return manageParcelShopPODUsersDao.deactivateParcelShopPODUser(parcelShopPODUsersSearchResultDto);
	}

	/* 
	 * Method to reactivate parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#reactivateParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto)
	 */
	@Override
	public ManageParcelShopPODUsersDto reactivateParcelShopPODUser(ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : reactivateParcelShopPODUser");

		misLog(Constants.FEATURE_NAME_MANAGE_PARCELSHOP_POD_USERS,parcelShopPODUsersSearchResultDto.getLoggedInAdminLoginId());
	    return manageParcelShopPODUsersDao.reactivateParcelShopPODUser(parcelShopPODUsersSearchResultDto);
	}

	/* 
	 * Method to get parcel hop/POD users.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#getParcelShopPODUsers(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchDto)
	 */
	@Override
	public ManageParcelShopPODUsersDto getParcelShopPODUsers(ParcelShopPODUsersSearchDto parcelShopPODUsersSearchDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : getParcelShopPODUsers");

		misLog(Constants.FEATURE_NAME_MANAGE_PARCELSHOP_POD_USERS,parcelShopPODUsersSearchDto.getLoggedInAdminLoginId());
		return manageParcelShopPODUsersDao.getParcelShopPODUsers(parcelShopPODUsersSearchDto);
	}

	/* 
	 * Method to update parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#updateParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto)
	 */
	@Override
	public ManageParcelShopPODUsersDto updateParcelShopPODUser(
			ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : updateParcelShopPODUser");

		misLog(Constants.FEATURE_NAME_MANAGE_PARCELSHOP_POD_USERS,parcelShopPODUsersDetailsDto.getLoggedInAdminLoginId());
		return manageParcelShopPODUsersDao.updateParcelShopPODUser(parcelShopPODUsersDetailsDto);
	}

	/* 
	 * Method to get areas based on region. 
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#getAreaRegionList(java.util.ArrayList)
	 */
	@Override
	public ManageParcelShopPODUsersDto getAreaRegionList(ArrayList<String> region) {
		log.debug("ManageParcelShopPODUsersServiceImpl : getAreaRegionList");

		return manageParcelShopPODUsersDao.getAreaRegionList(region);
	}

	/* 
	 * Method to save audit log details.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#manageParcelShopPODUsersSaveAuditLogDetails(com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersAuditDto)
	 */
	@Override
	public ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersSaveAuditLogDetails(
			ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersAuditDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : manageParcelShopPODUsersSaveAuditLogDetails");

		return manageParcelShopPODUsersDao.manageParcelShopPODUsersSaveAuditLogDetails(manageParcelShopPODUsersAuditDto);
	}

	/* 
	 * Method to delete audit log records.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#deleteAuditLog(java.util.ArrayList)
	 */
	@Override
	public ManageParcelShopPODUsersAuditDto deleteAuditLog(ArrayList<String> auditSequenceList) {
		log.debug("ManageParcelShopPODUsersServiceImpl : deleteAuditLog");

		return manageParcelShopPODUsersDao.deleteAuditLog(auditSequenceList);
	}

	/* 
	 * Method to send email notifications.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.service.ManageParcelShopPODUsersService#sendEmailManageParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersNotificationsDto)
	 */
	@Override
	public String sendEmailManageParcelShopPODUser(ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto) {
		log.debug("ManageParcelShopPODUsersServiceImpl : sendEmailManageParcelShopPODUser");

		return manageParcelShopPODUsersDao.sendEmailManageParcelShopPODUser(manageParcelShopPODUsersNotificationsDto);
	}
	

	
	/**
     * This method is for MIS logs
     * @param featureName
     * @param loginId
     */
     private void misLog(String featureName, String loginId) {

           if (!StringUtils.isEmpty(loginId)) {
                 misLogDao.saveMIS(featureName, loginId);
           } else {
                 misLogDao.saveMISWithOutLogin(featureName, "", "", "", "");
           }
     }
	
}
