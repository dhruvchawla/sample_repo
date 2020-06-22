package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;

import com.bluedart.common.dto.EmailContent;

public class ManageParcelShopPODUsersNotificationsDto implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private String action;
	private String moduleName;
	private String fromId;
	private ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto;
	private ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto;
	private EmailContent emailContent;
	private String password;
	private String siteUrl;
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/**
	 * @return the fromId
	 */
	public String getFromId() {
		return fromId;
	}
	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	/**
	 * @return the parcelShopPODUsersDetailsDto
	 */
	public ParcelShopPODUsersDetailsDto getParcelShopPODUsersDetailsDto() {
		return parcelShopPODUsersDetailsDto;
	}
	/**
	 * @param parcelShopPODUsersDetailsDto the parcelShopPODUsersDetailsDto to set
	 */
	public void setParcelShopPODUsersDetailsDto(ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto) {
		this.parcelShopPODUsersDetailsDto = parcelShopPODUsersDetailsDto;
	}
	/**
	 * @return the parcelShopPODUsersSearchResultDto
	 */
	public ParcelShopPODUsersSearchResultDto getParcelShopPODUsersSearchResultDto() {
		return parcelShopPODUsersSearchResultDto;
	}
	/**
	 * @param parcelShopPODUsersSearchResultDto the parcelShopPODUsersSearchResultDto to set
	 */
	public void setParcelShopPODUsersSearchResultDto(ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto) {
		this.parcelShopPODUsersSearchResultDto = parcelShopPODUsersSearchResultDto;
	}
	/**
	 * @return the emailContent
	 */
	public EmailContent getEmailContent() {
		return emailContent;
	}
	/**
	 * @param emailContent the emailContent to set
	 */
	public void setEmailContent(EmailContent emailContent) {
		this.emailContent = emailContent;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the siteUrl
	 */
	public String getSiteUrl() {
		return siteUrl;
	}
	/**
	 * @param siteUrl the siteUrl to set
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManageParcelShopPODUsersNotificationsDto [action=" + action + ", moduleName=" + moduleName + ", fromId="
				+ fromId + ", parcelShopPODUsersDetailsDto=" + parcelShopPODUsersDetailsDto
				+ ", parcelShopPODUsersSearchResultDto=" + parcelShopPODUsersSearchResultDto + ", emailContent="
				+ emailContent + ", password=" + password + ", siteUrl=" + siteUrl + "]";
	}
	
	
	
	

}
