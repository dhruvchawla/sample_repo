package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ParcelShopPODUsersDetailsDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String userName;
	private String emailId;
	private String loginId;
	
	private String userStatus;
	private String securityLevel;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
    private String employeeCode; 
    private String area;
    private String region;
	private String password;
	private String bd_flag;
    private String userType;
    private String custCode;
    private String podStatus;
    private String loggedInAdminEmailId;
    private ArrayList<String> loggedInAdminRegion;
    private String loggedInAdminLoginId;
    
	//------------------------------------------------
	private ArrayList<ParcelShopsDto> selectedParcelshops;
	private ArrayList<ServiceCentersDto> selectedServiceCenters;
	
	//----------------------------------------------------
	private String userId;
	private String creator_userId;
	
	//--------------------EMAIL----------------------------
	
	private ArrayList<ParcelShopsDto> deletedParcelShops;
	private ArrayList<ParcelShopsDto> addedParcelShops;
	
	private ArrayList<ServiceCentersDto> deletedServiceCenters;
	private ArrayList<ServiceCentersDto> addedServiceCenters;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}
	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * @return the securityLevel
	 */
	public String getSecurityLevel() {
		return securityLevel;
	}
	/**
	 * @param securityLevel the securityLevel to set
	 */
	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the bd_flag
	 */
	public String getBd_flag() {
		return bd_flag;
	}
	/**
	 * @param bd_flag the bd_flag to set
	 */
	public void setBd_flag(String bd_flag) {
		this.bd_flag = bd_flag;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the custCode
	 */
	public String getCustCode() {
		return custCode;
	}
	/**
	 * @param custCode the custCode to set
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	/**
	 * @return the podStatus
	 */
	public String getPodStatus() {
		return podStatus;
	}
	/**
	 * @param podStatus the podStatus to set
	 */
	public void setPodStatus(String podStatus) {
		this.podStatus = podStatus;
	}
	/**
	 * @return the loggedInAdminEmailId
	 */
	public String getLoggedInAdminEmailId() {
		return loggedInAdminEmailId;
	}
	/**
	 * @param loggedInAdminEmailId the loggedInAdminEmailId to set
	 */
	public void setLoggedInAdminEmailId(String loggedInAdminEmailId) {
		this.loggedInAdminEmailId = loggedInAdminEmailId;
	}
	/**
	 * @return the loggedInAdminRegion
	 */
	public ArrayList<String> getLoggedInAdminRegion() {
		return loggedInAdminRegion;
	}
	/**
	 * @param loggedInAdminRegion the loggedInAdminRegion to set
	 */
	public void setLoggedInAdminRegion(ArrayList<String> loggedInAdminRegion) {
		this.loggedInAdminRegion = loggedInAdminRegion;
	}
	/**
	 * @return the loggedInAdminLoginId
	 */
	public String getLoggedInAdminLoginId() {
		return loggedInAdminLoginId;
	}
	/**
	 * @param loggedInAdminLoginId the loggedInAdminLoginId to set
	 */
	public void setLoggedInAdminLoginId(String loggedInAdminLoginId) {
		this.loggedInAdminLoginId = loggedInAdminLoginId;
	}
	/**
	 * @return the selectedParcelshops
	 */
	public ArrayList<ParcelShopsDto> getSelectedParcelshops() {
		return selectedParcelshops;
	}
	/**
	 * @param selectedParcelshops the selectedParcelshops to set
	 */
	public void setSelectedParcelshops(ArrayList<ParcelShopsDto> selectedParcelshops) {
		this.selectedParcelshops = selectedParcelshops;
	}
	/**
	 * @return the selectedServiceCenters
	 */
	public ArrayList<ServiceCentersDto> getSelectedServiceCenters() {
		return selectedServiceCenters;
	}
	/**
	 * @param selectedServiceCenters the selectedServiceCenters to set
	 */
	public void setSelectedServiceCenters(ArrayList<ServiceCentersDto> selectedServiceCenters) {
		this.selectedServiceCenters = selectedServiceCenters;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the creator_userId
	 */
	public String getCreator_userId() {
		return creator_userId;
	}
	/**
	 * @param creator_userId the creator_userId to set
	 */
	public void setCreator_userId(String creator_userId) {
		this.creator_userId = creator_userId;
	}
	/**
	 * @return the deletedParcelShops
	 */
	public ArrayList<ParcelShopsDto> getDeletedParcelShops() {
		return deletedParcelShops;
	}
	/**
	 * @param deletedParcelShops the deletedParcelShops to set
	 */
	public void setDeletedParcelShops(ArrayList<ParcelShopsDto> deletedParcelShops) {
		this.deletedParcelShops = deletedParcelShops;
	}
	/**
	 * @return the addedParcelShops
	 */
	public ArrayList<ParcelShopsDto> getAddedParcelShops() {
		return addedParcelShops;
	}
	/**
	 * @param addedParcelShops the addedParcelShops to set
	 */
	public void setAddedParcelShops(ArrayList<ParcelShopsDto> addedParcelShops) {
		this.addedParcelShops = addedParcelShops;
	}
	/**
	 * @return the deletedServiceCenters
	 */
	public ArrayList<ServiceCentersDto> getDeletedServiceCenters() {
		return deletedServiceCenters;
	}
	/**
	 * @param deletedServiceCenters the deletedServiceCenters to set
	 */
	public void setDeletedServiceCenters(ArrayList<ServiceCentersDto> deletedServiceCenters) {
		this.deletedServiceCenters = deletedServiceCenters;
	}
	/**
	 * @return the addedServiceCenters
	 */
	public ArrayList<ServiceCentersDto> getAddedServiceCenters() {
		return addedServiceCenters;
	}
	/**
	 * @param addedServiceCenters the addedServiceCenters to set
	 */
	public void setAddedServiceCenters(ArrayList<ServiceCentersDto> addedServiceCenters) {
		this.addedServiceCenters = addedServiceCenters;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParcelShopPODUsersDetailsDto [userName=" + userName + ", emailId=" + emailId + ", loginId=" + loginId
				+ ", userStatus=" + userStatus + ", securityLevel=" + securityLevel + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate
				+ ", employeeCode=" + employeeCode + ", area=" + area + ", region=" + region + ", password=" + password
				+ ", bd_flag=" + bd_flag + ", userType=" + userType + ", custCode=" + custCode + ", podStatus="
				+ podStatus + ", loggedInAdminEmailId=" + loggedInAdminEmailId + ", loggedInAdminRegion="
				+ loggedInAdminRegion + ", loggedInAdminLoginId=" + loggedInAdminLoginId + ", selectedParcelshops="
				+ selectedParcelshops + ", selectedServiceCenters=" + selectedServiceCenters + ", userId=" + userId
				+ ", creator_userId=" + creator_userId + ", deletedParcelShops=" + deletedParcelShops
				+ ", addedParcelShops=" + addedParcelShops + ", deletedServiceCenters=" + deletedServiceCenters
				+ ", addedServiceCenters=" + addedServiceCenters + "]";
	}
	
}
