/**
 * 
 */
package com.bluedart.common.webservice;

/**
 * @author Subhransu Maharana
 *  
 *
 */
public class FinderServiceFault {
	private String faultCode;
	private String faultString;

	/**
	 * @return the faultCode
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * @param faultCode
	 *            the faultCode to set
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * @return the faultString
	 */
	public String getFaultString() {
		return faultString;
	}

	/**
	 * @param faultString
	 *            the faultString to set
	 */
	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}

}
