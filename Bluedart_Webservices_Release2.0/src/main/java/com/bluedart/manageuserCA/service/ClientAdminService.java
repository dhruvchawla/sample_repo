package com.bluedart.manageuserCA.service;

import java.util.List;

import com.bluedart.manageuserCA.dto.AffiliatesDto;
import com.bluedart.manageuserCA.dto.ClientAdminResponseDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;

/**
 * 
 * @author TH334025
 *
 */
public interface ClientAdminService {
	
	public ClientAdminResponseDto createNewUser(UserBasicDetailsDto userBasicDetails);

	public ClientAdminResponseDto createNewUserBDAdmin(UserBasicDetailsDto userBasicDetails);

	public ClientAdminResponseDto deleteUser(String userLoginId,String adminLoginId);

	public ClientAdminResponseDto viewUsers(String loginid, String letter);

	public ClientAdminResponseDto getSingleUser(String loginId);

	public ClientAdminResponseDto modifyUserClientAdmin(UserBasicDetailsDto userBasicDetails);

	public ClientAdminResponseDto viewUsersForAdmin(String loginId,String letter);
	
	public ClientAdminResponseDto resetPassword(String loginId,String emailId,String adminLoginId);
	
	public ClientAdminResponseDto getAffiliates(String loginId);
	
	public ClientAdminResponseDto addAffiliates(List<AffiliatesDto> affliates);

	public ClientAdminResponseDto updateAffiliates(List<AffiliatesDto> affliates);

	public ClientAdminResponseDto deleteAffiliates(List<AffiliatesDto> affliates);
	
	public ClientAdminResponseDto updateUserBAdmin(UserBasicDetailsDto userBasicDetails);
	
	public ClientAdminResponseDto  getFeatures(String loginID);
	
	public ClientAdminResponseDto sendMail(String emailId, String loginId, String password,
			String status);

	public ClientAdminResponseDto createnewuserPermission(UserBasicDetailsDto userBasicDetails);
}