package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;

import com.bluedart.common.dto.StatusDto;

/**
 * 
 * @author PR334023
 *
 */
public class ValidUserDto extends StatusDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String userflag;
	private String employeeName;
	private String emailId;
	private boolean isEmailSent;
	
	public boolean isEmailSent() {
		return isEmailSent;
	}
	public void setEmailSent(boolean isEmailSent) {
		this.isEmailSent = isEmailSent;
	}
	public String getUserflag() {
		return userflag;
	}
	public void setUserflag(String userflag) {
		this.userflag = userflag;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "ValidUserDto [userflag=" + userflag + ", employeeName="
				+ employeeName + ", emailId=" + emailId + ", isEmailSent="
				+ isEmailSent + "]";
	}
}