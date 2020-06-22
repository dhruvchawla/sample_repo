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
@Table(name = "WEBMASTER.CURRMST")
public class CurrencyMaster implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name = "CCURRNAME")
	private String currencyName;
	
	@Column(name = "CCURRCODE")
	private String currencyCode;
	
	@Column(name = "NEXCHRATE")
	private String nexchrate;
	
	@Column(name = "NUNITS")
	private String nunits;
	
	@Column(name = "NIMPTRATE")
	private String nimptrate;
	
	
	
	/**
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}
	/**
	 * @param currencyName the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}
	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	/**
	 * @return the nexchrate
	 */
	public String getNexchrate() {
		return nexchrate;
	}
	/**
	 * @param nexchrate the nexchrate to set
	 */
	public void setNexchrate(String nexchrate) {
		this.nexchrate = nexchrate;
	}
	/**
	 * @return the nunits
	 */
	public String getNunits() {
		return nunits;
	}
	/**
	 * @param nunits the nunits to set
	 */
	public void setNunits(String nunits) {
		this.nunits = nunits;
	}
	/**
	 * @return the nimptrate
	 */
	public String getNimptrate() {
		return nimptrate;
	}
	/**
	 * @param nimptrate the nimptrate to set
	 */
	public void setNimptrate(String nimptrate) {
		this.nimptrate = nimptrate;
	}
	
	

}
