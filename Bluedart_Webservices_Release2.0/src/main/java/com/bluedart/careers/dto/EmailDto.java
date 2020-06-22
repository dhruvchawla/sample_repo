package com.bluedart.careers.dto;

import java.io.Serializable;
/**
 * @author CH848113
 */
public class EmailDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String emailType;
	private String emailId;
	private String emailFlag;
	
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailFlag() {
		return emailFlag;
	}
	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}
	

}
