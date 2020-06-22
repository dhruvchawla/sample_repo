package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class CommodityDto extends ErrorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String commodityCode;
	private String commodityName;
	
	private List<CommodityDto> listOfCommodityCode;

	/**
	 * @return the commodityCode
	 */
	public String getCommodityCode() {
		return commodityCode;
	}

	/**
	 * @param commodityCode the commodityCode to set
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	/**
	 * @return the commodityName
	 */
	public String getCommodityName() {
		return commodityName;
	}

	/**
	 * @param commodityName the commodityName to set
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	/**
	 * @return the listOfCommodityCode
	 */
	public List<CommodityDto> getListOfCommodityCode() {
		return listOfCommodityCode;
	}

	/**
	 * @param listOfCommodityCode the listOfCommodityCode to set
	 */
	public void setListOfCommodityCode(List<CommodityDto> listOfCommodityCode) {
		this.listOfCommodityCode = listOfCommodityCode;
	}
	
	
	 
	
	
	

}
