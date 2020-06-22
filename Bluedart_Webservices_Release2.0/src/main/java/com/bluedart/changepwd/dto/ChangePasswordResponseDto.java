package com.bluedart.changepwd.dto;

/**
 * Dto to be sent from Change Password Service
 * @author PR334023
 *
 */
public class ChangePasswordResponseDto {
	private String logId;
	private Long userId;
	private String mailId;
	private String oldPassword;
	private String newPassword;
	private String ipAddress;
	
	private boolean isOldPwdExisting;
	private String changePwdResponse;
	private boolean isMailSent;
	
	private String statusCode;
	private String errorMessage;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * @return the logId
	 */
	public String getLogId() {
		return logId;
	}
	/**
	 * @param logId the logId to set
	 */
	public void setLogId(String logId) {
		this.logId = logId;
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
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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
	 * @return the isOldPwdExisting
	 */
	public boolean isOldPwdExisting() {
		return isOldPwdExisting;
	}
	/**
	 * @param isOldPwdExisting the isOldPwdExisting to set
	 */
	public void setOldPwdExisting(boolean isOldPwdExisting) {
		this.isOldPwdExisting = isOldPwdExisting;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChangePasswordResponseDto [logId=" + logId + ", mailId="
				+ mailId + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", ipAddress=" + ipAddress
				+ ", isOldPwdExisting=" + isOldPwdExisting
				+ ", changePwdResponse=" + changePwdResponse + ", statusCode="
				+ statusCode + ", errorMessage=" + errorMessage + "]";
	}
}