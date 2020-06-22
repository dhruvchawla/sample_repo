package com.bluedart.camanagecorpusers.service;

import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.camanagecorpusers.dto.ClientUserDto;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
/**
 * Service interface to manage corporate users
 * @author PR334023
 *
 */
public interface CAManageCorpUsersService {
	
	public String getCARegion(String adminLoginId);

	public ClientUserDto getNoOfUsers(String adminLoginId);
	
	public ClientUserDto verifyAdminAffiliate(String adminLoginId, String areaCode, String custCode);
	
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto);
            
	public ValidCustomerDto createCorpUser(UserBasicDetailsDto userBasicDetails);
	
	public ClientUserDto searchAffiliates(String areaCode, String custCode,
			String adminLoginId, String userLoginId, int pageSize, int pageNumber);
	
	public BDCustomerDto listAffiliates(String loginId, int pageSize, int pageNum);
	
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto);
	
	public ValidCustomerDto deleteAffiliates(BDCustomerDto bdCustDto);
	
	public BDCustomerDto getAffPermissions(String areaCode,String custCode, String adminLoginId, String userLoginId);
	
	public ValidCustomerDto saveAffPermissions(PermissionMappingDto perMappingDto);
	
	public BDCustomerDto getLoginPermissions(String adminLoginId, String userLoginId);
	
	public ValidCustomerDto saveLoginPermissions(PermissionMappingDto perMappingDto);
	
	public ValidCustomerDto resetUserPassword(CorporateUserDto corporateUserDto);
	
	public ValidCustomerDto activateOrDeactivate(CorporateUserDto corporateUserDto);
 
	public ValidCustomerDto editCorpUser(UserBasicDetailsDto userBasicDetails);
	
	public AuditDto saveAuditLog(AuditDto auditDto);
	
	public ValidCustomerDto deleteAuditLog(AuditDto auditDto);

}
