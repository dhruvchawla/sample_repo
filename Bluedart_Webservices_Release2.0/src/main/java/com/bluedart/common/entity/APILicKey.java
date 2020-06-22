package com.bluedart.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APILIC_T")
public class APILicKey {

	@Id
	@Column(name ="CLICENSEID")
	private Integer licenseKeyId;
	
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	public Integer getLicenseKeyId() {
		return licenseKeyId;
	}

	public void setLicenseKeyId(Integer licenseKeyId) {
		this.licenseKeyId = licenseKeyId;
	}

	
}
