package com.bluedart.trackingapi.dao;

/**
 * 
 * @author DH839598
 *
 */
public interface TrackingAPIFindSecurityLevelDao {
	
	/**
	 * 
	 * @param loginId
	 * @return
	 */
	public int findSecurityLevel(String loginId);

}
