package com.bluedart.billsandpayment.service;

import com.bluedart.billsandpayment.dto.BillsAndPaymentDto;
import com.bluedart.billsandpayment.dto.BillsAndPaymentSearchDto;


/**
 * 
 * @author ra848436
 *
 */
public interface BillsAndPaymentService {
	
	
	public BillsAndPaymentDto getInvoiceList(BillsAndPaymentDto billsAndPaymentDto) ;
	
	public BillsAndPaymentDto downloadInvoices(BillsAndPaymentDto billsAndPaymentDto) ;
	
	public BillsAndPaymentDto getOutstandingInvoicesList(BillsAndPaymentDto billsAndPaymentDto) ;
	
	public BillsAndPaymentDto approveInvoices(BillsAndPaymentDto billsAndPaymentDto); 	
	
	public BillsAndPaymentDto payInvoices(BillsAndPaymentSearchDto billsAndPaymentSearchDto) ;
	
	public BillsAndPaymentDto getStatementOfAccount(BillsAndPaymentDto billsAndPaymentDto) ;
	 
	public BillsAndPaymentDto downloadStatementOfAccount(BillsAndPaymentDto billsAndPaymentDto);
	 
	public BillsAndPaymentDto downloadStatementOfOutstandingPayments(BillsAndPaymentDto billsAndPaymentDto);
	 
	public BillsAndPaymentDto getStatementOfOutstandingPayments(BillsAndPaymentDto billsAndPaymentDto);
	
	public BillsAndPaymentDto getBillingCodes(String loginId,String permission_name);
	
}
