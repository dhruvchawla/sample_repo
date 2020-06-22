package com.bluedart.common.webservice.bookshipment;

public class GenerateResponsePdfDto {
	
	private String Value;
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public boolean isErrorOccured() {
		return errorOccured;
	}
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
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
