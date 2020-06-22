package com.bluedart.trackdart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.trackdart.dao.FindSecurityLevelDao;
import com.bluedart.trackdart.service.FindSecurityLevelService;

@Service
public class FindSecurityLevelServiceImpl implements FindSecurityLevelService{
	
	@Autowired
	private FindSecurityLevelDao findSecurityLevelDao;

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.FindSecurityLevelService#findSecurityLevel(java.lang.String)
	 */
	@Override
	public int findSecurityLevel(String loginId) {
		return findSecurityLevelDao.findSecurityLevel(loginId);
	}

}
