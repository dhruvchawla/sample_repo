/**
 * 
 */
package com.bluedart.exception;

import javax.xml.ws.WebFault;

/**
 * @author Subhransu Maharana
 *  
 *
 */
@WebFault(name = "LocationServiceFault", targetNamespace = "http://www.bluedart.wipro.com")
public class FinderServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1632010067142850566L;

	private FinderServiceFault locationFault;

	public FinderServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param fault
	 */
	protected FinderServiceException(FinderServiceFault fault) {
		super(fault.getFaultString());
		this.locationFault = fault;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public FinderServiceException(String message, FinderServiceFault faultInfo) {
		super(message);
		this.locationFault = faultInfo;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 * @param cause
	 */
	public FinderServiceException(String message, FinderServiceFault faultInfo, Throwable cause) {
		super(message, cause);
		this.locationFault = faultInfo;
	}

	/**
	 * 
	 * @return
	 */
	public FinderServiceFault getFaultInfo() {
		return locationFault;
	}

	/**
	 * @param message
	 */
	public FinderServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FinderServiceException(String code, String message) {
		super(message);
		this.locationFault = new FinderServiceFault();
		this.locationFault.setFaultString(message);
		this.locationFault.setFaultCode(code);
	}

	/**
	 * @param cause
	 */
	public FinderServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FinderServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}