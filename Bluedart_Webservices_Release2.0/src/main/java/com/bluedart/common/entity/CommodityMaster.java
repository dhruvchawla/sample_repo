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
@Table(name = "WEBMASTER.CMDTYMST")
public class CommodityMaster implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name = "CCMDTYCODE")
	private String commodityCode;
	
	@Column(name = "CCMDTYNAME")
	private String commodityName;

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
	
	
	 
	
	

}
