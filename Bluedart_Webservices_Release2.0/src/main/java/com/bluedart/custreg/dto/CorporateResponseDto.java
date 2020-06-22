package com.bluedart.custreg.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO class for sending the response from REST service
 * @author PR334023
 *
 */
public class CorporateResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String customerCode;
	private String customerEmail;
	private boolean isCustMasterExists;
	private CustomerMasterDto customerMasterDto;
	private List<LoginDto> loginDtoList=null;
	private long generatedOTP;
	private boolean isMailSent;
	
	private String statusCode;
	private String errorMessage;
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
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the isCustMasterExists
	 */
	public boolean isCustMasterExists() {
		return isCustMasterExists;
	}
	/**
	 * @param isCustMasterExists the isCustMasterExists to set
	 */
	public void setCustMasterExists(boolean isCustMasterExists) {
		this.isCustMasterExists = isCustMasterExists;
	}
	/**
	 * @return the customerMasterDto
	 */
	public CustomerMasterDto getCustomerMasterDto() {
		return customerMasterDto;
	}
	/**
	 * @param customerMasterDto the customerMasterDto to set
	 */
	public void setCustomerMasterDto(CustomerMasterDto customerMasterDto) {
		this.customerMasterDto = customerMasterDto;
	}
	/**
	 * @return the loginDtoList
	 */
	public List<LoginDto> getLoginDtoList() {
		return loginDtoList;
	}
	/**
	 * @param loginDtoList the loginDtoList to set
	 */
	public void setLoginDtoList(List<LoginDto> loginDtoList) {
		this.loginDtoList = loginDtoList;
	}
	/**
	 * @return the generatedOTP
	 */
	public long getGeneratedOTP() {
		return generatedOTP;
	}
	/**
	 * @param generatedOTP the generatedOTP to set
	 */
	public void setGeneratedOTP(long generatedOTP) {
		this.generatedOTP = generatedOTP;
	}
	/**
	 * @return the isMailSent
	 */
	public boolean isMailSent() {
		return isMailSent;
	}
	/**
	 * @param isMailSent the isMailSent to set
	 */
	public void setMailSent(boolean isMailSent) {
		this.isMailSent = isMailSent;
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
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CorporateResponseDto [customerCode=" + customerCode
				+ ", customerEmail=" + customerEmail + ", isCustMasterExists="
				+ isCustMasterExists + ", customerMasterDto="
				+ customerMasterDto + ", loginDtoList=" + loginDtoList
				+ ", generatedOTP=" + generatedOTP + ", isMailSent="
				+ isMailSent + ", statusCode=" + statusCode + ", errorMessage="
				+ errorMessage + "]";
	}
}