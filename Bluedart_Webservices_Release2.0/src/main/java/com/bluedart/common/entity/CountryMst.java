package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author DH839598
 *
 */
@Entity
@Table(name = " WEBMASTER.CNTRYMST")
public class CountryMst implements Serializable {
	 
	
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(name = "CCNTRYCODE")
	private String countryCode;
	
	@Column(name = "CCNTRYNAME")
	private String countryName;
	
	@Column(name = "CPINFORMAT")
	private String pincodeFormat;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPincodeFormat() {
		return pincodeFormat;
	}

	public void setPincodeFormat(String pincodeFormat) {
		this.pincodeFormat = pincodeFormat;
	}
}
