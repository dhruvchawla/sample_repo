/**
 * 
 */
package com.bluedart.pricefinder.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Subhransu Maharana
 * @CreateDate Jul 28, 2016
 *
 */
@XmlRootElement(name = "ProductServicesDTO", namespace = "http://webservice.bluedart.wipro.com/")
public class ProductServicesDTO {

	private String productCode;
	private String productType;
	private String productName;
	private String expectedDateOfDel;
	private double minChargebleWeight;
	private double approxPrice;
	private List<ValueAddedServicesDTO> valueAddedServicesDTOs;
	private boolean selected;

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
	 * @return the valueAddedServicesDTOs
	 */
	public List<ValueAddedServicesDTO> getValueAddedServicesDTOs() {
		return valueAddedServicesDTOs;
	}

	/**
	 * @param valueAddedServicesDTOs
	 *            the valueAddedServicesDTOs to set
	 */
	public void setValueAddedServicesDTOs(List<ValueAddedServicesDTO> valueAddedServicesDTOs) {
		this.valueAddedServicesDTOs = valueAddedServicesDTOs;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
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
	 * @return the expectedDateOfDel
	 */
	public String getExpectedDateOfDel() {
		return expectedDateOfDel;
	}

	/**
	 * @param expectedDateOfDel
	 *            the expectedDateOfDel to set
	 */
	public void setExpectedDateOfDel(String expectedDateOfDel) {
		this.expectedDateOfDel = expectedDateOfDel;
	}

	public double getMinChargebleWeight() {
		return minChargebleWeight;
	}

	public void setMinChargebleWeight(double minChargebleWeight) {
		this.minChargebleWeight = minChargebleWeight;
	}

	/**
	 * @return the approxPrice
	 */
	public double getApproxPrice() {
		return approxPrice;
	}

	/**
	 * @param approxPrice
	 *            the approxPrice to set
	 */
	public void setApproxPrice(double approxPrice) {
		this.approxPrice = approxPrice;
	}

}
