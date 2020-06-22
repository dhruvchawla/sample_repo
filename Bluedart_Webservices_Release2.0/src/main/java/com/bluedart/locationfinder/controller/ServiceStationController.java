package com.bluedart.locationfinder.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.dto.AreaDTO;
import com.bluedart.exception.DataBaseException;
import com.bluedart.locationfinder.dto.LocationFinderDto;
import com.bluedart.locationfinder.dto.PincodeServiceabilityDto;
import com.bluedart.locationfinder.service.ServiceStationService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author AN765570
 * @Description This Class contains all the rest controller methods related to Location Finder
 *
 */

@RestController
public class ServiceStationController {
	
	@Autowired
	private ServiceStationService serviceStationService;
	
	private static final Logger logger = Logger.getLogger(ServiceStationController.class);
	
	/**
	 * This method is used to get the area codes based on location name
	 * @param locationName
	 * @return
	 */
	@RequestMapping(value = "findlocation/getareacodes/{locationName}/{ipAddress}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AreaDTO getAreaCodes(@PathVariable String locationName){
		logger.debug(" ServiceStationController : getAreaCodes");
		return serviceStationService.getAreaCodes(locationName);
	}
	
	/**
	 * This method is used to get the international city code
	 * @param pincode
	 * @param countryCode
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "findlocation/getinternationalcitycode/{pincode}/{countryCode}/{cityName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getInternationalCityCode(@PathVariable String pincode,@PathVariable String countryCode,@PathVariable String cityName) {
		logger.debug(" ServiceStationController : getInternationalCityCode");
		return serviceStationService.getInternationalCityCode(pincode, countryCode, cityName);
	}
	
	/**
	 * This method is for search by pincode
	 * @param pincode
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "findlocation/getservicestationsbypincode/{pincode}/{ipAddress}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LocationFinderDto getServiceStationsByPincode(@PathVariable String pincode,@PathVariable String ipAddress,@PathVariable String loginId){
		logger.debug(" ServiceStationController : getServiceStationsByPincode");
		LocationFinderDto locationFinderDto = new LocationFinderDto();
		String pin = pincode.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:pincode;
		String login = loginId.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:loginId;	
		if (StringUtils.isEmpty(pincode)) { 
			locationFinderDto.setErrorOccured(true);
			locationFinderDto.setErrorCode(Constants.FINDER_INPUT_ERRORCODE);
			locationFinderDto.setErrorMessage(Constants.NOT_A_VALID_INPUT);
			return locationFinderDto;
		}
		
		locationFinderDto = serviceStationService.getServiceStationsByPincode(pin,ipAddress, login); 
		locationFinderDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return locationFinderDto;
	}
	
	/**
	 * This method is for showing nearby locations 
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
	@RequestMapping(value = "findlocation/getnearbyservicestationsbyparam/{lat}/{lng}/{state}/{count}/{distance}/{type}/{ipAddress}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LocationFinderDto getNearbyServiceStationsByParam(@PathVariable String lat,@PathVariable String lng,@PathVariable String state,@PathVariable int count,@PathVariable int distance,@PathVariable String type , @PathVariable String ipAddress,@PathVariable String loginId) {
		logger.debug(" ServiceStationController : getServiceStationsByPincode");
		String latitude = lat.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:lat;
		String longitude = lng.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:lng;
		String stateName = state.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:state;
		String serviceType = type.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:type;
		String login = loginId.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:loginId;
		LocationFinderDto locationFinderDto = new LocationFinderDto();
		
		if (StringUtils.isEmpty(latitude) || StringUtils.isEmpty(longitude)) {
			locationFinderDto.setErrorOccured(true);
			locationFinderDto.setErrorCode(Constants.FINDER_INPUT_ERRORCODE);
			locationFinderDto.setErrorMessage(Constants.NOT_A_VALID_INPUT);
			return locationFinderDto;
		}

		if (StringUtils.isEmpty(stateName)) {
			locationFinderDto.setErrorOccured(true);
			locationFinderDto.setErrorCode(Constants.FINDER_INPUT_ERRORCODE);
			locationFinderDto.setErrorMessage(Constants.NOT_A_VALID_INPUT);
			return locationFinderDto;
		}
		
		// max length 4 after decimal
		int latDotIndex = latitude.indexOf('.', 0);
		int lngDotIndex = longitude.indexOf('.', 0);

		latitude = latitude.substring(0, latDotIndex + (latitude.substring(latDotIndex + 1, latitude.length()).length() > 4 ? 4
				: latitude.substring(latDotIndex + 1, latitude.length()).length()) + 1);
		longitude = longitude.substring(0, lngDotIndex + (longitude.substring(lngDotIndex + 1, longitude.length()).length() > 4 ? 4
				: longitude.substring(lngDotIndex + 1, longitude.length()).length()) + 1);

		locationFinderDto = serviceStationService.getNearbyServiceStationsByParam(latitude, longitude, stateName, count, distance, serviceType, ipAddress,login);
		locationFinderDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return locationFinderDto;
	}
	
	/**
	 * This method is for international location search
	 * @param intlPincode
	 * @param cityName
	 * @param countryCode
	 * @param ipAddress
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "findlocation/checkinternationalserviceability/{cityName}/{countryCode}/{intlPincode}/{ipAddress}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LocationFinderDto checkInternationalServiceability(@PathVariable String intlPincode,@PathVariable String cityName,@PathVariable String countryCode,@PathVariable String ipAddress,@PathVariable String loginId){
		logger.debug(" ServiceStationController : checkInternationalServiceability");
		String city = cityName.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:cityName;
		String cntryCode = countryCode.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:countryCode;
		String intlPin = intlPincode.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:intlPincode;
		String login = loginId.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:loginId;
		LocationFinderDto locationFinderDto;
		locationFinderDto = serviceStationService.checkInternationalServiceability(intlPin, city, cntryCode, ipAddress, login);
		locationFinderDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return locationFinderDto;
	}
	
	/**
	 * This method is for pincode serviceability
	 * @param pincodeServiceabilityDto
	 * @return
	 */
	@RequestMapping(value = "/findlocation/getservicestationsbymultiplepincodes", method = RequestMethod.POST)
	public LocationFinderDto getServiceStationsByMultiplePincodes(@RequestBody PincodeServiceabilityDto pincodeServiceabilityDto){
		logger.debug(" ServiceStationController : getServiceStationsByMultiplePincodes");
		String ip = pincodeServiceabilityDto.getIp();
		String loginId = pincodeServiceabilityDto.getLoginId();
		List<String> pinServList = pincodeServiceabilityDto.getPincodeServList();
		LocationFinderDto locationFinderDto;
		locationFinderDto = serviceStationService.getServiceStationsByMultiplePincodes(pinServList,ip,loginId);
		locationFinderDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return locationFinderDto;
	}
	
