package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author PR334023
 *
 */
public class AuditDto extends StatusDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<AdminAuditDetails> adminAuditDtoList;
	private List<Integer> sequenceNumbers;

	public List<Integer> getSequenceNumbers() {
		return sequenceNumbers;
	}

	public void setSequenceNumbers(List<Integer> sequenceNumbers) {
		this.sequenceNumbers = sequenceNumbers;
	}

	public List<AdminAuditDetails> getAdminAuditDtoList() {
		return adminAuditDtoList;
	}

	public void setAdminAuditDtoList(List<AdminAuditDetails> adminAuditDtoList) {
		this.adminAuditDtoList = adminAuditDtoList;
	}

	@Override
	public String toString() {
		return "AuditDto [adminAuditDtoList=" + adminAuditDtoList
				+ ", sequenceNumbers=" + sequenceNumbers + "]";
	}
}