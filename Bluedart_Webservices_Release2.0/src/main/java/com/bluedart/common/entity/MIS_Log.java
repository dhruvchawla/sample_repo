package com.bluedart.common.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author DH839598
 *
 */
@Entity
@Table( name = "detail_mis_log")
public class MIS_Log implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name = "FEATUREID")
	private Integer featureId;
	
	@Column(name = "CEMAILID")
	private String emailId;
	
	@Column(name = "CIP")
	private String ip;
	
	@Column(name = "ACCESS_DATE")
	private Date accessDate;
	
	@Column(name = "ACCESS_TIME")
	private String accessTime;
	
	@Column(name = "CAWBNOS")
	private String awbNos;
	
	@Column(name = "MAILDATE")
	private String mailDate;
	
	
	/**
	 * @return the featureId
	 */
	public Integer getFeatureId() {
		return featureId;
	}
	/**
	 * @param featureId the featureId to set
	 */
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the accessDate
	 */
	public Date getAccessDate() {
		return accessDate;
	}
	/**
	 * @param accessDate the accessDate to set
	 */
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
	/**
	 * @return the accessTime
	 */
	public String getAccessTime() {
		return accessTime;
	}
	/**
	 * @param accessTime the accessTime to set
	 */
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	/**
	 * @return the mailDate
	 */
	public String getMailDate() {
		return mailDate;
	}
	/**
	 * @param mailDate the mailDate to set
	 */
	public void setMailDate(String mailDate) {
		this.mailDate = mailDate;
	}
	public String getAwbNos() {
		return awbNos;
	}
	public void setAwbNos(String awbNos) {
		this.awbNos = awbNos;
	}
	
	
	
	

}
