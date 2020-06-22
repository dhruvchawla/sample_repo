package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;


/**
 * 
 * @author PR334023
 * DTO to send search criteria for listing admin users
 *
 */
public class UserSearchDto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private long createdByUserId;
	private String adminEmployeeCode;
	private String userType;
	private String[] adminRegions;
	private int status;
	private int pageNumber;
	private int pageSize;
	private String sortBy;
	private String order;
	
	public long getCreatedByUserId() {
		return createdByUserId;
	}
	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	public String getAdminEmployeeCode() {
		return adminEmployeeCode;
	}
	public void setAdminEmployeeCode(String adminEmployeeCode) {
		this.adminEmployeeCode = adminEmployeeCode;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String[] getAdminRegions() {
		return adminRegions;
	}
	public void setAdminRegions(String[] adminRegions) {
		this.adminRegions = adminRegions;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}