package com.bluedart.common.dto;

import java.io.Serializable;

/**
 * 
 * @author DH839598
 *
 */
public class ErrorDto implements Serializable {

	private static final long serialVersionUID = -3440353216200742644L;
	
	private String errorCode;
	private String errorMessage;
	
	
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
