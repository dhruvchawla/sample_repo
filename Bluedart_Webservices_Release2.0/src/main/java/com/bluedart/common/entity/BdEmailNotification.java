package com.bluedart.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author PR334023
 *
 */
@Entity
@Table(name = "UPROFILE4.BD_EMAIL_NOTIFICATION")
public class BdEmailNotification {

	@Id	
	@Column(name = "LOGID")
	private String logId;
	@Column(name = "FROM_ID")
	private String fromId;
	@Column(name = "TO_ID")
	private String toId;
	@Column(name = "CC_ID")
	private String ccId;
	@Column(name = "ACTION")
	private String action;
	@Column(name = "MODULE_NAME")
	private String moduleName;
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getCcId() {
		return ccId;
	}
	public void setCcId(String ccId) {
		this.ccId = ccId;
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
	@Override
	public String toString() {
		return "BdEmailNotification [logId=" + logId + ", fromId=" + fromId
				+ ", toId=" + toId + ", ccId=" + ccId + ", action=" + action
				+ ", moduleName=" + moduleName + "]";
	}
	
}