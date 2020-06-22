package com.bluedart.manageuserCA.dao;

import java.util.List;

import com.bluedart.manageuserCA.dto.AffiliatesDto;
import com.bluedart.manageuserCA.dto.ClientAdminResponseDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.exception.BlueDartException;;

/**
 * 
 * @author TH334025
 *
 */
public interface ClientAdminDao {

	public ClientAdminResponseDto createNewUser(UserBasicDetailsDto userBasicDetails);
	
	public ClientAdminResponseDto createNewUserBDAdmin(UserBasicDetailsDto userBasicDetails);

	public ClientAdminResponseDto deleteUser(String name) throws BlueDartException;

	public ClientAdminResponseDto viewUsers(String loginid, String flag);

	public ClientAdminResponseDto modifyUserClientAdmin(UserBasicDetailsDto userBasicDetails);

	public ClientAdminResponseDto getSingleUser(String loginId);

	public ClientAdminResponseDto resetPassword(String loginId,String emailId);

	public ClientAdminResponseDto viewUsersForAdmin(String loginId,String letter);

	public ClientAdminResponseDto getAffiliates(String loginId);

	public ClientAdminResponseDto addAffiliates(List<AffiliatesDto> affliates);

	public ClientAdminResponseDto updateAffiliates(List<AffiliatesDto> affliates);

	public ClientAdminResponseDto deleteAffiliates(List<AffiliatesDto> affliates);
	
	public ClientAdminResponseDto updateUserBAdmin(UserBasicDetailsDto userBasicDetails);

	public ClientAdminResponseDto  getFeatures(String loginID) throws BlueDartException;

	public ClientAdminResponseDto sendMail(String emailId, String loginId, String password,
			String status);

	public ClientAdminResponseDto createnewuserPermission(UserBasicDetailsDto userBasicDetails);
}