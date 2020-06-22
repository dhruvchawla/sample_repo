package com.bluedart.shipdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author CH851827
 *
 */
public class MasterListDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AreaMstDto> areaMstDtoList;
	private List<CustMstDto> custMstDtoList;
	private List<CityMstDto> cityMstDtoList;
	private List<PincodeMstDto> pincodeMstDtoList;	
			
	private String statusCode;
	private String statusMessage;	
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<AreaMstDto> getAreaMstDtoList() {
		return areaMstDtoList;
	}
	
	public void setAreaMstDtoList(List<AreaMstDto> areaMstDtoList) {
		this.areaMstDtoList = areaMstDtoList;
	}
	
	public List<CustMstDto> getCustMstDtoList() {
		return custMstDtoList;
	}
	
	public void setCustMstDtoList(List<CustMstDto> custMstDtoList) {
		this.custMstDtoList = custMstDtoList;
	}
	
	public List<CityMstDto> getCityMstDtoList() {
		return cityMstDtoList;
	}

	public void setCityMstDtoList(List<CityMstDto> cityMstDtoList) {
		this.cityMstDtoList = cityMstDtoList;
	}

	public List<PincodeMstDto> getPincodeMstDtoList() {
		return pincodeMstDtoList;
	}
	
	public void setPincodeMstDtoList(List<PincodeMstDto> pincodeMstDtoList) {
		this.pincodeMstDtoList = pincodeMstDtoList;
	}	
		
}
