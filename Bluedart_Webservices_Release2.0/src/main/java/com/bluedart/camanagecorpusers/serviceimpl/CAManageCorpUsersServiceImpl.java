package com.bluedart.camanagecorpusers.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.bdmanagecorporateusers.dto.PermissionResponseDto;
import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService;
import com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao;
import com.bluedart.camanagecorpusers.daoimpl.CANotificationHelper;
import com.bluedart.camanagecorpusers.dto.ClientUserDto;
import com.bluedart.camanagecorpusers.service.CAManageCorpUsersService;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateNotificationDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.PermissionDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.utils.BDAdminConstants;

/**
 * 
 * @author PR334023
 *
 */
@Service
public class CAManageCorpUsersServiceImpl implements CAManageCorpUsersService{

	@Autowired
	private CAManageCorpUsersDao CAManageCorpUsersDao;
	
	@Autowired
	private BDManageCorporateUsersService bdManageCorporateUsersService;
	
	@Autowired
	private CANotificationHelper caNotificationHelper;
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#getCARegion(java.lang.String)
	 */
	@Override
	public String getCARegion(String adminLoginId){
		return CAManageCorpUsersDao.getCARegion(adminLoginId);
	}
	
	/*
	 * Method to get number of users 
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#getNoOfUsers(java.lang.String)
	 */
	@Override
	public ClientUserDto getNoOfUsers(String adminLoginId) {
		return CAManageCorpUsersDao.getNoOfUsers(adminLoginId);
	}
	/*
	 * 
	 * @param adminLoginId
	 * @param areaCode
	 * @param custCode
	 * @return
	 */
	@Override
	public ClientUserDto verifyAdminAffiliate(String adminLoginId, String areaCode, String custCode){
		return CAManageCorpUsersDao.verifyAdminAffiliate(adminLoginId, areaCode, custCode); 
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#listCorpUsers(java.lang.String, java.lang.String)
	 */
	@Override
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto) {
		/*if (alphabet == null || ((Constants.ALL_USERS).equalsIgnoreCase(alphabet))) {
			alphabet = "%";
		}else{
			alphabet =alphabet+"%";
		}*/
		return null;
	}

	/*
	 * Method to create new corporate user by corporate admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#createCorpUser(com.bluedart.manageuserCA.dto.UserBasicDetailsDto)
	 */
	@Override
	public ValidCustomerDto createCorpUser(UserBasicDetailsDto userBasicDetails) {
		ValidCustomerDto response = null;
				
		PermissionMappingDto perMappingDto = new PermissionMappingDto();
		perMappingDto.setAreaCode(null);
		perMappingDto.setCustCode(null);
		perMappingDto.setLoginId(userBasicDetails.getLoginId());
		List<PermissionDto> permissionList = new ArrayList<>();
		
		PermissionDto permissionDto = null;
		
		permissionDto = new PermissionDto();
		permissionDto.setPermissionName("TRACK_AND_TRACE");
		permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
		permissionDto.setPermissionValue("Y");
		permissionList.add(permissionDto);
		
		permissionDto = new PermissionDto();
		permissionDto.setPermissionName("INTERNET_DART_REPORT_DOWNLOAD");
		permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
		permissionDto.setPermissionValue("Y");
		permissionList.add(permissionDto);
		
		perMappingDto.setPermissionDtosList(permissionList); 
		ValidCustomerDto validCustomerDto = bdManageCorporateUsersService.saveLoginPermissions(perMappingDto);
		if(validCustomerDto!=null && validCustomerDto.getValidFlag().equalsIgnoreCase("SUCCESS")){
			response = CAManageCorpUsersDao.createCorpUser(userBasicDetails); 
		}
		return response; 
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#searchAffiliates(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public ClientUserDto searchAffiliates(String areaCode, String custCode,
			String adminLoginId, String userLoginId, int pageSize, int pageNumber) {
		return CAManageCorpUsersDao.searchAffiliates(areaCode, custCode, adminLoginId, userLoginId, pageSize, pageNumber);
	}

