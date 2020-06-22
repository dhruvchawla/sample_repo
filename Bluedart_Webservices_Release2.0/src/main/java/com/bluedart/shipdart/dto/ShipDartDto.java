/**
 * 
 */
package com.bluedart.shipdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author CH851827
 *
 */
public class ShipDartDto implements Serializable{

	private static final long serialVersionUID = -2684087556273397696L;
	
	private ShipDartLogDto shipDartLogDto;
	private TrackAwbDto TrackAwbDto;
	
	private List<ShipDartLogDto> shipdartLogDtoList;
	
	private String statusCode;
	private String statusMessage;
	
	private String flag;	
			
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}	
	/**
	 * @return the shipDartLogDto
	 */
	public ShipDartLogDto getShipDartLogDto() {
		return shipDartLogDto;
	}
	/**
	 * @param shipDartLogDto the shipDartLogDto to set
	 */
	public void setShipDartLogDto(ShipDartLogDto shipDartLogDto) {
		this.shipDartLogDto = shipDartLogDto;
	}
	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}
	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	/**
	 * @return the shipdartLogDtoList
	 */
	public List<ShipDartLogDto> getShipdartLogDtoList() {
		return shipdartLogDtoList;
	}
	/**
	 * @param shipdartLogDtoList the shipdartLogDtoList to set
	 */
	public void setShipdartLogDtoList(List<ShipDartLogDto> shipdartLogDtoList) {
		this.shipdartLogDtoList = shipdartLogDtoList;
	}	

	/**
	 * @return the trackAwbDto
	 */
	public TrackAwbDto getTrackAwbDto() {
		return TrackAwbDto;
	}
	/**
	 * @param trackAwbDto the trackAwbDto to set
	 */
	public void setTrackAwbDto(TrackAwbDto trackAwbDto) {
		TrackAwbDto = trackAwbDto;
	}
	
	@Override
	public String toString() {
		return "ShipDartDto [shipDartLogDto=" + shipDartLogDto
				+ ", TrackAwbDto=" + TrackAwbDto + ", shipdartLogDtoList="
				+ shipdartLogDtoList + ", statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + ", flag=" + flag + "]";
	}
	public void setshipDartDto(ShipDartDto shipDartDto) {
			
	}
}