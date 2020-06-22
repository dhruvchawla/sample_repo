package com.bluedart.backendsupport.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bluedart.backendsupport.dao.TrackServiceStationDao;
import com.bluedart.backendsupport.dto.ServiceStationDTO;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;
import com.bluedart.backendsupport.service.TrackServiceStationService;
import org.apache.log4j.Logger;
import com.bluedart.common.dao.MISLogDao;
/**
 * @author Velayutham Balasubramanian
 *
 */
@Service
public class TrackServiceStationServiceImpl implements TrackServiceStationService {

	private static final Logger logger = Logger.getLogger(TrackServiceStationServiceImpl.class);
	@Autowired
	private TrackServiceStationDao serviceStationDao;
	@Autowired
	private MISLogDao misLogDao;
	private String featureName = null;
	/*
	 * 
	 * 
	 * @see com.wipro.bluedart.service.ServiceStationService#
	 * getServiceStationsByPincode(java.lang.String)
	 */
	@Override
	public List<ServiceStationDTO> getServiceStationsByPincode(String pincode,String ipAddress)
			throws BlueDartException {
		featureName = Constants.BACK_END_SUPPORT;
		logger.info("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :");
		saveMISLog(featureName,null,ipAddress,null,null);
		logger.info("---------- SAVED TO ServiceStationDTO LOG ----------");
		return serviceStationDao.getServiceStationsByPincode(pincode);
	}

	/*
	 * 
	 * 
	 * @see com.wipro.bluedart.service.ServiceStationService#
	 * getServiceStationsByLocationName(java.lang.String)
	 */

	@Override
	public List<ServiceStationDTO> getServiceStationsByLocationName(String locationName,String ipAddress) throws IOException, BlueDartException {
		featureName = Constants.BACK_END_SUPPORT;
		logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :");
		saveMISLog(featureName,null,ipAddress,null,null);
		logger.debug("---------- SAVED TO ServiceStationDTO LOG ----------");
		return serviceStationDao.getServiceStationsByLocationName( locationName );
		
	}
	

	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
}
