package com.bluedart.contactus.dto;

import java.io.Serializable;

public class CustomerFeedbackRequestDto implements Serializable {

	/**
	 * @author CH848113
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	private String waybillNumber;	
	
	private String feedbackType;	
	
	private String feedbackBy;	
			
	private String feedbackDescription;	
	
	private String destinationArea;	
	
	private String contactNumber;	
	
	private String customerName;	
	
	private String customerEmailId;	
	
	private String feedbackReason;	
	
	private String feedbackRefno;
	
	private String employeeName;
	
	private String ipAddress;
	
	private String loginId;
	
	private String locationName;
	
	private String pinCode;
	
	

	
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public String getFeedbackType() {
		return feedbackType;
	}
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	public String getFeedbackBy() {
		return feedbackBy;
	}
	public void setFeedbackBy(String feedbackBy) {
		this.feedbackBy = feedbackBy;
	}
	
	public String getFeedbackDescription() {
		return feedbackDescription;
	}
	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}

	public String getDestinationArea() {
		return destinationArea;
	}
	public void setDestinationArea(String destinationArea) {
		this.destinationArea = destinationArea;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getFeedbackReason() {
		return feedbackReason;
	}
	public void setFeedbackReason(String feedbackReason) {
		this.feedbackReason = feedbackReason;
	}
	public String getFeedbackRefno() {
		return feedbackRefno;
	}
	public void setFeedbackRefno(String feedbackRefno) {
		this.feedbackRefno = feedbackRefno;
	}	

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
