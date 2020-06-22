package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;

public class ParcelShopsDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String psCode;
	String psName;
	String parcelshopRegion;
	String parcelshopArea;
	String parcelshopCscrcd;
	String parcelshopCscrcdDesc;
	String enableFlag;
	String emailId1;
	String emailId2;
	
	
	
	/**
	 * @return the emailId1
	 */
	public String getEmailId1() {
		return emailId1;
	}
	/**
	 * @param emailId1 the emailId1 to set
	 */
	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	/**
	 * @return the emailId2
	 */
	public String getEmailId2() {
		return emailId2;
	}
	/**
	 * @param emailId2 the emailId2 to set
	 */
	public void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getPsCode() {
		return psCode;
	}
	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public String getParcelshopRegion() {
		return parcelshopRegion;
	}
	public void setParcelshopRegion(String parcelshopRegion) {
		this.parcelshopRegion = parcelshopRegion;
	}
	public String getParcelshopArea() {
		return parcelshopArea;
	}
	public void setParcelshopArea(String parcelshopArea) {
		this.parcelshopArea = parcelshopArea;
	}
	public String getParcelshopCscrcd() {
		return parcelshopCscrcd;
	}
	public void setParcelshopCscrcd(String parcelshopCscrcd) {
		this.parcelshopCscrcd = parcelshopCscrcd;
	}
	public String getParcelshopCscrcdDesc() {
		return parcelshopCscrcdDesc;
	}
	public void setParcelshopCscrcdDesc(String parcelshopCscrcdDesc) {
		this.parcelshopCscrcdDesc = parcelshopCscrcdDesc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParcelShopsDto [psCode=" + psCode + ", psName=" + psName + ", parcelshopRegion=" + parcelshopRegion
				+ ", parcelshopArea=" + parcelshopArea + ", parcelshopCscrcd=" + parcelshopCscrcd
				+ ", parcelshopCscrcdDesc=" + parcelshopCscrcdDesc + ", enableFlag=" + enableFlag + ", emailId1="
				+ emailId1 + ", emailId2=" + emailId2 + "]";
	}
	
}
