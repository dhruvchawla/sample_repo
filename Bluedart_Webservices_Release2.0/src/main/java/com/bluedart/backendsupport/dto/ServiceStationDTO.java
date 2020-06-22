package com.bluedart.backendsupport.dto;

import java.io.Serializable;
import java.util.List;

public class ServiceStationDTO implements Serializable {

	private String pincodeInput;

	private String stationCode;
	private String stationName;
	private String locationName;
	private String areaCode;
	private String areaCity;
	private String pincode;
	private String address1;
	private String address2;
	private String address3;
	private String telNo;
	private String locationTelNo;
	private String stationTelNo;
	private String fax;
	private String contact1;
	private String contact2;

	// All the service details
	private String domesticPriorityService;// Domestic Priority
	private String regionalPriorityService;// Regional Priority
	private String internationalPriorityService;// International Priority
	private String jumboBoxService;// JumboBox

	private String doorToDoorService; // Dart Apex
	private String airportToDoorService;// Airport to Door
	private String doorToAirportService; // door to Airport
	private String smartBoxService;
	private String dartSurfaceLineService;// SurfaceLine
	private String airportToAirportService;// Airport to Airport
	private String areaZone;
	private String sfcZone;
	private String locationType;
	private String latitude;
	private String longitude;
	private String state;
	private boolean serviceableFlag;

	private List<ServiceStationDTO> serviceStationDTOList;

	/**
	 * 
	 */
	public ServiceStationDTO() {

		// TODO Auto-generated constructor stub
	}

	public List<ServiceStationDTO> getServiceStationDTOList() {
		return serviceStationDTOList;
	}

	public void setServiceStationDTOList(List<ServiceStationDTO> serviceStationDTOList) {
		this.serviceStationDTOList = serviceStationDTOList;
	}

	public String getStationTelNo() {
		return stationTelNo;
	}

	public void setStationTelNo(String stationTelNo) {
		this.stationTelNo = stationTelNo;
	}

	public String getJumboBoxService() {
		return jumboBoxService;
	}

	public void setJumboBoxService(String jumboBoxService) {
		this.jumboBoxService = jumboBoxService;
	}

	public String getAirportToDoorService() {
		return airportToDoorService;
	}

	public void setAirportToDoorService(String airportToDoorService) {
		this.airportToDoorService = airportToDoorService;
	}

	public String getDoorToAirportService() {
		return doorToAirportService;
	}

	public void setDoorToAirportService(String doorToAirportService) {
		this.doorToAirportService = doorToAirportService;
	}

	public String getSmartBoxService() {
		return smartBoxService;
	}

	public void setSmartBoxService(String smartBoxService) {
		this.smartBoxService = smartBoxService;
	}

	public String getDartSurfaceLineService() {
		return dartSurfaceLineService;
	}

	public void setDartSurfaceLineService(String dartSurfaceLineService) {
		this.dartSurfaceLineService = dartSurfaceLineService;
	}

	public String getAirportToAirportService() {
		return airportToAirportService;
	}

	public void setAirportToAirportService(String airportToAirportService) {
		this.airportToAirportService = airportToAirportService;
	}

	public String getLocationTelNo() {
		return locationTelNo;
	}

	public void setLocationTelNo(String locationTelNo) {
		this.locationTelNo = locationTelNo;
	}

	/**
	 * @return the pincodeInput
	 */
	public String getPincodeInput() {
		return pincodeInput;
	}

	/**
	 * @param pincodeInput
	 *            the pincodeInput to set
	 */
	public void setPincodeInput(String pincodeInput) {
		this.pincodeInput = pincodeInput;
	}

	/**
	 * @return the serviceableFlag
	 */
	public boolean isServiceableFlag() {
		return serviceableFlag;
	}

	/**
	 * @param serviceableFlag
	 *            the serviceableFlag to set
	 */
	public void setServiceableFlag(boolean serviceableFlag) {
		this.serviceableFlag = serviceableFlag;
	}

	/**
	 * @return the doorToDoorService
	 */
	public String getDoorToDoorService() {
		return doorToDoorService;
	}

	/**
	 * @param doorToDoorService
	 *            the doorToDoorService to set
	 */
	public void setDoorToDoorService(String doorToDoorService) {
		this.doorToDoorService = doorToDoorService;
	}

	public String getInternationalPriorityService() {
		return internationalPriorityService;
	}

	public void setInternationalPriorityService(String internationalPriorityService) {
		this.internationalPriorityService = internationalPriorityService;
	}

	public String getRegionalPriorityService() {
		return regionalPriorityService;
	}

	public void setRegionalPriorityService(String regionalPriorityService) {
		this.regionalPriorityService = regionalPriorityService;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName
	 *            the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @param cDesc, areaCity
	 *            the LocationName to set
	 */
	public void setLocationName(String CSCRCDDESC, String areaCity ) {
		this.locationName = CSCRCDDESC+" , "+areaCity;
	}

	/**
	 * @param the LocationName
	 *            
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 *            the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2
	 *            the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * @param address3
	 *            the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the telNo
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * @param telNo
	 *            the telNo to set
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the contact1
	 */
	public String getContact1() {
		return contact1;
	}

	/**
	 * @param contact1
	 *            the contact1 to set
	 */
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	/**
	 * @return the contact2
	 */
	public String getContact2() {
		return contact2;
	}

	/**
	 * @param contact2
	 *            the contact2 to set
	 */
	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	/**
	 * @return the domesticPriorityService
	 */
	public String getDomesticPriorityService() {
		return domesticPriorityService;
	}

	/**
	 * @param domesticPriorityService
	 *            the domesticPriorityService to set
	 */
	public void setDomesticPriorityService(String domesticPriorityService) {
		this.domesticPriorityService = domesticPriorityService;
	}

	/**
	 * @return the areaZone
	 */
	public String getAreaZone() {
		return areaZone;
	}

	/**
	 * @param areaZone
	 *            the areaZone to set
	 */
	public void setAreaZone(String areaZone) {
		this.areaZone = areaZone;
	}

	/**
	 * @return the sfcZone
	 */
	public String getSfcZone() {
		return sfcZone;
	}

	/**
	 * @param sfcZone
	 *            the sfcZone to set
	 */
	public void setSfcZone(String sfcZone) {
		this.sfcZone = sfcZone;
	}

	/**
	 * @return the areaCity
	 */
	public String getAreaCity() {
		return areaCity;
	}

	/**
	 * @param areaCity
	 *            the areaCity to set
	 */
	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}

	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}

	/**
	 * @param locationType
	 *            the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stationCode == null) ? 0 : stationCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceStationDTO other = (ServiceStationDTO) obj;
		if (stationCode == null) {
			if (other.stationCode != null)
				return false;
		} else if (!stationCode.equals(other.stationCode))
			return false;
		return true;
	}




}
