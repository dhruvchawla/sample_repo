package com.bluedart.bdmanageadminusers.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao;
import com.bluedart.bdmanageadminusers.daoImpl.BDAdminNotificationHelper;
import com.bluedart.bdmanageadminusers.dto.AdminUserResponseDto;
import com.bluedart.bdmanageadminusers.dto.BDAdminDto;
import com.bluedart.bdmanageadminusers.dto.NotificationDto;
import com.bluedart.bdmanageadminusers.dto.UserSearchDto;
import com.bluedart.bdmanageadminusers.dto.ValidUserDto;
import com.bluedart.bdmanageadminusers.service.BDManageAdminUsersService;
import com.bluedart.common.dto.AdminAuditDetails;
/**
 * 
 * @author PR334023
 * Service implementation for Bluedart admin - Manage Admin users	
 */
@Service
public class BDManageAdminUsersServiceImpl implements BDManageAdminUsersService {

	@Autowired
	private BDManageAdminUsersDao bdManageAdminUsersDao;
	
	@Autowired
	private BDAdminNotificationHelper bdAdminNotificationHelper;

	/**
	 * Method to validate Employee code
	 * @return AdminDto
	 */
	@Override
	public ValidUserDto validateEmployeeCode(String employeeCode, String adminRole, String userType, String superAdminFlag) {
		
		return bdManageAdminUsersDao.validateEmployeeCode(employeeCode,adminRole,userType,superAdminFlag);
	}
	
	/**
	 * Method to send email notification
	 * @return boolean
	 */
	@Override
	public boolean sendEmailNotification(NotificationDto notificationDto) {
		boolean result = false;
		if (notificationDto != null && (notificationDto.getAction().equalsIgnoreCase("DEACTIVATE") || notificationDto
						.getAction().equalsIgnoreCase("ACTIVATE"))) {
			List<AdminAuditDetails> adminAuditLogList = new ArrayList<>();

			AdminAuditDetails adminAuditLog = new AdminAuditDetails();
			adminAuditLog.setLoginId(notificationDto.getBdAdminDto().getToLoginId());
			adminAuditLog.setModuleName("BDADMIN");
			adminAuditLog.setModuleAction(notificationDto.getAction());
			adminAuditLog.setSchemaName("WEBPORTAL");
			adminAuditLog.setTableName("USER_");
			adminAuditLog.setColumnName("STATUS");
			adminAuditLog.setModifyDate(notificationDto.getBdAdminDto().getModifiedDate());
			
			adminAuditLog.setTypeOfChange("U");
			adminAuditLog.setCidMst(Long.valueOf(notificationDto.getBdAdminDto().getUserId()).toString());
			adminAuditLog.setSql_type("UPROFILE4.AUDITOBJ");
			
			if(notificationDto.getAction().equalsIgnoreCase("DEACTIVATE")){
				adminAuditLog.setOldValue("0");
				adminAuditLog.setNewValue("5");
			}else if(notificationDto.getAction().equalsIgnoreCase("ACTIVATE")){
				adminAuditLog.setOldValue("5");
				adminAuditLog.setNewValue("0");
			}
			
			adminAuditLogList.add(adminAuditLog);
			result = bdManageAdminUsersDao.saveAuditLog(adminAuditLogList);
			
			if(result){
				bdAdminNotificationHelper.sendEmailNotification(notificationDto);
			}
		}else{
			result = bdAdminNotificationHelper.sendEmailNotification(notificationDto);
		}
		return result;
	}

	@Override
	public AdminUserResponseDto listAdminUsers(UserSearchDto userSearchDto) {
		return bdManageAdminUsersDao.listAdminUsers(userSearchDto);
	}

	@Override
	public  ValidUserDto createAdminUser(BDAdminDto bdAdminDto) {
		return bdManageAdminUsersDao.createAdminUser(bdAdminDto);
	}

	@Override
	public ValidUserDto editAdminUser(BDAdminDto bdAdminDto) {
		return bdManageAdminUsersDao.editAdminUser(bdAdminDto);
	}

	@Override
	public boolean saveAuditLog(List<AdminAuditDetails> adminAuditLogList) {
		return bdManageAdminUsersDao.saveAuditLog(adminAuditLogList);
	}

	@Override
	public ValidUserDto createSuperAdmin(BDAdminDto bdAdminDto) {
		return bdManageAdminUsersDao.createSuperAdmin(bdAdminDto) ;
	}

}