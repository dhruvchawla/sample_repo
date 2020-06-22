package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import com.bluedart.common.dto.StatusDto;

/**
 * 
 * @author PR334023
 *
 */
public class BDAdminDto extends StatusDto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private long adminUserId;
	private String byLoginId;
	private String toLoginId;
	private String[] userRegions;
	private String employeeCode;
	private String validUser;
	private String userType;
	private String password;
	private long userId;
	private String employeeName;
	private String emailId;
	private String siteURL;
	private String adminRole;
	private String adminEmpCode;
	private String[] rolesToEdit;
	private Timestamp modifiedDate;
	
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getByLoginId() {
		return byLoginId;
	}
	public void setByLoginId(String byLoginId) {
		this.byLoginId = byLoginId;
	}
	public String[] getRolesToEdit() {
		return rolesToEdit;
	}
	public void setRolesToEdit(String[] rolesToEdit) {
		this.rolesToEdit = rolesToEdit;
	}
	public long getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(long adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getToLoginId() {
		return toLoginId;
	}
	public void setToLoginId(String toLoginId) {
		this.toLoginId = toLoginId;
	}
	public String[] getUserRegions() {
		return userRegions;
	}
	public void setUserRegions(String[] userRegions) {
		this.userRegions = userRegions;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getValidUser() {
		return validUser;
	}
	public void setValidUser(String validUser) {
		this.validUser = validUser;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSiteURL() {
		return siteURL;
	}
	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	public String getAdminEmpCode() {
		return adminEmpCode;
	}
	public void setAdminEmpCode(String adminEmpCode) {
		this.adminEmpCode = adminEmpCode;
	}
	@Override
	public String toString() {
		return "BDAdminDto [adminUserId=" + adminUserId + ", byLoginId="
				+ byLoginId + ", toLoginId=" + toLoginId + ", userRegions="
				+ Arrays.toString(userRegions) + ", employeeCode="
				+ employeeCode + ", validUser=" + validUser + ", userType="
				+ userType + ", password=" + password + ", userId=" + userId
				+ ", employeeName=" + employeeName + ", emailId=" + emailId
				+ ", siteURL=" + siteURL + ", adminRole=" + adminRole
				+ ", adminEmpCode=" + adminEmpCode + ", rolesToEdit="
				+ Arrays.toString(rolesToEdit) + ", modifiedDate="
				+ modifiedDate + "]";
	}

}