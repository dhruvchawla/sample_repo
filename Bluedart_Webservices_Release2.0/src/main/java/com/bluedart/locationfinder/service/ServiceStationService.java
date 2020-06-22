/**
 * 
 */
package com.bluedart.locationfinder.service;

import java.util.List;

import com.bluedart.common.dto.AreaDTO;
import com.bluedart.locationfinder.dto.LocationFinderDto;

/**
 * @author Subhransu Maharana
 *
 */
public interface ServiceStationService {

	/**
	 * This method is for search by pincode
	 * @param pincode
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	public LocationFinderDto getServiceStationsByPincode(String pincode, String ipAddress, String loginId);

	/**
	 * This method is used to get the area codes based on location name
	 * @param locationName
	 * @return
	 */
	public AreaDTO getAreaCodes(String locationName);

	/**
	 * This method is for international location search
	 * @param intlPincode
	 * @param cityName
	 * @param countryCode
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	public LocationFinderDto checkInternationalServiceability(String intlPincode, String cityName, String countryCode,
			String ipAddress, String loginId);

	/**
	 * This method is for pincode serviceability
	 * @param pincodes
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	public LocationFinderDto getServiceStationsByMultiplePincodes(List<String> pincodes, String ipAddress,
			String loginId);

	/**
	 * This method is for search by location i.e; without pincode
	 * @param isCity
	 * @param locationName
	 * @param cityName
	 * @param state
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	LocationFinderDto getServiceStationsByLocationName(boolean isCity, String locationName, String cityName,
			String state, String ipAddress, String loginId);

	/**
	 * This method is used to show the nearby service stations
	 * @param lat
	 * @param lng
	 * @param state
	 * @param count
	 * @param distance
	 * @param type
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	public LocationFinderDto getNearbyServiceStationsByParam(String lat, String lng, String state, int count,
			int distance, String type, String ipAddress, String loginId);

	/**
	 * This method is to get the international city codes
	 * @param pincode
	 * @param countryCode
	 * @param cityName
	 * @return
	 */
	public String getInternationalCityCode(String pincode, String countryCode, String cityName);

}
