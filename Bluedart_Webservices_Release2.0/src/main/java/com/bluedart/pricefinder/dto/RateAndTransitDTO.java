/**
 * 
 */
package com.bluedart.pricefinder.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Subhransu Maharana
 *
 */
@XmlRootElement(name = "RateAndTransitDTO", namespace = "http://webservice.bluedart.wipro.com/")
public class RateAndTransitDTO {

	private String customerCode;
	private String productCode;
	private String productType;
	private String originAreaCode;
	private String originServiceCenterCode;
	private String destinationAreaCode;
	private String destinationServiceCenterCode;

	private AddressBookDto originAddress;
	private AddressBookDto destinationAddress;

	private String bookingDate;// current Date
	private String bookingTime;

	private List<ProductServicesDTO> productServicesDTOs;
	private String status;


	private double actualWeight;

	private boolean error;
	private String errorMessage;
	private String errorCode;
	private boolean serviceable;

	private String ipAddress;
	private String loginId;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return the bookingTime
	 */
	public String getBookingTime() {
		return bookingTime;
	}

	/**
	 * @param bookingTime
	 *            the bookingTime to set
	 */
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	/**
	 * @return the originAddress
	 */
	public AddressBookDto getOriginAddress() {
		return originAddress;
	}

	/**
	 * @param originAddress
	 *            the originAddress to set
	 */
	public void setOriginAddress(AddressBookDto originAddress) {
		this.originAddress = originAddress;
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

	/**
	 * @return the destinationAddress
	 */
	public AddressBookDto getDestinationAddress() {
		return destinationAddress;
	}

	/**
	 * @param destinationAddress
	 *            the destinationAddress to set
	 */
	public void setDestinationAddress(AddressBookDto destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	/**
	 * @return the serviceable
	 */
	public boolean isServiceable() {
		return serviceable;
	}

	/**
	 * @param serviceable
	 *            the serviceable to set
	 */
	public void setServiceable(boolean serviceable) {
		this.serviceable = serviceable;
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
	 * @return the originServiceCenterCode
	 */
	public String getOriginServiceCenterCode() {
		return originServiceCenterCode;
	}

	/**
	 * @param originServiceCenterCode
	 *            the originServiceCenterCode to set
	 */
	public void setOriginServiceCenterCode(String originServiceCenterCode) {
		this.originServiceCenterCode = originServiceCenterCode;
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
	 * @return the destinationServiceCenterCode
	 */
	public String getDestinationServiceCenterCode() {
		return destinationServiceCenterCode;
	}

	/**
	 * @param destinationServiceCenterCode
	 *            the destinationServiceCenterCode to set
	 */
	public void setDestinationServiceCenterCode(String destinationServiceCenterCode) {
		this.destinationServiceCenterCode = destinationServiceCenterCode;
	}

	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate
	 *            the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the productServicesDTOs
	 */
	public List<ProductServicesDTO> getProductServicesDTOs() {
		return productServicesDTOs;
	}

	/**
	 * @param productServicesDTOs
	 *            the productServicesDTOs to set
	 */
	public void setProductServicesDTOs(List<ProductServicesDTO> productServicesDTOs) {
		this.productServicesDTOs = productServicesDTOs;
	}

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RateAndTransitDTO [customerCode=" + customerCode + ", productCode=" + productCode + ", productType="
				+ productType + ", originAreaCode=" + originAreaCode + ", originServiceCenterCode="
				+ originServiceCenterCode + ", destinationAreaCode=" + destinationAreaCode
				+ ", destinationServiceCenterCode=" + destinationServiceCenterCode + ", originAddress=" + originAddress
				+ ", destinationAddress=" + destinationAddress + ", bookingDate=" + bookingDate + ", bookingTime="
				+ bookingTime + ", productServicesDTOs=" + productServicesDTOs + ", status=" + status
				+ ", actualWeight=" + actualWeight + ", error=" + error + ", errorMessage=" + errorMessage
				+ ", errorCode=" + errorCode + ", serviceable=" + serviceable + ", ipAddress=" + ipAddress
				+ ", loginId=" + loginId + "]";
	}

	
}
