package com.bluedart.pod.dto;

import java.io.Serializable;

/**
 * @author AK765612
 *
 */    
public class IdentificationTypeDto implements Serializable  {
	private static final long serialVersionUID = 1L;
	public String identificationDesc;
	public String identificationType;

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * @return the identificationDesc
	 */
	public String getIdentificationDesc() {
		return identificationDesc;
	}

	/**
	 * @param identificationDesc the identificationDesc to set
	 */
	public void setIdentificationDesc(String identificationDesc) {
		this.identificationDesc = identificationDesc;
	}

	
	
}
