package com.bluedart.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author SI334034
 *
 */
@Entity
@Table(name = "APILIC_T")
public class ApiLicense {
	
	@Id
	
	@Column(name = "LOGINID")
	private String loginId;
	
	@Column(name = "API_TYPE")
	private String apiType;
	
	@Column(name = "LICENSE")
	private String license;
	
	@Column(name = "VERSION")
	private String version;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "INSERTION_DATE")
	private Date insertionDate;

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the apiType
	 */
	public String getApiType() {
		return apiType;
	}

	/**
	 * @param apiType the apiType to set
	 */
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the insertionDate
	 */
	public Date getInsertionDate() {
		return insertionDate;
	}

	/**
	 * @param insertionDate the insertionDate to set
	 */
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApiLicense [loginId=" + loginId + ", apiType=" + apiType
				+ ", license=" + license + ", version=" + version + ", status="
				+ status + ", insertionDate=" + insertionDate + "]";
	}
	
	

}
