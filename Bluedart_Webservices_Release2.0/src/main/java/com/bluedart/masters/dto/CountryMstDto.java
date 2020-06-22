package com.bluedart.masters.dto;

import java.io.Serializable;

/**
 * 
 * @author DH839598
 *
 */

public class CountryMstDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String countryCode;
	private String countryName;
	
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
	
	

}
