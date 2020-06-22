package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.common.entity.MailLink;

/**
 * 
 * @author PR334023
 *
 */
public class NotificationDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BDAdminDto bdAdminDto;
	private MailLink mailLink;
	private String moduleName;
	private String action;
	private String fromId;
	private String toId;
	private String ccId;
	private List<EmailNotifyValuesRecord> emailRecList;
	
	public String getCcId() {
		return ccId;
	}
	public void setCcId(String ccId) {
		this.ccId = ccId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public List<EmailNotifyValuesRecord> getEmailRecList() {
		return emailRecList;
	}
	public void setEmailRecList(List<EmailNotifyValuesRecord> emailRecList) {
		this.emailRecList = emailRecList;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
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
	public BDAdminDto getBdAdminDto() {
		return bdAdminDto;
	}
	public void setBdAdminDto(BDAdminDto bdAdminDto) {
		this.bdAdminDto = bdAdminDto;
	}
	public MailLink getMailLink() {
		return mailLink;
	}
	public void setMailLink(MailLink mailLink) {
		this.mailLink = mailLink;
	}
	@Override
	public String toString() {
		return "NotificationDto [bdAdminDto=" + bdAdminDto + ", mailLink="
				+ mailLink + ", moduleName=" + moduleName + ", action="
				+ action + ", fromId=" + fromId + ", toId=" + toId + ", ccId="
				+ ccId + ", emailRecList=" + emailRecList + "]";
	}

}
