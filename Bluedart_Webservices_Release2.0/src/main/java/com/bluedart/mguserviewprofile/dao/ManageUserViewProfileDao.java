package com.bluedart.mguserviewprofile.dao;


import com.bluedart.exception.BlueDartException;
import com.bluedart.mguserviewprofile.dto.ManageUserViewProfileDto;

/**
 * @author Velayutham Balasubramaniana
 *
 */
public interface ManageUserViewProfileDao {


	public ManageUserViewProfileDto manageUserViewProfile(String userId) throws BlueDartException;

}
