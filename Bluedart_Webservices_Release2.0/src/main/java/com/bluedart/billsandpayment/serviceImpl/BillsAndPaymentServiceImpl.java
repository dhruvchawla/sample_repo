/**
 * @author ra848436
 */

package com.bluedart.billsandpayment.serviceImpl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import javax.activation.DataHandler;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bluedart.billsandpayment.dao.BillsAndPaymentDao;
import com.bluedart.billsandpayment.dto.BillsAndPaymentDto;
import com.bluedart.billsandpayment.dto.BillsAndPaymentSearchDto;
import com.bluedart.billsandpayment.helper.BillingServiceStub;
import com.bluedart.billsandpayment.helper.BillingServiceStub.ArrayOfInvoiceData;
import com.bluedart.billsandpayment.helper.BillingServiceStub.DownloadInvoiceAsZip;
import com.bluedart.billsandpayment.helper.BillingServiceStub.DownloadInvoiceAsZipResponse;
import com.bluedart.billsandpayment.helper.BillingServiceStub.FileShare;
import com.bluedart.billsandpayment.helper.BillingServiceStub.GetInvoiceData;
import com.bluedart.billsandpayment.helper.BillingServiceStub.GetInvoiceDataResponse;
import com.bluedart.billsandpayment.helper.BillingServiceStub.InvoiceData;
/*
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;*/
import com.bluedart.billsandpayment.helper.BlueDartServiceStub;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ApprovedStatus;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ArrayOfApprovedStatus;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ArrayOfInvoiceData;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ArrayOfInvoicePayment;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ArrayOfInvoicePaymentFeedToNav;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.ArrayOfPaymentFeedToNAV;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.DownloadCustomerStatement;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.DownloadCustomerStatementResponse;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.DownloadInvoiceAsZip;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.DownloadInvoiceAsZipResponse;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.FileShare;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.GetInvoiceData;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.GetInvoiceDataResponse;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.GetInvoicePayment;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.GetInvoicePaymentResponse;
//import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoiceData;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePayment;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePaymentFeedToNAVResponse;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePaymentFeedToNav;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.PaymentFeedToNAV;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfOutstandingPayments;
import com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfOutstandingPaymentsResponse;
import com.bluedart.billsandpayment.service.BillsAndPaymentService;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

@Service
public class BillsAndPaymentServiceImpl implements BillsAndPaymentService {

	private static final Logger logger = Logger
			.getLogger(BillsAndPaymentServiceImpl.class);

	@Autowired
	private BillsAndPaymentDao billsAndPaymentDao;

	@Autowired
	private Environment env;
	private BillsAndPaymentDto billsAndPaymentDtoRes = null;
	private BillsAndPaymentSearchDto billsAndPaymentSearchDto = null;
	
	@Autowired
	private MISLogDao misLogDao;
	
