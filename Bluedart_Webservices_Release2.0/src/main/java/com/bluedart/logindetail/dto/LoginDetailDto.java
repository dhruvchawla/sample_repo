package com.bluedart.logindetail.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class LoginDetailDto implements Serializable{ 
	
	private static final long serialVersionUID = -7661536875204521356L;

	private String loginId;
	private List<String> regionList;
	private Map<String,String> permissionMap;
	private String areaCode;
	private String custCode;
	
	private String featureName;
	
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the regionList
	 */
	public List<String> getRegionList() {
		return regionList;
	}
	/**
	 * @param regionList the regionList to set
	 */
	public void setRegionList(List<String> regionList) {
		this.regionList = regionList;
	}
	/**
	 * @return the permissionMap
	 */
	public Map<String, String> getPermissionMap() {
		return permissionMap;
	}
	/**
	 * @param permissionMap the permissionMap to set
	 */
	public void setPermissionMap(Map<String, String> permissionMap) {
		this.permissionMap = permissionMap;
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
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	
}
