package com.bluedart.careers.dto;

import java.io.Serializable;
import java.util.List;

public class JobPostsDto implements Serializable {
	/**
	 * @author CH848113
	 */
	private static final long serialVersionUID = 1L;
	private String loginId;
	private List<JobPostDto> jobPostDto;
	private String statusCode;
	private String statusMessage;
	
	private String jobOpeningId;
	private String jobDescription;
	

	private int pageSize;
	private int pageNumber;
	private int totalCount;;
	
	public List<JobPostDto> getJobPostDto() {
		return jobPostDto;
	}

	public void setJobPostDto(List<JobPostDto> jobPostDto) {
		this.jobPostDto = jobPostDto;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getJobOpeningId() {
		return jobOpeningId;
	}

	public void setJobOpeningId(String jobOpeningId) {
		this.jobOpeningId = jobOpeningId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
