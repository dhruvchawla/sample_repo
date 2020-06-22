/**
 * 
 */
package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CH851827
 *
 */

@Entity
@Table(name = "WEBMASTER.CITYMST")
public class CitiesMst implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	
	@Column(name = "CCITYCODE")
	private String cityCode;
	
	@Column(name = "CCITYNAME")
	private String cityName;
	
	@Column(name = "CCNTRYCODE")
	private String countryCode;
	

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
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
	
}
