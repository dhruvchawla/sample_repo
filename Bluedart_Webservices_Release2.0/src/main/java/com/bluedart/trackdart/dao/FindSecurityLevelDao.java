package com.bluedart.trackdart.dao;

/**
 * 
 * @author DH839598
 *
 */
public interface FindSecurityLevelDao {

	/**
	 * 
	 * @param loginId
	 * @return
	 */
	public int findSecurityLevel(String loginId);

}
