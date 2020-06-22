package com.bluedart.managelicensekey.dto;

import java.io.Serializable;

/**
 * 
 * @author PR334023
 *
 */
public class LicenseKeyStatusDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String statusMessage;
	private boolean isMailSent;
	private String generatedKey;
	
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
	public boolean isMailSent() {
		return isMailSent;
	}
	public void setMailSent(boolean isMailSent) {
		this.isMailSent = isMailSent;
	}
	public String getGeneratedKey() {
		return generatedKey;
	}
	public void setGeneratedKey(String generatedKey) {
		this.generatedKey = generatedKey;
	}
	@Override
	public String toString() {
		return "LicenseKeyStatusDto [statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + ", isMailSent="
				+ isMailSent + ", generatedKey=" + generatedKey + "]";
	}
}