	/**
	 * This method is for pincode serviceability
	 * @param searchedPincodes
	 * @param ipAddress
	 * @param liginId
	 * @return
	 */
	@RequestMapping(value = "/findlocation/getservicestationsbymultiplepincodes/{searchedPincodes}/{ipAddress}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LocationFinderDto getServiceStationsByMultiplePincodes(@PathVariable String searchedPincodes,@PathVariable String ipAddress,@PathVariable String loginId){
		logger.debug(" ServiceStationController : getServiceStationsByMultiplePincodes");
		//List<String> pinServList = new ArrayList<String>();
		List<String> pinServList = Arrays.asList(searchedPincodes.split("\\s*,\\s*"));
		LocationFinderDto locationFinderDto;
		locationFinderDto = serviceStationService.getServiceStationsByMultiplePincodes(pinServList,ipAddress,loginId);
		locationFinderDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return locationFinderDto;
	}
	
	
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
	@RequestMapping(value = "findlocation/getservicestationsbylocationname/{isCity}/{locationName}/{cityName}/{state}/{ipAddress}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LocationFinderDto getServiceStationsByLocationName(@PathVariable boolean isCity,@PathVariable String locationName,@PathVariable String cityName,@PathVariable String state, @PathVariable String ipAddress,@PathVariable String loginId){
		logger.debug(" ServiceStationController : getServiceStationsByLocationName");
		String location = locationName.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:locationName;
		String city = cityName.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:cityName;
		String stateName = state.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:state;
		String login = loginId.equals(Constants.NULL_STRING)?Constants.EMPTY_STRING:loginId;
		LocationFinderDto locationFinderDto;
		locationFinderDto = serviceStationService.getServiceStationsByLocationName(isCity, location, city, stateName,ipAddress,login);
		locationFinderDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return locationFinderDto;
	}

	/**
	 * This private method is used for exception handling
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private LocationFinderDto myError(DataBaseException serviceException) {
		LocationFinderDto locationFinderDto = new LocationFinderDto();
		locationFinderDto.setErrorCode(serviceException.getErrorCode());
		locationFinderDto.setErrorMessage(serviceException.getErrorMessage());
	    return locationFinderDto;
	}
	
}
