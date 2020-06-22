package com.bluedart.bdmanagecorporateusers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService;
import com.bluedart.common.dto.AffiliateDetailDto;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.StatusDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author PR334023
 * Rest Controller for Managing Corporate Users and their Permissions by BlueDart Admin
 *
 */
@RestController
public class BDManageCorporateUsersController {

	@Autowired
	private BDManageCorporateUsersService bdManageCorporateUsersService;
	
	/**
	 * @param usersSearchDto
	 * @return UserDetailDto
	 * This method gives the list of users under a bd admin
	 */
	@RequestMapping(value = "/bdmanagecorpusers/listUsers", method = RequestMethod.POST)
	public ResponseEntity<CustomerResponseDto> listUsers(@RequestBody UsersSearchDto usersSearchDto) {
		CustomerResponseDto customerResponseDto = null;
		customerResponseDto = bdManageCorporateUsersService.listUsers(usersSearchDto);
		customerResponseDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(customerResponseDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param emailID
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/{emailID}/createsendotp", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<ValidCustomerDto> createSendOTP(@PathVariable("emailID") String emailID) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.createSendOTP(emailID);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/validateusercreation", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> validateUserCreation(@RequestBody CorporateUserDto corporateUserDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.validateUserCreation(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param userName
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/validateusername/{emailId}/{userName}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<ValidCustomerDto> validateUserName(@PathVariable("userName") String userName,@PathVariable("emailId") String emailId){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.validateUserName(userName, emailId);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bdmanagecorpusers/addcustomeremaildata", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> addCustomerEmailData(@RequestBody CorporateUserDto corporateUserDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.addCustomerEmailData(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/createcorpuser", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> createCorpUser(@RequestBody CorporateUserDto corporateUserDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.createCorpUser(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param corporateUserDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/editcorpuser", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> editCorpUser(@RequestBody CorporateUserDto corporateUserDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.editCorpUser(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param loginId
	 * @param pageSize
	 * @param pageNum
	 * @return BDCustomerDto
	 * This method gives list of affiliates under a corporate admin
	 */
	@RequestMapping(value = "/bdmanagecorpusers/listAffiliates/{loginId}/{pageSize}/{pageNum}/{orderBy}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> listAffiliates(@PathVariable("loginId") String loginId,@PathVariable("pageSize") int pageSize,@PathVariable("pageNum") int pageNum,@PathVariable("orderBy") String orderBy) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = bdManageCorporateUsersService.listAffiliates(loginId, pageSize, pageNum,orderBy);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/bdmanagecorpusers/getaffusers", method = RequestMethod.POST)
	public ResponseEntity<BDCustomerDto> getAffUsers(@RequestBody BDCustomerDto bdCustDto) {
		BDCustomerDto bdCustomerDto = null; 
		bdCustomerDto = bdManageCorporateUsersService.getAffUsers(bdCustDto);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param affList
	 * @return Boolean
	 * This method adds affiliates under a corporate admin
	 */
	@RequestMapping(value = "/bdmanagecorpusers/addAffiliates", method = RequestMethod.POST)
	public ResponseEntity<BDCustomerDto> addAffiliates(@RequestBody BDCustomerDto bdCustDto) {
		BDCustomerDto bdCustomerDto = null; 
		bdCustomerDto = bdManageCorporateUsersService.addAffiliates(bdCustDto);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @param adminLoginId
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/listuserswithaff/{areaCode}/{custCode}/{adminLoginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> listUsersWithAff(@PathVariable("areaCode") String areaCode, @PathVariable("custCode") String custCode, @PathVariable("adminLoginId") String adminLoginId){
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = bdManageCorporateUsersService.listUsersWithAff(areaCode, custCode, adminLoginId);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}
	/**
	 * @param affList
	 * @return Boolean
	 * This method deletes affiliates under a corporate admin
	 */
	@RequestMapping(value = "/bdmanagecorpusers/deleteAffiliates", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> deleteAffiliates(@RequestBody BDCustomerDto bdCustDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.deleteAffiliates(bdCustDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * @param areaCode
	 * @param customerCode
	 * @return perDtoList
	 */
	@RequestMapping(value = "/bdmanagecorpusers/getAffPermissions/{areaCode}/{custCode}/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> getAffPermissions(@PathVariable("areaCode") String areaCode, @PathVariable("custCode") String custCode, 
			@PathVariable("loginId") String loginId) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = bdManageCorporateUsersService.getAffPermissions(areaCode,custCode,loginId);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}	
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/getaffpermusers", method = RequestMethod.POST)
	public ResponseEntity<BDCustomerDto> getAffPermUsers(@RequestBody PermissionMappingDto perMappingDto) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = bdManageCorporateUsersService.getAffPermUsers(perMappingDto);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}	
	/**
	 * 
	 * @param perMapList
	 * @return ValidCustomerDto
	 */
	@RequestMapping(value = "/bdmanagecorpusers/saveAffPermissions", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> saveAffPermissions(@RequestBody PermissionMappingDto perMapDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.saveAffPermissions(perMapDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/savecascadedaffper", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> saveCascadedAffPermissions(@RequestBody PermissionMappingDto perMappingDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.saveCascadedAffPermissions(perMappingDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	
	/**
	 * @param loginId
	 * @return perDtoList
	 */
	@RequestMapping(value = "/bdmanagecorpusers/getLoginPermissions/{loginId}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> getLoginPermissions(@PathVariable("loginId") String loginId) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = bdManageCorporateUsersService.getLoginPermissions(loginId);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}	
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/getloginpermusers", method = RequestMethod.POST)
	public ResponseEntity<BDCustomerDto> getLoginPermUsers(@RequestBody PermissionMappingDto perMappingDto) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = bdManageCorporateUsersService.getLoginPermUsers(perMappingDto);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}	
	/**
	 * @param permissionMappingDto
	 * @return Boolean
	 */
	@RequestMapping(value = "/bdmanagecorpusers/saveLoginPermissions", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> saveLoginPermissions(@RequestBody PermissionMappingDto perMappingDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.saveLoginPermissions(perMappingDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/savecascadedloginper", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> saveCascadedLoginPermissions(@RequestBody PermissionMappingDto perMappingDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.saveCascadedLoginPermissions(perMappingDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	
	/**
	 * @param adminLoginId
	 * @param userLoginId
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/resetUserPassword", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> resetUserPassword(@RequestBody CorporateUserDto corporateUserDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.resetUserPassword(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	} 
	/**
	 * 
	 * @param adminLoginId
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/getUsersToUpdateStatus/{adminLoginId}/{status}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<CustomerResponseDto> getUsersToUpdateStatus(@PathVariable("adminLoginId") String adminLoginId,
			@PathVariable("status") String status) {
		CustomerResponseDto customerResponseDto = null;
		customerResponseDto = bdManageCorporateUsersService.getUsersToUpdateStatus(adminLoginId,status);
		customerResponseDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(customerResponseDto, HttpStatus.OK);
	}
	/**
	 * @param adminLoginId
	 * @param userLoginId
	 * @return Boolean
	 */
	@RequestMapping(value = "/bdmanagecorpusers/updatestatus", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> activateOrDeactivate(@RequestBody CustomerResponseDto custResponseDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.activateOrDeactivate(custResponseDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param auditDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/saveauditlog", method = RequestMethod.POST)
	public ResponseEntity<AuditDto> saveAuditLog(@RequestBody AuditDto auditDto){
		AuditDto audDto = null;
		audDto = bdManageCorporateUsersService.saveAuditLog(auditDto); 
		audDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(audDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param auditDto
	 * @return
	 */
	@RequestMapping(value = "/bdmanagecorpusers/deleteauditlog", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> deleteAuditLog(@RequestBody AuditDto auditDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = bdManageCorporateUsersService.deleteAuditLog(auditDto); 
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private StatusDto ManageAdminUsersException(DataBaseException serviceException) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(serviceException.getErrorCode());
		statusDto.setStatusMessage(serviceException.getErrorMessage());
		return statusDto;
	}
	/**
	 * 
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private StatusDto ManageAdminUsersException(BlueDartException serviceException) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(serviceException.getErrorCode());
		statusDto.setStatusMessage(serviceException.getErrorMessage());
		return statusDto;
	}
	
}