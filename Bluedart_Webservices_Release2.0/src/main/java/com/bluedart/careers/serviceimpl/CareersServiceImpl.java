package com.bluedart.careers.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.careers.dto.ApplyJobDto;
import com.bluedart.careers.dto.JobPostDto;
import com.bluedart.careers.dto.JobPostsDto;
import com.bluedart.careers.service.CareersService;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.exception.BlueDartException;
import com.bluedart.masters.dao.MasterDao;
import com.bluedart.masters.dto.CountryDto;
import com.bluedart.masters.dto.StateDto;
/**
 * @author CH848113
 */

@Service
public class CareersServiceImpl implements CareersService{
	private static final Logger logger = Logger.getLogger(CareersServiceImpl.class); 


	@Autowired
	private MasterDao masterDao;
	
	private String featureName = null;
	
	@Autowired
	private MISLogDao misLogDao;
	
	
	

	@Override
	public ApplyJobDto renderApplyJob() throws BlueDartException{
		ApplyJobDto applyJob = new ApplyJobDto();
		
		List<StateDto> states = masterDao.getStates();
		List<CountryDto> countrys = masterDao.getCountries();
		applyJob.setStates(states);
		applyJob.setCountrys(countrys);
		
		//2 more list languages and degrees should be set once webservice issues is resolved.
		
		return applyJob;
	}
	
	


	@Override
	public JobPostsDto getJobs() throws BlueDartException {
		JobPostsDto jobPosts =  new JobPostsDto();
		
		// call here for 3rd party service
		// below are set only for testing
		List<JobPostDto> jobPostList = new ArrayList<>();
		
		JobPostDto jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1001");
		jobPostDto.setJobTitle("Software Engineer");
		jobPostDto.setJobLocation("Bangalore");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1002");
		jobPostDto.setJobTitle("Tech Lead");
		jobPostDto.setJobLocation("Hyderbad");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1003");
		jobPostDto.setJobTitle("Tester");
		jobPostDto.setJobLocation("Delhi");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1004");
		jobPostDto.setJobTitle("UI Developer");
		jobPostDto.setJobLocation("Mumbai");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1005");
		jobPostDto.setJobTitle("HR");
		jobPostDto.setJobLocation("Chennai");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1006");
		jobPostDto.setJobTitle("Software Engineer");
		jobPostDto.setJobLocation("Bangalore");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1007");
		jobPostDto.setJobTitle("Tech Lead");
		jobPostDto.setJobLocation("Hyderbad");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1008");
		jobPostDto.setJobTitle("Tester");
		jobPostDto.setJobLocation("Delhi");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1009");
		jobPostDto.setJobTitle("UI Developer");
		jobPostDto.setJobLocation("Mumbai");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1011");
		jobPostDto.setJobTitle("UI Developer");
		jobPostDto.setJobLocation("Mumbai");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		jobPostDto = new JobPostDto();
		jobPostDto.setJobOpeningId("1010");
		jobPostDto.setJobTitle("HR");
		jobPostDto.setJobLocation("Chennai");
		jobPostDto.setJobDepartment("Computer Applications");
		jobPostDto.setJobPostDate("06-12-2017");
		jobPostList.add(jobPostDto);
		
		
		jobPosts.setJobPostDto(jobPostList);
		jobPosts.setTotalCount(jobPosts.getJobPostDto().size());
		System.out.println("List of Jobs-------------------"+jobPosts.getJobPostDto().size());
		return jobPosts;
		
	}
	
	@Override
	public JobPostsDto getJobDescription(String jobOpeningId) throws BlueDartException {
		JobPostsDto jobPosts =  new JobPostsDto();
		
		// call here for 3rd party service
		// below are set only for testing
		jobPosts.setJobOpeningId(jobOpeningId);
		
		String jobDescription = "<h3>DESCRIPTION OF DUTIES</h3><h5>Responsibility</h5>	";
		jobPosts.setJobDescription(jobDescription);
		
		
		return jobPosts;
		
	}


	@Override
	public ApplyJobDto applyJob(ApplyJobDto applyJob) throws BlueDartException {
		ApplyJobDto applyJobResponse = null;
		// call here for 3rd party service, 5 webservice.
		
		
		
		
		System.out.println(applyJob.getGeneralInformationDto().getFirstName());
		System.out.println("Experience Details :"+applyJob.getExperiences().size());
		System.out.println("Language Details :"+applyJob.getLanguages().size());
		System.out.println("Degrees Details :"+applyJob.getDegrees().size());
		
		return applyJobResponse;
	}


	
	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.info("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.info("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}

}
