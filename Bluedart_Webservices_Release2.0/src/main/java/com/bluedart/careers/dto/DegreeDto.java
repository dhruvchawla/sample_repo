package com.bluedart.careers.dto;

import java.io.Serializable;
/**
 * @author CH848113
 */
public class DegreeDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String degreeId;
	private String degreeDescription;
	
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public String getDegreeDescription() {
		return degreeDescription;
	}
	public void setDegreeDescription(String degreeDescription) {
		this.degreeDescription = degreeDescription;
	}
	
	
	

}
