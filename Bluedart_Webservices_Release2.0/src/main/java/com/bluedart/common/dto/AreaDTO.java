/**
 * 
 */
package com.bluedart.common.dto;

/**
 * @author SU299168
 *
 */
public class AreaDTO {

	private String carea;
	private String cscrcd;
	private String careacity;
	
	// added for ebusiness solution
	
	private String cbranch;
	private String cregion;

	public String getCareacity() {
		return careacity;
	}

	public void setCareacity(String careacity) {
		this.careacity = careacity;
	}

	/**
	 * @return the carea
	 */
	public String getCarea() {
		return carea;
	}

	/**
	 * @param carea
	 *            the carea to set
	 */
	public void setCarea(String carea) {
		this.carea = carea;
	}

	/**
	 * @return the cscrcd
	 */
	public String getCscrcd() {
		return cscrcd;
	}

	/**
	 * @param cscrcd
	 *            the cscrcd to set
	 */
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}

	public String getCbranch() {
		return cbranch;
	}

	public void setCbranch(String cbranch) {
		this.cbranch = cbranch;
	}

	public String getCregion() {
		return cregion;
	}

	public void setCregion(String cregion) {
		this.cregion = cregion;
	}

}
