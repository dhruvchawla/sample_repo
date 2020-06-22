package com.bluedart.exception;

public class DataBaseException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	
	private String errorCode;
	
	private String errorMessage;
	
	public DataBaseException() {
	}

	public DataBaseException(String code, String message) {
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
