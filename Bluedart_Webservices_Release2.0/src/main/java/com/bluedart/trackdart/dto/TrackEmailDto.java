package com.bluedart.trackdart.dto;

import java.io.Serializable;

public class TrackEmailDto implements Serializable{

	private static final long serialVersionUID = -822476976847560868L;
	
	private String isMailSent;
	private String errorCode;
	private String errorMessage;
	
	/**
	 * @return the isMailSent
	 */
	public String getIsMailSent() {
		return isMailSent;
	}
	/**
	 * @param isMailSent the isMailSent to set
	 */
	public void setIsMailSent(String isMailSent) {
		this.isMailSent = isMailSent;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
	
	

}
