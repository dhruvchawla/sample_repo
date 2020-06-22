package com.bluedart.common.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.MailLinkDao;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.entity.MailLink;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

@Repository
public class MailLinkDaoImpl extends BaseDaoImpl  implements MailLinkDao {
	private static final Logger logger = Logger.getLogger(MailLinkDaoImpl.class);
	private MailLink maillink = null;
	private List<MailLink> maillinkList = null;
	
	@Transactional
	@Override
	public MailLink getEmailIds(AreaDTO area, String interfaceCode) throws BlueDartException {
		SQLQuery query;
		String queryString;
		MailLink mailLink = null;
		try{
			queryString = "select * from("+
					"select '1' ord_num,ml.* from maillink ml where cinterface=:interfaceCode and cmaillink=:serviceStation "+
					" union "+
					"select '2' ord_num,ml.* from maillink ml where cinterface=:interfaceCode and cmaillink=:area "+
					" union "+
					"select '3' ord_num,ml.* from maillink ml where cinterface=:interfaceCode and cmaillink=:branch "+
					" union "+
					"select '4' ord_num,ml.* from maillink ml where cinterface=:interfaceCode and cmaillink=:region "+
					" union "+
					"select '5' ord_num,ml.* from maillink ml where cinterface=:interfaceCode and cmaillink=:allIndiaCode) "+ 
			" where rownum=1 order by ord_num";
	query = getSession().createSQLQuery(queryString);
			
			query.setParameter("interfaceCode", interfaceCode);
			if(area != null && area.getCscrcd() != null){
				query.setParameter("serviceStation", area.getCscrcd());
			}else{
				query.setParameter("serviceStation", "");
			}
			
			if(area != null && area.getCarea()!= null){
				query.setParameter("area", area.getCarea());
			}else{
				query.setParameter("area", "");
			}
			
			if(area != null && area.getCbranch() != null){
				query.setParameter("branch", area.getCbranch());
			}else{
				query.setParameter("branch", "");
			}
			
			if(area != null && area.getCregion()!= null){
				query.setParameter("region", getRegion(area.getCregion()));
			}else{
				query.setParameter("region", "");
			}
						
			query.setParameter("allIndiaCode", "XXX");
			
			
			List<Object[]> mailLinkObjects = query.list();
			
			if(mailLinkObjects != null && mailLinkObjects.size() >0){
			Object[] mailLinks = mailLinkObjects.get(0);
				if(mailLinks != null){
					mailLink = new MailLink();
					mailLink.setcMailLink(mailLinks[1].toString());
					mailLink.setcInterface(mailLinks[2].toString());
					mailLink.setcMailTo(mailLinks[3].toString());
					if(mailLinks[4] != null)
						mailLink.setcMailCC(mailLinks[4].toString());
					}
			}
			
		}
	    catch(BlueDartException e){
			logger.error("EXCEPTION TYPE :",e);
			
	    	logger.error(e.getMessage());
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}

		return mailLink;
	}
	
	
	private String getRegion(String pRegion){
		String region = null;
		switch (pRegion){
			case "EAST" :{
				region = "E";
				break;
			}
			case "NORTH" :{
				region = "N";
				break;
			}
			case "SOUTH1" :{
				region = "S1";
				break;
			}
			case "SOUTH2" :{
				region = "S2";
				break;
			}
			case "WEST1" :{
				region = "W1";
				break;
			}
			case "WEST2" :{
				region = "W2";
				break;
			}
			case "HO" :{
				region = "HO";
				break;
			}

		}
		return region;
	}


	@Override
	@Transactional
	public List<MailLink> getEmailIds(String[] regions, String interfaceCode) throws BlueDartException {
		
		maillinkList = new ArrayList<MailLink>();
		
		List<String> region = new ArrayList<String>();
		
		for (String regionToPass : regions) {
			region.add(getRegion(regionToPass));
		}
		
		String[] reg = region.toArray(new String[region.size()]);
		
		try {
			maillinkList = (List<MailLink>) getSession().doReturningWork(new ReturningWork<List<MailLink>>() {
				@Override
				public List<MailLink> execute(Connection connection) throws SQLException {
					List<MailLink> mailList = new ArrayList<MailLink>();
					CallableStatement callableStatement = null;
					ResultSet resultSet = null;
					try {
						ArrayDescriptor des = ArrayDescriptor.createDescriptor("UPROFILE4.GENERIC_VARCHAR_TYPE", connection);
						ARRAY regionsArray = null;
						try {
							regionsArray = new ARRAY(des, connection, reg);
							
							callableStatement = connection.prepareCall("{call UPROFILE4.PACK_MANAGEUSERS.GET_MAILINK(?,?,?)}");
							
							callableStatement.setArray(1, regionsArray);
							callableStatement.setString(2, interfaceCode);
							((OracleCallableStatement) callableStatement).registerOutParameter(3, OracleTypes.CURSOR);
							
							((OracleCallableStatement) callableStatement).execute();
							
							resultSet = (ResultSet)callableStatement.getObject (3);

							 while (resultSet.next ()){								 
								 maillink = new MailLink();
								 
								 maillink.setcInterface(resultSet.getString ("CINTERFACE"));
								 maillink.setcMailCC(resultSet.getString ("CMAILCC"));
								 maillink.setcMailCC1(resultSet.getString ("CMAILCC1"));
								 maillink.setcMailLink(resultSet.getString ("CMAILLINK"));
								 maillink.setcMailTo(resultSet.getString ("CMAILTO"));
								 
								 logger.debug(resultSet.getString ("CMAILLINK"));
								 logger.debug(resultSet.getString ("CMAILTO"));
								 logger.debug(resultSet.getString ("CMAILCC"));
								 logger.debug(resultSet.getString ("CMAILCC1"));
								 
								mailList.add(maillink);
							 }
						
							
						} catch (Exception exception) {
							logger.error("EXCEPTION TYPE :",exception);
							
							//logger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
					} finally {
						logger.debug("-------------getEmailIds finally -------------");
						CloseConnections.closeResultSet(resultSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return mailList;
				}
			});
		} catch(Exception exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			
			logger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		return maillinkList;		
	}	

}
