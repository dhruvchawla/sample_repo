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
//@Table(name = "WEBMASTER.CITYMST")
@Table(name = "WEBMASTER.SUBCTMST")
public class CityMst implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	
	@Column(name = "CCITYCODE")
	private String ccitycode;
	
	@Column(name = "CCITYNAME")
	private String ccityname;
	
	@Column(name = "CCNTRYCODE")
	private String countryCode;
	

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCcitycode() {
		return ccitycode;
	}
	public void setCcitycode(String ccitycode) {
		this.ccitycode = ccitycode;
	}
	public String getCcityname() {
		return ccityname;
	}
	public void setCcityname(String ccityname) {
		this.ccityname = ccityname;
	}
	@Override
	public String toString() {
		return "CityMst [ccitycode=" + ccitycode + ", ccityname=" + ccityname
				+ ", countryCode=" + countryCode + "]";
	}
	
}
