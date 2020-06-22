package com.bluedart.mguserviewprofile.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.mguserviewprofile.dto.ManageUserViewProfileDto;
import com.bluedart.mguserviewprofile.service.ManageUserViewProfileService;
import com.bluedart.exception.BlueDartException;


@RestController
public class ManageUserViewProfile {

	@Autowired
	ManageUserViewProfileService manageUserViewProfileService;

	@RequestMapping(value = "viewprofile/mguserviewprofile/{userId}/{loginId}", method = RequestMethod.GET, headers="Accept=application/json")
	public ManageUserViewProfileDto manageUserViewProfile(@PathVariable String userId,@PathVariable String loginId) throws BlueDartException {
		ManageUserViewProfileDto viewProfileList = manageUserViewProfileService.manageUserViewProfile(userId,loginId);
		return viewProfileList;	
	}

	@ExceptionHandler(BlueDartException.class)
	private ManageUserViewProfileDto myError(BlueDartException ttfException) {
		ManageUserViewProfileDto dto = new ManageUserViewProfileDto();
		dto.setErrorCode(ttfException.getErrorCode());
		dto.setErrorMessage(ttfException.getErrorMessage());
		return dto;
	}	
}
