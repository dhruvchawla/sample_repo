package com.bluedart.careers.dto;

import java.io.Serializable;

public class JobPostDto implements Serializable {
	/**
	 * @author CH848113
	 */
	private static final long serialVersionUID = 1L;
	
	private String jobOpeningId;
	private String jobTitle;
	private String jobPostDate;
	private String jobLocation;
	private String jobDepartment;
	private String description;
	
	public String getJobOpeningId() {
		return jobOpeningId;
	}
	public void setJobOpeningId(String jobOpeningId) {
		this.jobOpeningId = jobOpeningId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobPostDate() {
		return jobPostDate;
	}
	public void setJobPostDate(String jobPostDate) {
		this.jobPostDate = jobPostDate;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJobDepartment() {
		return jobDepartment;
	}
	public void setJobDepartment(String jobDepartment) {
		this.jobDepartment = jobDepartment;
	}
	
	
	


}
