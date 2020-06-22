package com.bluedart.bdmanagecorporateusers.dto;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author PR334023
 *
 */
public class UsersSearchDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String userType;
	private String loginId;
	private String areaCode;
	private String custCode;
	private String groupCode;
	private String emailId;
	private List<String> regions;
	private String creationDate;
	private String status;
	private int pageSize;
	private int pageNumber;
	private String salesEmpCode;
	private String filterValue;
	private String adminType;
	private String adminLoginId;
	
	public String getAdminLoginId() {
		return adminLoginId;
	}
	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	public String getAdminType() {
		return adminType;
	}
	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<String> getRegions() {
		return regions;
	}
	public void setRegions(List<String> regions) {
		this.regions = regions;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getSalesEmpCode() {
		return salesEmpCode;
	}
	public void setSalesEmpCode(String salesEmpCode) {
		this.salesEmpCode = salesEmpCode;
	}
	@Override
	public String toString() {
		return "UsersSearchDto [userType=" + userType + ", loginId=" + loginId
				+ ", areaCode=" + areaCode + ", custCode=" + custCode
				+ ", groupCode=" + groupCode + ", emailId=" + emailId
				+ ", regions=" + regions + ", creationDate=" + creationDate
				+ ", status=" + status + ", pageSize=" + pageSize
				+ ", pageNumber=" + pageNumber + ", salesEmpCode="
				+ salesEmpCode + ", filterValue=" + filterValue
				+ ", adminType=" + adminType + ", adminLoginId=" + adminLoginId
				+ "]";
	}


}