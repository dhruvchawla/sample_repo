package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBMASTER.SUBCTMST")
public class SubCitiesMst implements Serializable
{

	private static final long serialVersionUID = 1L;
	
@Id	
@Column(name = "CCITYNAME")
private String cityName;

@Column(name = "CCITYCODE")
	private String cityCode;
	

	
	@Column(name = "CCNTRYCODE")
	private String countryCode;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	
}
