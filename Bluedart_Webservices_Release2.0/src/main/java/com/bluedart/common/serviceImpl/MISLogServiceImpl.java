package com.bluedart.common.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.service.MISLogService;

/**
 * 
 * @author DH839598
 *
 */
@Service
public class MISLogServiceImpl implements MISLogService {

	private static final Logger logger = Logger.getLogger(MISLogServiceImpl.class);

	@Autowired
	private MISLogDao auditingDao;

	@Override
	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize) {
		logger.debug(" MISLogServiceImpl : saveDownloadedFileSizeMIS");
		return auditingDao.saveDownloadedFileSizeMIS(loginId, filesize);
	}

	@Override
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
		logger.debug(" MISLogServiceImpl : saveMISWithOutLogin");
		return auditingDao.saveMISWithOutLogin(featureName, emailId, ip, awbnos, maildate);
	}

	@Override
	public boolean saveMIS(String featureName, String loginId) {
		logger.debug(" MISLogServiceImpl : saveMIS");
		return auditingDao.saveMIS(featureName, loginId);
	}

}
