/**
 * 
 */
package com.bluedart.exception;

/**
 * @author RA848436
 *
 */

public class PodMailServiceException extends RuntimeException	 {
	
	private static final long serialVersionUID = -7650179531578663910L;
	
	private String errorCode;
	
	private String errorMessage;
	
	public PodMailServiceException() {
	}

	public PodMailServiceException(String code, String message) {
		//super(code);
		this.errorCode = code;
		this.errorMessage = message;
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
	
	
	
	
	
	
	
}
