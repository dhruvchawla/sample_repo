package com.bluedart.careers.dto;

import java.io.Serializable;
/**
 * @author CH848113
 */
public class LanguageDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String languageId;
	private String languageDescription;
	
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public String getLanguageDescription() {
		return languageDescription;
	}
	public void setLanguageDescription(String languageDescription) {
		this.languageDescription = languageDescription;
	}
	

}
