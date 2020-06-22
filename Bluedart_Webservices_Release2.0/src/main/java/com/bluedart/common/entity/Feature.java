package com.bluedart.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author TH334025
 *
 */
@Entity
@Table(name = "UPROFILE4.FEATURE_T")
public class Feature {
	
	@Id
	@Column(name = "FEATUREID")
	private Integer featureId;
	
	   
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "INSERTION_DATE")
	private Date insertionDate;
	
	@Column(name = "ENABLE_FLAG")
	private String enableFlag;

	/**
	 * @return the featureId
	 */
	public Integer getFeatureId() {
		return featureId;
	}

	/**
	 * @param featureId the featureId to set
	 */
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the insertionDate
	 */
	public Date getInsertionDate() {
		return insertionDate;
	}

	/**
	 * @param insertionDate the insertionDate to set
	 */
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	
	
	
	
}
