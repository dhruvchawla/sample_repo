package com.bluedart.managelicensekey.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bluedart.common.entity.BDAuditLog;
import com.bluedart.common.entity.BDAuditLogValues;


@Component
//@PropertySource("classpath:tablesDetails.properties")
public class ManageLicenseKeyTables {

	@Autowired
	Environment environment;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<HashMap<String, List<String>>> getTablesAndColumns(String action){
		
		List<HashMap<String, List<String>>> tablesAndColumns = new ArrayList<HashMap<String, List<String>>>();
		//HashMap<String, List<String>> tableDetails = new HashMap<String, List<String>>();
		
		
		
		if(action.equalsIgnoreCase("delete") || action.equalsIgnoreCase("deactivate") || action.equalsIgnoreCase("reactivate"))
		{
			//--------------------------------Table 1---------------------------------------------------------------------------
			List<String> columns1 = new ArrayList<String>();
			HashMap<String, List<String>> tableDetails1 = new HashMap<String, List<String>>();
			columns1.add("STATUS");
			tableDetails1.put("APILIC_T", columns1);
			tablesAndColumns.add(tableDetails1);
			//--------------------------------Table 2---------------------------------------------------------------------------
			List<String> columns2 = new ArrayList<String>();
			HashMap<String, List<String>> tableDetails2 = new HashMap<String, List<String>>();
			columns2.add("col1");
			columns2.add("col2");
			columns2.add("col3");
			tableDetails2.put("TESTTABLE", columns2);
			tablesAndColumns.add(tableDetails2);
			
		}
		else{
		//-------------------------------Table 1----------------------------------------------------------------------------
			List<String> columns1 = new ArrayList<String>();
			HashMap<String, List<String>> tableDetails1 = new HashMap<String, List<String>>();
		columns1.add("LOGINID");
		columns1.add("API_TYPE");
		columns1.add("LICENSE");
		columns1.add("VERSION");
		columns1.add("STATUS");
		columns1.add("INSERTION_DATE");
		tableDetails1.put("APILIC_T", columns1);
		tablesAndColumns.add(tableDetails1);
		
		//--------------------------------Table 2---------------------------------------------------------------------------
		List<String> columns2 = new ArrayList<String>();
		HashMap<String, List<String>> tableDetails2 = new HashMap<String, List<String>>();
		columns2.add("col1");
		columns2.add("col2");
		columns2.add("col3");
		columns2.add("col4");
		columns2.add("col5");
		tableDetails2.put("TESTTABLE_CREATE", columns2);
		tablesAndColumns.add(tableDetails2);
		
		}
		
		return tablesAndColumns;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------
	
	public boolean logData(String action,String data[])
	{
		Properties audit_log = new Properties();
		//audit_log.
		try {
			audit_log.load(getClass().getClassLoader().getResourceAsStream("tablesDetails.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("properties error.....................................");
			e.printStackTrace();
		} 
		
		System.out.println(audit_log.getProperty("manageLicenseKey.functionalityName"));
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		
		Date insertionDate = new Date();
		
		BDAuditLog bdAuditLog = new BDAuditLog();  
		BDAuditLogValues bDAuditLogValues = new BDAuditLogValues();
		if(action.equalsIgnoreCase("create"))
		{
			/*AuditLogDetailsDto auditLogDetailsDto = new AuditLogDetailsDto();
			auditLogDetailsDto.setMod_seq_number(current_sequenceNumber);
			auditLogDetailsDto.setModule_name(moduleName);
			auditLogDetailsDto.setTable_name(currentTableName);
			auditLogDetailsDto.setColumn_name(element_columns);
			auditLogDetailsDto.setOld_value(data.get(currentTableName)[i]);
			auditLogDetailsDto.setNew_value("none");
			auditLogDetailsDto.setAudit_stmt(action);
			auditLogDetailsDto.setLogged_by(adminLoginId);
			auditLogDetailsDto.setLogged_to(toLoginId);*/
			//auditLogDetailsList.add(auditLogDetailsDto);
			bDAuditLogValues.setAudValueId(1);
			bDAuditLogValues.setColumnValue("NewLogin");
			
			bdAuditLog.setModSeqNumber(111);
			bdAuditLog.setModuleName(audit_log.getProperty("MANAGELICENSEKEY.FUNCTIONALITYNAME"));
			bdAuditLog.setTableName(audit_log.getProperty("MANAGELICENSEKEY.UPROFILE4.APILIC_T"));
			bdAuditLog.setColumnName(audit_log.getProperty("MANAGELICENSEKEY.UPROFILE4.APILIC_T.LOGINID"));
			bdAuditLog.setSchemaName(audit_log.getProperty("MANAGELICENSEKEY.UPROFILE4"));
			bdAuditLog.setLogDate(insertionDate);
			bdAuditLog.setLoggedBy("12345");
			bdAuditLog.setLoggedTo("11111");
			
			
		}
		
		
		return false;
		
	}
	
	
}
