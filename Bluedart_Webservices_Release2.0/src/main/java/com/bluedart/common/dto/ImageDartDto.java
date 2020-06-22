package com.bluedart.common.dto;

import java.io.Serializable;
import java.sql.Blob;

/**
 * 
 * @author DH839598
 *
 */
public class ImageDartDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String awbNo;
	private String batchName;
	private Integer ndcNumber;
	private Blob imageOfAwb;
	
	/**
	 * @return the awbNo
	 */
	public String getAwbNo() {
		return awbNo;
	}
	/**
	 * @param awbNo the awbNo to set
	 */
	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}
	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}
	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	/**
	 * @return the ndcNumber
	 */
	public Integer getNdcNumber() {
		return ndcNumber;
	}
	/**
	 * @param ndcNumber the ndcNumber to set
	 */
	public void setNdcNumber(Integer ndcNumber) {
		this.ndcNumber = ndcNumber;
	}
	/**
	 * @return the imageOfAwb
	 */
	public Blob getImageOfAwb() {
		return imageOfAwb;
	}
	/**
	 * @param imageOfAwb the imageOfAwb to set
	 */
	public void setImageOfAwb(Blob imageOfAwb) {
		this.imageOfAwb = imageOfAwb;
	}
	 
	
}
