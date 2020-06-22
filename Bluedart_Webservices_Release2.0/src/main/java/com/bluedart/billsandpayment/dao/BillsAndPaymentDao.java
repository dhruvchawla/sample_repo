package com.bluedart.billsandpayment.dao;

import com.bluedart.billsandpayment.dto.BillsAndPaymentDto;


/**
 * 
 * @author ra848436
 *
 */
public interface BillsAndPaymentDao {
	
	public BillsAndPaymentDto getBillingCodes(String loginId,String permission_name);
	
}
