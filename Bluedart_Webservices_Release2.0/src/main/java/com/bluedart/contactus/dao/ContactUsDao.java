package com.bluedart.contactus.dao;

/**
 * @author CH848113
 */
public interface ContactUsDao {

	public String getLocation(String locationName,String locationPinCode);
	
	public Boolean isValidWayBillNo(String awbNo);

}