	/*
	 * Method to get login level permissions of corporate admin & corporate user
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#getLoginPermissions(java.lang.String, java.lang.String)
	 */
	@Override
	public BDCustomerDto getLoginPermissions(String adminLoginId, String userLoginId) {
		BDCustomerDto adminPermissions = bdManageCorporateUsersService.getLoginPermissions(adminLoginId);
		BDCustomerDto userPermissions = bdManageCorporateUsersService.getLoginPermissions(userLoginId);
		
		
		PermissionResponseDto perResponseDto = new PermissionResponseDto();
		List<PermissionResponseDto> perResponseList = new ArrayList<>();
				
		Set<PermissionDto> permissionSet = new HashSet<>();
		if(adminPermissions.getPerList()!=null){
			permissionSet.addAll(adminPermissions.getPerList());
		}
		if(userPermissions.getPerList()!=null){
			permissionSet.addAll(userPermissions.getPerList());
		}
		
		for (PermissionDto perSet : permissionSet) {
			perResponseDto = new PermissionResponseDto();
			perResponseDto.setPermissionName(perSet.getPermissionName());
			perResponseDto.setPermissionValue("N");
			perResponseDto.setEnableFlag("N");
			
			if(userPermissions.getPerList()!=null){
				for (PermissionDto userPer : userPermissions.getPerList()) {
					if(perSet.getPermissionName().equalsIgnoreCase(userPer.getPermissionName())){
						perResponseDto.setPermissionValue(userPer.getPermissionValue());
					}
				}
			}else{
				perResponseDto.setPermissionValue("N");
			}
			perResponseDto.setVisibleFlag("Y"); 
			if(adminPermissions.getPerList()!=null){
				for (PermissionDto admPer : adminPermissions.getPerList()) {
					if(perSet.getPermissionName().equalsIgnoreCase(admPer.getPermissionName())){
						perResponseDto.setEnableFlag("Y");
					}
				}
			}
			perResponseList.add(perResponseDto);
		}
		BDCustomerDto bdCustomerDto = new BDCustomerDto();
		bdCustomerDto.setPerResponseList(perResponseList);
		
//		BDCustomerDto bdCustomerDto = new BDCustomerDto();
//		if(adminPermissions!=null && userPermissions!=null){
//			List<PermissionDto> adminList = adminPermissions.getPerList();
//			List<PermissionDto> userList = userPermissions.getPerList();
//			List<PermissionDto> differentList = new ArrayList<>();
//			List<PermissionDto> finalList = new ArrayList<>();
//			
//			List<PermissionDto> yesList = new ArrayList<>();
//			List<PermissionDto> noList = new ArrayList<>();
//			boolean differentFlag = false;
//			
//			if(adminPermissions.getPerList()!=null){
//				
//				for (PermissionDto adminPermissionDto : adminList) {
//				 if(userList!=null){
//					 differentFlag=true;
//					for(PermissionDto userPermissionDto : userList) {
//						if((userPermissionDto.getPermissionName()).equalsIgnoreCase(adminPermissionDto.getPermissionName())){
//							yesList.add(adminPermissionDto);
//							break;
//						}
//					}
//				 }else{
//					adminPermissionDto.setPermissionValue(Constants.REG_FLAG_NO);
//					finalList.add(adminPermissionDto); 
//				 }
//				}
//				if(differentFlag){
//					differentList.addAll(adminList);
//					differentList.removeAll(yesList);
//					for (PermissionDto permissionDto : differentList) {
//						permissionDto.setPermissionValue(Constants.REG_FLAG_NO);
//						noList.add(permissionDto);
//					}
//					finalList.addAll(yesList);
//					finalList.addAll(noList);
//				}
//				bdCustomerDto.setPerList(finalList); 
//			}
//		}
		return bdCustomerDto;
	}

