package com.bluedart.common.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author pr334023
 *
 */
@Entity
@Table(name = "UPROFILE4.BD_SMSLOG")
public class BD_SMSLog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SMS_LOGID")
	private Integer smsLogId;
	
	@Column(name = "RESPONSEID")
	private String responseId;
	
	@Column(name = "MODULE_NAME")
	private String moduleName;
	
	@Column(name = "LOG_DATE")
	private Date logDate;
	
	 
	
	
	
	public Integer getSmsLogId() {
		return smsLogId;
	}





	public void setSmsLogId(Integer smsLogId) {
		this.smsLogId = smsLogId;
	}





	public String getResponseId() {
		return responseId;
	}





	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}





	public String getModuleName() {
		return moduleName;
	}





	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}





	public Date getLogDate() {
		return logDate;
	}





	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BD_SMSLOG [ smsLogId="
				+ smsLogId + ", responseId=" + responseId
				+ ", moduleName=" + moduleName + ", logDate=" + logDate
				+ ", validFlag=" +"]";
	}
}