package com.bluedart.bdmanageadminusers.service;

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
 * Service interface for Bluedart admin - Manage Admin users
 *
 */
public interface BDManageAdminUsersService {

	public AdminUserResponseDto listAdminUsers(UserSearchDto bdAdminSearchDto);
	public ValidUserDto validateEmployeeCode(String employeeCode, String adminRole, String userType, String superAdminFlag);
	public ValidUserDto createAdminUser(BDAdminDto bdAdminDto);
	public ValidUserDto editAdminUser(BDAdminDto bdAdminDto);
	public boolean sendEmailNotification(NotificationDto notificationDto);
	public ValidUserDto createSuperAdmin(BDAdminDto bdAdminDto);
	public boolean saveAuditLog(List<AdminAuditDetails> adminAuditLogList);
	
	
	
}