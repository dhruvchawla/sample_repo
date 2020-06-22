package com.bluedart.common.dao;

import java.util.List;

import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.entity.MailLink;
import com.bluedart.exception.BlueDartException;

/*
 * @Author CH848113
 * 
 */

public interface MailLinkDao {
	public MailLink getEmailIds(AreaDTO area,String interfaceCode)throws BlueDartException ;
	
	
	/*
	 * To get emailIds based on multiple regions, for BDAdmin functionality
	 */
	public List<MailLink> getEmailIds(String[] regions, String interfaceCode) throws BlueDartException;
}
