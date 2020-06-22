package com.bluedart.billsandpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bluedart.billsandpayment.dto.BillsAndPaymentDto;
import com.bluedart.billsandpayment.dto.BillsAndPaymentSearchDto;
import com.bluedart.billsandpayment.service.BillsAndPaymentService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.masters.dto.AffiliatesDto;
import com.bluedart.masters.service.AffiliatesService;
import com.bluedart.utils.ErrorMessageStatusCode;

@RestController
public class BillsAndPaymentController {

	@Autowired
	private BillsAndPaymentService billsAndPaymentService;
	
	@Autowired
	private AffiliatesService affiliatesService;

	@RequestMapping(value = "billsandpayments/invoices", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> getInvoiceList(@RequestBody BillsAndPaymentDto billsAndPaymentDto) {
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.getInvoiceList(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	@RequestMapping(value = "billsandpayments/downloadInvoices", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> downloadInvoices(@RequestBody BillsAndPaymentDto billsAndPaymentDto) {

		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.downloadInvoices(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		//billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	@RequestMapping(value = "billsandpayments/invoicePaymentList", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> getOutstandingInvoicesList(@RequestBody
			BillsAndPaymentDto billsAndPaymentDto) {
 		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.getOutstandingInvoicesList(billsAndPaymentDto);
 		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	
	@RequestMapping(value = "billsandpayments/downloadStatementOfAccount", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> downloadStatementOfAccount(@RequestBody BillsAndPaymentDto billsAndPaymentDto) {
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.downloadStatementOfAccount(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	@RequestMapping(value = "billsandpayments/downloadStatementOfOutstandingPayments", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> downloadStatementOfOutstandingPayments(@RequestBody BillsAndPaymentDto billsAndPaymentDto) {
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.downloadStatementOfOutstandingPayments(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	@RequestMapping(value = "billsandpayments/approveInvoices", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> approveInvoices(@RequestBody
			BillsAndPaymentDto billsAndPaymentDto) {
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.approveInvoices(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	@RequestMapping(value = "billsandpayments/payInvoices", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> payInvoices(@RequestBody
		BillsAndPaymentSearchDto billsAndPaymentSearchDto) {
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.payInvoices(billsAndPaymentSearchDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */										
	@RequestMapping(value = "billsandpayments/statementOfAccount", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> getStatementOfAccount(@RequestBody
			BillsAndPaymentDto billsAndPaymentDto) {
		System.out.println("getStatementOfAccount is inside java side called");
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.getStatementOfAccount(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	@RequestMapping(value = "billsandpayments/statementOfOutstandingPayments", method = RequestMethod.POST)
	public ResponseEntity<BillsAndPaymentDto> getStatementOfOutstandingPayments(@RequestBody
			BillsAndPaymentDto billsAndPaymentDto) {
		System.out.println("getStatementOfAccount is inside java side called");
		BillsAndPaymentDto billsAndPaymentDtoRes = billsAndPaymentService.getStatementOfOutstandingPayments(billsAndPaymentDto);
		billsAndPaymentDtoRes.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(billsAndPaymentDtoRes, HttpStatus.OK);
	}
	/**
	 * 
	 * 
	 * @param loginId
	 * @return
	 */
	//http://localhost:8080/Bluedart_Webservices/billsandpayments/getAffiliates/SYSDEV001
	@RequestMapping(value = "billsandpayments/getAffiliates/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public AffiliatesDto getAffiliates(@PathVariable String loginId) {
          //logger.debug("InternetDartController : getAffiliates");
		System.out.println("Call");
          AffiliatesDto affiliatesDto = null;
          affiliatesDto = affiliatesService.getAffiliates(loginId);
          affiliatesDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
          return affiliatesDto;
    }
	@RequestMapping(value = "billsandpayments/getBillingCodes/{loginId}/{permissionName}", method = RequestMethod.GET, headers = "Accept=application/json")
    public BillsAndPaymentDto getBillingCodes(@PathVariable String loginId, @PathVariable String permissionName) {
		BillsAndPaymentDto paymentDto = billsAndPaymentService.getBillingCodes(loginId, permissionName);
		return paymentDto;
    }
	
	
	
		@ExceptionHandler(BlueDartException.class)
    private BillsAndPaymentDto BlueDartException(BlueDartException serviceException) {
		BillsAndPaymentDto errorDto = new BillsAndPaymentDto();
          errorDto.setErrorCode(serviceException.getErrorCode());
          errorDto.setErrorMessage(serviceException.getErrorMessage());
          return errorDto;
    }
}
