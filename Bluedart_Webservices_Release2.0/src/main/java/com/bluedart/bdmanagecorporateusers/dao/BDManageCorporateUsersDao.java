package com.bluedart.bdmanagecorporateusers.dao;

import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateNotificationDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
/**
 * 
 * @author PR334023
 * DAO interface for Managing Corporate Users and their Permissions by BlueDart Admin
 *
 */
public interface BDManageCorporateUsersDao {
	
	/**
	 * 
	 * @param usersSearchDto
	 * @return
	 */
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto);
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	public ValidCustomerDto validateUserCreation(CorporateUserDto corporateUserDto);
	/**
	 * 
	 * @param userName
	 * @param emailId
	 * @return
	 */
	public ValidCustomerDto validateUserName(String userName, String emailId);
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	public ValidCustomerDto addCustomerEmailData(CorporateUserDto corporateUserDto);
	/**
	 * 
	 * @param emailID
	 * @param otp
	 * @return
	 */
	public ValidCustomerDto createSendOTP(String emailID, long otp);
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	public ValidCustomerDto createCorpUser(CorporateUserDto corporateUserDto);
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	public ValidCustomerDto editCorpUser(CorporateUserDto corporateUserDto);
	/**
	 * 
	 * @param loginId
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public BDCustomerDto listAffiliates(String loginId, int pageSize, int pageNum,String orderBy);
	/**
	 * 
	 * @param bdCustDto
	 * @return
	 */
	public BDCustomerDto getAffUsers(BDCustomerDto bdCustDto);
	/**
	 * 
	 * @param affList
	 * @return
	 */
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto);
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @param adminLoginId
	 * @return
	 */
	public BDCustomerDto listUsersWithAff(String areaCode, String custCode, String adminLoginId);
	/**
	 * 
	 * @param affList
	 * @return
	 */
	public ValidCustomerDto deleteAffiliates(BDCustomerDto bdCustDto);
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @return
	 */
	public BDCustomerDto getAffPermissions(String areaCode, String custCode, String loginId);
	/**
	 * 
	 * @param loginId
	 * @return
	 */
	public BDCustomerDto getLoginPermissions(String loginId);
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	public BDCustomerDto getAffPermUsers(PermissionMappingDto perMappingDto);
	/**
	 * 
	 * @param perMapList
	 * @return
	 */
	public ValidCustomerDto saveAffPermissions(PermissionMappingDto perMappingDto);
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	public ValidCustomerDto saveCascadedAffPermissions(PermissionMappingDto perMappingDto);
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	public BDCustomerDto getLoginPermUsers(PermissionMappingDto perMappingDto);
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	public ValidCustomerDto saveLoginPermissions(PermissionMappingDto perMappingDto);
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	public ValidCustomerDto saveCascadedLoginPermissions(PermissionMappingDto perMappingDto);
	/**
	 * 
	 * @param adminLoginId
	 * @return
	 */
	public CustomerResponseDto getUsersToUpdateStatus(String adminLoginId,String status);
	/**
	 * 
	 * @param custResponseDto
	 * @return
	 */
	public ValidCustomerDto activateOrDeactivate (CustomerResponseDto custResponseDto);
	/**
	 * 
	 * @param coListDto
	 * @return
	 */
	public ValidCustomerDto resetUserPassword(CorporateUserDto coListDto);
	/**
	 * 
	 * @param coNotificationDto
	 * @return
	 */
	public boolean sendEmailNotification(CorporateNotificationDto coNotificationDto);
	/**
	 * 
	 * @param adminAuditLogList
	 * @return
	 */
	public AuditDto saveAuditLog(AuditDto auditDto);
	/**
	 * 
	 * @param auditDto
	 * @return
	 */
	public ValidCustomerDto deleteAuditLog(AuditDto auditDto);
	
}