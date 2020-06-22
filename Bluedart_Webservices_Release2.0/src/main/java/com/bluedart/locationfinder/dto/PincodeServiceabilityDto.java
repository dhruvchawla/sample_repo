package com.bluedart.locationfinder.dto;

import java.util.List;

/**
 * @author AN765570
 * @Description This Class contains parameters for pincode serviceability
 *
 */
public class PincodeServiceabilityDto {

	private List<String> pincodeServList;
	private String ip;
	private String loginId;

	/**
	 * @return the pincodeServList
	 */
	public List<String> getPincodeServList() {
		return pincodeServList;
	}

	/**
	 * @param pincodeServList the pincodeServList to set
	 */
	public void setPincodeServList(List<String> pincodeServList) {
		this.pincodeServList = pincodeServList;
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
	
	
}
