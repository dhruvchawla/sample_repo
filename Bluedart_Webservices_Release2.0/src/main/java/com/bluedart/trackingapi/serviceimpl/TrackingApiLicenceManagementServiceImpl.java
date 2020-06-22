package com.bluedart.trackingapi.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.trackingapi.dao.TrackingApiLicenceManagementDao;
import com.bluedart.common.dto.TrackingAPILicenseDto;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.dto.TrackingAPIDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.trackingapi.service.TrackingApiLicenceManagementService;
import com.bluedart.utils.Constants;

/**
 * 
 * @author SI334034
 *
 */
@Service
public class TrackingApiLicenceManagementServiceImpl implements TrackingApiLicenceManagementService {

	private static final Logger logger = Logger.getLogger(TrackingApiLicenceManagementServiceImpl.class);
	
	@Autowired
	TrackingApiLicenceManagementDao trackingApiLicenceManagementDao;
	
	@Autowired
	private MISLogDao misLogDao;
	
	@Override
	public TrackingAPILicenseDto showLicenseKey(String userLoginId, String type) {
		return trackingApiLicenceManagementDao.showLicenseKey(userLoginId, type);
	}
	
	public TrackingAPIDto getTrackByAwbNoList(List<String> awbNos, String loginId, int reqScanFlag, String lickey, String verno) throws IOException, BlueDartException {
		String featureName= Constants.TRACKINGAPI;
		saveMISLog(featureName,loginId,null,null,null);
		return trackingApiLicenceManagementDao.getTrackByAwbNoList(awbNos, loginId, reqScanFlag, lickey, verno);
	}
	
	public TrackingAPIDto getTrackByRefNoList(List<String> refNos, String loginId, int reqScanFlag, String lickey, String verno) throws IOException, BlueDartException {
		String featureName= Constants.TRACKINGAPI;
		saveMISLog(featureName,loginId,null,null,null);
		return trackingApiLicenceManagementDao.getTrackByRefNoList(refNos, loginId, reqScanFlag, lickey, verno);
		
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
