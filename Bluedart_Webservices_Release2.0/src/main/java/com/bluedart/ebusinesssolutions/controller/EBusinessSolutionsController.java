package com.bluedart.ebusinesssolutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bluedart.ebusinesssolutions.dto.EBusinessSolutionsDto;
import com.bluedart.ebusinesssolutions.service.EBusinessSolutionsService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;

/*
 * @author CH848113 
 */
@RestController
public class EBusinessSolutionsController {

	@Autowired
	private EBusinessSolutionsService eBusinessSolutionsService; 
	
	@RequestMapping(value = "/ebusinesssolutions/submitebusinesssolutions", method = RequestMethod.POST)
	public EBusinessSolutionsDto submitEBusinessSolution(@RequestBody EBusinessSolutionsDto eBusinessSolutions) throws BlueDartException{
	
		EBusinessSolutionsDto eBusinessSolutionsDto = new EBusinessSolutionsDto();
		eBusinessSolutionsDto.setEmailSent(eBusinessSolutionsService.submitEBusinessSolutions(eBusinessSolutions));
		eBusinessSolutionsDto.setStatusCode(Constants.SUCESSCODE);
		eBusinessSolutionsDto.setStatusMessage(Constants.SUCESSMESSAGE);
		return eBusinessSolutionsDto;
		
	}
	
	@ExceptionHandler(DataBaseException.class)
	private EBusinessSolutionsDto myError(DataBaseException serviceException) {
		EBusinessSolutionsDto eBusinessSolutionsDto = new EBusinessSolutionsDto();
		eBusinessSolutionsDto.setStatusCode(serviceException.getErrorCode());
		eBusinessSolutionsDto.setStatusMessage(serviceException.getErrorMessage());
	    return eBusinessSolutionsDto;
	}
	
	@ExceptionHandler(BlueDartException.class)
	private EBusinessSolutionsDto emailServiceError(BlueDartException serviceException) {
		EBusinessSolutionsDto eBusinessSolutionsDto = new EBusinessSolutionsDto();
		eBusinessSolutionsDto.setStatusCode(serviceException.getErrorCode());
		eBusinessSolutionsDto.setStatusMessage(serviceException.getErrorMessage());
	    return eBusinessSolutionsDto;
	}
	
}