	private String featureName = null;
	@Override
	public BillsAndPaymentDto getInvoiceList(
			BillsAndPaymentDto billsAndPaymentDto) {
			try {	
			logger.info("BillsAndPaymentServiceImpl : getInvoiceList");
			logger.info("BillsAndPaymentServiceImpl : setSDate"+billsAndPaymentDto.getFromDate());
			logger.info("BillsAndPaymentServiceImpl : setEDate"+billsAndPaymentDto.getToDate());
			logger.info("BillsAndPaymentServiceImpl : setRows"+billsAndPaymentDto.getRows().toString());
			logger.info("BillsAndPaymentServiceImpl : setPage"+billsAndPaymentDto.getPage().toString());
			billsAndPaymentDtoRes = new BillsAndPaymentDto();
			//BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
			BillingServiceStub blueDartServiceStub = new BillingServiceStub();
			GetInvoiceData getInvoiceData = new GetInvoiceData();
			getInvoiceData.setBillingCode(billsAndPaymentDto.getBillingCode());
			//getInvoiceData.setBillingCode("XYZ");
			getInvoiceData.setSDate(billsAndPaymentDto.getFromDate());
			getInvoiceData.setEDate(billsAndPaymentDto.getToDate());
			getInvoiceData.setRows(billsAndPaymentDto.getRows().toString());
			getInvoiceData.setPage(billsAndPaymentDto.getPage().toString());
			GetInvoiceDataResponse getInvoiceDataResponse = blueDartServiceStub.getInvoiceData(getInvoiceData);
			ArrayOfInvoiceData arrayOfInvoiceData = getInvoiceDataResponse.getGetInvoiceDataResult();
			InvoiceData[] invoiceData = arrayOfInvoiceData.getInvoiceData();
			int i=0;
			if(arrayOfInvoiceData.getInvoiceData()!=null){
			for (InvoiceData dto : arrayOfInvoiceData.getInvoiceData()) {
				
				logger.info("BillsAndPaymentServiceImpl : dto.getBillingCode()"+i);
				if(dto!=null){
					logger.info("BillsAndPaymentServiceImpl : dto.getBillingCode()"+dto.getBillingCode());
					logger.info("BillsAndPaymentServiceImpl : dto.getEntryNo()"+dto.getEntryNo());
					logger.info("BillsAndPaymentServiceImpl : dto.getDocNo()"+dto.getDocNo());
				}else{
					logger.info("BillsAndPaymentServiceImpl : dto is null");
				}
				
				i++;
			}}
			logger.info("BillsAndPaymentServiceImpl : invoiceData"+invoiceData);
			if (null != invoiceData) {
				billsAndPaymentDtoRes = new BillsAndPaymentDto();
				billsAndPaymentDtoRes.setInvoiceData(invoiceData);
			} else  {
				  billsAndPaymentDtoRes.setRecordNotFound("N");
			}
			
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.error("BillsAndPaymentServiceImpl : invoiceData exception");
			e.printStackTrace();
			throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
	}
			finally{
				featureName = Constants.INVOICE_LISTING;  
				logger.info("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+billsAndPaymentDto.getLoginId());
				saveMISLog(featureName,billsAndPaymentDto.getLoginId(),null,null,null);
				logger.info("---------- SAVED TO MIS LOG ----------");
				}
		
		return billsAndPaymentDtoRes;
		
	}
/**
 * 
 * 
 */
	@Override
	public BillsAndPaymentDto downloadInvoices(
			BillsAndPaymentDto billsAndPaymentDto) {
		try {
			logger.info("BillsAndPaymentServiceImpl : downloadInvoices");
			logger.info("BillsAndPaymentServiceImpl : entrynumber"+billsAndPaymentDto.getEntryNo());
			//BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
			BillingServiceStub blueDartServiceStub = new BillingServiceStub();
			DownloadInvoiceAsZip downloadInvoiceAsZip = new DownloadInvoiceAsZip();
			//downloadInvoiceAsZip.setEntryNo(billsAndPaymentDto.getEntryNosVal());//-ve Testing
			////System.out.println("dynamic entry downloadInvoices is called"+downloadInvoiceAsZip );
			//downloadInvoiceAsZip.setEntryNo(",");// Happy Testing
			//downloadInvoiceAsZip.setEntryNo(",");
			//System.out.println("downloadInvoices is called static entry no"+downloadInvoiceAsZip );
			downloadInvoiceAsZip.setEntryNo(billsAndPaymentDto.getEntryNo());
			downloadInvoiceAsZip.setExtension("pdf");
			 DownloadInvoiceAsZipResponse	downloadInvoiceAsZipResponse = blueDartServiceStub.downloadInvoiceAsZip(downloadInvoiceAsZip);
			    if(downloadInvoiceAsZipResponse !=null){
			    	if(downloadInvoiceAsZipResponse.getDownloadInvoiceAsZipResult() !=null){
			    		logger.info("BillsAndPaymentServiceImpl : getFileName"+downloadInvoiceAsZipResponse.getDownloadInvoiceAsZipResult().getFileName());
						logger.info("BillsAndPaymentServiceImpl : getEntryNo"+downloadInvoiceAsZipResponse.getDownloadInvoiceAsZipResult().getEntryNo());
			    	}else{
			    		logger.info("BillsAndPaymentServiceImpl : downloadInvoiceAsZipResponse.getDownloadInvoiceAsZipResult() is null");
			    	}
			    	
			    }else{
			    	logger.info("BillsAndPaymentServiceImpl : downloadInvoiceAsZipResponse is null");
			    }
			    DataHandler  dataHandler=null;
			    if (null != downloadInvoiceAsZipResponse) {
				FileShare fshre=downloadInvoiceAsZipResponse.getDownloadInvoiceAsZipResult();
				dataHandler= fshre.getFileName();
				billsAndPaymentDto.setRecordNotFound("N");	
			    }else{
			    	billsAndPaymentDto.setRecordNotFound("Y");	
			    }
				logger.info("BillsAndPaymentServiceImpl : downdataHandler");
				if (null != dataHandler) {
					InputStream is=dataHandler.getInputStream();
					byte[] bytes=convertInputStreamToByteArrary(is);
					 billsAndPaymentDto.setBytes(bytes);
						logger.info("BillsAndPaymentServiceImpl : bytes"+bytes);
				} else  {
					billsAndPaymentDto.setRecordNotFound("Y");
				}
				
		} catch (RemoteException ex) {
			logger.error("EXCEPTION TYPE :",ex);
			if (ex instanceof AxisFault) {
				logger.error("BillsAndPaymentServiceImpl : AxisFault exception"); 
				billsAndPaymentDto.setRecordNotFound("Y");
			}
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.error("BillsAndPaymentServiceImpl : exception");
			e.printStackTrace();
			throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),
					ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}
		finally{
		featureName = Constants.INVOICE_LISTING;  
		logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+billsAndPaymentDto.getLoginId());
		saveMISLog(featureName,billsAndPaymentDto.getLoginId(),null,null,null);
		logger.debug("---------- SAVED TO MIS LOG ----------");
		}
		return billsAndPaymentDto;
	}
	/**
	 * 
	 * 
	 */

	@Override
	public BillsAndPaymentDto getOutstandingInvoicesList(BillsAndPaymentDto billsAndPaymentDto) {
		logger.info("BillsAndPaymentServiceImpl : getOutstandingInvoicesList");
		
		try {
			
			billsAndPaymentDtoRes = new BillsAndPaymentDto();
			BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();

			GetInvoicePayment getInvoicePayment = new GetInvoicePayment();
			logger.info(" getOutstandingInvoicesList Request : billsAndPaymentDto.getBillingCode()"+billsAndPaymentDto.getBillingCode());
			logger.info(" getOutstandingInvoicesList Request:billsAndPaymentDto.getFromDate()"+billsAndPaymentDto.getFromDate());
			logger.info(" getOutstandingInvoicesList Request: billsAndPaymentDto.getToDate()"+billsAndPaymentDto.getToDate());
			logger.info(" getOutstandingInvoicesList Request : billsAndPaymentDto.getStatus()"+billsAndPaymentDto.getStatus());
			logger.info(" getOutstandingInvoicesList Request: billsAndPaymentDto.getRows().toString()"+billsAndPaymentDto.getRows().toString());
			logger.info(" getOutstandingInvoicesList Request : billsAndPaymentDto.getPage().toString()"+billsAndPaymentDto.getPage().toString());
			getInvoicePayment.setBillingCode(billsAndPaymentDto
					.getBillingCode());
			getInvoicePayment.setSDate(billsAndPaymentDto.getFromDate());
			getInvoicePayment.setEDate(billsAndPaymentDto.getToDate());
			getInvoicePayment.setStatus(billsAndPaymentDto.getStatus());
			getInvoicePayment.setRows(billsAndPaymentDto.getRows().toString());
			getInvoicePayment.setPage(billsAndPaymentDto.getPage().toString());
			GetInvoicePaymentResponse getInvoicePaymentResponse = blueDartServiceStub.getInvoicePayment(getInvoicePayment);
		ArrayOfInvoicePayment arrayOfInvoicePayment = getInvoicePaymentResponse.getGetInvoicePaymentResult();
		InvoicePayment[] invoicePayment = arrayOfInvoicePayment.getInvoicePayment();
			if (null != invoicePayment) {
				logger.info("BillsAndPaymentServiceImpl Response : invoicePayment"+invoicePayment);
				billsAndPaymentDtoRes.setInvoicePayment(invoicePayment);
			} else  {
				logger.info("BillsAndPaymentServiceImpl Response : RecordNotFound for invoicePayment ");
				  billsAndPaymentDtoRes.setRecordNotFound("N");
			}
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.error("BillsAndPaymentServiceImpl Response : Exception"+e.getMessage());
			throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}
		
		return billsAndPaymentDtoRes;
	}
