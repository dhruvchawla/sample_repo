/**
 * 
 */
package com.bluedart.pricefinder.dto;

/**
 * @author Subhransu Maharana
 * @CreateDate Aug 9, 2016
 * 
 *
 */
public class ValueAddedServicesDTO {

	private String vasCode;
	private String vasName;
	private double vasPrice;

	/**
	 * @return the vasCode
	 */
	public String getVasCode() {
		return vasCode;
	}

	/**
	 * @param vasCode
	 *            the vasCode to set
	 */
	public void setVasCode(String vasCode) {
		this.vasCode = vasCode;
	}

	/**
	 * @return the vasName
	 */
	public String getVasName() {
		return vasName;
	}

	/**
	 * @param vasName
	 *            the vasName to set
	 */
	public void setVasName(String vasName) {
		this.vasName = vasName;
	}

	/**
	 * @return the vasPrice
	 */
	public double getVasPrice() {
		return vasPrice;
	}

	/**
	 * @param vasPrice
	 *            the vasPrice to set
	 */
	public void setVasPrice(double vasPrice) {
		this.vasPrice = vasPrice;
	}

}
