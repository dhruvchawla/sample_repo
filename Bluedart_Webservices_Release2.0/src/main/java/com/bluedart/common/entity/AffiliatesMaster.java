package com.bluedart.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author pr334023
 *
 */
@Entity
@Table(name = "UPROFILE4.AFFILIATES_T")
public class AffiliatesMaster {

	@Id	
	@Column(name = "LOGINID")
	private String loginId;
	@Column(name = "AFF_CC")
	private String affiliateCustomerCode;
	@Column(name = "AFF_AC")
	private String areaCode;
	@Column(name = "INSERT_DATE")
	private Date insertionDate;
	@Column(name = "BPFLAG")
	private String bpFlag;
	@Column(name="CBASEAFFILIATE")
	private String baseAffiliateFlag;
	
	/**
	 * 
	 * @return
	 */
	public String getBaseAffiliateFlag() {
		return baseAffiliateFlag;
	}
	/**
	 * 
	 * @param baseAffiliateFlag
	 */
	public void setBaseAffiliateFlag(String baseAffiliateFlag) {
		this.baseAffiliateFlag = baseAffiliateFlag;
	}
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
	 * @return the affiliateCustomerCode
	 */
	public String getAffiliateCustomerCode() {
		return affiliateCustomerCode;
	}
	/**
	 * @param affiliateCustomerCode the affiliateCustomerCode to set
	 */
	public void setAffiliateCustomerCode(String affiliateCustomerCode) {
		this.affiliateCustomerCode = affiliateCustomerCode;
	}
	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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
	/**
	 * @return the bpFlag
	 */
	public String getBpFlag() {
		return bpFlag;
	}
	/**
	 * @param bpFlag the bpFlag to set
	 */
	public void setBpFlag(String bpFlag) {
		this.bpFlag = bpFlag;
	}
	@Override
	public String toString() {
		return "AffiliatesMaster [loginId=" + loginId
				+ ", affiliateCustomerCode=" + affiliateCustomerCode
				+ ", areaCode=" + areaCode + ", insertionDate=" + insertionDate
				+ ", bpFlag=" + bpFlag + ", baseAffiliateFlag="
				+ baseAffiliateFlag + "]";
	}
}