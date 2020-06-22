package com.bluedart.contactus.dto;

import java.io.Serializable;

/**
 * @author CH848113
 */
public class FeedBackReasonDto implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String reasonCode;
	private String reasonDescription;
	
	
	
	
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getReasonDescription() {
		return reasonDescription;
	}
	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}
	
	    
	
}
