package com.bluedart.changepwd.service;

import com.bluedart.changepwd.dto.ChangePasswordResponseDto;

/**
 * 
 * @author PR334023
 *
 */
public interface ChangePasswordService {
	/**
	 * 
	 * @param changePwdDto
	 * @return
	 */
	public ChangePasswordResponseDto changePassword(ChangePasswordResponseDto changePwdDto);
	/**
	 * 
	 * @param loginId
	 * @param oldPassword
	 * @return
	 */
	public ChangePasswordResponseDto checkExistingPassword(String loginId, String oldPassword);
}
