/**
 * 
 */
package com.bluedart.billsandpayment.dto;

import java.util.List;

/**
 * @author RA848436
 *
 */
public class BillsAndPaymentSearchDto {
	
	private List<BillsAndPaymentDto> billsAndPaymentDtoList;

	/**
	 * 
	 */
	public BillsAndPaymentSearchDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the billsAndPaymentDtoList
	 */
	public List<BillsAndPaymentDto> getBillsAndPaymentDtoList() {
		return billsAndPaymentDtoList;
	}

	/**
	 * @param billsAndPaymentDtoList the billsAndPaymentDtoList to set
	 */
	public void setBillsAndPaymentDtoList(
			List<BillsAndPaymentDto> billsAndPaymentDtoList) {
		this.billsAndPaymentDtoList = billsAndPaymentDtoList;
	}

}
