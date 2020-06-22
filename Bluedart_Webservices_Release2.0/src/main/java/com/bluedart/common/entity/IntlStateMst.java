package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CH848113
 *
 */

@Entity
@Table(name = "INTLSTATEMST")
public class IntlStateMst implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	
	
	@Column(name ="CSTATECODE")
	private String stateCode;
	
	@Column(name ="CSTATEDESC")
	private String stateName;
	
	@Column(name ="CCNTRYCODE")
	private String countryCode;

	
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
}
