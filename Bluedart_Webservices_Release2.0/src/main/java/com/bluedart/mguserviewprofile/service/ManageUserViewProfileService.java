/**
 * 
 */
package com.bluedart.mguserviewprofile.service;

import com.bluedart.mguserviewprofile.dto.ManageUserViewProfileDto;

import java.util.List;

import com.bluedart.exception.BlueDartException;

/**
 * @author Velayutham Balasubramanian
 *
 */
public interface ManageUserViewProfileService {

	public ManageUserViewProfileDto manageUserViewProfile(String userId,String logind) throws BlueDartException;

	


}
