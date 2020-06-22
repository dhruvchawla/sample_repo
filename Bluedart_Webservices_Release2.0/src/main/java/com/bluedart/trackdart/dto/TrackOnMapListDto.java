package com.bluedart.trackdart.dto;

import java.util.List;

public class TrackOnMapListDto {
	private List<TrackOnMapDto> serviceStationsList;
	private String errorCode;
	private String errorMessage;
	private TrackGpsDto trackGpsDto;
	private String mapType;

	/**
	 * @return the serviceStationsList
	 */
	public List<TrackOnMapDto> getServiceStationsList() {
		return serviceStationsList;
	}

	/**
	 * @param serviceStationsList the serviceStationsList to set
	 */
	public void setServiceStationsList(List<TrackOnMapDto> serviceStationsList) {
		this.serviceStationsList = serviceStationsList;
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
	 * @return the trackGpsDto
	 */
	public TrackGpsDto getTrackGpsDto() {
		return trackGpsDto;
	}

	/**
	 * @param trackGpsDto the trackGpsDto to set
	 */
	public void setTrackGpsDto(TrackGpsDto trackGpsDto) {
		this.trackGpsDto = trackGpsDto;
	}

	/**
	 * @return the mapType
	 */
	public String getMapType() {
		return mapType;
	}

	/**
	 * @param mapType the mapType to set
	 */
	public void setMapType(String mapType) {
		this.mapType = mapType;
	}
	
	
}
