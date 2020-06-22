/**
 * 
 */
package com.bluedart.shipdart.dto;

import java.io.Serializable;

/**
 * @author CH851827
 *
 */
public class StatusDto implements Serializable{

	private static final long serialVersionUID = 729859061633273363L;
		
	private String statusCode;
	private String statusMessage;
	
	private String flag;

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
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	

}
