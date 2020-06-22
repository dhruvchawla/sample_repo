package com.bluedart.manageparcelshoppodusers.dto;

import java.util.ArrayList;

public class ParcelShopPODUsersSearchDto {

	private String userType;
	private String region;
	private String area;
	private String parcelShop;
	private String serviceCenter;
	private String status;
	private int pageSize;
	private int pageNumber;
	private ArrayList<String> adminRegion;
	private String loggedInAdminLoginId;
	
	

	/**
	 * @return the loggedInAdminLoginId
	 */
	public String getLoggedInAdminLoginId() {
		return loggedInAdminLoginId;
	}
	/**
	 * @param loggedInAdminLoginId the loggedInAdminLoginId to set
	 */
	public void setLoggedInAdminLoginId(String loggedInAdminLoginId) {
		this.loggedInAdminLoginId = loggedInAdminLoginId;
	}
	/**
	 * @return the adminRegion
	 */
	public ArrayList<String> getAdminRegion() {
		return adminRegion;
	}
	/**
	 * @param adminRegion the adminRegion to set
	 */
	public void setAdminRegion(ArrayList<String> adminRegion) {
		this.adminRegion = adminRegion;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the parcelShop
	 */
	public String getParcelShop() {
		return parcelShop;
	}
	/**
	 * @param parcelShop the parcelShop to set
	 */
	public void setParcelShop(String parcelShop) {
		this.parcelShop = parcelShop;
	}
	/**
	 * @return the serviceCenter
	 */
	public String getServiceCenter() {
		return serviceCenter;
	}
	/**
	 * @param serviceCenter the serviceCenter to set
	 */
	public void setServiceCenter(String serviceCenter) {
		this.serviceCenter = serviceCenter;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParcelShopPODUsersSearchDto [userType=" + userType + ", region=" + region + ", area=" + area
				+ ", parcelShop=" + parcelShop + ", serviceCenter=" + serviceCenter + ", status=" + status
				+ ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", adminRegion=" + adminRegion
				+ ", loggedInAdminLoginId=" + loggedInAdminLoginId + "]";
	}

}
