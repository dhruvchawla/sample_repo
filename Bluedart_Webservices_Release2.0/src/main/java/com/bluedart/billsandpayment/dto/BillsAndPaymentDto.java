package com.bluedart.billsandpayment.dto;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ApprovedStatus;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoiceData;
import com.bluedart.billsandpayment.helper.BillingServiceStub.InvoiceData;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePayment;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePaymentFeedToNav;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.PaymentFeedToNAV;

/**
 * 
 * @author ra848436
 * 
 */
public class BillsAndPaymentDto implements Serializable{
	
	private static final long serialVersionUID = 7296825305925439431L;
	
	private String pdfString;
	private String billingCode;
	private String fromDate;
	private String toDate;
	private String date;
	private String entryNoFilter;
	private String approvedBy;
	private String postingDate;
    private boolean approvalStatus;
    private String status;
    private long invoiceNo;
    private long invoiceAmt;
    private long outstandingAmt;
    private String pmtToBeMade;
    private String entryNo;
    private long totalPayble;
    private String tds;
    private long netPayble;
    private long chequeNo;
    private String description;
    private long debitAmt;
    private long creditAmt;
    private long balance;
	private List<BillsAndPaymentDto> billsAndPaymentDtoList;
	private InvoiceData[] invoiceData;
	private InvoicePayment[] invoicePayment;
	private PaymentFeedToNAV[] paymentFeedToNAV;
	private InvoicePaymentFeedToNav[] invoicePaymentFeedToNav;
	
	private ApprovedStatus[] approvedStatus;
	private OutputStream outputStream;
	private InputStream is;
	private Integer page;
	private Integer rows;
	private ByteArrayOutputStream baos;
	private byte[] bytes;
	private String extension;
	private Integer specificIndex;
	private Integer start;
	private String errorCode;
	private String entryNosVal;
	private String errorMessage;
	private String recordNotFound;
	
	private Boolean isPdf;
	private String loginId;
	
