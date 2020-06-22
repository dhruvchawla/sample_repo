package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ParcelShopPODUsersSearchResultDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String userId;
	private String loginId;
	private String userName;
	private String userType;
	private String status;
	private ArrayList<String> loggedInAdminRegion;
	private String deactivationReacivationPossibilityStatus;
	private String podStatus;
	private String userEmailId;
	private String loggedInAdminEmailId;
	private String loggedInAdminLoginId;
	private String newPasswordReactivate;
	
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the loggedInAdminRegion
	 */
	public ArrayList<String> getLoggedInAdminRegion() {
		return loggedInAdminRegion;
	}
	/**
	 * @param loggedInAdminRegion the loggedInAdminRegion to set
	 */
	public void setLoggedInAdminRegion(ArrayList<String> loggedInAdminRegion) {
		this.loggedInAdminRegion = loggedInAdminRegion;
	}
	/**
	 * @return the deactivationReacivationPossibilityStatus
	 */
	public String getDeactivationReacivationPossibilityStatus() {
		return deactivationReacivationPossibilityStatus;
	}
	/**
	 * @param deactivationReacivationPossibilityStatus the deactivationReacivationPossibilityStatus to set
	 */
	public void setDeactivationReacivationPossibilityStatus(String deactivationReacivationPossibilityStatus) {
		this.deactivationReacivationPossibilityStatus = deactivationReacivationPossibilityStatus;
	}
	/**
	 * @return the podStatus
	 */
	public String getPodStatus() {
		return podStatus;
	}
	/**
	 * @param podStatus the podStatus to set
	 */
	public void setPodStatus(String podStatus) {
		this.podStatus = podStatus;
	}
	/**
	 * @return the userEmailId
	 */
	public String getUserEmailId() {
		return userEmailId;
	}
	/**
	 * @param userEmailId the userEmailId to set
	 */
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	/**
	 * @return the loggedInAdminEmailId
	 */
	public String getLoggedInAdminEmailId() {
		return loggedInAdminEmailId;
	}
	/**
	 * @param loggedInAdminEmailId the loggedInAdminEmailId to set
	 */
	public void setLoggedInAdminEmailId(String loggedInAdminEmailId) {
		this.loggedInAdminEmailId = loggedInAdminEmailId;
	}
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
	 * @return the newPassword_reactivate
	 */
	public String getNewPasswordReactivate() {
		return newPasswordReactivate;
	}
	/**
	 * @param newPassword_reactivate the newPassword_reactivate to set
	 */
	public void setNewPasswordReactivate(String newPassword_reactivate) {
		this.newPasswordReactivate = newPassword_reactivate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParcelShopPODUsersSearchResultDto [userId=" + userId + ", loginId=" + loginId + ", userName=" + userName
				+ ", userType=" + userType + ", status=" + status + ", loggedInAdminRegion=" + loggedInAdminRegion
				+ ", deactivationReacivationPossibilityStatus=" + deactivationReacivationPossibilityStatus
				+ ", podStatus=" + podStatus + ", userEmailId=" + userEmailId + ", loggedInAdminEmailId="
				+ loggedInAdminEmailId + ", loggedInAdminLoginId=" + loggedInAdminLoginId + ", newPassword_reactivate="
				+ newPasswordReactivate + "]";
	}
}
