package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;

/**
 * 
 * @author DH839598
 *
 */
public class CommodityCodeDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String commodityCode;
	private String commodityDesc;
	
	
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
	 * @return the commodityDesc
	 */
	public String getCommodityDesc() {
		return commodityDesc;
	}
	/**
	 * @param commodityDesc the commodityDesc to set
	 */
	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc;
	}
	
	

}
