/**
 * 
 */
package com.bluedart.mguserviewprofile.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bluedart.mguserviewprofile.dao.ManageUserViewProfileDao;
import com.bluedart.mguserviewprofile.dto.ManageUserViewProfileDto;
import com.bluedart.mguserviewprofile.service.ManageUserViewProfileService;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;
import org.apache.log4j.Logger;


@Service
public class ManageUserViewProfileServiceImpl implements ManageUserViewProfileService {
	
	private static final Logger logger = Logger
			.getLogger(ManageUserViewProfileServiceImpl.class);
	
	@Autowired
	private ManageUserViewProfileDao manageUserViewProfileDao;
	
	@Autowired
	private MISLogDao misLogDao;

	private String featureName = null;
	
	@Override
	public ManageUserViewProfileDto manageUserViewProfile(String userId,String loginId) throws BlueDartException {
		featureName = Constants.MANAGEUSER_VIEW_PROFILE;
		logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+loginId);
		saveMISLog(featureName,loginId,null,null,null);
		logger.debug("---------- SAVED TO MIS LOG ----------");
		return manageUserViewProfileDao.manageUserViewProfile(userId);
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
