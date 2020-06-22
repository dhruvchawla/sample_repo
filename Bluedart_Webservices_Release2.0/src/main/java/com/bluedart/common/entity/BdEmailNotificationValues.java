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
@Table(name = "UPROFILE4.BD_EMAIL_NOTIFICATION_VALUES")
public class BdEmailNotificationValues{

	@Id	
	@Column(name = "VALUEID")
	private String valueId;
	@Column(name = "LOGID")
	private String logId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "NOTIFY_NAME")
	private String notifyName;
	@Column(name = "NOTIFY_VALUES")
	private String notifyValues;
	
	public String getValueId() {
		return valueId;
	}
	public void setValueId(String valueId) {
		this.valueId = valueId;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNotifyName() {
		return notifyName;
	}
	public void setNotifyName(String notifyName) {
		this.notifyName = notifyName;
	}
	public String getNotifyValues() {
		return notifyValues;
	}
	public void setNotifyValues(String notifyValues) {
		this.notifyValues = notifyValues;
	}
	@Override
	public String toString() {
		return "BdEmailNotificationValues [valueId=" + valueId + ", logId="
				+ logId + ", password=" + password + ", notifyName="
				+ notifyName + ", notifyValues=" + notifyValues + "]";
	}
	
}