	/*
	 * Method to get affiliate level permissions for corporate admin and corporate user
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#getAffPermissions(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public BDCustomerDto getAffPermissions(String areaCode, String custCode,
			String adminLoginId, String userLoginId) {
		
		if(areaCode.equalsIgnoreCase("null") || StringUtils.isEmpty(areaCode)){
			areaCode=null;
		}
		
		if(custCode.equalsIgnoreCase("null") || StringUtils.isEmpty(custCode)){	
		//if(custCode.equalsIgnoreCase("null") || custCode==""){
			custCode=null;
		}
		BDCustomerDto adminPermissions = bdManageCorporateUsersService.getAffPermissions(areaCode,custCode,adminLoginId);
		BDCustomerDto userPermissions = bdManageCorporateUsersService.getAffPermissions(areaCode,custCode,userLoginId);
		
		PermissionResponseDto perResponseDto = new PermissionResponseDto();
		List<PermissionResponseDto> perResponseList = new ArrayList<>();
				
		Set<PermissionDto> permissionSet = new HashSet<>();
		/*permissionSet.addAll(adminPermissions.getPerList());
		permissionSet.addAll(userPermissions.getPerList());
		for (PermissionDto perSet : permissionSet) {
			perResponseDto = new PermissionResponseDto();
			perResponseDto.setPermissionName(perSet.getPermissionName());
			perResponseDto.setPermissionValue(perSet.getPermissionValue());
			perResponseDto.setVisibleFlag("Y"); 
			if(adminPermissions.getPerList().contains(perSet.getPermissionName())){
				perResponseDto.setEnableFlag("Y");
			}else{
				perResponseDto.setEnableFlag("N");
			}
			perResponseList.add(perResponseDto);
		}*/
		if(adminPermissions.getPerList()!=null){
			permissionSet.addAll(adminPermissions.getPerList());
		}
		if(userPermissions.getPerList()!=null){
			permissionSet.addAll(userPermissions.getPerList());
		}
		
