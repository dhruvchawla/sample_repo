package com.bluedart.managelicensekey.dto;

import java.util.List;

public class ManageLicenseKeyDto {

	
	
	List<ManageLicenseUserDetailsDto> usersList;
	List<String> regionsList;
	String apiType;
	String errorCode;
	String errorMsg;
	int totalCount;
	
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<ManageLicenseUserDetailsDto> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<ManageLicenseUserDetailsDto> usersList) {
		this.usersList = usersList;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
		
	public List<String> getRegionsList() {
		return regionsList;
	}
	public void setRegionsList(List<String> regionsList) {
		this.regionsList = regionsList;
	}
	
	
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	@Override
	public String toString() {
		return "ManageLicenseKeyDto [usersList=" + usersList + ", regionsList="
				+ regionsList + ", apiType=" + apiType + ", errorCode="
				+ errorCode + ", errorMsg=" + errorMsg + ", totalCount="
				+ totalCount + "]";
	}
	
	
	
}
