package com.bluedart.manageparcelshoppodusers.dto;

public class AreaRegionDto {

	
	private String region;
	private String areaCode;
	private String areaDesc;
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
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
	 * @return the areaDesc
	 */
	public String getAreaDesc() {
		return areaDesc;
	}
	/**
	 * @param areaDesc the areaDesc to set
	 */
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AreaRegionDto [region=" + region + ", areaCode=" + areaCode + ", areaDesc=" + areaDesc + "]";
	}
	
	
	
}
