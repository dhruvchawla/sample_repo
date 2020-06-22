package com.bluedart.billsandpayment.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.billsandpayment.dao.BillsAndPaymentDao;
import com.bluedart.billsandpayment.dto.BillsAndPaymentDto;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;

/**
 * @author ra848436
 */

@Repository
public class BillsAndPaymentDaoImpl extends BaseDaoImpl implements BillsAndPaymentDao {
	
	private static final Logger logger = Logger.getLogger(BillsAndPaymentDaoImpl.class);

	@Override
	@Transactional
	public BillsAndPaymentDto getBillingCodes (String loginId,String permission_name) {
		BillsAndPaymentDto returnDto = new BillsAndPaymentDto();
		StringBuilder sqlQuery = new StringBuilder();
		ScrollableResults results = null;
		try{
		sqlQuery.append("SELECT  CONCAT(AFF_AC,AFF_CC) abc FROM uprofile4.bd_permission_mapping pmap, uprofile4.BD_permission_master pm ")
		.append("WHERE pmap.permission_id  = pm.permission_id ")
		.append("AND upper(pm.status)  ='Y'")
		.append("AND upper(permission_name)=upper("+"'"+permission_name+"'"+")")
		.append("AND upper(loginid) ="+"'"+loginId+"'"+" ");
		
		 
		
		List<BillsAndPaymentDto> billingCodeList = new ArrayList<>();
		
		System.out.println(sqlQuery.toString());
		
		results = getSession().createSQLQuery(sqlQuery.toString()).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
		
		
		while (results.next()) {
			BillsAndPaymentDto billsAndPaymentDto = new BillsAndPaymentDto();
			billsAndPaymentDto.setBillingCode(results.get()[0].toString());
			billingCodeList.add(billsAndPaymentDto);
		}
		returnDto.setBillsAndPaymentDtoList(billingCodeList);
		
		} catch(Exception e){
			logger.error("EXCEPTION TYPE :",e);
			
			
			//System.out.println("Exception " + e);
		}finally{
			logger.debug("---------------getBillingCodes finally-------------");
			CloseConnections.closeScrollableResults(results);
		}
			

	return returnDto;

}}
