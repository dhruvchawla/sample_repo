package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;

/**
 * 
 * @author DH839598
 *
 */
public class PickupRegistrationDto implements Serializable {

	private static final long serialVersionUID = 3551206618213384682L;

	private String loginId;
	private String actualPickupDate;
	private String actualPickupTime;
	private String areaCode;
	private String contactPerson;
	private String address1;
	private String address2;
	private String address3;
	private String custCode;
	private String customerName;
	private String pincode;
	private String emailId;
	private String telephoneNumber;
	private String numberOfPieces;
	private String officeCloseTime;
	private String refNumber;
	private String routeCode;
	private String serviceCenterCode;
	private String shipmentPickupDate;
	private String shipmentPickupTime;
	private String tokenNumber;
	private String volumeWeight;
	private String weightOfTheShipment;
	private String[] productArray;
	private String[] subProductArray;
	private String mobileNumber;
 
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the actualPickupDate
	 */
	public String getActualPickupDate() {
		return actualPickupDate;
	}

	/**
	 * @param actualPickupDate
	 *            the actualPickupDate to set
	 */
	public void setActualPickupDate(String actualPickupDate) {
		this.actualPickupDate = actualPickupDate;
	}

	/**
	 * @return the actualPickupTime
	 */
	public String getActualPickupTime() {
		return actualPickupTime;
	}

	/**
	 * @param actualPickupTime
	 *            the actualPickupTime to set
	 */
	public void setActualPickupTime(String actualPickupTime) {
		this.actualPickupTime = actualPickupTime;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode
	 *            the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson
	 *            the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 *            the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2
	 *            the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * @param address3
	 *            the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	/**
	 * @return the custCode
	 */
	public String getCustCode() {
		return custCode;
	}

	/**
	 * @param custCode
	 *            the custCode to set
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber
	 *            the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the numberOfPieces
	 */
	public String getNumberOfPieces() {
		return numberOfPieces;
	}

	/**
	 * @param numberOfPieces
	 *            the numberOfPieces to set
	 */
	public void setNumberOfPieces(String numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	/**
	 * @return the officeCloseTime
	 */
	public String getOfficeCloseTime() {
		return officeCloseTime;
	}

	/**
	 * @param officeCloseTime
	 *            the officeCloseTime to set
	 */
	public void setOfficeCloseTime(String officeCloseTime) {
		this.officeCloseTime = officeCloseTime;
	}

	/**
	 * @return the refNumber
	 */
	public String getRefNumber() {
		return refNumber;
	}

	/**
	 * @param refNumber
	 *            the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	/**
	 * @return the routeCode
	 */
	public String getRouteCode() {
		return routeCode;
	}

	/**
	 * @param routeCode
	 *            the routeCode to set
	 */
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	/**
	 * @return the serviceCenterCode
	 */
	public String getServiceCenterCode() {
		return serviceCenterCode;
	}

	/**
	 * @param serviceCenterCode
	 *            the serviceCenterCode to set
	 */
	public void setServiceCenterCode(String serviceCenterCode) {
		this.serviceCenterCode = serviceCenterCode;
	}

	/**
	 * @return the shipmentPickupDate
	 */
	public String getShipmentPickupDate() {
		return shipmentPickupDate;
	}

	/**
	 * @param shipmentPickupDate
	 *            the shipmentPickupDate to set
	 */
	public void setShipmentPickupDate(String shipmentPickupDate) {
		this.shipmentPickupDate = shipmentPickupDate;
	}

	/**
	 * @return the shipmentPickupTime
	 */
	public String getShipmentPickupTime() {
		return shipmentPickupTime;
	}

	/**
	 * @param shipmentPickupTime
	 *            the shipmentPickupTime to set
	 */
	public void setShipmentPickupTime(String shipmentPickupTime) {
		this.shipmentPickupTime = shipmentPickupTime;
	}

	/**
	 * @return the tokenNumber
	 */
	public String getTokenNumber() {
		return tokenNumber;
	}

	/**
	 * @param tokenNumber
	 *            the tokenNumber to set
	 */
	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	/**
	 * @return the volumeWeight
	 */
	public String getVolumeWeight() {
		return volumeWeight;
	}

	/**
	 * @param volumeWeight
	 *            the volumeWeight to set
	 */
	public void setVolumeWeight(String volumeWeight) {
		this.volumeWeight = volumeWeight;
	}

	/**
	 * @return the weightOfTheShipment
	 */
	public String getWeightOfTheShipment() {
		return weightOfTheShipment;
	}

	/**
	 * @param weightOfTheShipment
	 *            the weightOfTheShipment to set
	 */
	public void setWeightOfTheShipment(String weightOfTheShipment) {
		this.weightOfTheShipment = weightOfTheShipment;
	}

	/**
	 * @return the productArray
	 */
	public String[] getProductArray() {
		return productArray;
	}

	/**
	 * @param productArray
	 *            the productArray to set
	 */
	public void setProductArray(String[] productArray) {
		this.productArray = productArray;
	}


	/**
	 * @return the subProductArray
	 */
	public String[] getSubProductArray() {
		return subProductArray;
	}

	/**
	 * @param subProductArray
	 *            the subProductArray to set
	 */
	public void setSubProductArray(String[] subProductArray) {
		this.subProductArray = subProductArray;
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
	
	

}
