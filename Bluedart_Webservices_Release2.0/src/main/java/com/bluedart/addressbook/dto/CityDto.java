package com.bluedart.addressbook.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author AN765570
 * 
 */
public class CityDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cityCode;
	private String cityName;
	private String countryCode;
	
	private List<CityDto> cityList;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;

	
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the cityList
	 */
	public List<CityDto> getCityList() {
		return cityList;
	}

	/**
	 * @param cityList the cityList to set
	 */
	public void setCityList(List<CityDto> cityList) {
		this.cityList = cityList;
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
