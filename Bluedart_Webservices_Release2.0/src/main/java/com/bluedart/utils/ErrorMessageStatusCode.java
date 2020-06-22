package com.bluedart.utils;

/**
 * 
 * @author DH839598
 *
 */
public enum ErrorMessageStatusCode {

	DATABASE_DOWN("0", "A database error has occured."),
	OK("200", "OK"),
	NOT_FOUND("404", "Not Found"),
	UNAUTHORIZED("401", "Unauthorized"),
	EMAIL_NOT_SENT("700", "Email Server Down."),
	INPUT_ERROR("515","Please provide a valid input. "),
	DB_ERROR("520","The service is temporarily unavailable! Try again later. "),
	C2PC_DOWN("777", "C2PC Service Down"),
	
	//--------------------------------------------TTF--------------------------------------------------------------
		ORIGIN_NOT_SERVICEABLE("511","Origin Not Serviceable"),
		DESTINATION_NOT_SERVICEABLE("512","Destination Not Serviceable"),
		FINDER_C2PC_REMOTE_ERROR("102","The service is temporarily unavailable! Try again later."),
		INVALID_PINCODE("503","Invalid PinCode"),
		NA_DELIVERY_DATE("519","ExpectedDateOfDel:NA"),
		DB_ERROR_TTF("709","The service is temporarily unavailable! Try again later."),
		UNEXPECTED_ERROR("703","Unexpeced error occured");

	private final String code;
	private final String description;

	private ErrorMessageStatusCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}
}
