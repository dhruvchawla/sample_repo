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
@Table(name = " WEBMASTER.PRODMST")
public class ProductMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id

	@Column(name = "CPRODCODE")
	private String productCode;

	@Column(name = "CPRODDESC")
	private String productDesc;

	@Column(name = "CPRODGRP")
	private Character productGrp;

	@Column(name = "NSTAX")
	private Integer nstax;

	@Column(name = "NDSSORD")
	private Integer ndssord;

	@Column(name = "CTODISP")
	private Character ctoSDisp;

	@Column(name = "NCESSTAX")
	private Integer ncesstax;

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
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
	 * @param productDesc
	 *            the productDesc to set
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
	 * @param productGrp
	 *            the productGrp to set
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
	 * @param nstax
	 *            the nstax to set
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
	 * @param ndssord
	 *            the ndssord to set
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
	 * @param ctoSDisp
	 *            the ctoSDisp to set
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
	 * @param ncesstax
	 *            the ncesstax to set
	 */
	public void setNcesstax(Integer ncesstax) {
		this.ncesstax = ncesstax;
	}

}
