package com.bluedart.manageparcelshoppodusers.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParcelShopUsersDto {

	private String userName;
	private String emailId;
	private String loginId;
	private String region;
	private String userStatus;
	//-----------------------------------------------
	
	private long psuid;
	private long psUserId;
	private String securityLevel;
	private long createdBy;
	private Date createdDate;
	private long modifiedBy;
	private Date modifiedDate;
	private String employeeCode; 
	
	//------------------------------------------------
	private ArrayList<ParcelShopsDto> selectedParcelshops;
	private ArrayList<ServiceCentersDto> selectedServiceCenters;
	//----------------------------------------------------
	private String userId;
	private String creator_userId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreator_userId() {
		return creator_userId;
	}
	public void setCreator_userId(String creator_userId) {
		this.creator_userId = creator_userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}
	
	public ArrayList<ParcelShopsDto> getSelectedParcelshops() {
		return selectedParcelshops;
	}
	public void setSelectedParcelshops(ArrayList<ParcelShopsDto> selectedParcelshops) {
		this.selectedParcelshops = selectedParcelshops;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	//----------------------------------
	
	
	public long getPsUserId() {
		return psUserId;
	}
	public void setPsUserId(long psUserId) {
		this.psUserId = psUserId;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long l) {
		this.createdBy = l;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long l) {
		this.modifiedBy = l;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public ArrayList<ServiceCentersDto> getSelectedServiceCenters() {
		return selectedServiceCenters;
	}
	public void setSelectedServiceCenters(ArrayList<ServiceCentersDto> selectedServiceCenters) {
		this.selectedServiceCenters = selectedServiceCenters;
	}
	
	public long getPsuid() {
		return psuid;
	}
	public void setPsuid(long psuid) {
		this.psuid = psuid;
	}
	@Override
	public String toString() {
		return "ParcelShopUsersDto [userName=" + userName + ", emailId=" + emailId + ", loginId=" + loginId
				+ ", region=" + region + ", psuid=" + psuid + ", psUserId=" + psUserId + ", securityLevel="
				+ securityLevel + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy="
				+ modifiedBy + ", modifiedDate=" + modifiedDate + ", employeeCode=" + employeeCode
				+ ", selectedParcelshops=" + selectedParcelshops + ", selectedServiceCenters=" + selectedServiceCenters
				+ "]";
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
