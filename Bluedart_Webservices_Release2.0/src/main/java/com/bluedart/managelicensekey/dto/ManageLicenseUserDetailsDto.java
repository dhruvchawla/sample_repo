package com.bluedart.managelicensekey.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ManageLicenseUserDetailsDto implements SQLData,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021614045984410842L;

	private String sql_type;
	
	private String name;
	private String loginid;
	private String apiType;
	private String status;
	private String license;
	private String licenseKeyId;
	private String licenseStatus;
	private Date insertionDate;
	private String region;
	private String emailid;
	private String version;
	
	
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getLicenseStatus() {
		return licenseStatus;
	}
	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
	}
	public Date getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	public String getLicenseKeyId() {
		return licenseKeyId;
	}
	public void setLicenseKeyId(String licenseKeyId) {
		this.licenseKeyId = licenseKeyId;
	}
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(typeName);
		setName(paramSQLInput.readNString());
		setLoginid(paramSQLInput.readNString());
		setApiType(paramSQLInput.readNString());
		setStatus(paramSQLInput.readNString());
		setLicense(paramSQLInput.readNString());
		setLicenseKeyId(paramSQLInput.readNString());
		setLicenseStatus(paramSQLInput.readNString());
		setInsertionDate(paramSQLInput.readDate());
		setRegion(paramSQLInput.readNString());
		setEmailid(paramSQLInput.readNString());
		setVersion(paramSQLInput.readNString());
	}
	
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(name);
		paramSQLOutput.writeString(loginid);
		paramSQLOutput.writeString(apiType);
		paramSQLOutput.writeString(status);
		paramSQLOutput.writeString(license);
		paramSQLOutput.writeString(licenseStatus);
		paramSQLOutput.writeDate(insertionDate);
		paramSQLOutput.writeString(region);
		paramSQLOutput.writeString(emailid);
		paramSQLOutput.writeString(version);
		paramSQLOutput.writeString(licenseKeyId);
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
