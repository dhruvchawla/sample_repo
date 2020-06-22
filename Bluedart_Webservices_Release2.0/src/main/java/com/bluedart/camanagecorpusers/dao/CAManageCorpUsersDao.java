package com.bluedart.camanagecorpusers.dao;

import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.camanagecorpusers.dto.ClientUserDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;

/**
 * DAO interface to manage corporate users
 * @author PR334023
 *
 */
public interface CAManageCorpUsersDao {
	/**
	 * 
	 * @param adminLoginId
	 * @return
	 */
	public String getCARegion(String adminLoginId);
	/**
	 * 
	 * @param adminLoginId
	 * @return
	 */
	public ClientUserDto getNoOfUsers(String adminLoginId);
	/**
	 * 
	 * @param adminLoginId
	 * @param areaCode
	 * @param custCode
	 * @return
	 */
	public ClientUserDto verifyAdminAffiliate(String adminLoginId, String areaCode, String custCode);
	
	/**
	 * 
	 * @param usersSearchDto
	 * @return
	 */
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto);
	
	/**
	 * 
	 * @param userBasicDetails
	 * @return
	 */
	public ValidCustomerDto createCorpUser(UserBasicDetailsDto userBasicDetails);
	
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @param adminLoginId
	 * @param userLoginId
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public ClientUserDto searchAffiliates(String areaCode, String custCode, String adminLoginId, String userLoginId,
			int pageSize, int pageNumber);
	
	/**
	 * @param bdCustDto
	 * @return
	 */
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto);
	
	/**
	 * @param corporateUserDto
	 * @return
	 */
	public ValidCustomerDto activateOrDeactivate(CorporateUserDto corporateUserDto);

	/**
	 * 
	 * @param userBasicDetails
	 * @return
	 */
	public ValidCustomerDto editCorpUser(UserBasicDetailsDto userBasicDetails);
	
}
