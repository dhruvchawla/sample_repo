package com.bluedart.changepwd.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.changepwd.dao.ChangePasswordDao;
import com.bluedart.changepwd.dto.ChangePasswordResponseDto;
import com.bluedart.changepwd.service.ChangePasswordService;

/**
 * 
 * @author PR334023
 *
 */
@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
	
	@Autowired
	private ChangePasswordDao changePasswordDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.changepwd.service.ChangePasswordService#changePassword(com.bluedart.changepwd.dto.ChangePasswordResponseDto)
	 */
	@Override
	public ChangePasswordResponseDto changePassword(ChangePasswordResponseDto changePwdDto){
		return changePasswordDao.changePassword(changePwdDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.changepwd.service.ChangePasswordService#checkExistingPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public ChangePasswordResponseDto checkExistingPassword(String loginId, String oldPassword){
		return changePasswordDao.checkExistingPassword(loginId, oldPassword);
	}
}