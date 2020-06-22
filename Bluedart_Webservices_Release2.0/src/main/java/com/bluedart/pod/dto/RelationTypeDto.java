package com.bluedart.pod.dto;

import java.io.Serializable;

/**
 * @author AK765612
 *
 */
public class RelationTypeDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public String relationDesc;
	public String relationDescCode;
	
	public String getRelationDescCode() {
		return relationDescCode;
	}
	public void setRelationDescCode(String relationDescCode) {
		this.relationDescCode = relationDescCode;
	}
	/**
	 * @return the relationDesc
	 */
	public String getRelationDesc() {
		return relationDesc;
	}
	/**
	 * @param relationDesc the relationDesc to set
	 */
	public void setRelationDesc(String relationDesc) {
		this.relationDesc = relationDesc;
	}
	
	
}
