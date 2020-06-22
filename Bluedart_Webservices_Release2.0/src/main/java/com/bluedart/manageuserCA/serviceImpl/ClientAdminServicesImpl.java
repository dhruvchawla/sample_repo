package com.bluedart.manageuserCA.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.manageuserCA.dao.ClientAdminDao;
import com.bluedart.manageuserCA.dto.AffiliatesDto;
import com.bluedart.manageuserCA.dto.ClientAdminResponseDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.manageuserCA.service.ClientAdminService;

@Service
public class ClientAdminServicesImpl implements ClientAdminService{
	
	@Autowired
	private ClientAdminDao clientAdminDao;
	
	@Override
	public ClientAdminResponseDto deleteUser(String loginId,String adminLoginId){
		return clientAdminDao.deleteUser(loginId);
	}

	@Override
	public ClientAdminResponseDto viewUsers(String loginId, String letter){
		return clientAdminDao.viewUsers(loginId, letter);
	}

	@Override
	public ClientAdminResponseDto getSingleUser(String loginId){
		return clientAdminDao.getSingleUser(loginId);
		
	}

	@Override
	public ClientAdminResponseDto modifyUserClientAdmin(UserBasicDetailsDto userBasicDetails){
		return clientAdminDao.modifyUserClientAdmin(userBasicDetails);
		
	}

	@Override
	public ClientAdminResponseDto viewUsersForAdmin(String loginId,
			String letter) throws BlueDartException {
		return clientAdminDao.viewUsersForAdmin(loginId, letter);
	}

	@Override
	public ClientAdminResponseDto resetPassword(String loginId,String emailId,String adminLoginId){
		return clientAdminDao.resetPassword(loginId,emailId);
				
	}

	@Override
	public ClientAdminResponseDto getAffiliates(String loginId){
		return clientAdminDao.getAffiliates(loginId);
	}

	@Override
	public ClientAdminResponseDto addAffiliates(List<AffiliatesDto> affliates){
		return clientAdminDao.addAffiliates(affliates);
	}

	@Override
	public ClientAdminResponseDto updateAffiliates(List<AffiliatesDto> affliates) {
		return clientAdminDao.updateAffiliates(affliates);
	}

	@Override
	public ClientAdminResponseDto deleteAffiliates(List<AffiliatesDto> affliates){
		return clientAdminDao.deleteAffiliates(affliates);
	}

	@Override
	public ClientAdminResponseDto createNewUser(UserBasicDetailsDto userBasicDetails){
		return clientAdminDao.createNewUser(userBasicDetails);
	}

	@Override
	public ClientAdminResponseDto updateUserBAdmin(UserBasicDetailsDto userBasicDetails){
		return clientAdminDao.updateUserBAdmin(userBasicDetails);
		
	}

	@Override
	public ClientAdminResponseDto getFeatures(String loginID){
		return clientAdminDao.getFeatures(loginID);
	}

	@Override
	public ClientAdminResponseDto createNewUserBDAdmin(UserBasicDetailsDto userBasicDetails){
		return clientAdminDao.createNewUserBDAdmin(userBasicDetails);
	}

	@Override
	public ClientAdminResponseDto sendMail(String emailId, String loginId, String password,
			String status) {
		return clientAdminDao.sendMail(emailId, loginId, password, status);
		
	}

	@Override
	public ClientAdminResponseDto createnewuserPermission(UserBasicDetailsDto userBasicDetails) {
		return clientAdminDao.createnewuserPermission(userBasicDetails);
	}
}