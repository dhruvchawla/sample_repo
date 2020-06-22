package com.bluedart.common.entity;

import java.io.Serializable;
import java.sql.Blob;

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
@Table( name = "BDIMAGE.AWBIMAGE")
public class TrackingAPIImageDart implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	 
	@Column(name = "CAWBNO")
	private String awbNo;
	
	@Column(name = "BATCHNAME")
	private String batchName;
	
	@Column(name = "NDC")
	private Integer ndcNumber;
	
	@Column(name = "IAWBNO")
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
