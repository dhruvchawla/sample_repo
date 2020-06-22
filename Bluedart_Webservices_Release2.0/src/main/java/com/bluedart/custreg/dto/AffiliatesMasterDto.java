package com.bluedart.custreg.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author pr334023
 *
 */
public class AffiliatesMasterDto implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String loginId;
	private String affiliateCustomerCode;
	private String areaCode;
	private Date insertionDate;
	private String bpFlag;
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
}
