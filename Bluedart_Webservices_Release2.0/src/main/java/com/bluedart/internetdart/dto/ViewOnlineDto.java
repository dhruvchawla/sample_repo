package com.bluedart.internetdart.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.common.dto.PodDto;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.ShipmentDtoCust;

public class ViewOnlineDto implements Serializable {

	private static final long serialVersionUID = 7090241543749799049L;
	
	private List<ShipmentDto> shipmentList;
	private List<ShipmentDtoCust> shipmentDtoCustList;
	private List<PodDto> podList;
	private long recordSize;
	private boolean isLimitExceeded;
	private String errorCode;
	
	
	
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
	 * @return the recordSize
	 */
	public long getRecordSize() {
		return recordSize;
	}
	/**
	 * @param recordSize the recordSize to set
	 */
	public void setRecordSize(long recordSize) {
		this.recordSize = recordSize;
	}
	/**
	 * @return the isLimitExceeded
	 */
	public boolean isLimitExceeded() {
		return isLimitExceeded;
	}
	/**
	 * @param isLimitExceeded the isLimitExceeded to set
	 */
	public void setLimitExceeded(boolean isLimitExceeded) {
		this.isLimitExceeded = isLimitExceeded;
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
	 * @return the shipmentDtoCustList
	 */
	public List<ShipmentDtoCust> getShipmentDtoCustList() {
		return shipmentDtoCustList;
	}
	/**
	 * @param shipmentDtoCustList the shipmentDtoCustList to set
	 */
	public void setShipmentDtoCustList(List<ShipmentDtoCust> shipmentDtoCustList) {
		this.shipmentDtoCustList = shipmentDtoCustList;
	}
	
	
	
}
