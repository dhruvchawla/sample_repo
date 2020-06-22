package com.bluedart.manageuserCA.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.manageuserCA.dto.ClientAdminResponseDto;

@RestController
public class CAManageCorpUsersController2 {

	@RequestMapping(value = "camanageusers/listusers", method = RequestMethod.POST)
	public ResponseEntity<ClientAdminResponseDto> listCorpUsers(@PathVariable String adminLoginId,
			                                            @PathVariable String alphabet) {
		ClientAdminResponseDto clResponseDto = new ClientAdminResponseDto();
	//	clResponseDto = clientAdminService.createNewUser(userBasicDetails);
		clResponseDto.setStatusCode("OK");		
		return new ResponseEntity(clResponseDto, HttpStatus.OK);
	}
	
}
