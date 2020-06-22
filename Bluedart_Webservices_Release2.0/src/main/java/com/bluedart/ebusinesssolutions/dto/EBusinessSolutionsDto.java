package com.bluedart.ebusinesssolutions.dto;

import java.io.Serializable;

/**
 * @author CH848113
 */
public class EBusinessSolutionsDto implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	private String organisationName;
	private String contactPerson;
	private String emailId;
	private String mobileNumber;
	private String pinCode;
	private String website;
	private String areYouUsingBlueDart;
	private String areYouLookingFor;
	private String doYouHaveWebService;
	private String softwareCurrentlyUse;
	private String dataBaseCurrentlyUse;
	private String platformCurrentlyUse;
	private String technologyToIntigrate;
	private String yourCustomerCode;
	private String message;
	private String interfaceCode;
	private String countryCode;
	private boolean isEmailSent;
	private String loginId;
	private String statusCode;
	private String statusMessage;
	private String ipAddress;
	
	
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAreYouUsingBlueDart() {
		return areYouUsingBlueDart;
	}
	public void setAreYouUsingBlueDart(String areYouUsingBlueDart) {
		this.areYouUsingBlueDart = areYouUsingBlueDart;
	}
	public String getAreYouLookingFor() {
		return areYouLookingFor;
	}
	public void setAreYouLookingFor(String areYouLookingFor) {
		this.areYouLookingFor = areYouLookingFor;
	}
	public String getDoYouHaveWebService() {
		return doYouHaveWebService;
	}
	public void setDoYouHaveWebService(String doYouHaveWebService) {
		this.doYouHaveWebService = doYouHaveWebService;
	}
	public String getSoftwareCurrentlyUse() {
		return softwareCurrentlyUse;
	}
	public void setSoftwareCurrentlyUse(String softwareCurrentlyUse) {
		this.softwareCurrentlyUse = softwareCurrentlyUse;
	}
	public String getDataBaseCurrentlyUse() {
		return dataBaseCurrentlyUse;
	}
	public void setDataBaseCurrentlyUse(String dataBaseCurrentlyUse) {
		this.dataBaseCurrentlyUse = dataBaseCurrentlyUse;
	}
	public String getPlatformCurrentlyUse() {
		return platformCurrentlyUse;
	}
	public void setPlatformCurrentlyUse(String platformCurrentlyUse) {
		this.platformCurrentlyUse = platformCurrentlyUse;
	}
	public String getTechnologyToIntigrate() {
		return technologyToIntigrate;
	}
	public void setTechnologyToIntigrate(String technologyToIntigrate) {
		this.technologyToIntigrate = technologyToIntigrate;
	}
	public String getYourCustomerCode() {
		return yourCustomerCode;
	}
	public void setYourCustomerCode(String yourCustomerCode) {
		this.yourCustomerCode = yourCustomerCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInterfaceCode() {
		return interfaceCode;
	}
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public boolean isEmailSent() {
		return isEmailSent;
	}
	public void setEmailSent(boolean isEMailSent) {
		this.isEmailSent = isEMailSent;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}