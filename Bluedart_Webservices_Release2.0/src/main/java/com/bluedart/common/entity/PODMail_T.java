package com.bluedart.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "podmail_t")
public class PODMail_T implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOGINID")
	private String loginId;
	
	@Column(name = "EMAILID")
	private String emailId;
	
	@Column(name = "FREQUENCY")
	private String frequency;
	
	@Column(name = "REPORTTYPE")
	private String reportType;
	
	@Column(name = "RUNDAY")
	private int runDay;
	
	@Column(name = "LASTRUNDATE")
	private Date lastRunDate;
	
	@Column(name = "LASTRUNTIME")
	private String lastRunTime;
	
	@Column(name = "ATTACHMENT")
	private String attachment;
	
	@Column(name = "SORTORDER")
	private String sortedOrder;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATEDDATE")
	private Date lastUpdatedDate;
	
	@Column(name = "CSTATUS")
	private int status;
	

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getLastRunDate() {
		return lastRunDate;
	}

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	public String getSortedOrder() {
		return sortedOrder;
	}

	public void setSortedOrder(String sortedOrder) {
		this.sortedOrder = sortedOrder;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
