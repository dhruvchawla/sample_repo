package com.bluedart.careers.dto;

import java.io.Serializable;

/**
 * @author CH848113
 */
public class ExperienceDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private String employeer;
	private String jobTitle;
	private String employeerContactNumber;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEmployeer() {
		return employeer;
	}
	public void setEmployeer(String employeer) {
		this.employeer = employeer;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmployeerContactNumber() {
		return employeerContactNumber;
	}
	public void setEmployeerContactNumber(String employeerContactNumber) {
		this.employeerContactNumber = employeerContactNumber;
	}
	
	
}