/**
 * 
 * 
 */
	@Override
	public BillsAndPaymentDto approveInvoices(BillsAndPaymentDto billsAndPaymentDto) {
		try {
			logger.info("BillsAndPaymentServiceImpl : approveInvoices");
			BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
		
			BlueDartServiceStub.EntryApprovedData entryApprovedData  = new  BlueDartServiceStub.EntryApprovedData();
			entryApprovedData.setCommasepEntryNo(billsAndPaymentDto.getEntryNo());
			//entryApprovedData.setCommasepEntryNo("98,100,102");
			entryApprovedData.setApprovedBy("Rasmi");
			entryApprovedData.setPage("1");
			entryApprovedData.setRows("5");
			//EntryApprovedData 	entryApprovedData = new 	EntryApprovedData();
			com.bluedart.billsandpayment.helper.BlueDartServiceStub.EntryApprovedDataResponse entryApprovedDataResponse= blueDartServiceStub.entryApprovedData(entryApprovedData);
			ArrayOfApprovedStatus arrayOfApprovedStatus=entryApprovedDataResponse.getEntryApprovedDataResult();
			ApprovedStatus[] approvedStatus = arrayOfApprovedStatus.getApprovedStatus();
			
				billsAndPaymentDtoRes = new BillsAndPaymentDto();

			//System.out.println("Total no of records are " + approvedStatus.length);
			
			billsAndPaymentDtoRes.setApprovedStatus(approvedStatus);
			
			
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}

		return billsAndPaymentDtoRes;
	}
