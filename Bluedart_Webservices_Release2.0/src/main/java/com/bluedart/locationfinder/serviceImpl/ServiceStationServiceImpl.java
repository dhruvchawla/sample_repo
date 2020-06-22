package com.bluedart.locationfinder.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.locationfinder.dao.ServiceStationDao;
import com.bluedart.locationfinder.dto.LocationFinderDto;
import com.bluedart.locationfinder.service.ServiceStationService;
import com.bluedart.utils.Constants;

/**
 * @author Subhransu Maharana
 *
 */
@Service
public class ServiceStationServiceImpl implements ServiceStationService {

	private static final Logger logger = Logger.getLogger(ServiceStationServiceImpl.class);
	@Autowired
	private ServiceStationDao serviceStationDao;
	@Autowired
	private MISLogDao misLogDao;

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#getServiceStationsByPincode(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LocationFinderDto getServiceStationsByPincode(String pincode, String ipAddress, String loginId){
		logger.debug(" ServiceStationController : getServiceStationsByPincode");
		misLog(Constants.FEATURE_NAME_FINDER_DOMESTIC_LOCATION, ipAddress, loginId);
		return serviceStationDao.getServiceStationsByPincode(pincode);
	}

	
	/**
	 * This method is for MIS logs
	 * @param featureName
	 * @param ipAddress
	 * @param loginId
	 */
	private void misLog(String featureName, String ipAddress, String loginId) {
		if (!StringUtils.isEmpty(loginId)) {
			misLogDao.saveMIS(featureName, loginId);
		} else {
			misLogDao.saveMISWithOutLogin(featureName, "", ipAddress, "", "");
		} 
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#getAreaCodes(java.lang.String)
	 */
	@Override
	public AreaDTO getAreaCodes(String locationName) {
		logger.debug(" ServiceStationController : getAreaCodes");
		return serviceStationDao.getAreaCodes(locationName);
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#checkInternationalServiceability(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LocationFinderDto checkInternationalServiceability(String intlPincode, String cityName, String countryCode,
			String ipAddress, String loginId){
		logger.debug(" ServiceStationController : checkInternationalServiceability");
		misLog(Constants.FEATURE_NAME_FINDER_INTERNATIONAL, ipAddress, loginId);
		return serviceStationDao.checkInternationalServiceability(intlPincode, cityName, countryCode);
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#getServiceStationsByMultiplePincodes(java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public LocationFinderDto getServiceStationsByMultiplePincodes(List<String> pincodes, String ipAddress,
			String loginId){
		logger.debug(" ServiceStationController : getServiceStationsByMultiplePincodes");
		misLog(Constants.FEATURE_NAME_FINDER_DOMESTIC_LOCATION, ipAddress, loginId);
		return serviceStationDao.getServiceStationsByMultiplePincodes(pincodes);
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#getServiceStationsByLocationName(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LocationFinderDto getServiceStationsByLocationName(boolean isCity, String locationName,
			String cityName, String state, String ipAddress, String loginId){
		logger.debug(" ServiceStationController : getServiceStationsByLocationName");
		misLog(Constants.FEATURE_NAME_FINDER_DOMESTIC_LOCATION, ipAddress, loginId);
		return serviceStationDao.getServiceStationsByLocationName(isCity, locationName, cityName, state);
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#getNearbyServiceStationsByParam(java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public LocationFinderDto getNearbyServiceStationsByParam(String lat, String lng, String state, int count,
			int distance, String type, String ipAddress, String loginId){
		logger.debug(" ServiceStationController : getNearbyServiceStationsByParam");
		misLog(Constants.FEATURE_NAME_FINDER_DOMESTIC_LOCATION, ipAddress, loginId);
		return serviceStationDao.getNearbyServiceStationsByParam(lat, lng, state, count, distance, type);
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.bluedart.service.ServiceStationService#getInternationalCityCode(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getInternationalCityCode(String pincode, String countryCode, String cityName){
		logger.debug(" ServiceStationController : getInternationalCityCode");
		return serviceStationDao.getInternationalCityCode(pincode, countryCode, cityName);
	}

}
