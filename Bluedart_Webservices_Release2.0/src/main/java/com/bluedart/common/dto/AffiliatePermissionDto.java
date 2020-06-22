package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author AN765570
 *
 */
public class AffiliatePermissionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String areaCode;
	private String customerCode;
	private String permissionName;
	private String permissionValue;
	private String errorCode;
	
	private List<AffiliatePermissionDto> affiliatePermissionList;
	
	
	/**
	 * @return the permissionName
	 */
	public String getPermissionName() {
		return permissionName;
	}
	/**
	 * @param permissionName the permissionName to set
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	/**
	 * @return the permissionValue
	 */
	public String getPermissionValue() {
		return permissionValue;
	}
	/**
	 * @param permissionValue the permissionValue to set
	 */
	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
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
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	/**
	 * @return the affiliatePermissionList
	 */
	public List<AffiliatePermissionDto> getAffiliatePermissionList() {
		return affiliatePermissionList;
	}
	/**
	 * @param affiliatePermissionList the affiliatePermissionList to set
	 */
	public void setAffiliatePermissionList(
			List<AffiliatePermissionDto> affiliatePermissionList) {
		this.affiliatePermissionList = affiliatePermissionList;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
