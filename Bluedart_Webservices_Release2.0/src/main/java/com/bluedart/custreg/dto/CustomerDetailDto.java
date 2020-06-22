package com.bluedart.custreg.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * @author PR334023
 */
public class CustomerDetailDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String customerCode;
	private String customerArea;
	private String userType;
	private Long securityLevel;
	private Long dbDownload;
	private Long noOfAffiliates;
	private String emailId;
	private String name;
	private String designation;
	private String department;
	private String addr1;
	private String addr2;
	private String addr3;
	private String city;
	private String pincode;
	private String phone;
	private String fax;
	private Timestamp registrationDate;
	private Timestamp modifyDate;
	private String status;
	private String modeOfShipment;
	private String cregion;
	private Long noOfShipment;
	private String cscrcd;
	private String contactPerson;
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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
	 * @return the securityLevel
	 */
	public Long getSecurityLevel() {
		return securityLevel;
	}
	/**
	 * @param securityLevel the securityLevel to set
	 */
	public void setSecurityLevel(Long securityLevel) {
		this.securityLevel = securityLevel;
	}
	/**
	 * @return the dbDownload
	 */
	public Long getDbDownload() {
		return dbDownload;
	}
	/**
	 * @param dbDownload the dbDownload to set
	 */
	public void setDbDownload(Long dbDownload) {
		this.dbDownload = dbDownload;
	}
	/**
	 * @return the noOfAffiliates
	 */
	public Long getNoOfAffiliates() {
		return noOfAffiliates;
	}
	/**
	 * @param noOfAffiliates the noOfAffiliates to set
	 */
	public void setNoOfAffiliates(Long noOfAffiliates) {
		this.noOfAffiliates = noOfAffiliates;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	 * @return the addr3
	 */
	public String getAddr3() {
		return addr3;
	}
	/**
	 * @param addr3 the addr3 to set
	 */
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
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
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
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
	 * @return the registrationDate
	 */
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}
	/**
	 * @return the modifyDate
	 */
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
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
	 * @return the modeOfShipment
	 */
	public String getModeOfShipment() {
		return modeOfShipment;
	}
	/**
	 * @param modeOfShipment the modeOfShipment to set
	 */
	public void setModeOfShipment(String modeOfShipment) {
		this.modeOfShipment = modeOfShipment;
	}
	/**
	 * @return the cregion
	 */
	public String getCregion() {
		return cregion;
	}
	/**
	 * @param cregion the cregion to set
	 */
	public void setCregion(String cregion) {
		this.cregion = cregion;
	}
	/**
	 * @return the noOfShipment
	 */
	public Long getNoOfShipment() {
		return noOfShipment;
	}
	/**
	 * @param noOfShipment the noOfShipment to set
	 */
	public void setNoOfShipment(Long noOfShipment) {
		this.noOfShipment = noOfShipment;
	}
	/**
	 * @return the cscrcd
	 */
	public String getCscrcd() {
		return cscrcd;
	}
	/**
	 * @param cscrcd the cscrcd to set
	 */
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}
	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	}
