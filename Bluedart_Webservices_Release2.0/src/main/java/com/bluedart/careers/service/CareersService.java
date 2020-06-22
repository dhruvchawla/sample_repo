package com.bluedart.careers.service;

import com.bluedart.careers.dto.ApplyJobDto;
import com.bluedart.careers.dto.JobPostsDto;
import com.bluedart.exception.BlueDartException;

/*
 * @author CH848113 
 */

public interface CareersService {
	
	public ApplyJobDto renderApplyJob()throws BlueDartException;
	
	public JobPostsDto getJobs()throws BlueDartException;
	
	public ApplyJobDto applyJob(ApplyJobDto applyJob)throws BlueDartException;
	
	public JobPostsDto getJobDescription(String jobOpeningId) throws BlueDartException;
}
