package com.bluedart.careers.controller;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.careers.dto.ApplyJobDto;
import com.bluedart.careers.dto.JobPostsDto;
import com.bluedart.careers.service.CareersService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;

/*
 * @author CH848113 
 */
@RestController
public class CareersController {
	
	
	@Autowired
	private CareersService careersService; 
	
	@RequestMapping(value = "/careers/renderapplyjob", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApplyJobDto renderApplyJob() throws BlueDartException{
	
		ApplyJobDto applyJob = careersService.renderApplyJob();
		
		applyJob.setStatusCode(Constants.SUCESSCODE);
		applyJob.setStatusMessage(Constants.SUCESSMESSAGE);
		return applyJob;

	}
	
	
	
	
	
	@RequestMapping(value = "/careers/jobdescription/{jobOpeningId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public JobPostsDto getJobDescription(@PathVariable String jobOpeningId) throws BlueDartException, RemoteException {
		System.out.println("jobOpeningId------------------------"+jobOpeningId);
	
		JobPostsDto jobs = careersService.getJobDescription(jobOpeningId);
		
		jobs.setStatusCode(Constants.SUCESSCODE);
		jobs.setStatusMessage(Constants.SUCESSMESSAGE);
		return jobs;
		
	}
	
	
	@RequestMapping(value = "/careers/jobposts", method = RequestMethod.GET, headers = "Accept=application/json")
	public JobPostsDto getJobs() throws BlueDartException{
	
		JobPostsDto jobs = careersService.getJobs();
		
		jobs.setStatusCode(Constants.SUCESSCODE);
		jobs.setStatusMessage(Constants.SUCESSMESSAGE);
		return jobs;

	}
	
	
	@RequestMapping(value = "/careers/applyjob", method = RequestMethod.POST)
	public ApplyJobDto applyJob(@RequestBody ApplyJobDto applyJobDto) throws BlueDartException{
		System.out.println("ApplyJobDto-----------URL-------------");
		ApplyJobDto applyJobResponse = new ApplyJobDto();
		applyJobResponse = careersService.applyJob(applyJobDto);
		applyJobResponse.setStatusCode(Constants.SUCESSCODE);
		applyJobResponse.setStatusMessage(Constants.SUCESSMESSAGE);
		return applyJobResponse;
		
	}
	
/*
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
	}*/
	
}
