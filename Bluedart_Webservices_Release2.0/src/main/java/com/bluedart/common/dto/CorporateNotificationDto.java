package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;

/**
 * 
 * @author PR334023
 *
 */
public class CorporateNotificationDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String action;
	private String moduleName;
	private String fromId;
	private UserBasicDetailsDto userBasicDetailsDto;
	private CorporateUserDto corporateUserDto;
	private List<CorporateUserDto> coList;
	private EmailContent emailContent;
	private String password;
	private String siteUrl;
	
	public List<CorporateUserDto> getCoList() {
		return coList;
	}
	public void setCoList(List<CorporateUserDto> coList) {
		this.coList = coList;
	}
	public CorporateUserDto getCorporateUserDto() {
		return corporateUserDto;
	}
	public void setCorporateUserDto(CorporateUserDto corporateUserDto) {
		this.corporateUserDto = corporateUserDto;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public UserBasicDetailsDto getUserBasicDetailsDto() {
		return userBasicDetailsDto;
	}
	public void setUserBasicDetailsDto(UserBasicDetailsDto userBasicDetailsDto) {
		this.userBasicDetailsDto = userBasicDetailsDto;
	}
	public EmailContent getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(EmailContent emailContent) {
		this.emailContent = emailContent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	@Override
	public String toString() {
		return "CorporateNotificationDto [action=" + action + ", moduleName="
				+ moduleName + ", fromId=" + fromId + ", corporateUserDto="
				+ corporateUserDto + ", coList=" + coList + ", emailContent="
				+ emailContent + ", password=" + password + ", siteUrl="
				+ siteUrl + "]";
	}
	
}