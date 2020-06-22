package com.bluedart.trackingapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.trackingapi.dao.MISLogDao;
import com.bluedart.trackingapi.service.MISLogService;

/**
 * 
 * @author DH839598
 *
 */
@Service
public class TrackingAPIMISLogServiceImpl implements MISLogService {

	@Autowired
	private MISLogDao auditingDao;

	@Override
	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize) {
		return auditingDao.saveDownloadedFileSizeMIS(loginId, filesize);
	}

	@Override
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
		return auditingDao.saveMISWithOutLogin(featureName, emailId, ip, awbnos, maildate);
	}

	@Override
	public boolean saveMIS(String featureName, String loginId) {
		return auditingDao.saveMIS(featureName, loginId);
	}

}
