/**
 * 
 */
package com.bluedart.pricefinder.dto;

/**
 * @author SU299168
 * @CreateDate Aug 18, 2016
 * 
 *
 */
public class RateInputDto {
	private String customerCode;
	private String productCode;
	private String originAreaCode;
	private String destinationAreaCode;
	private String destinationPincode;
	private String insurance;
	private String productType;
	private double actualWeight;

	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode
	 *            the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return the destinationPincode
	 */
	public String getDestinationPincode() {
		return destinationPincode;
	}

	/**
	 * @param destinationPincode
	 *            the destinationPincode to set
	 */
	public void setDestinationPincode(String destinationPincode) {
		this.destinationPincode = destinationPincode;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the originAreaCode
	 */
	public String getOriginAreaCode() {
		return originAreaCode;
	}

	/**
	 * @param originAreaCode
	 *            the originAreaCode to set
	 */
	public void setOriginAreaCode(String originAreaCode) {
		this.originAreaCode = originAreaCode;
	}

	/**
	 * @return the destinationAreaCode
	 */
	public String getDestinationAreaCode() {
		return destinationAreaCode;
	}

	/**
	 * @param destinationAreaCode
	 *            the destinationAreaCode to set
	 */
	public void setDestinationAreaCode(String destinationAreaCode) {
		this.destinationAreaCode = destinationAreaCode;
	}

	/**
	 * @return the insurance
	 */
	public String getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance
	 *            the insurance to set
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the actualWeight
	 */
	public double getActualWeight() {
		return actualWeight;
	}

	/**
	 * @param actualWeight
	 *            the actualWeight to set
	 */
	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}

}
