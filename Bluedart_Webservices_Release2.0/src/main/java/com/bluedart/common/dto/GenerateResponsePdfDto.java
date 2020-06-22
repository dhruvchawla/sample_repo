package com.bluedart.common.dto;

public class GenerateResponsePdfDto {
	
	private String Value;
	private String a_waybill_no; 
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	private String downloadPDFData;
	private byte[] pdfbytearray;
	private String tokenNumber;
	private String pickupDate;

	public byte[] getPdfbytearray() {
	      return pdfbytearray;
	}

	public void setPdfbytearray(byte[] pdfbytearray) {
	      this.pdfbytearray = pdfbytearray;
	}
	
	public String getA_waybill_no() {
		return a_waybill_no;
	}
	public void setA_waybill_no(String a_waybill_no) {
		this.a_waybill_no = a_waybill_no;
	}
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
	
	public String getPDFData() {
		return downloadPDFData;
	}
	
	public void setPDFData(String pdfData){
		downloadPDFData = pdfData;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
}