	/**
	 * @return the billingCode
	 */
	public String getBillingCode() {
		return billingCode;
	}
	/**
	 * @param billingCode the billingCode to set
	 */
	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the entryNoFilter
	 */
	public String getEntryNoFilter() {
		return entryNoFilter;
	}
	/**
	 * @param entryNoFilter the entryNoFilter to set
	 */
	public void setEntryNoFilter(String entryNoFilter) {
		this.entryNoFilter = entryNoFilter;
	}
	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}
	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	/**
	 * @return the postingDate
	 */
	public String getPostingDate() {
		return postingDate;
	}
	/**
	 * @param postingDate the postingDate to set
	 */
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	/**
	 * @return the approvalStatus
	 */
	public boolean isApprovalStatus() {
		return approvalStatus;
	}
	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the invoiceNo
	 */
	public long getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * @return the invoiceAmt
	 */
	public long getInvoiceAmt() {
		return invoiceAmt;
	}
	/**
	 * @param invoiceAmt the invoiceAmt to set
	 */
	public void setInvoiceAmt(long invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	/**
	 * @return the outstandingAmt
	 */
	public long getOutstandingAmt() {
		return outstandingAmt;
	}
	/**
	 * @param outstandingAmt the outstandingAmt to set
	 */
	public void setOutstandingAmt(long outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}
	
	
	/**
	 * @return the pmtToBeMade
	 */
	public String getPmtToBeMade() {
		return pmtToBeMade;
	}
	/**
	 * @param pmtToBeMade the pmtToBeMade to set
	 */
	public void setPmtToBeMade(String pmtToBeMade) {
		this.pmtToBeMade = pmtToBeMade;
	}
	
	/**
	 * @return the totalPayble
	 */
	public long getTotalPayble() {
		return totalPayble;
	}
	
	
	
	/**
	 * @return the pdfString
	 */
	public String getPdfString() {
		return pdfString;
	}
	/**
	 * @param pdfString the pdfString to set
	 */
	public void setPdfString(String pdfString) {
		this.pdfString = pdfString;
	}
	/**
	 * @param totalPayble the totalPayble to set
	 */
	public void setTotalPayble(long totalPayble) {
		this.totalPayble = totalPayble;
	}
	
	/**
	 * @return the netPayble
	 */
	public long getNetPayble() {
		return netPayble;
	}
	/**
	 * @param netPayble the netPayble to set
	 */
	public void setNetPayble(long netPayble) {
		this.netPayble = netPayble;
	}
	/**
	 * @return the chequeNo
	 */
	public long getChequeNo() {
		return chequeNo;
	}
	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the debitAmt
	 */
	public long getDebitAmt() {
		return debitAmt;
	}
	/**
	 * @param debitAmt the debitAmt to set
	 */
	public void setDebitAmt(long debitAmt) {
		this.debitAmt = debitAmt;
	}
	/**
	 * @return the creditAmt
	 */
	public long getCreditAmt() {
		return creditAmt;
	}
	/**
	 * @param creditAmt the creditAmt to set
	 */
	public void setCreditAmt(long creditAmt) {
		this.creditAmt = creditAmt;
	}
	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
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
	/**
	 * @return the outputStream
	 */
	public OutputStream getOutputStream() {
		return outputStream;
	}
	/**
	 * @param outputStream the outputStream to set
	 */
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	/**
	 * @return the invoiceData
	 */
	public InvoiceData[] getInvoiceData() {
		return invoiceData;
	}
	/**
	 * @param invoiceData the invoiceData to set
	 */
	public void setInvoiceData(InvoiceData[] invoiceData) {
		this.invoiceData = invoiceData;
	}
	/**
	 * @return the invoicePayment
	 */
	public InvoicePayment[] getInvoicePayment() {
		return invoicePayment;
	}
	/**
	 * @param invoicePayment the invoicePayment to set
	 */
	public void setInvoicePayment(InvoicePayment[] invoicePayment) {
		this.invoicePayment = invoicePayment;
	}
	
	/**
	 * @return the is
	 */
	public InputStream getIs() {
		return is;
	}
	/**
	 * @param is the is to set
	 */
	public void setIs(InputStream is) {
		this.is = is;
	}
	/**
	 * @return the bytes
	 */
	public byte[] getBytes() {
		return bytes;
	}
	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * @return the start
	 */
	/**
	 * @return the start
	 */
	
	/**
	 * @return the specificIndex
	 */
	
	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}
	/**
	 * @return the specificIndex
	 */
	public Integer getSpecificIndex() {
		return specificIndex;
	}
	/**
	 * @param specificIndex the specificIndex to set
	 */
	public void setSpecificIndex(Integer specificIndex) {
		this.specificIndex = specificIndex;
	}
	/**
	 * @return the approvedStatus
	 */
	public ApprovedStatus[] getApprovedStatus() {
		return approvedStatus;
	}
	/**
	 * @param approvedStatus the approvedStatus to set
	 */
	public void setApprovedStatus(ApprovedStatus[] approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	/**
	 * @return the paymentFeedToNAV
	 */
	public PaymentFeedToNAV[] getPaymentFeedToNAV() {
		return paymentFeedToNAV;
	}
	/**
	 * @param paymentFeedToNAV the paymentFeedToNAV to set
	 */
	public void setPaymentFeedToNAV(PaymentFeedToNAV[] paymentFeedToNAV) {
		this.paymentFeedToNAV = paymentFeedToNAV;
	}
	/**
	 * @return the invoicePaymentFeedToNav
	 */
	public InvoicePaymentFeedToNav[] getInvoicePaymentFeedToNav() {
		return invoicePaymentFeedToNav;
	}
	/**
	 * @param invoicePaymentFeedToNav the invoicePaymentFeedToNav to set
	 */
	public void setInvoicePaymentFeedToNav(
			InvoicePaymentFeedToNav[] invoicePaymentFeedToNav) {
		this.invoicePaymentFeedToNav = invoicePaymentFeedToNav;
	}
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	/**
	 * @return the entryNo
	 */
	public String getEntryNo() {
		return entryNo;
	}
	/**
	 * @return the baos
	 */
	public ByteArrayOutputStream getBaos() {
		return baos;
	}
	/**
	 * @param entryNo the entryNo to set
	 */
	public void setEntryNo(String entryNo) {
		this.entryNo = entryNo;
	}
	/**
	 * @param baos the baos to set
	 */
	public void setBaos(ByteArrayOutputStream baos) {
		this.baos = baos;
	}
	/**
	 * @return the tds
	 */
	public String getTds() {
		return tds;
	}
	/**
	 * @param tds the tds to set
	 */
	public void setTds(String tds) {
		this.tds = tds;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the recordNotFound
	 */
	public String getRecordNotFound() {
		return recordNotFound;
	}
	/**
	 * @param recordNotFound the recordNotFound to set
	 */
	public void setRecordNotFound(String recordNotFound) {
		this.recordNotFound = recordNotFound;
	}
	/**
	 * @return the entryNosVal
	 */
	public String getEntryNosVal() {
		return entryNosVal;
	}
	/**
	 * @param entryNosVal the entryNosVal to set
	 */
	public void setEntryNosVal(String entryNosVal) {
		this.entryNosVal = entryNosVal;
	}
	public Boolean getIsPdf() {
		return isPdf;
	}
	public void setIsPdf(Boolean isPdf) {
		this.isPdf = isPdf;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}