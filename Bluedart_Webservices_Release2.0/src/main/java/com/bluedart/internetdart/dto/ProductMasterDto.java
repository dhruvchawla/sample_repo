package com.bluedart.internetdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class ProductMasterDto implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private String productCode;
	private String productDesc;
	private Character productGrp;
	private Integer nstax;
	private Integer ndssord;
	private Character ctoSDisp;
	private Integer ncesstax;
	private String errorCode;
	private List<ProductMasterDto> productMasterDtoList;
	
	
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}
	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	/**
	 * @return the productGrp
	 */
	public Character getProductGrp() {
		return productGrp;
	}
	/**
	 * @param productGrp the productGrp to set
	 */
	public void setProductGrp(Character productGrp) {
		this.productGrp = productGrp;
	}
	/**
	 * @return the nstax
	 */
	public Integer getNstax() {
		return nstax;
	}
	/**
	 * @param nstax the nstax to set
	 */
	public void setNstax(Integer nstax) {
		this.nstax = nstax;
	}
	/**
	 * @return the ndssord
	 */
	public Integer getNdssord() {
		return ndssord;
	}
	/**
	 * @param ndssord the ndssord to set
	 */
	public void setNdssord(Integer ndssord) {
		this.ndssord = ndssord;
	}
	/**
	 * @return the ctoSDisp
	 */
	public Character getCtoSDisp() {
		return ctoSDisp;
	}
	/**
	 * @param ctoSDisp the ctoSDisp to set
	 */
	public void setCtoSDisp(Character ctoSDisp) {
		this.ctoSDisp = ctoSDisp;
	}
	/**
	 * @return the ncesstax
	 */
	public Integer getNcesstax() {
		return ncesstax;
	}
	/**
	 * @param ncesstax the ncesstax to set
	 */
	public void setNcesstax(Integer ncesstax) {
		this.ncesstax = ncesstax;
	}
	/**
	 * @return the productMasterDtoList
	 */
	public List<ProductMasterDto> getProductMasterDtoList() {
		return productMasterDtoList;
	}
	/**
	 * @param productMasterDtoList the productMasterDtoList to set
	 */
	public void setProductMasterDtoList(List<ProductMasterDto> productMasterDtoList) {
		this.productMasterDtoList = productMasterDtoList;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	

}
