package com.bluedart.camanagecorpusers.dto;

import java.io.Serializable;

/**
 * DTO to hold status code and message
 * @author PR334023
 *
 */
public class CorporateStatusDto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String statusMessage;
	
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
	@Override
	public String toString() {
		return "CorporateStatusDto [statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + "]";
	}
}
