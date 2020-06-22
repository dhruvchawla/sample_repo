package com.bluedart.manageparcelshoppodusers.dto;

public class NotificationsDto {
	
	String toContacts;
	String ccContacts;
	String adminEmailContent;
	String userEmailContent;
	String licenseKey;
	String apiType;
	String version;
	
	
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getToContacts() {
		return toContacts;
	}
	public void setToContacts(String toContacts) {
		this.toContacts = toContacts;
	}
	public String getCcContacts() {
		return ccContacts;
	}
	public void setCcContacts(String ccContacts) {
		this.ccContacts = ccContacts;
	}
	public String getAdminEmailContent() {
		return adminEmailContent;
	}
	public void setAdminEmailContent(String adminEmailContent) {
		this.adminEmailContent = adminEmailContent;
	}
	public String getUserEmailContent() {
		return userEmailContent;
	}
	public void setUserEmailContent(String userEmailContent) {
		this.userEmailContent = userEmailContent;
	}
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	@Override
	public String toString() {
		return "NotificationsDto [toContacts=" + toContacts + ", ccContacts=" + ccContacts + ", adminEmailContent="
				+ adminEmailContent + ", userEmailContent=" + userEmailContent + ", licenseKey=" + licenseKey + "]";
	}
	
	

}
