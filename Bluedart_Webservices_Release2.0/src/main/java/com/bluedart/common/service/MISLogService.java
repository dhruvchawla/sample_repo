package com.bluedart.common.service;

/**
 * 
 * @author DH839598
 *
 */
public interface MISLogService {

	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize);

	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate);

	public boolean saveMIS(String featureName, String loginId);

}
