package com.bluedart.forgetpwd.dto;

import java.io.Serializable;

/**
 * Dto to be sent from forgot password functionality
 * @author PR334023
 *
 */
public class ForgotPasswordResponseDto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String loginId;
	private String mailId;
	private String newPassword;
	private String ipAddress;
	
	private long forgotPwdOtp;
	private String existingMailId;
	private String changePwdResponse;
	private boolean isMailSent;
	private boolean isPwdUpdatedInLiferay;
	
	private String statusCode;
	private String errorMessage;
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
	 * @return the mailId
	 */
	public String getMailId() {
		return mailId;
	}
	/**
	 * @param mailId the mailId to set
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the forgotPwdOtp
	 */
	public long getForgotPwdOtp() {
		return forgotPwdOtp;
	}
	/**
	 * @param forgotPwdOtp the forgotPwdOtp to set
	 */
	public void setForgotPwdOtp(long forgotPwdOtp) {
		this.forgotPwdOtp = forgotPwdOtp;
	}
	/**
	 * @return the existingMailId
	 */
	public String getExistingMailId() {
		return existingMailId;
	}
	/**
	 * @param existingMailId the existingMailId to set
	 */
	public void setExistingMailId(String existingMailId) {
		this.existingMailId = existingMailId;
	}
	/**
	 * @return the changePwdResponse
	 */
	public String getChangePwdResponse() {
		return changePwdResponse;
	}
	/**
	 * @param changePwdResponse the changePwdResponse to set
	 */
	public void setChangePwdResponse(String changePwdResponse) {
		this.changePwdResponse = changePwdResponse;
	}
	/**
	 * @return the isMailSent
	 */
	public boolean isMailSent() {
		return isMailSent;
	}
	/**
	 * @param isMailSent the isMailSent to set
	 */
	public void setMailSent(boolean isMailSent) {
		this.isMailSent = isMailSent;
	}
	/**
	 * @return the isPwdUpdatedInLiferay
	 */
	public boolean isPwdUpdatedInLiferay() {
		return isPwdUpdatedInLiferay;
	}
	/**
	 * @param isPwdUpdatedInLiferay the isPwdUpdatedInLiferay to set
	 */
	public void setPwdUpdatedInLiferay(boolean isPwdUpdatedInLiferay) {
		this.isPwdUpdatedInLiferay = isPwdUpdatedInLiferay;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}