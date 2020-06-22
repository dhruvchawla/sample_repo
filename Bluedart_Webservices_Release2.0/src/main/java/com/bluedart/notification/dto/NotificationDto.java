package com.bluedart.notification.dto;

import java.io.Serializable;

public class NotificationDto implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private String logId;
	private String fromEmailId;
	private String toEmailId;
	private String ccEmailId;
	private String action;
	private String moduleName;
	private String model;
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getFromEmailId() {
		return fromEmailId;
	}
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}
	public String getToEmailId() {
		return toEmailId;
	}
	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}
	public String getCcEmailId() {
		return ccEmailId;
	}
	public void setCcEmailId(String ccEmailId) {
		this.ccEmailId = ccEmailId;
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	

}
