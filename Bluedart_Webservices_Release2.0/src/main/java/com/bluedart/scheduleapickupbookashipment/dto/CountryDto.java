package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author AN765570
 * 
 */
public class CountryDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String countryName;
	private String pincodeFormat;
	
	private List<CountryDto> countryList;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getPincodeFormat() {
		return pincodeFormat;
	}
	public void setPincodeFormat(String pincodeFormat) {
		this.pincodeFormat = pincodeFormat;
	}
	/**
	 * @return the countryList
	 */
	public List<CountryDto> getCountryList() {
		return countryList;
	}
	/**
	 * @param countryList the countryList to set
	 */
	public void setCountryList(List<CountryDto> countryList) {
		this.countryList = countryList;
	}
	/**
	 * @return the errorOccured
	 */
	public boolean isErrorOccured() {
		return errorOccured;
	}
	/**
	 * @param errorOccured the errorOccured to set
	 */
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
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
