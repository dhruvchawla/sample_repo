package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author PR334023
 *
 */
public class CorporateUserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String loginId;
	private String cCustCode;
	private String emailId;
	private String insertion_date;
	private String cCompGrp;
	private String cCompName;
	private String status;
	private String cArea;
	private String cRegion;
	private String siteUrl;
	private String byAdminName;
	private long userId;
	private String password;
	private String encryptedPassword;
	private String byEmailId;
	private String byLoginId;
	private String mobileNo;
	private boolean isCA;
	private String clientAdminId;
	private List<String> loginIDList;
	private List<String> adminRegions;
	private String byAdminType;
	private String ipAddress;
	private String adminColorType;
	
	public String getAdminColorType() {
		return adminColorType;
	}
	public void setAdminColorType(String adminColorType) {
		this.adminColorType = adminColorType;
	}
	public String getClientAdminId() {
		return clientAdminId;
	}
	public void setClientAdminId(String clientAdminId) {
		this.clientAdminId = clientAdminId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getByAdminType() {
		return byAdminType;
	}
	public void setByAdminType(String byAdminType) {
		this.byAdminType = byAdminType;
	}
	public List<String> getAdminRegions() {
		return adminRegions;
	}
	public void setAdminRegions(List<String> adminRegions) {
		this.adminRegions = adminRegions;
	}
	public List<String> getLoginIDList() {
		return loginIDList;
	}
	public void setLoginIDList(List<String> loginIDList) {
		this.loginIDList = loginIDList;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public boolean isCA() {
		return isCA;
	}
	public void setCA(boolean isCA) {
		this.isCA = isCA;
	}
	public String getByLoginId() {
		return byLoginId;
	}
	public void setByLoginId(String byLoginId) {
		this.byLoginId = byLoginId;
	}
	public String getByEmailId() {
		return byEmailId;
	}
	public void setByEmailId(String byEmailId) {
		this.byEmailId = byEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getByAdminName() {
		return byAdminName;
	}
	public void setByAdminName(String byAdminName) {
		this.byAdminName = byAdminName;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public String getcRegion() {
		return cRegion;
	}
	public void setcRegion(String cRegion) {
		this.cRegion = cRegion;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cArea
	 */
	public String getcArea() {
		return cArea;
	}
	/**
	 * @param cArea the cArea to set
	 */
	public void setcArea(String cArea) {
		this.cArea = cArea;
	}
	/**
	 * @return the sql_type
	 *//*
	public String getSql_type() {
		return sql_type;
	}
	*//**
	 * @param sql_type the sql_type to set
	 *//*
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	*/
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
	 * @return the cCustCode
	 */
	public String getcCustCode() {
		return cCustCode;
	}
	/**
	 * @param cCustCode the cCustCode to set
	 */
	public void setcCustCode(String cCustCode) {
		this.cCustCode = cCustCode;
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
	 * @return the insertion_date
	 */
	public String getInsertion_date() {
		return insertion_date;
	}
	/**
	 * @param insertion_date the insertion_date to set
	 */
	public void setInsertion_date(String insertion_date) {
		this.insertion_date = insertion_date;
	}
	/**
	 * @return the cCompGrp
	 */
	public String getcCompGrp() {
		return cCompGrp;
	}
	/**
	 * @param cCompGrp the cCompGrp to set
	 */
	public void setcCompGrp(String cCompGrp) {
		this.cCompGrp = cCompGrp;
	}
	/**
	 * @return the cCompName
	 */
	public String getcCompName() {
		return cCompName;
	}
	/**
	 * @param cCompName the cCompName to set
	 */
	public void setcCompName(String cCompName) {
		this.cCompName = cCompName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}