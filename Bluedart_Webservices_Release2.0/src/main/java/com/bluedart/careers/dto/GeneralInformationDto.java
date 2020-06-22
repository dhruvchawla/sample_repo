package com.bluedart.careers.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author CH848113
 */
public class GeneralInformationDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String jobOpeningId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String maritalStatus;
	private String gender;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private List<EmailDto> emailDetail;
	private List<PhoneDto> phoneDetail;
	
	public String getJobOpeningId() {
		return jobOpeningId;
	}
	public void setJobOpeningId(String jobOpeningId) {
		this.jobOpeningId = jobOpeningId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public List<EmailDto> getEmailDetail() {
		return emailDetail;
	}
	public void setEmailDetail(List<EmailDto> emailDetail) {
		this.emailDetail = emailDetail;
	}
	public List<PhoneDto> getPhoneDetail() {
		return phoneDetail;
	}
	public void setPhoneDetail(List<PhoneDto> phoneDetail) {
		this.phoneDetail = phoneDetail;
	}
	

}
