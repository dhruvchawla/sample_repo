package com.bluedart.custreg.dto;

import java.io.Serializable;

/**
 * 
 * @author PR334023
 *
 */
public class CorporateCustomerDto implements Serializable
{
	
	private static final long serialVersionUID = 1L; 
	
	private String firstName;
	private String lastName;
	private String prefix;
	private String ccustomerCode; 
	private String userType;
	private Integer dbDownload;
	private Integer no_of_affiliates;
	private String addr1;
	private String addr2;
	private String landmark;
	private String pinCode;
	private String emailId;
	private String phone;
	private String fax;
	private String status;
	private String mode_of_shipment;
	private Integer no_of_shipments;
	private String city;
	private String customerArea;
	private String ccontactPerson;
	private String companyName;
	private String businessPotential;
	private String employeeCode;
	private String loginId;
	private String originalPassword;
	private String encryptedPassword;
	private String IpAddress;
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return IpAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the ccustomerCode
	 */
	public String getCcustomerCode() {
		return ccustomerCode;
	}
	/**
	 * @param ccustomerCode the ccustomerCode to set
	 */
	public void setCcustomerCode(String ccustomerCode) {
		this.ccustomerCode = ccustomerCode;
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
	 * @return the dbDownload
	 */
	public Integer getDbDownload() {
		return dbDownload;
	}
	/**
	 * @param dbDownload the dbDownload to set
	 */
	public void setDbDownload(Integer dbDownload) {
		this.dbDownload = dbDownload;
	}
	/**
	 * @return the no_of_affiliates
	 */
	public Integer getNo_of_affiliates() {
		return no_of_affiliates;
	}
	/**
	 * @param no_of_affiliates the no_of_affiliates to set
	 */
	public void setNo_of_affiliates(Integer no_of_affiliates) {
		this.no_of_affiliates = no_of_affiliates;
	}
	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}
	/**
	 * @param addr1 the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}
	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}
	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the mode_of_shipment
	 */
	public String getMode_of_shipment() {
		return mode_of_shipment;
	}
	/**
	 * @param mode_of_shipment the mode_of_shipment to set
	 */
	public void setMode_of_shipment(String mode_of_shipment) {
		this.mode_of_shipment = mode_of_shipment;
	}
	/**
	 * @return the no_of_shipments
	 */
	public Integer getNo_of_shipments() {
		return no_of_shipments;
	}
	/**
	 * @param no_of_shipments the no_of_shipments to set
	 */
	public void setNo_of_shipments(Integer no_of_shipments) {
		this.no_of_shipments = no_of_shipments;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the customerArea
	 */
	public String getCustomerArea() {
		return customerArea;
	}
	/**
	 * @param customerArea the customerArea to set
	 */
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}
	/**
	 * @return the ccontactPerson
	 */
	public String getCcontactPerson() {
		return ccontactPerson;
	}
	/**
	 * @param ccontactPerson the ccontactPerson to set
	 */
	public void setCcontactPerson(String ccontactPerson) {
		this.ccontactPerson = ccontactPerson;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the businessPotential
	 */
	public String getBusinessPotential() {
		return businessPotential;
	}
	/**
	 * @param businessPotential the businessPotential to set
	 */
	public void setBusinessPotential(String businessPotential) {
		this.businessPotential = businessPotential;
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
	 * @return the originalPassword
	 */
	public String getOriginalPassword() {
		return originalPassword;
	}
	/**
	 * @param originalPassword the originalPassword to set
	 */
	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}
	/**
	 * @return the encryptedPassword
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	/**
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}