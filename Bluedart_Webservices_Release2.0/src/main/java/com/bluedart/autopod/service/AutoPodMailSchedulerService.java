/**
 * 
 */
package com.bluedart.autopod.service;

import java.sql.Date;
import java.util.List;

import com.bluedart.exception.PodMailServiceException;

/**
 * @author RA848436
 *
 */
public interface AutoPodMailSchedulerService {
	
/*	public void generateReports();
	
	public  void runReport(String loginid, String emailid,
			String frequency, String reporttype, int runday, Date lastrundate,
			String lastruntime, String attachment, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder) throws PodMailServiceException;
	
	
	public long createReportFile(boolean trackByLoginId, int secLevel,
			String loginid, String custCC, String custAC,
			java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode,
			String status, String orgAreaCode, String dstAreaCode,
			String sortBy, String sortOrder, String frequency) throws PodMailServiceException;
	
	
	public  StringBuffer GetOverridePODDetails(boolean trackByLoginId,
			int secLevel, String loginid, String custCC, String custAC,
			java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode,
			String status, String orgAreaCode, String dstAreaCode,
			String sortBy, String sortOrder, String frequency) throws PodMailServiceException;*/
	
	
	 public List<Object[]> getPodmailTDetails()  throws PodMailServiceException;
	

}
