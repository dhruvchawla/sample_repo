package com.bluedart.pod.dto;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Akanksha/Velayutham
 *  
 *
 */
public class SavePodEntryDto implements Serializable {

	private static final long serialVersionUID = 1L;

  	public String handHeld;
    public String location;
    public String loginId;
    public Calendar modifiedDate;
	public String awbNo; //Airway bill no
	public String batchNumber;
	public String consignee; //Consignee
	public String creditCardShipment;
	public String deliveryEmployeeCode;
	public String identityGroup;
	public String identityNumber;
	public String identityType;
	public String locationDetail;
	public String loggedInEmployeeCode;
	public String mobileNumber;
	public String newAWBNumber;
	public String newDestination;
	public String octroiConeeName;
	public String octroiDuty;
	public String octroiMobileNo;
	public String pieces;
	public String pinCode;
	public String receivedBy;
	public String relationCode; //Relation
	public String remarks;
	public String statusCode; //Status code
	public Calendar statusDate; //Status date
	public String statusTime; //Status time
	public String statusType; //Status type
	public String toDestinationArea;
	
	public String statusInfo;
	public String errorSeverity;
	public Boolean isErrorSpecified;

	/**
	 * @return the message
	 */
	public String getStatusInfo() {
		return statusInfo;
	}
	/**
	 * @param message the message to set
	 */
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	
	/**
	 * @return the errorSeverity
	 */
	public String getErrorSeverity() {
		return errorSeverity;
	}
	/**
	 * @param errorSeverity the errorSeverity to set
	 */
	public void setErrorSeverity(String errorSeverity) {
		this.errorSeverity = errorSeverity;
	}
	
	/**
	 * @return the isErrorSpecified
	 */
	public Boolean getErrorSpecified() {
		return isErrorSpecified;
	}
	/**
	 * @param isErrorSpecified the isErrorSpecified to set
	 */
	public void setErrorSpecified(Boolean isErrorSpecified) {
		this.isErrorSpecified = isErrorSpecified;
	}
	
	/**
	 * @return the handHeld
	 */
	public String getHandHeld() {
		return handHeld;
	}
	/**
	 * @param handHeld the handHeld to set
	 */
	public void setHandHeld(String handHeld) {
		this.handHeld = handHeld;
	}
	
	/**
	 * @return the awbNo
	 */
	public String getAwbNo() {
		return awbNo;
	}
	/**
	 * @param awbNo the awbNo to set
	 */
	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
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
	 * @return the modifiedDate
	 */
	public Calendar getModifiedDate() {
		return modifiedDate;
	}
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * @return the batchNumber
	 */
	public String getBatchNumber() {
		return batchNumber;
	}
	/**
	 * @param batchNumber the batchNumber to set
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	
	/**
	 * @return the creditCardShipment
	 */
	public String getCreditCardShipment() {
		return creditCardShipment;
	}
	/**
	 * @param creditCardShipment the creditCardShipment to set
	 */
	public void setCreditCardShipment(String creditCardShipment) {
		this.creditCardShipment = creditCardShipment;
	}
	
	
	/**
	 * @return the deliveryEmployeeCode
	 */
	public String getDeliveryEmployeeCode() {
		return deliveryEmployeeCode;
	}
	/**
	 * @param deliveryEmployeeCode the deliveryEmployeeCode to set
	 */
	public void setDeliveryEmployeeCode(String deliveryEmployeeCode) {
		this.deliveryEmployeeCode = deliveryEmployeeCode;
	}
	/**
	 * @return the identityGroup
	 */
	public String getIdentityGroup() {
		return identityGroup;
	}
	/**
	 * @param identityGroup the identityGroup to set
	 */
	public void setIdentityGroup(String identityGroup) {
		this.identityGroup = identityGroup;
	}
	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * @return the identityNumber
	 */
	public String getIdentityNumber() {
		return identityNumber;
	}
	/**
	 * @param identityNumber the identityNumber to set
	 */
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	/**
	 * @return the identityType
	 */
	public String getIdentityType() {
		return identityType;
	}
	/**
	 * @param identityType the identityType to set
	 */
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	
	/**
	 * @return the locationDetail
	 */
	public String getLocationDetail() {
		return locationDetail;
	}
	/**
	 * @param locationDetail the locationDetail to set
	 */
	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}
	
	/**
	 * @return the loggedInEmployeeCode
	 */
	public String getLoggedInEmployeeCode() {
		return loggedInEmployeeCode;
	}
	/**
	 * @param loggedInEmployeeCode the loggedInEmployeeCode to set
	 */
	public void setLoggedInEmployeeCode(String loggedInEmployeeCode) {
		this.loggedInEmployeeCode = loggedInEmployeeCode;
	}
	
	
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * @return the newAWBNumber
	 */
	public String getNewAWBNumber() {
		return newAWBNumber;
	}
	/**
	 * @param newAWBNumber the newAWBNumber to set
	 */
	public void setNewAWBNumber(String newAWBNumber) {
		this.newAWBNumber = newAWBNumber;
	}
	
	/**
	 * @return the newDestination
	 */
	public String getNewDestination() {
		return newDestination;
	}
	/**
	 * @param newDestination the newDestination to set
	 */
	public void setNewDestination(String newDestination) {
		this.newDestination = newDestination;
	}
	
	/**
	 * @return the octroiConeeName
	 */
	public String getOctroiConeeName() {
		return octroiConeeName;
	}
	/**
	 * @param octroiConeeName the octroiConeeName to set
	 */
	public void setOctroiConeeName(String octroiConeeName) {
		this.octroiConeeName = octroiConeeName;
	}
	
	/**
	 * @return the octroiDuty
	 */
	public String getOctroiDuty() {
		return octroiDuty;
	}
	/**
	 * @param octroiDuty the octroiDuty to set
	 */
	public void setOctroiDuty(String octroiDuty) {
		this.octroiDuty = octroiDuty;
	}
	
	/**
	 * @return the octroiMobileNo
	 */
	public String getOctroiMobileNo() {
		return octroiMobileNo;
	}
	/**
	 * @param octroiMobileNo the octroiMobileNo to set
	 */
	public void setOctroiMobileNo(String octroiMobileNo) {
		this.octroiMobileNo = octroiMobileNo;
	}
	
	/**
	 * @return the pieces
	 */
	public String getPieces() {
		return pieces;
	}
	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(String pieces) {
		this.pieces = pieces;
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
	public void setPincode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	/**
	 * @return the receivedBy
	 */
	public String getReceivedBy() {
		return receivedBy;
	}
	/**
	 * @param receivedBy the receivedBy to set
	 */
	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}
	/**
	 * @return the relationCode
	 */
	public String getRelationCode() {
		return relationCode;
	}
	/**
	 * @param relationCode the relationCode to set
	 */
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}
	
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the statusDate
	 */
	public Calendar getStatusDate() {
		return statusDate;
	}
	/**
	 * @param statusDate the statusDate to set
	 */
	public void setStatusDate(Calendar statusDate) {
		this.statusDate = statusDate;
	}
	/**
	 * @return the statusTime
	 */
	public String getStatusTime() {
		return statusTime;
	}
	/**
	 * @param statusTime the statusTime to set
	 */
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}
	
	/**
	 * @return the statusType
	 */
	public String getStatusType() {
		return statusType;
	}
	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * @return the toDestinationArea
	 */
	public String getToDestinationArea() {
		return toDestinationArea;
	}
	/**
	 * @param toDestinationArea the toDestinationArea to set
	 */
	public void setToDestinationArea(String toDestinationArea) {
		this.toDestinationArea = toDestinationArea;
	}
	
}
