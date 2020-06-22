package com.bluedart.common.dao;

/**
 * 
 * @author DH839598
 *
 */
public interface MISLogSchedulerDao {

	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize);

	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate);

	public boolean saveMIS(String featureName, String loginId);

}
