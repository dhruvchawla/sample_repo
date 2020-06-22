package com.bluedart.locationfinder.dto;

import java.util.List;

/**
 * @author AN765570
 * @Description This Class contains parameters for location finder
 *
 */
public class LocationFinderDto {

	private List<ServiceStationDTO> serviceStationDTOList;
	private boolean internationalServiceabilityCheck;
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;

	/**
	 * @return the serviceStationDTOList
	 */
	public List<ServiceStationDTO> getServiceStationDTOList() {
		return serviceStationDTOList;
	}

	/**
	 * @param serviceStationDTOList the serviceStationDTOList to set
	 */
	public void setServiceStationDTOList(
			List<ServiceStationDTO> serviceStationDTOList) {
		this.serviceStationDTOList = serviceStationDTOList;
	}

	/**
	 * @return the internationalServiceabilityCheck
	 */
	public boolean isInternationalServiceabilityCheck() {
		return internationalServiceabilityCheck;
	}

	/**
	 * @param internationalServiceabilityCheck the internationalServiceabilityCheck to set
	 */
	public void setInternationalServiceabilityCheck(
			boolean internationalServiceabilityCheck) {
		this.internationalServiceabilityCheck = internationalServiceabilityCheck;
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
	 * @return the errorOccured
	 */
	public boolean isErrorOccured() {
		return errorOccured;
	}

	/**
	 * @param errorOccured the errorOccured to set
	 */
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
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

	

}
