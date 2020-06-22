package com.bluedart.common.dto;

import java.io.Serializable;

public class SchedulerDto implements Serializable{

	/**
	 * CH848113
	 */
	private static final long serialVersionUID = 1L;
	
	private String schedulerName;
	private String schedulerInterval;
	private String schedulerRunFlag;
	private String schedulerJob;
	private String schedulerGroup;
	private String schedulerTrigger;
	
	public String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public String getSchedulerInterval() {
		return schedulerInterval;
	}
	public void setSchedulerInterval(String schedulerInterval) {
		this.schedulerInterval = schedulerInterval;
	}
	public String getSchedulerRunFlag() {
		return schedulerRunFlag;
	}
	public void setSchedulerRunFlag(String schedulerRunFlag) {
		this.schedulerRunFlag = schedulerRunFlag;
	}
	public String getSchedulerJob() {
		return schedulerJob;
	}
	public void setSchedulerJob(String schedulerJob) {
		this.schedulerJob = schedulerJob;
	}
	public String getSchedulerGroup() {
		return schedulerGroup;
	}
	public void setSchedulerGroup(String schedulerGroup) {
		this.schedulerGroup = schedulerGroup;
	}
	public String getSchedulerTrigger() {
		return schedulerTrigger;
	}
	public void setSchedulerTrigger(String schedulerTriger) {
		this.schedulerTrigger = schedulerTriger;
	}
	

}
