package com.bluedart.pod.dto;

import java.util.List;

public class ShipmentTrackingDto {

	private List<ShipmentDto> shipmentList ;
	private long recordSize;

	
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
	
	
}
