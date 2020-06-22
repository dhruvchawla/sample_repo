/**
 * 
 */
package com.bluedart.locationfinder.dao;

import java.util.List;

import com.bluedart.common.dto.AreaDTO;
import com.bluedart.locationfinder.dto.LocationFinderDto;

/**
 * @author Subhransu Maharana
 *
 */
public interface ServiceStationDao {

	/**
	 * This method is used to get the area codes based on location name
	 * @param location
	 * @return
	 */
	public AreaDTO getAreaCodes(String locationName);

	
	/**
	 * This method is used to check serviceability based on location name
	 * @param location
	 * @return
	 */
	boolean checkServiceability(String location);

	/**
	 * This method is for search by pincode
	 * @param pincode
	 * @return
	 */
	public LocationFinderDto getServiceStationsByPincode(String pincode);

	/**
	 * This method is for pincode serviceability
	 * @param pincodes
	 * @return
	 */
	public LocationFinderDto getServiceStationsByMultiplePincodes(List<String> pincodes);

	/**
	 * This method is to get the international city codes
	 * @param countryCode
	 * @param cityName
	 * @return
	 */
	String getInternationalCityCode(String pincode, String countryCode, String cityName);

	/**
	 * This method is for search by location i.e; without pincode
	 * @param isCity
	 * @param locationName
	 * @param cityName
	 * @param state
	 * @param ipAddress
	 * @return
	 */
	LocationFinderDto getServiceStationsByLocationName(boolean isCity, String locationName, String cityName,
			String state);

	/**
	 * This method is used to show the nearby service stations
	 * @param lat
	 * @param lng
	 * @param state
	 * @param count
	 * @param distance
	 * @param type
	 * @return
	 */
	public LocationFinderDto getNearbyServiceStationsByParam(String lat, String lng, String state, int count,
			int distance, String type);

	/**
	 * This method is for international location search
	 * @param intlPincode
	 * @param cityName
	 * @param countryCode
	 * @return
	 */
	LocationFinderDto checkInternationalServiceability(String intlPincode, String cityName, String countryCode);

}
