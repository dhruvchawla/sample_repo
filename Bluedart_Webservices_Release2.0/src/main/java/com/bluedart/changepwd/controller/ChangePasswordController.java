package com.bluedart.changepwd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.changepwd.dto.ChangePasswordResponseDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.changepwd.service.ChangePasswordService;
/**
 * 
 * @author PR334023
 *
 */
@RestController
public class ChangePasswordController {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	/**
	 * @param loginId
	 * @param oldPassword
	 * @return
	 */
	@RequestMapping(value = "corporatechangepassword/checkexistingpassword/{loginId}/{oldPassword}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ChangePasswordResponseDto checkExistingPassword(@PathVariable String loginId, @PathVariable String oldPassword){
		ChangePasswordResponseDto chResponseDto = null;
		chResponseDto = changePasswordService.checkExistingPassword(loginId, oldPassword);
		chResponseDto.setStatusCode("OK");
		return chResponseDto;
	}
	/**
	 * @param changePwdDto
	 * @return
	 */
	@RequestMapping(value = "corporatechangepassword/changepassword", method = RequestMethod.POST)
	public ResponseEntity<ChangePasswordResponseDto> changePassword(@RequestBody ChangePasswordResponseDto changePwdDto){
		ChangePasswordResponseDto chResponseDto = null;
		chResponseDto = changePasswordService.changePassword(changePwdDto);
		chResponseDto.setStatusCode("OK");
		return new ResponseEntity( chResponseDto, HttpStatus.OK);
	}
	
	/**
	 * @param chException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private ChangePasswordResponseDto myError(BlueDartException chException) {
		ChangePasswordResponseDto chDto = new ChangePasswordResponseDto();
		chDto.setStatusCode(chException.getErrorCode());
		chDto.setErrorMessage(chException.getErrorMessage());
	    return chDto;
	}
	
}