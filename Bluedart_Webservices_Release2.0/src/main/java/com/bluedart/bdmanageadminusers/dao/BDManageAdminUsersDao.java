package com.bluedart.bdmanageadminusers.dao;

import java.util.List;

import com.bluedart.bdmanageadminusers.dto.AdminUserResponseDto;
import com.bluedart.bdmanageadminusers.dto.BDAdminDto;
import com.bluedart.bdmanageadminusers.dto.NotificationDto;
import com.bluedart.bdmanageadminusers.dto.UserSearchDto;
import com.bluedart.bdmanageadminusers.dto.ValidUserDto;
import com.bluedart.common.dto.AdminAuditDetails;
/**
 * 
 * @author PR334023
 * DAO interface for Bluedart admin - Manage Admin users
 */
public interface BDManageAdminUsersDao {
	
	/**
	 * @param employeeCode
	 * @return
	 */
	public ValidUserDto validateEmployeeCode(String employeeCode, String adminRole, String userType, String superAdminFlag);
	/**
	 * @param notificationDto
	 * @return
	 */
	public boolean sendEmailNotification(NotificationDto notificationDto);
	/**
	 * @param bdAdminSearchDto
	 * @return
	 */
	public AdminUserResponseDto listAdminUsers(UserSearchDto bdAdminSearchDto);
	/**
	 * @param bdAdminDto
	 * @return
	 */
	public ValidUserDto createAdminUser(BDAdminDto bdAdminDto);
	/**
	 * @param bdAdminDto
	 * @return
	 */
	public ValidUserDto editAdminUser(BDAdminDto bdAdminDto); 
	/**
	 * 
	 * @param adminAuditLog
	 * @return
	 */
	public boolean saveAuditLog(List<AdminAuditDetails> adminAuditLogList);
	/**
	 * 
	 * @param bdAdminDto
	 * @return
	 */
	public ValidUserDto createSuperAdmin(BDAdminDto bdAdminDto);
}