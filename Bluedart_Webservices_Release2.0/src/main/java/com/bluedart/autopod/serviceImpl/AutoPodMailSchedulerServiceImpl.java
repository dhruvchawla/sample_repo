package com.bluedart.autopod.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.autopod.dao.AutoPodMailSchedulerDao;
import com.bluedart.autopod.service.AutoPodMailSchedulerService;
import com.bluedart.exception.PodMailServiceException;
import com.bluedart.utils.SpringApplicationContext; 

@Service
public class AutoPodMailSchedulerServiceImpl implements AutoPodMailSchedulerService {
	
	@Autowired
	private AutoPodMailSchedulerDao autoPodMailSchedulerDao;
	 
	
	
	
	public AutoPodMailSchedulerServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
/*	

	@Override
	public void runReport(String loginid, String emailid, String frequency,
			String reporttype, int runday, Date lastrundate,
			String lastruntime, String attachment, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder)
			throws PodMailServiceException {
		
		autoPodMailSchedulerDao = (AutoPodMailSchedulerDao) SpringApplicationContext.getBean("autoPodMailSchedulerDao");
		
		autoPodMailSchedulerDao.generateReport(loginid, emailid, frequency, reporttype, runday, lastrundate, lastruntime, attachment, orgAreaCode, dstAreaCode, sortBy, sortOrder);
		
	}

	@Override
	public long createReportFile(boolean trackByLoginId, int secLevel,
			String loginid, String custCC, String custAC, Date dateFrom,
			Date dateTo, String prodCode, String status, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder,
			String frequency) throws PodMailServiceException {
		
		autoPodMailSchedulerDao = (AutoPodMailSchedulerDao) SpringApplicationContext.getBean("autoPodMailSchedulerDao");
		
		autoPodMailSchedulerDao.createReportFile(trackByLoginId, secLevel, loginid, custCC, custAC, dateFrom, dateTo, prodCode, status, orgAreaCode, dstAreaCode, sortBy, sortOrder, frequency);
	
		return 0;
	}

	@Override
	public StringBuffer GetOverridePODDetails(boolean trackByLoginId,
			int secLevel, String loginid, String custCC, String custAC,
			Date dateFrom, Date dateTo, String prodCode, String status,
			String orgAreaCode, String dstAreaCode, String sortBy,
			String sortOrder, String frequency) throws PodMailServiceException {
		autoPodMailSchedulerDao = (AutoPodMailSchedulerDao) SpringApplicationContext.getBean("autoPodMailSchedulerDao");
		//autoPodMailSchedulerDao.getOverridePODDetails(trackByLoginId, secLevel, loginid, custCC, custAC, dateFrom, dateTo, prodCode, status, orgAreaCode, dstAreaCode, sortBy, sortOrder, frequency);
		
		return null;
	}*/

	@Override
	public List<Object[]> getPodmailTDetails() throws PodMailServiceException {
		
		List<Object[]> objects=	autoPodMailSchedulerDao.getPodmailTDetails();
		return objects;
	}

/*	@Override
	public void generateReports() {
		// TODO Auto-generated method stub
		
		
		
		
		
	}*/

}
