package com.bluedart.common.dto;

import java.io.Serializable;

/**
 * 
 * @author PR334023
 *
 */
public class StatusDto implements Serializable{

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
	
}
