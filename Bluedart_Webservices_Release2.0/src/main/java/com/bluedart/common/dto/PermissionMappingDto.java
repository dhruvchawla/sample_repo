package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author PR334023
 *
 */
public class PermissionMappingDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<PermissionDto> permissionDtosList;
	private List<PermissionCascadeDto> perCascadeList;
	private String areaCode;
	private String custCode;
	private String loginId;
	private List<String> permissionNames;
	private List<String> loginIdsList;
	private String modifiedBy;
	
	public List<PermissionCascadeDto> getPerCascadeList() {
		return perCascadeList;
	}
	public void setPerCascadeList(List<PermissionCascadeDto> perCascadeList) {
		this.perCascadeList = perCascadeList;
	}
	public List<String> getLoginIdsList() {
		return loginIdsList;
	}
	public void setLoginIdsList(List<String> loginIdsList) {
		this.loginIdsList = loginIdsList;
	}
	public List<String> getPermissionNames() {
		return permissionNames;
	}
	public void setPermissionNames(List<String> permissionNames) {
		this.permissionNames = permissionNames;
	}
	public List<PermissionDto> getPermissionDtosList() {
		return permissionDtosList;
	}
	public void setPermissionDtosList(List<PermissionDto> permissionDtosList) {
		this.permissionDtosList = permissionDtosList;
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
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "PermissionMappingDto [permissionDtosList=" + permissionDtosList
				+ ", perCascadeList=" + perCascadeList + ", areaCode="
				+ areaCode + ", custCode=" + custCode + ", loginId=" + loginId
				+ ", permissionNames=" + permissionNames + ", loginIdsList="
				+ loginIdsList + ", modifiedBy=" + modifiedBy + "]";
	}
}