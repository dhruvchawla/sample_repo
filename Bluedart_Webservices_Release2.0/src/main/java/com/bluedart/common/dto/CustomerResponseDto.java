package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author PR334023
 *
 */
public class CustomerResponseDto extends StatusDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<CorporateUserDto> custList;
	private List<String> loginIDList;
	private String status;
	private int resultCount;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getLoginIDList() {
		return loginIDList;
	}

	public void setLoginIDList(List<String> loginIDList) {
		this.loginIDList = loginIDList;
	}

	public List<CorporateUserDto> getCustList() {
		return custList;
	}

	public void setCustList(List<CorporateUserDto> custList) {
		this.custList = custList;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	@Override
	public String toString() {
		return "CustomerResponseDto [custList=" + custList + ", loginIDList="
				+ loginIDList + ", status=" + status + ", resultCount="
				+ resultCount + "]";
	}
}