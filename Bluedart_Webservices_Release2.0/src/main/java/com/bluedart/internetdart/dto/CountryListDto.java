package com.bluedart.internetdart.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.masters.dto.CountryMstDto;

/**
 * 
 * @author DH839598
 *
 */

public class CountryListDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<CountryMstDto> countryMstDtoList;
	private String errorCode;
	
	

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
	 * @return the countryMstDtoList
	 */
	public List<CountryMstDto> getCountryMstDtoList() {
		return countryMstDtoList;
	}

	/**
	 * @param countryMstDtoList the countryMstDtoList to set
	 */
	public void setCountryMstDtoList(List<CountryMstDto> countryMstDtoList) {
		this.countryMstDtoList = countryMstDtoList;
	}
	
	
	
	 
	
	

}
