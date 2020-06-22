package com.bluedart.careers.dto;

import java.io.Serializable;
/**
 * @author CH848113
 */
public class PhoneDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String phoneType;
	private String phoneId;
	private String phoneFlag;
	
	public String getPhoneFlag() {
		return phoneFlag;
	}
	public void setPhoneFlag(String phoneFlag) {
		this.phoneFlag = phoneFlag;
	}
	public String getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	

}
