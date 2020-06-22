package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class TrackDto implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private List<ShipmentDto> shipmentList;
	private List<PodDto> podList;
	private String awbNo;
	private int secLevel;
	private String errorCode;
	private String errorMessage;
	
	private String noRecFound;
	private String noInfoFound;
	private String invalidNumber;
	private String validShiments;
	
	/**
	 * @return the shipmentList
	 */
	public List<ShipmentDto> getShipmentList() {
		return shipmentList;
	}
	/**
	 * @param shipmentList the shipmentList to set
	 */
	public void setShipmentList(List<ShipmentDto> shipmentList) {
		this.shipmentList = shipmentList;
	}
	/**
	 * @return the podList
	 */
	public List<PodDto> getPodList() {
		return podList;
	}
	/**
	 * @param podList the podList to set
	 */
	public void setPodList(List<PodDto> podList) {
		this.podList = podList;
	}
	/**
	 * @return the awbNo
	 */
	public String getAwbNo() {
		return awbNo;
	}
	/**
	 * @param awbNo the awbNo to set
	 */
	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}
	/**
	 * @return the secLevel
	 */
	public int getSecLevel() {
		return secLevel;
	}
	/**
	 * @param secLevel the secLevel to set
	 */
	public void setSecLevel(int secLevel) {
		this.secLevel = secLevel;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
	/**
	 * @return the noRecFound
	 */
	public String getNoRecFound() {
		return noRecFound;
	}
	/**
	 * @param noRecFound the noRecFound to set
	 */
	public void setNoRecFound(String noRecFound) {
		this.noRecFound = noRecFound;
	}
	/**
	 * @return the noInfoFound
	 */
	public String getNoInfoFound() {
		return noInfoFound;
	}
	/**
	 * @param noInfoFound the noInfoFound to set
	 */
	public void setNoInfoFound(String noInfoFound) {
		this.noInfoFound = noInfoFound;
	}
	/**
	 * @return the invalidNumber
	 */
	public String getInvalidNumber() {
		return invalidNumber;
	}
	/**
	 * @param invalidNumber the invalidNumber to set
	 */
	public void setInvalidNumber(String invalidNumber) {
		this.invalidNumber = invalidNumber;
	}
	/**
	 * @return the validShiments
	 */
	public String getValidShiments() {
		return validShiments;
	}
	/**
	 * @param validShiments the validShiments to set
	 */
	public void setValidShiments(String validShiments) {
		this.validShiments = validShiments;
	}
	 
	
	
	
	
	
	 
	
}