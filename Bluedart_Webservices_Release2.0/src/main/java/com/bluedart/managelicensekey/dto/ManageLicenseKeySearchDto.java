package com.bluedart.managelicensekey.dto;

import java.util.List;

public class ManageLicenseKeySearchDto {

		String name;
	  String loginId;
	  String areaCode;
	  String custCode;
	  String groupCode;
	  String loginCreationDate;
	  String licenseKeyStatus;
	  String region;
	  String apiType;
	  List<String> regionsList;
	  int pageSize;
	  int pageNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getLoginCreationDate() {
		return loginCreationDate;
	}
	public void setLoginCreationDate(String loginCreationDate) {
		this.loginCreationDate = loginCreationDate;
	}
	public String getLicenseKeyStatus() {
		return licenseKeyStatus;
	}
	public void setLicenseKeyStatus(String licenseKeyStatus) {
		this.licenseKeyStatus = licenseKeyStatus;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	public List<String> getRegionsList() {
		return regionsList;
	}
	public void setRegionsList(List<String> regionsList) {
		this.regionsList = regionsList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	@Override
	public String toString() {
		return "ManageLicenseKeySearchDto [name=" + name + ", loginId="
				+ loginId + ", areaCode=" + areaCode + ", custCode=" + custCode
				+ ", groupCode=" + groupCode + ", loginCreationDate="
				+ loginCreationDate + ", licenseKeyStatus=" + licenseKeyStatus
				+ ", region=" + region + ", apiType=" + apiType
				+ ", regionsList=" + regionsList + ", pageSize=" + pageSize
				+ ", pageNumber=" + pageNumber + "]";
	}
}