package com.bluedart.saffire.dto;


public class NewUserRegistrationDTO{
	/**
	 * 
	 */
	private String companyName = null;
	private String yourName = null;
	private String firstName = null;
	private String lastName = null;
	private String addressLine1 = null;
	private String addressLine2 = null;
	private String landmark = null;
	private String location = null;
	private String otp = null;
	private String pincode = null;
	private String emailId = null;
	//private int mobileNo;
	private String mobileNo = null;
	private String faXNumber = null;
	private String shippingMode = null;
	private int numberofShipmentsPerMonth = 0;
	//private int annualSpendonLogistics;
	private float annualSpendonLogistics = 0;
	
	
	private String result = null;
	private String errorCode = null;
	private String errorMessage = null; 
	
	private String ipAddress= null;
	private boolean emailSent;
	private String statusCode;
	private String statusMessage;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getYourName() {
		return yourName;
	}
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFaXNumber() {
		return faXNumber;
	}
	public void setFaXNumber(String faXNumber) {
		this.faXNumber = faXNumber;
	}

	public String getShippingMode() {
		return shippingMode;
	}
	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}
	public int getNumberofShipmentsPerMonth() {
		return numberofShipmentsPerMonth;
	}
	public void setNumberofShipmentsPerMonth(int numberofShipmentsPerMonth) {
		this.numberofShipmentsPerMonth = numberofShipmentsPerMonth;
	}
	public float getAnnualSpendonLogistics() {
		return annualSpendonLogistics;
	}
	public void setAnnualSpendonLogistics(float annualSpendonLogistics) {
		this.annualSpendonLogistics = annualSpendonLogistics;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public boolean isEmailSent() {
		return emailSent;
	}
	public void setEmailSent(boolean emailSent) {
		this.emailSent = emailSent;
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
	
	
}
