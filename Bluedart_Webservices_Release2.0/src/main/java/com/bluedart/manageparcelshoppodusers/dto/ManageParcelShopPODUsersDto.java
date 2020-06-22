package com.bluedart.manageparcelshoppodusers.dto;

import java.util.List;

public class ManageParcelShopPODUsersDto {
	
	
	private List<ParcelShopPODUsersSearchResultDto> parcelShopPODUsersSearchResultList;
	private List<ParcelShopsDto> parcelShopsList;
	private List<ServiceCentersDto> serviceCentersList;
	private ParcelShopPODUsersDetailsDto parcelShopUserDetails;
	private String parcelShopPODUserDeactivationReactivationStatus;
	private List<AreaRegionDto> areaRegionList;
	private int totalCount;
	private String parcelShopPODUserCreationStatus;
	private String parcelShopPODUserUpdateStatus;
	private String userLoginId;
	private String errorCode;
	private String errorMsg;
	private String emailStatus;
	
	
	/**
	 * @return the emailStatus
	 */
	public String getEmailStatus() {
		return emailStatus;
	}
	/**
	 * @param emailStatus the emailStatus to set
	 */
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}
	/**
	 * @return the parcelShopPODUserUpdateStatus
	 */
	public String getParcelShopPODUserUpdateStatus() {
		return parcelShopPODUserUpdateStatus;
	}
	/**
	 * @param parcelShopPODUserUpdateStatus the parcelShopPODUserUpdateStatus to set
	 */
	public void setParcelShopPODUserUpdateStatus(String parcelShopPODUserUpdateStatus) {
		this.parcelShopPODUserUpdateStatus = parcelShopPODUserUpdateStatus;
	}
	/**
	 * @return the userLoginId
	 */
	public String getUserLoginId() {
		return userLoginId;
	}
	/**
	 * @param userLoginId the userLoginId to set
	 */
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	/**
	 * @return the parcelShopPODUserCreationStatus
	 */
	public String getParcelShopPODUserCreationStatus() {
		return parcelShopPODUserCreationStatus;
	}
	/**
	 * @param parcelShopPODUserCreationStatus the parcelShopPODUserCreationStatus to set
	 */
	public void setParcelShopPODUserCreationStatus(String parcelShopPODUserCreationStatus) {
		this.parcelShopPODUserCreationStatus = parcelShopPODUserCreationStatus;
	}
	/**
	 * @return the parcelShopPODUsersSearchResultList
	 */
	public List<ParcelShopPODUsersSearchResultDto> getParcelShopPODUsersSearchResultList() {
		return parcelShopPODUsersSearchResultList;
	}
	/**
	 * @param parcelShopPODUsersSearchResultList the parcelShopPODUsersSearchResultList to set
	 */
	public void setParcelShopPODUsersSearchResultList(
			List<ParcelShopPODUsersSearchResultDto> parcelShopPODUsersSearchResultList) {
		this.parcelShopPODUsersSearchResultList = parcelShopPODUsersSearchResultList;
	}
	/**
	 * @return the parcelShopsList
	 */
	public List<ParcelShopsDto> getParcelShopsList() {
		return parcelShopsList;
	}
	/**
	 * @param parcelShopsList the parcelShopsList to set
	 */
	public void setParcelShopsList(List<ParcelShopsDto> parcelShopsList) {
		this.parcelShopsList = parcelShopsList;
	}
	/**
	 * @return the serviceCentersList
	 */
	public List<ServiceCentersDto> getServiceCentersList() {
		return serviceCentersList;
	}
	/**
	 * @param serviceCentersList the serviceCentersList to set
	 */
	public void setServiceCentersList(List<ServiceCentersDto> serviceCentersList) {
		this.serviceCentersList = serviceCentersList;
	}
	/**
	 * @return the parcelShopUserDetails
	 */
	public ParcelShopPODUsersDetailsDto getParcelShopUserDetails() {
		return parcelShopUserDetails;
	}
	/**
	 * @param parcelShopUserDetails the parcelShopUserDetails to set
	 */
	public void setParcelShopUserDetails(ParcelShopPODUsersDetailsDto parcelShopUserDetails) {
		this.parcelShopUserDetails = parcelShopUserDetails;
	}
	/**
	 * @return the parcelShopPODUserDeactivationReactivationStatus
	 */
	public String getParcelShopPODUserDeactivationReactivationStatus() {
		return parcelShopPODUserDeactivationReactivationStatus;
	}
	/**
	 * @param parcelShopPODUserDeactivationReactivationStatus the parcelShopPODUserDeactivationReactivationStatus to set
	 */
	public void setParcelShopPODUserDeactivationReactivationStatus(String parcelShopPODUserDeactivationReactivationStatus) {
		this.parcelShopPODUserDeactivationReactivationStatus = parcelShopPODUserDeactivationReactivationStatus;
	}
	/**
	 * @return the areaRegionList
	 */
	public List<AreaRegionDto> getAreaRegionList() {
		return areaRegionList;
	}
	/**
	 * @param areaRegionList the areaRegionList to set
	 */
	public void setAreaRegionList(List<AreaRegionDto> areaRegionList) {
		this.areaRegionList = areaRegionList;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
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
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManageParcelShopPODUsersDto [parcelShopPODUsersSearchResultList=" + parcelShopPODUsersSearchResultList
				+ ", parcelShopsList=" + parcelShopsList + ", serviceCentersList=" + serviceCentersList
				+ ", parcelShopUserDetails=" + parcelShopUserDetails
				+ ", parcelShopPODUserDeactivationReactivationStatus=" + parcelShopPODUserDeactivationReactivationStatus
				+ ", areaRegionList=" + areaRegionList + ", totalCount=" + totalCount
				+ ", parcelShopPODUserCreationStatus=" + parcelShopPODUserCreationStatus
				+ ", parcelShopPODUserUpdateStatus=" + parcelShopPODUserUpdateStatus + ", userLoginId=" + userLoginId
				+ ", errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", emailStatus=" + emailStatus + "]";
	}
	
	
	
	
}
