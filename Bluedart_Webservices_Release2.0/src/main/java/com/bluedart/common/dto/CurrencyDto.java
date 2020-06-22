package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class CurrencyDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String currencyName;
	private String currencyCode;
	private String nexchrate;
	private String nunits;
	private String nimptrate;
	
	private List<CurrencyDto> listOfCurrencyCode;
	
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
	/**
	 * @return the listOfCurrencyCode
	 */
	public List<CurrencyDto> getListOfCurrencyCode() {
		return listOfCurrencyCode;
	}
	/**
	 * @param listOfCurrencyCode the listOfCurrencyCode to set
	 */
	public void setListOfCurrencyCode(List<CurrencyDto> listOfCurrencyCode) {
		this.listOfCurrencyCode = listOfCurrencyCode;
	}
	
	
	

}
