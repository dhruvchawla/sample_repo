package com.bluedart.common.dto;

import java.io.Serializable;

/**
 * @author PR334023
 *
 */
public class ValidCustomerDto extends StatusDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String validFlag;
	private boolean isEmailSent;
	private Long otp;

	
	public Long getOtp() {
		return otp;
	}


	public void setOtp(Long otp) {
		this.otp = otp;
	}


	public boolean isEmailSent() {
		return isEmailSent;
	}


	public void setEmailSent(boolean isEmailSent) {
		this.isEmailSent = isEmailSent;
	}


	public String getValidFlag() {
		return validFlag;
	}


	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
	@Override
	public String toString() {
		return "ValidCustomerDto [validFlag=" + validFlag + ", isEmailSent="
				+ isEmailSent + ", otp=" + otp + "]";
	}
}
