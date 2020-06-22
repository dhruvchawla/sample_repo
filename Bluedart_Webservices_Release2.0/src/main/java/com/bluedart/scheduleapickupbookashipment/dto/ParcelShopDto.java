package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class ParcelShopDto extends ErrorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String parcelShopCode;
	private String parcelShopAddress1;
	private String parcelShopAddress2;
	private String parcelShopAddress3;
	private String parcelShopPincode;
	
	private List<ParcelShopDto> listOfParcelShop;
	
	
	/**
	 * @return the parcelShopCode
	 */
	public String getParcelShopCode() {
		return parcelShopCode;
	}
	/**
	 * @param parcelShopCode the parcelShopCode to set
	 */
	public void setParcelShopCode(String parcelShopCode) {
		this.parcelShopCode = parcelShopCode;
	}
	 
	/**
	 * @return the parcelShopAddress1
	 */
	public String getParcelShopAddress1() {
		return parcelShopAddress1;
	}
	/**
	 * @param parcelShopAddress1 the parcelShopAddress1 to set
	 */
	public void setParcelShopAddress1(String parcelShopAddress1) {
		this.parcelShopAddress1 = parcelShopAddress1;
	}
	/**
	 * @return the parcelShopAddress2
	 */
	public String getParcelShopAddress2() {
		return parcelShopAddress2;
	}
	/**
	 * @param parcelShopAddress2 the parcelShopAddress2 to set
	 */
	public void setParcelShopAddress2(String parcelShopAddress2) {
		this.parcelShopAddress2 = parcelShopAddress2;
	}
	/**
	 * @return the parcelShopAddress3
	 */
	public String getParcelShopAddress3() {
		return parcelShopAddress3;
	}
	/**
	 * @param parcelShopAddress3 the parcelShopAddress3 to set
	 */
	public void setParcelShopAddress3(String parcelShopAddress3) {
		this.parcelShopAddress3 = parcelShopAddress3;
	}
	/**
	 * @return the parcelShopPincode
	 */
	public String getParcelShopPincode() {
		return parcelShopPincode;
	}
	/**
	 * @param parcelShopPincode the parcelShopPincode to set
	 */
	public void setParcelShopPincode(String parcelShopPincode) {
		this.parcelShopPincode = parcelShopPincode;
	}
	/**
	 * @return the listOfParcelShop
	 */
	public List<ParcelShopDto> getListOfParcelShop() {
		return listOfParcelShop;
	}
	/**
	 * @param listOfParcelShop the listOfParcelShop to set
	 */
	public void setListOfParcelShop(List<ParcelShopDto> listOfParcelShop) {
		this.listOfParcelShop = listOfParcelShop;
	}
	
	
	
	

}
