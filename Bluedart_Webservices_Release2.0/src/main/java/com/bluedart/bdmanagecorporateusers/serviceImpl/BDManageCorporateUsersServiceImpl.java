package com.bluedart.bdmanagecorporateusers.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao;
import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService;
import com.bluedart.camanagecorpusers.service.CAManageCorpUsersService;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.common.service.OTPService;

/**
 * 
 * @author PR334023
 * Service implementation for Managing Corporate Users and their Permissions by BlueDart Admin
 */
@Service
public class BDManageCorporateUsersServiceImpl implements BDManageCorporateUsersService {

	@Autowired
	private BDManageCorporateUsersDao bdManageCorporateUsersDao;
	
	@Autowired
	private CAManageCorpUsersService caManageCorpUsersService; 
	
	@Autowired
	private OTPService otpService;
	
	/**
	 * List Users
	 * @return UserDetailDto
	 */
	@Override
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto) {
		return bdManageCorporateUsersDao.listUsers(usersSearchDto);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#validateUserCreation(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	public ValidCustomerDto validateUserCreation( CorporateUserDto corporateUserDto) {
		return bdManageCorporateUsersDao.validateUserCreation(corporateUserDto);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#validateUserName(java.lang.String, java.lang.String)
	 */
	@Override
	public ValidCustomerDto validateUserName(String userName, String emailId) {
		return bdManageCorporateUsersDao.validateUserName(userName, emailId);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#addCustomerEmailData(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	public ValidCustomerDto addCustomerEmailData(CorporateUserDto corporateUserDto) {
		return bdManageCorporateUsersDao.addCustomerEmailData(corporateUserDto);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#createSendOTP(java.lang.String)
	 */
	@Override
	public ValidCustomerDto createSendOTP(String emailID) {
		long otp = otpService.generateOTP(6);
		return bdManageCorporateUsersDao.createSendOTP(emailID, otp);
	}
	/**
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#createCorpUser(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	public ValidCustomerDto createCorpUser(CorporateUserDto corporateUserDto) {
		
		return bdManageCorporateUsersDao.createCorpUser(corporateUserDto);
	}
	/**
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#editCorpUser(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	public ValidCustomerDto editCorpUser(CorporateUserDto corporateUserDto){
		return bdManageCorporateUsersDao.editCorpUser(corporateUserDto);
	}
	/**
	 * list affiliates
	 * @return AffiliateDetailDto
	 */
	@Override
	public BDCustomerDto listAffiliates(String loginId, int pageSize, int pageNum,String orderBy) {
		return bdManageCorporateUsersDao.listAffiliates(loginId, pageSize, pageNum,orderBy);
	}
	/**
	 * 
	 * @param bdCustDto
	 * @return
	 */
	@Override
	public BDCustomerDto getAffUsers(BDCustomerDto bdCustDto){
		return bdManageCorporateUsersDao.getAffUsers(bdCustDto);
	}
	/**
	 * add affiliates
	 * @return Boolean
	 */
	@Override
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto) {
		return bdManageCorporateUsersDao.addAffiliates(bdCustDto);
	}
	/**
	 * list Users With Affiliate
	 * @return BDCustomerDto
	 */
	@Override
	public BDCustomerDto listUsersWithAff(String areaCode, String custCode, String adminLoginId){
		return bdManageCorporateUsersDao.listUsersWithAff(areaCode, custCode, adminLoginId);
	}
	/**
	 * delete affiliates
	 * @return Boolean
	 */
	@Override
	public ValidCustomerDto deleteAffiliates(BDCustomerDto bdCustDto) {
		return bdManageCorporateUsersDao.deleteAffiliates(bdCustDto);
	}
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @return
	 */
	@Override
	public BDCustomerDto getAffPermissions(String areaCode, String custCode,String loginId){
		return bdManageCorporateUsersDao.getAffPermissions(areaCode,custCode,loginId);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#getAffPermUsers(com.bluedart.common.dto.PermissionMappingDto)
	 */
	public BDCustomerDto getAffPermUsers(PermissionMappingDto perMappingDto){
		return bdManageCorporateUsersDao.getAffPermUsers(perMappingDto);
	}
	/**
	 * 
	 * @param permissionMappingDto
	 * @return
	 */
	@Override
	public ValidCustomerDto saveAffPermissions(PermissionMappingDto perMappingDto){
		return bdManageCorporateUsersDao.saveAffPermissions(perMappingDto);
	}
	
	/**
	 * 
	 * @param loginId
	 * @return
	 */
	
	@Override
	public BDCustomerDto getLoginPermissions(String loginId){
		return bdManageCorporateUsersDao.getLoginPermissions(loginId);
	}
	/**
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#getLoginPermUsers(com.bluedart.common.dto.PermissionMappingDto)
	 */
	@Override
	public BDCustomerDto getLoginPermUsers(PermissionMappingDto perMappingDto){
		return bdManageCorporateUsersDao.getLoginPermUsers(perMappingDto);
	}
	/**
	 * 
	 * @param permissionMappingDto
	 * @return
	 */
	@Override
	public ValidCustomerDto saveLoginPermissions(PermissionMappingDto perMappingDto){
		return bdManageCorporateUsersDao.saveLoginPermissions(perMappingDto);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#saveCascadedLoginPermissions(com.bluedart.common.dto.PermissionMappingDto)
	 */
	@Override
	public ValidCustomerDto saveCascadedLoginPermissions(PermissionMappingDto perMappingDto){
		return bdManageCorporateUsersDao.saveCascadedLoginPermissions(perMappingDto);
	}
	
	/**
	 * reset user password
	 * @return String
	 */
	@Override
	public ValidCustomerDto resetUserPassword(CorporateUserDto corporateUserDto) {
		return bdManageCorporateUsersDao.resetUserPassword(corporateUserDto);
	}

	/**
	 * activate or deactivate corporate user
	 * @return boolean 
	 */
	@Override
	public ValidCustomerDto activateOrDeactivate(CustomerResponseDto custResponseDto) {
		return bdManageCorporateUsersDao.activateOrDeactivate(custResponseDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#getUsersToUpdateStatus(java.lang.String)
	 */
	@Override
	public CustomerResponseDto getUsersToUpdateStatus(String adminLoginId,String status) {
		return bdManageCorporateUsersDao.getUsersToUpdateStatus(adminLoginId,status);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#saveAuditLog(java.util.List)
	 */
	@Override
	public AuditDto saveAuditLog(AuditDto auditDto) {
		return bdManageCorporateUsersDao.saveAuditLog(auditDto);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#deleteAuditLog(com.bluedart.common.dto.AuditDto)
	 */
	@Override
	public ValidCustomerDto deleteAuditLog(AuditDto auditDto) {
		return bdManageCorporateUsersDao.deleteAuditLog(auditDto);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService#saveCascadedAffPermissions(com.bluedart.common.dto.PermissionMappingDto)
	 */
	@Override
	public ValidCustomerDto saveCascadedAffPermissions(PermissionMappingDto perMappingDto) {
		return bdManageCorporateUsersDao.saveCascadedAffPermissions(perMappingDto);
	}


}