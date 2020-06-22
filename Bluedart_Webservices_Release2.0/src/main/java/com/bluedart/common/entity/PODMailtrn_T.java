/*package com.bluedart.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "podmailtrn_t")
public class PODMailtrn_T implements Serializable {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;


	
	@Id
	
	
	
	//@GeneratedValue(generator="system-uuid")
	@Column(name = "LOGINID")
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String loginId;
	
	@Column(name = "FREQUENCY")
	private String frequency;
	
	@Column(name = "REPORTTYPE")
	private String reportType;
	
	@Column(name = "LASTRUNDATE")
	//@Temporal(TemporalType.DATE)
	private Date lastRunDate;
	
	@Column(name = "LASTRUNTIME")
	private String lastRunTime;
	
	@Column(name = "REPORTSIZE")
	private long reportSize;
	
	@Column(name = "REPORTSTATUS")
	private String reportStatus;
	

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}
	
	public Date getLastRunDate() {
		return lastRunDate;
	}
	
	public void setLastRunTime(String lastRunTime) {
		this.lastRunTime = lastRunTime;
	}
	
	public String getLastRunTime() {
		return lastRunTime;
	}

	public void setReportSize(long reportsize2) {
		this.reportSize = reportsize2;
	}
	
	public long getReportSize() {
		return reportSize;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	
	public String getReportStatus() {
		return reportStatus;
	}

}
*/