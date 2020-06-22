package com.bluedart.mobiledart.dto;

import java.io.Serializable;
import java.util.List;
/**
 * @author CH848113
 */
public class MobileDartDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//request parameters
	private List<String> awbNumbers;
	private String action;
	private String handler;
	private String mobileNumber;
	private String reverseMessage;
	
	//response parameters
	private String smsMessage;
	private String error;
	private String sucess;
	private String sendToMessage;
	private String statusCode;
	private String statusMessage;
	

	public List<String> getAwbNumbers() {
		return awbNumbers;
	}
	
	public String getAction() {
		return action;
	}
	
	public String getHandler() {
		return handler;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getReverseMessage() {
		return reverseMessage;
	}

	public String getSmsMessage() {
		return smsMessage;
	}
	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getSucess() {
		return sucess;
	}
	public void setSucess(String sucess) {
		this.sucess = sucess;
	}
	public String getSendToMessage() {
		return sendToMessage;
	}
	public void setSendToMessage(String sendToMessage) {
		this.sendToMessage = sendToMessage;
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