/**
 * 
 * 
 */
	@Override
	public BillsAndPaymentDto payInvoices(BillsAndPaymentSearchDto billsAndPaymentSearchDto) {
		
		try {
			logger.info("BillsAndPaymentServiceImpl : payInvoices");
			BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
			ArrayOfInvoicePaymentFeedToNav arrayOfInvoicePaymentFeedToNav= new ArrayOfInvoicePaymentFeedToNav();
			com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePaymentFeedToNAV0  invoicePaymentFeedToNAV= new com.bluedart.billsandpayment.helper.BlueDartServiceStub.InvoicePaymentFeedToNAV0();
			
			List<BillsAndPaymentDto> billsAndPaymentDtoReq =   billsAndPaymentSearchDto.getBillsAndPaymentDtoList();
			
			 for(BillsAndPaymentDto billsAndPaymentDtoInd:billsAndPaymentDtoReq){  
				InvoicePaymentFeedToNav invoicePaymentFeedToNav= new InvoicePaymentFeedToNav();
				       
				/*
				invoicePaymentFeedToNav.setEntryNo(billsAndPaymentDtoInd.getEntryNo());
				invoicePaymentFeedToNav.setPaymentAmount(billsAndPaymentDtoInd.getPmtToBeMade());
				invoicePaymentFeedToNav.setPaymentBy("Douglas");
				invoicePaymentFeedToNav.setTDS("10");
				invoicePaymentFeedToNav.setTDS(billsAndPaymentDtoInd.getTds());
				
				*/
				
					invoicePaymentFeedToNav.setEntryNo("4");
					invoicePaymentFeedToNav.setPaymentAmount("1000");
					invoicePaymentFeedToNav.setPaymentBy("Douglas");
					invoicePaymentFeedToNav.setTDS("10");
					
				arrayOfInvoicePaymentFeedToNav.addInvoicePaymentFeedToNav(invoicePaymentFeedToNav);
			 }
				
			invoicePaymentFeedToNAV.setLst(arrayOfInvoicePaymentFeedToNav);
			
			InvoicePaymentFeedToNAVResponse invoicePaymentFeedToNAVResponse= blueDartServiceStub.invoicePaymentFeedToNAV(invoicePaymentFeedToNAV);
			
			ArrayOfPaymentFeedToNAV arrayOfPaymentFeedToNAV=invoicePaymentFeedToNAVResponse.getInvoicePaymentFeedToNAVResult();
			
			PaymentFeedToNAV[] paymentFeedToNAV = arrayOfPaymentFeedToNAV.getPaymentFeedToNAV();
		
				billsAndPaymentDtoRes = new BillsAndPaymentDto();
			
				billsAndPaymentDtoRes.setPaymentFeedToNAV(paymentFeedToNAV);
					//System.out.println("Total no of records are " + paymentFeedToNAV.length);
			
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}
		return billsAndPaymentDtoRes;
		
	}
   
	
	
	
	@Override
	public BillsAndPaymentDto getStatementOfOutstandingPayments(
			BillsAndPaymentDto billsAndPaymentDto){
		try {
			logger.info("getStatementOfOutstandingPayments");
			logger.info("getStatementOfOutstandingPayments Request : billsAndPaymentDto.getBillingCode()"+billsAndPaymentDto.getBillingCode());
			logger.info("getStatementOfOutstandingPayments Request:billsAndPaymentDto.getFromDate()"+billsAndPaymentDto.getFromDate());
			logger.info("getStatementOfOutstandingPayments getStatementOfOutstandingPayments Request: billsAndPaymentDto.getToDate()"+billsAndPaymentDto.getToDate());
			logger.info("getStatementOfOutstandingPayments getStatementOfOutstandingPayments Request: Extension)"+"PDF");
			//System.out.println("BD side getStatementOfOutstandingPayments is called");
			BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
			StatementOfOutstandingPayments statementOfOutstandingPayments = new StatementOfOutstandingPayments();
			statementOfOutstandingPayments.setCustomerNo(billsAndPaymentDto.getBillingCode());
			//System.out.println("getStatementOfAccountOutStanding is java side customerno"+statementOfOutstandingPayments);
			// downloadCustomerStatement.setCustomerNo(billsAndPaymentDto.getBillingCode());
			statementOfOutstandingPayments.setSdate(billsAndPaymentDto.getFromDate());
			//System.out.println("getStatementOfAccountOutStanding is java side getFromDate"+statementOfOutstandingPayments);
			// downloadCustomerStatement.setSdate(billsAndPaymentDto.getFromDate().trim());
			// downloadCustomerStatement.setEDate(billsAndPaymentDto.getToDate().trim());
			statementOfOutstandingPayments.setEDate(billsAndPaymentDto.getToDate().trim());
			//System.out.println("getStatementOfAccountOutStanding is java side getToDate"+statementOfOutstandingPayments);
			// downloadCustomerStatement.setEDate("");
			statementOfOutstandingPayments.setExtension("PDF");
			StatementOfOutstandingPaymentsResponse statementOfOutstandingPaymentsResponse = blueDartServiceStub.statementOfOutstandingPayments(statementOfOutstandingPayments);

				
				com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfAccount statementOfAccount= statementOfOutstandingPaymentsResponse.getStatementOfOutstandingPaymentsResult();
				DataHandler dataHandler= statementOfAccount.getFile();
				
				InputStream	is = dataHandler.getInputStream();
				
				byte[] bytes=convertInputStreamToByteArrary(is);
				 
				billsAndPaymentDto.setBytes(bytes);
				logger.info("getStatementOfOutstandingPayments  Response: bytes)"+bytes);
				} catch (Exception e) {
					logger.error("EXCEPTION TYPE :",e);
					e.printStackTrace();
					logger.info("getStatementOfOutstandingPayments getStatementOfOutstandingPayments Response: Exception)"+e.getMessage());
					throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
				}
		finally{
		featureName = Constants.STATEMENT_OF_OUTSTANDING;
		logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+billsAndPaymentDto.getLoginId());
		saveMISLog(featureName,billsAndPaymentDto.getLoginId(),null,null,null);
		logger.debug("---------- SAVED TO MIS LOG ----------");
		}
		return billsAndPaymentDto;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	
	
	@Override
	public BillsAndPaymentDto getStatementOfAccount(
			BillsAndPaymentDto billsAndPaymentDto){
		try {
			logger.info("getStatementOfAccount");
			logger.info("getStatementOfAccount Request : billsAndPaymentDto.getBillingCode()"+billsAndPaymentDto.getBillingCode());
			logger.info("getStatementOfAccount Request:billsAndPaymentDto.getFromDate()"+billsAndPaymentDto.getFromDate());
			logger.info("getStatementOfAccount getStatementOfOutstandingPayments Request: billsAndPaymentDto.getToDate()"+billsAndPaymentDto.getToDate());
			logger.info("getStatementOfAccount getStatementOfOutstandingPayments Request: Extension)"+"PDF");
			
			logger.info("BillsAndPaymentServiceImpl : getStatementOfAccount");
			//System.out.println("BD side getStatementOfAccount is called");
			BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
			
			DownloadCustomerStatement downloadCustomerStatement=new DownloadCustomerStatement();
			
			
			//downloadCustomerStatement.setCustomerNo("FIN000088,DEL003146,BBN005202");
			downloadCustomerStatement.setCustomerNo(billsAndPaymentDto.getBillingCode());
			//System.out.println("getStatementOfAccount is java side customerno"+downloadCustomerStatement);
			//downloadCustomerStatement.setSdate("2017-02-26");
			downloadCustomerStatement.setSdate(billsAndPaymentDto.getFromDate().trim());
			 //System.out.println("getStatementOfAccount is java side fromdate"+downloadCustomerStatement);
			downloadCustomerStatement.setEDate(billsAndPaymentDto.getToDate().trim());
			 //System.out.println("getStatementOfAccount is java side todate"+downloadCustomerStatement);
			//downloadCustomerStatement.setEDate("2017-08-30");
			
			downloadCustomerStatement.setExtension("PDF");
			//System.out.println("getStatementOfAccount is java side PDF"+downloadCustomerStatement);
			DownloadCustomerStatementResponse downloadCustomerStatementResponse = blueDartServiceStub.downloadCustomerStatement(downloadCustomerStatement);

			
			com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfAccount statementOfAccount= downloadCustomerStatementResponse.getDownloadCustomerStatementResult();
			DataHandler dataHandler= statementOfAccount.getFile();
			
			InputStream	is = dataHandler.getInputStream();
			
			byte[] bytes=convertInputStreamToByteArrary(is);
			 
			billsAndPaymentDto.setBytes(bytes);
			logger.info("getStatementOfAccount  Response: bytes)"+bytes);
			} catch (Exception e) {
				logger.error("EXCEPTION TYPE :",e);
				e.printStackTrace();
				logger.info("getStatementOfAccount  Response: Exception)"+e.getMessage());
				throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
			}
			/*DownloadCustomerStatementResponse downloadCustomerStatementResponse;
			
				downloadCustomerStatementResponse = blueDartServiceStub.downloadCustomerStatement(downloadCustomerStatement);
				System.out.println("getStatementOfAccount is java side todate"+downloadCustomerStatementResponse);
				com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfAccount statementOfAccount= downloadCustomerStatementResponse.getDownloadCustomerStatementResult();
				System.out.println("getStatementOfAccount is java side todate"+statementOfAccount);
				DataHandler dataHandler= statementOfAccount.getFile();
				System.out.println("getStatementOfAccount is reponse "+ dataHandler);
				
				InputStream	is = dataHandler.getInputStream();
				
				byte[] bytes=convertInputStreamToByteArrary(is);
				 
				billsAndPaymentDto.setBytes(bytes);
				} catch (Exception e) {
					
					throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
				}
			*/
		finally{
		featureName = Constants.STATEMENT_OF_ACCOUNTS;
		logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+billsAndPaymentDto.getLoginId());
		saveMISLog(featureName,billsAndPaymentDto.getLoginId(),null,null,null);
		logger.debug("---------- SAVED TO MIS LOG ----------");
		}
		return billsAndPaymentDto;
	}
	public  String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
	
	
	public static byte[] convertInputStreamToByteArrary(InputStream in) throws IOException {
		logger.info("BillsAndPaymentServiceImpl : convertInputStreamToByteArrary");
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final int BUF_SIZE = 1024;
	    byte[] buffer = new byte[BUF_SIZE];
	    int bytesRead = -1;
	    while ((bytesRead = in.read(buffer)) > -1) {
	        out.write(buffer, 0, bytesRead);
	    }
	    in.close();
	    byte[] byteArray = out.toByteArray();
	    return byteArray;
	}
	
	/**
	 * 
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	@Override
	public BillsAndPaymentDto downloadStatementOfOutstandingPayments(
			BillsAndPaymentDto billsAndPaymentDto) {
	try {
		logger.info("BillsAndPaymentServiceImpl : downloadStatementOfOutstandingPayments");
			//System.out.println("BD side downloadStatementOfAccount is called");
			
			logger.info("downloadStatementOfOutstandingPayments");
			logger.info("downloadStatementOfOutstandingPayments Request : billsAndPaymentDto.getBillingCode()"+billsAndPaymentDto.getBillingCode());
			logger.info("downloadStatementOfOutstandingPayments Request:billsAndPaymentDto.getFromDate()"+billsAndPaymentDto.getFromDate());
			logger.info("downloadStatementOfOutstandingPayments getStatementOfOutstandingPayments Request: billsAndPaymentDto.getToDate()"+billsAndPaymentDto.getToDate());
			logger.info("downloadStatementOfOutstandingPayments getStatementOfOutstandingPayments Request: billsAndPaymentDto.getIsPdf())"+billsAndPaymentDto.getIsPdf());
			
		BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
		StatementOfOutstandingPayments statementOfOutstandingPayments = new StatementOfOutstandingPayments();
		//statementOfOutstandingPayments.setCustomerNo("FIN000046,FIN000073,FIN000076,FIN000083");
		statementOfOutstandingPayments.setCustomerNo(billsAndPaymentDto.getBillingCode());
		// downloadCustomerStatement.setCustomerNo(billsAndPaymentDto.getBillingCode());
		//statementOfOutstandingPayments.setSdate("2017-01-01");
		statementOfOutstandingPayments.setSdate(billsAndPaymentDto.getFromDate().trim());
		// downloadCustomerStatement.setSdate(billsAndPaymentDto.getFromDate().trim());
		// downloadCustomerStatement.setEDate(billsAndPaymentDto.getToDate().trim());
		//statementOfOutstandingPayments.setEDate("2017-04-01");
		statementOfOutstandingPayments.setEDate(billsAndPaymentDto.getToDate().trim());
		// downloadCustomerStatement.setEDate("");
		
		if(billsAndPaymentDto.getIsPdf()){
			statementOfOutstandingPayments.setExtension("PDF");
			//System.out.println("billsAndPayment downloadStatementOfOutstandingPayments PDF----------"+ statementOfOutstandingPayments);
		} else {
			statementOfOutstandingPayments.setExtension("EXCEL");
			//System.out.println("billsAndPayment downloadStatementOfOutstandingPayments EXCEL================"+ statementOfOutstandingPayments);
		}
		//statementOfOutstandingPayments.setExtension("EXCEL");
		StatementOfOutstandingPaymentsResponse statementOfOutstandingPaymentsResponse = blueDartServiceStub.statementOfOutstandingPayments(statementOfOutstandingPayments);
		com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfAccount statementOfAccount= statementOfOutstandingPaymentsResponse.getStatementOfOutstandingPaymentsResult();
		DataHandler dataHandler= statementOfAccount.getFile();
		//System.out.println("billsAndPayment download"+ dataHandler);
		InputStream	is = dataHandler.getInputStream();
		//System.out.println("billsAndPayment download"+ is);
		byte[] bytes=convertInputStreamToByteArrary(is);
		//System.out.println("billsAndPayment download"+ bytes);
		logger.info("downloadStatementOfOutstandingPayments  Response: bytes)"+bytes);
		billsAndPaymentDto.setBytes(bytes);
		//System.out.println("billsAndPayment download set bytes"+ bytes);
			} catch (Exception e) {
				logger.error("EXCEPTION TYPE :",e);
				logger.info("downloadStatementOfOutstandingPayments  Response: Exception)"+e.getMessage());
				throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
			}
	finally{
	featureName = Constants.STATEMENT_OF_OUTSTANDING;
	logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+billsAndPaymentDto.getLoginId());
	saveMISLog(featureName,billsAndPaymentDto.getLoginId(),null,null,null);
	logger.debug("---------- SAVED TO MIS LOG ----------");
	}
	return billsAndPaymentDto;
	}
	/**
	 * 
	 * 
	 * 
	 * @param billsAndPaymentDto
	 * @return
	 */
	@Override
	public BillsAndPaymentDto downloadStatementOfAccount(
			BillsAndPaymentDto billsAndPaymentDto) {
	try {
		logger.info("BillsAndPaymentServiceImpl : downloadStatementOfAccount");
		logger.info("downloadStatementOfAccount");
		logger.info("downloadStatementOfAccount Request : billsAndPaymentDto.getBillingCode()"+billsAndPaymentDto.getBillingCode());
		logger.info("downloadStatementOfAccount Request:billsAndPaymentDto.getFromDate()"+billsAndPaymentDto.getFromDate());
		logger.info("downloadStatementOfAccount getStatementOfOutstandingPayments Request: billsAndPaymentDto.getToDate()"+billsAndPaymentDto.getToDate());
		logger.info("downloadStatementOfAccount getStatementOfOutstandingPayments Request: billsAndPaymentDto.getIsPdf())"+billsAndPaymentDto.getIsPdf());
	
			//System.out.println("BD side downloadStatementOfAccount is called");
			BlueDartServiceStub blueDartServiceStub = new BlueDartServiceStub();
			
			DownloadCustomerStatement downloadCustomerStatement=new DownloadCustomerStatement();
			downloadCustomerStatement.setCustomerNo(billsAndPaymentDto.getBillingCode());
			//System.out.println("billsAndPaymentDto.getBillingCode()"+billsAndPaymentDto.getBillingCode());
		  // downloadCustomerStatement.setSdate("2017-01-01");
		    downloadCustomerStatement.setSdate(billsAndPaymentDto.getFromDate().trim());
			downloadCustomerStatement.setEDate(billsAndPaymentDto.getToDate().trim());
			//downloadCustomerStatement.setExtension(billsAndPaymentDto.getExtension().toString());
			if(billsAndPaymentDto.getIsPdf()){
				downloadCustomerStatement.setExtension("PDF");
				//System.out.println("billsAndPayment downloadStatementOfAccount download PDF----------"+ downloadCustomerStatement);
			} else {
				downloadCustomerStatement.setExtension("EXCEL");
				//System.out.println("billsAndPayment downloadStatementOfAccount EXCEL================"+ downloadCustomerStatement);
			}
			DownloadCustomerStatementResponse downloadCustomerStatementResponse = blueDartServiceStub.downloadCustomerStatement(downloadCustomerStatement);
			com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfAccount statementOfAccount= downloadCustomerStatementResponse.getDownloadCustomerStatementResult();
			DataHandler dataHandler= statementOfAccount.getFile();
			InputStream	is = dataHandler.getInputStream();
			byte[] bytes=convertInputStreamToByteArrary(is);
			//System.out.println("BD downloadStatementOfAccount bytes"+bytes);
			billsAndPaymentDto.setBytes(bytes);
			logger.info("downloadStatementOfAccount  Response: bytes)"+bytes);
				} catch (Exception e) {
					logger.error("EXCEPTION TYPE :",e);
					logger.info("downloadStatementOfAccount  Response: Exception)"+e.getMessage());
					throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
				}
			/*DownloadCustomerStatementResponse downloadCustomerStatementResponse;
				downloadCustomerStatementResponse = blueDartServiceStub.downloadCustomerStatement(downloadCustomerStatement);
				com.bluedart.billsandpayment.helper.BlueDartServiceStub.StatementOfAccount statementOfAccount= downloadCustomerStatementResponse.getDownloadCustomerStatementResult();
				DataHandler dataHandler= statementOfAccount.getFile();
				InputStream	is = dataHandler.getInputStream();
				byte[] bytes=convertInputStreamToByteArrary(is);
				billsAndPaymentDto.setBytes(bytes);
				} catch (Exception e) {
					
					throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
				}
			*/
	finally{
			featureName = Constants.STATEMENT_OF_ACCOUNTS; 
			logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+billsAndPaymentDto.getLoginId());
			saveMISLog(featureName,billsAndPaymentDto.getLoginId(),null,null,null);
			logger.debug("---------- SAVED TO MIS LOG ----------");
	}
		return billsAndPaymentDto;
	}
	
	@Override
	public BillsAndPaymentDto getBillingCodes(String loginId, String permission_name) {
		return billsAndPaymentDao.getBillingCodes(loginId, permission_name);
	}
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
}