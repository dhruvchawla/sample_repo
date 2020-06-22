/**
 * 
 */
package com.bluedart.pod.exception;

import com.bluedart.exception.WSFault;


/**
 * @author AK765612
 *
 */
public class PODServiceException extends Exception {

	private static final long serialVersionUID = -7650179531578663910L;

	private WSFault entryDetailsServiceFalut;

	public PODServiceException() {
	}

	public PODServiceException(WSFault entryDetailsServiceFalut) {
		super(entryDetailsServiceFalut.getFaultString());
		this.entryDetailsServiceFalut = entryDetailsServiceFalut;
	}

	public PODServiceException(String message, WSFault faultInfo) {
		super(message);
		this.entryDetailsServiceFalut = faultInfo;
	}

	public PODServiceException(String message, WSFault faultInfo, Throwable cause) {
		super(message, cause);
		this.entryDetailsServiceFalut = faultInfo;
	}

	public WSFault getFaultInfo() {
		return entryDetailsServiceFalut;
	}
}
