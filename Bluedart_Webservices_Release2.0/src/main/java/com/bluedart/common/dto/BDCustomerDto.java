package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.bdmanagecorporateusers.dto.PermissionResponseDto;

/**
 * 
 * @author PR334023
 *
 */
public class BDCustomerDto extends StatusDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<AffiliateDetailDto> affList;
	private List<PermissionMappingDto> perDtoList;
	private List<PermissionDto> perList;
	private List<PermissionResponseDto> perResponseList;
	
	private String groupCode;
	private String custCode;
	private String adminLoginId;
	private int totalCount;
	private List<String> loginIdList;
	private List<Long> userIdList;
	private List<String> regions;
	private String adminType;
	
	public String getAdminType() {
		return adminType;
	}
	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}
	public List<String> getRegions() {
		return regions;
	}
	public void setRegions(List<String> regions) {
		this.regions = regions;
	}
	public List<Long> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<Long> userIdList) {
		this.userIdList = userIdList;
	}
	public List<String> getLoginIdList() {
		return loginIdList;
	}
	public void setLoginIdList(List<String> loginIdList) {
		this.loginIdList = loginIdList;
	}
	public List<AffiliateDetailDto> getAffList() {
		return affList;
	}
	public void setAffList(List<AffiliateDetailDto> affList) {
		this.affList = affList;
	}
	public List<PermissionMappingDto> getPerDtoList() {
		return perDtoList;
	}
	public void setPerDtoList(List<PermissionMappingDto> perDtoList) {
		this.perDtoList = perDtoList;
	}
	public List<PermissionDto> getPerList() {
		return perList;
	}
	public void setPerList(List<PermissionDto> perList) {
		this.perList = perList;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getAdminLoginId() {
		return adminLoginId;
	}
	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<PermissionResponseDto> getPerResponseList() {
		return perResponseList;
	}
	public void setPerResponseList(List<PermissionResponseDto> perResponseList) {
		this.perResponseList = perResponseList;
	}
	@Override
	public String toString() {
		return "BDCustomerDto [affList=" + affList + ", perDtoList="
				+ perDtoList + ", perList=" + perList + ", perResponseList="
				+ perResponseList + ", groupCode=" + groupCode + ", custCode="
				+ custCode + ", adminLoginId=" + adminLoginId + ", totalCount="
				+ totalCount + ", loginIdList=" + loginIdList + ", userIdList="
				+ userIdList + ", regions=" + regions + ", adminType="
				+ adminType + "]";
	}
	
}