		for (PermissionDto perSet : permissionSet) {
			perResponseDto = new PermissionResponseDto();
			perResponseDto.setPermissionName(perSet.getPermissionName());
			perResponseDto.setPermissionValue("N");
			perResponseDto.setEnableFlag("N");
			
			if(userPermissions.getPerList()!=null){
				for (PermissionDto userPer : userPermissions.getPerList()) {
					if(perSet.getPermissionName().equalsIgnoreCase(userPer.getPermissionName())){
						perResponseDto.setPermissionValue(userPer.getPermissionValue());
					}
				}
			}else{
				perResponseDto.setPermissionValue("N");
			}
			perResponseDto.setVisibleFlag("Y"); 
			if(adminPermissions.getPerList()!=null){
				for (PermissionDto admPer : adminPermissions.getPerList()) {
					if(perSet.getPermissionName().equalsIgnoreCase(admPer.getPermissionName())){
						perResponseDto.setEnableFlag("Y");
					}
				}
			}
			perResponseList.add(perResponseDto);
		}
		BDCustomerDto bdCustomerDto = new BDCustomerDto();
		bdCustomerDto.setPerResponseList(perResponseList);
		
//		if(adminPermissions!=null && userPermissions!=null){
//			List<PermissionDto> adminList = adminPermissions.getPerList();
//			List<PermissionDto> userList = userPermissions.getPerList();
//			List<PermissionDto> differentList = new ArrayList<>();
//			List<PermissionDto> finalList = new ArrayList<>();
//			
//			List<PermissionDto> yesList = new ArrayList<>();
//			List<PermissionDto> noList = new ArrayList<>();
//			
//			if(adminPermissions.getPerList()!=null){
//				for (PermissionDto adminPermissionDto : adminList) {
//				 if(userList!=null){
//					for(PermissionDto userPermissionDto : userList) {
//						if((userPermissionDto.getPermissionName()).equalsIgnoreCase(adminPermissionDto.getPermissionName())){
//							if(userPermissionDto.getPermissionName().equalsIgnoreCase("NUMBER_OF_ADDRESS_TO_MANAGE")){
//								adminPermissionDto.setPermissionValue(userPermissionDto.getPermissionValue());
//								yesList.add(adminPermissionDto);
//								break;
//							}else{
//								yesList.add(adminPermissionDto);
//								break;
//							}
//						}
//					}
//				 }else{
//					 
//					 if(adminPermissionDto.getPermissionName().equalsIgnoreCase("NUMBER_OF_ADDRESS_TO_MANAGE")){
//						 adminPermissionDto.setPermissionValue("0"); 
//						 finalList.add(adminPermissionDto); 
//						}else{
//							adminPermissionDto.setPermissionValue(Constants.REG_FLAG_NO);
//							finalList.add(adminPermissionDto); 
//						}
//				 }
//				}
//				differentList.addAll(adminList);
//				differentList.removeAll(yesList);
//				for (PermissionDto permissionDto : differentList) {
//					
//					if(permissionDto.getPermissionName().equalsIgnoreCase("NUMBER_OF_ADDRESS_TO_MANAGE")){
//						permissionDto.setPermissionValue("0"); 
//						 noList.add(permissionDto);
//						}else{
//							permissionDto.setPermissionValue(Constants.REG_FLAG_NO);
//							noList.add(permissionDto);
//						}
//				}
//				finalList.addAll(yesList);
//				finalList.addAll(noList);
//				bdCustomerDto.setPerList(finalList); 
//			}
//		}
		return bdCustomerDto;
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#listAffiliates(java.lang.String, int, int)
	 */
	@Override
	public BDCustomerDto listAffiliates(String loginId, int pageSize, int pageNum) {
		return bdManageCorporateUsersService.listAffiliates(loginId, pageSize, pageNum,"default");
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#addAffiliates(com.bluedart.common.dto.BDCustomerDto)
	 */
	@Override
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto) {
		return CAManageCorpUsersDao.addAffiliates(bdCustDto);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#deleteAffiliates(com.bluedart.common.dto.BDCustomerDto)
	 */
	@Override
	public ValidCustomerDto deleteAffiliates(BDCustomerDto bdCustDto) {
		return bdManageCorporateUsersService.deleteAffiliates(bdCustDto);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#saveAffPermissions(com.bluedart.bdmanagecorporateusers.dto.PermissionMappingDto)
	 */
	@Override
	public ValidCustomerDto saveAffPermissions(PermissionMappingDto perMappingDto) {
		return bdManageCorporateUsersService.saveAffPermissions(perMappingDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#saveLoginPermissions(com.bluedart.bdmanagecorporateusers.dto.PermissionMappingDto)
	 */
	@Override
	public ValidCustomerDto saveLoginPermissions(PermissionMappingDto perMappingDto) {
		return bdManageCorporateUsersService.saveLoginPermissions(perMappingDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#resetUserPassword(com.bluedart.bdmanagecorporateusers.dto.CorporateUserDto)
	 */
	@Override
	public ValidCustomerDto resetUserPassword(CorporateUserDto corporateUserDto) {
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		validCustomerDto = bdManageCorporateUsersService.resetUserPassword(corporateUserDto);
		if(validCustomerDto!=null && validCustomerDto.getValidFlag().equalsIgnoreCase(BDAdminConstants.SUCCESS)){
			CorporateNotificationDto notificationDto = new CorporateNotificationDto();
			notificationDto.setCorporateUserDto(corporateUserDto);
			notificationDto.setAction("RESET_PWD_CORP_USER");
			boolean isMailSent = caNotificationHelper.sendEmailNotification(notificationDto );
			validCustomerDto.setEmailSent(isMailSent); 
		}
		return validCustomerDto;
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#activateOrDeactivate(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	public ValidCustomerDto activateOrDeactivate(CorporateUserDto corporateUserDto) {
		return CAManageCorpUsersDao.activateOrDeactivate(corporateUserDto);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#editCorpUser(com.bluedart.manageuserCA.dto.UserBasicDetailsDto)
	 */
	@Override
	public ValidCustomerDto editCorpUser(UserBasicDetailsDto userBasicDetails) {
		return CAManageCorpUsersDao.editCorpUser(userBasicDetails);
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#saveAuditLog(com.bluedart.common.dto.AuditDto)
	 */
	@Override
	public AuditDto saveAuditLog(AuditDto auditDto) {
		return bdManageCorporateUsersService.saveAuditLog(auditDto);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.service.CAManageCorpUsersService#deleteAuditLog(com.bluedart.common.dto.AuditDto)
	 */
	@Override
	public ValidCustomerDto deleteAuditLog(AuditDto auditDto){
		return bdManageCorporateUsersService.deleteAuditLog(auditDto);
	}
}
