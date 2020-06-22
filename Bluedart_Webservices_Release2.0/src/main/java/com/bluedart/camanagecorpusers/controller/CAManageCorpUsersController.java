package com.bluedart.camanagecorpusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.camanagecorpusers.dto.ClientUserDto;
import com.bluedart.camanagecorpusers.service.CAManageCorpUsersService;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.utils.ErrorMessageStatusCode;
/**
 * Class to implement corporate admin managing corporate users
 * @author PR334023
 *
 */
@RestController
public class CAManageCorpUsersController {

	@Autowired
	private CAManageCorpUsersService caManageCorpUsersService;
	
	
	@RequestMapping(value = "/camanageusers/getcaregion/{adminloginid}", method = RequestMethod.GET,headers="Accept=application/json")
	public String getCARegion(@PathVariable("adminloginid") String adminloginid) {
		return caManageCorpUsersService.getCARegion(adminloginid);
	}
	
	@RequestMapping(value = "/camanageusers/getnoofusers/{adminloginid}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<ClientUserDto> getNoOfUsers(@PathVariable("adminloginid") String adminloginid) {
		ClientUserDto clientUserDto = caManageCorpUsersService.getNoOfUsers(adminloginid);
		return new ResponseEntity(clientUserDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/camanageusers/verifyadminaff/{adminLoginId}/{areaCode}/{custCode}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<ClientUserDto> verifyAdminAffiliate(@PathVariable("adminLoginId") String adminLoginId,@PathVariable("areaCode") String areaCode,@PathVariable("custCode") String custCode){
		ClientUserDto clientUserDto = caManageCorpUsersService.verifyAdminAffiliate(adminLoginId, areaCode, custCode);
		return new ResponseEntity(clientUserDto, HttpStatus.OK);
	}
	
	/**
	 * Method to list corporate users
	 * @param adminLoginId
	 * @param alphabet
	 * @return
	 */
	@RequestMapping(value = "/camanagecorpusers/listUsers", method = RequestMethod.POST)
	public ResponseEntity<CustomerResponseDto> listUsers(@RequestBody UsersSearchDto usersSearchDto) {
		CustomerResponseDto customerResponseDto = null;
		customerResponseDto = caManageCorpUsersService.listUsers(usersSearchDto);
		customerResponseDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(customerResponseDto, HttpStatus.OK);
	}
	/**
	 * Method to create new crporate user
	 * @param userBasicDetails
	 * @return
	 */
	@RequestMapping(value = "camanageusers/createcorpuser", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> createCorpUser(@RequestBody UserBasicDetailsDto userBasicDetails) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.createCorpUser(userBasicDetails);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());		
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to update corporate user details
	 * @param userBasicDetails
	 * @return
	 */
	@RequestMapping(value = "camanageusers/editcorpuser", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> editCorpUser(@RequestBody UserBasicDetailsDto userBasicDetails) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.editCorpUser(userBasicDetails);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());		
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to search affiliates
	 * @param areaCode
	 * @param custCode
	 * @param adminLoginId
	 * @param userLoginId
	 * @return
	 */
	@RequestMapping(value = "camanageusers/searchaffiliates/{areacode}/{custcode}/{adminloginid}/{userloginid}/{pagesize}/{pagenumber}", 
			                             method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ClientUserDto> searchAffiliates(@PathVariable("areacode") String areaCode,@PathVariable("custcode") String custCode,
			@PathVariable("adminloginid") String adminLoginId, @PathVariable("userloginid") String userLoginId, @PathVariable("pagesize") int pageSize, 
			@PathVariable("pagenumber") int pageNumber) {
		ClientUserDto clientUserDto = caManageCorpUsersService.searchAffiliates(areaCode, custCode, adminLoginId, userLoginId, pageSize, pageNumber);
		clientUserDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(clientUserDto, HttpStatus.OK);
	}
	/**
	 * Method to list affiliates
	 * @param loginId
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/listaffiliates/{loginid}/{pagesize}/{pagenumber}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> listAffiliates(@PathVariable("loginid") String loginId,@PathVariable("pagesize") int pageSize,@PathVariable("pagenumber") int pageNum) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = caManageCorpUsersService.listAffiliates(loginId, pageSize, pageNum);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	} 
	/**
	 * Method to add affiliates
	 * @param bdCustDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/addaffiliates", method = RequestMethod.POST)
	public ResponseEntity<BDCustomerDto> addAffiliates(@RequestBody BDCustomerDto bdCustDto) {
		BDCustomerDto bdCustomerDto = null; 
		bdCustomerDto = caManageCorpUsersService.addAffiliates(bdCustDto);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to delete affiliates
	 * @param bdCustDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/deleteaffiliates", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> deleteAffiliates(@RequestBody BDCustomerDto bdCustDto) {
		ValidCustomerDto bdCustomerDto = null;
		bdCustomerDto = caManageCorpUsersService.deleteAffiliates(bdCustDto);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to get affiliate permissions
	 * @param areaCode
	 * @param custCode
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/getaffpermissions/{areacode}/{custcode}/{adminloginid}/{userloginid}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> getAffPermissions(@PathVariable("areacode") String areaCode, @PathVariable("custcode") String custCode, 
			@PathVariable("adminloginid") String adminLoginId, @PathVariable("userloginid") String userLoginId) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = caManageCorpUsersService.getAffPermissions(areaCode,custCode,adminLoginId,userLoginId);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}	
	/**
	 * Method to save affiliate permissions
	 * @param perMapDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/saveaffpermissions", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> saveAffPermissions(@RequestBody PermissionMappingDto perMapDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.saveAffPermissions(perMapDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to get login permissions
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/getloginpermissions/{adminloginId}/{userloginid}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<BDCustomerDto> getLoginPermissions(@PathVariable("adminloginId") String adminLoginId,@PathVariable("userloginid") String userLoginId) {
		BDCustomerDto bdCustomerDto = null;
		bdCustomerDto = caManageCorpUsersService.getLoginPermissions(adminLoginId,userLoginId);
		bdCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(bdCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to save login permissions
	 * @param perMappingDto
	 * @return  
	 */
	@RequestMapping(value = "/camanageusers/saveloginpermissions", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> saveLoginPermissions(@RequestBody PermissionMappingDto perMappingDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.saveLoginPermissions(perMappingDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to reset user password
	 * @param corporateUserDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/resetuserpassword", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> resetUserPassword(@RequestBody CorporateUserDto corporateUserDto) {
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.resetUserPassword(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	} 
	/**
	 * Method to activate or Deactivate user
	 * @param corporateUserDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/activateordeactivate", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> activateOrDeactivate(@RequestBody CorporateUserDto corporateUserDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.activateOrDeactivate(corporateUserDto);
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
	/**
	 * Method to save audit log values
	 * @param auditDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/saveauditlog", method = RequestMethod.POST)
	public ResponseEntity<AuditDto> saveAuditLog(@RequestBody AuditDto auditDto){
		AuditDto audDto = null;
		audDto = caManageCorpUsersService.saveAuditLog(auditDto); 
		audDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(audDto, HttpStatus.OK);
	}
	
	/**
	 * Method to delete audit log values
	 * @param auditDto
	 * @return
	 */
	@RequestMapping(value = "/camanageusers/deleteauditlog", method = RequestMethod.POST)
	public ResponseEntity<ValidCustomerDto> deleteAuditLog(@RequestBody AuditDto auditDto){
		ValidCustomerDto validCustomerDto = null;
		validCustomerDto = caManageCorpUsersService.deleteAuditLog(auditDto); 
		validCustomerDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(validCustomerDto, HttpStatus.OK);
	}
}