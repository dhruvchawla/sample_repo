package com.bluedart.camanagecorpusers.dto;

import java.io.Serializable;
/**
 * DTO for capturing corporate user details
 * @author PR334023
 *
 */
public class CorporateUsersDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String userEmailId;
	private String userloginId;
	private String userMobile;
	private String userStatus;
	private String adminLoginId;
	private String adminName;
	private String adminEmailId;
	private long userId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserloginId() {
		return userloginId;
	}
	public void setUserloginId(String userloginId) {
		this.userloginId = userloginId;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getAdminLoginId() {
		return adminLoginId;
	}
	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	@Override
	public String toString() {
		return "CorporateUsersDto [userName=" + userName + ", userEmailId="
				+ userEmailId + ", userloginId=" + userloginId
				+ ", userMobile=" + userMobile + ", userStatus=" + userStatus
				+ ", adminLoginId=" + adminLoginId + ", adminName=" + adminName
				+ ", adminEmailId=" + adminEmailId + "]";
	}
	
}
