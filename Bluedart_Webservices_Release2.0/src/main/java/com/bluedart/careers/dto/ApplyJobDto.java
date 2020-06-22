package com.bluedart.careers.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.masters.dto.CountryDto;
import com.bluedart.masters.dto.StateDto;
/**
 * @author CH848113
 */
public class ApplyJobDto implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private String loginId;
	private String personId;
	private String jobOpeningId;
	//private String applicantId;
	private GeneralInformationDto generalInformationDto;
	
	private List<LanguageDto> languages;
	private List<DegreeDto> degrees;
	private List<ExperienceDto> experiences;
	private List<CountryDto> countrys;
	private List<StateDto> states;
	
	private String statusMessage;
	private String statusCode;
	private String resume;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getJobOpeningId() {
		return jobOpeningId;
	}
	public void setJobOpeningId(String jobOpeningId) {
		this.jobOpeningId = jobOpeningId;
	}
/*	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}*/
	public GeneralInformationDto getGeneralInformationDto() {
		return generalInformationDto;
	}
	public void setGeneralInformationDto(GeneralInformationDto generalInformationDto) {
		this.generalInformationDto = generalInformationDto;
	}
	public List<LanguageDto> getLanguages() {
		return languages;
	}
	public void setLanguages(List<LanguageDto> languages) {
		this.languages = languages;
	}
	public List<DegreeDto> getDegrees() {
		return degrees;
	}
	public void setDegrees(List<DegreeDto> degrees) {
		this.degrees = degrees;
	}
	public List<ExperienceDto> getExperiences() {
		return experiences;
	}
	public void setExperiences(List<ExperienceDto> experiences) {
		this.experiences = experiences;
	}
	public List<CountryDto> getCountrys() {
		return countrys;
	}
	public void setCountrys(List<CountryDto> countrys) {
		this.countrys = countrys;
	}
	public List<StateDto> getStates() {
		return states;
	}
	public void setStates(List<StateDto> states) {
		this.states = states;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	


}
