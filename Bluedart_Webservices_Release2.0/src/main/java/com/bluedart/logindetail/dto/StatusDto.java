/**
 * 
 */
package com.bluedart.logindetail.dto;

import java.io.Serializable;

/**
 * @author CH851827
 *
 */
public class StatusDto implements Serializable{

	private static final long serialVersionUID = 5258116688759886183L;
	
	private boolean isServerDown = false;
	private boolean isAuthorized = false;
	
	private String mailId;
	private String userName;	
	private String userType;

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the isServerDown
	 */
	public Boolean getIsServerDown() {
		return isServerDown;
	}
	/**
	 * @param isServerDown the isServerDown to set
	 */
	public void setIsServerDown(Boolean isServerDown) {
		this.isServerDown = isServerDown;
	}
	/**
	 * @return the isAuthorized
	 */
	public Boolean getIsAuthorized() {
		return isAuthorized;
	}
	/**
	 * @param isAuthorized the isAuthorized to set
	 */
	public void setIsAuthorized(Boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StatusDto [isServerDown=" + isServerDown + ", isAuthorized="
				+ isAuthorized + ", mailId=" + mailId + ", userName="
				+ userName + "]";
	}			

}
