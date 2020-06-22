package com.bluedart.trackingapi.service;

/**
 * 
 * @author DH839598
 *
 */
public interface MISLogService {

	/**
	 * 
	 * @param loginId
	 * @param filesize
	 * @return
	 */
	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize);

	/**
	 * @param featureName
	 * @param emailId
	 * @param ip
	 * @param awbnos
	 * @param maildate
	 * @return
	 */
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate);

	/**
	 * @param featureName
	 * @param loginId
	 * @return
	 */
	public boolean saveMIS(String featureName, String loginId);

}
