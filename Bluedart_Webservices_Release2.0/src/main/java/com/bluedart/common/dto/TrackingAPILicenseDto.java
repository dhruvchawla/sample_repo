package com.bluedart.common.dto;

import java.util.Date;
import java.io.IOException;

/**
 * 
 * @author Velayutham Balasubramanian 
 *
 */
public class TrackingAPILicenseDto {
	
private String loginId;
	
	private String apiType;
	
	private String license;
	
	private String version;
	
	private int status;
	
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
	
	


}
