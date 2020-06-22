package com.bluedart.pricefinder.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.pricefinder.dao.FinderDao;
import com.bluedart.pricefinder.dto.RateAndTransitDTO;
import com.bluedart.pricefinder.service.FinderService;
import com.bluedart.utils.Constants;


/**
 * @author Subhransu Maharana
 * This is service implementation class which extends the service interface. 
 */
@Service
public class FinderServiceImpl implements FinderService {
	
	private static Logger log = Logger.getLogger(FinderServiceImpl.class.getName()); 
	
	@Autowired
	private FinderDao finderDao;
	@Autowired
	private MISLogDao misLogDao;

	/**
	 * This is the service implementation method. This method call the DAO method.
	 */
	@Override
	public RateAndTransitDTO findTransitTimePrice(RateAndTransitDTO rateAndTransitDTO){
		
		log.debug(" FinderServiceImpl : findTransitTimePrice");
		
		String loginId = rateAndTransitDTO.getLoginId();
		misLog(Constants.FEATURE_NAME_FINDER_RATE_TRANSIT, String.valueOf(rateAndTransitDTO.getIpAddress()), loginId);
		
		return finderDao.findTransitTimePrice(rateAndTransitDTO);
	}
	
	/**
	 * This method fetches the appropriate message for MIS log.
	 */
	private void misLog(String featureName, String ipAddress, String loginId) {
		if (!StringUtils.isEmpty(loginId)) {
			misLogDao.saveMIS(featureName, loginId);
		} else {
			misLogDao.saveMISWithOutLogin(featureName, Constants.EMPTY_STRING, ipAddress, Constants.EMPTY_STRING, Constants.EMPTY_STRING);
		} 
	}

}
