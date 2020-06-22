/**
 * 
 */
package com.bluedart.mguserviewprofile.daoImpl;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.exception.BlueDartException;
import com.bluedart.mguserviewprofile.dao.ManageUserViewProfileDao;
import com.bluedart.mguserviewprofile.dto.ManageUserViewProfileDto;


/**
 * @author Velayutham Balasubramanian
 *
 */
@Repository
public class ManageUserViewProfileDaoImpl extends BaseDaoImpl implements ManageUserViewProfileDao {
	//private static Log logger = LogFactory.getLog(ManageUserViewProfileDaoImpl.class);
	private static final Logger logger = Logger.getLogger(ManageUserViewProfileDaoImpl.class); 
	private Session session = null;

	
	@Override
	@Transactional
	public ManageUserViewProfileDto manageUserViewProfile(String vloginid) throws BlueDartException {
		
		Set<String> regionList = new HashSet();
		Set<String> roleList = new HashSet();
		ManageUserViewProfileDto manageUserViewProDto = new ManageUserViewProfileDto();
		try{
			session = getSession();
			String queryStr  =	"select distinct ur.screenname,bu.loginid,ur.userid,Ur.Firstname,Ur.Lastname,Ur.Emailaddress,Bu.Cemplcode,Bu.Bd_User_Id,Bur.Cregion,Rl.Name from webportal.user_ ur, uprofile4.bd_users bu,UPROFILE4.Bd_Users_Region bur,webportal.users_roles uo, webportal.role_ rl where 1=1 and upper(UR.SCREENNAME)=upper(BU.LOGINID)and Bu.Bd_User_Id=Bur.Bd_User_Id and uo.roleid=rl.roleid and uo.userid=ur.userid and ur.userid=:uo.userid";
			SQLQuery query = session.createSQLQuery(queryStr);
			query.setParameter("uo.userid", vloginid);
			List objects = query.list();
			//List li2 = new ArrayList(new HashSet(objects)); //no order
			Iterator itr=objects.iterator();
			while(itr.hasNext()){
				Object obj[]=(Object[])itr.next();
				if(obj[5].toString().indexOf("_////_") != -1 ) {
					String emailArr[] = obj[5].toString().split("_////_",0);
					manageUserViewProDto.setEmail(emailArr[1]);
					//viewProifileList.add("email:"+emailArr[1]);
				}else {
					manageUserViewProDto.setEmail(obj[5].toString());
					//viewProifileList.add("email:"+obj[5].toString());
				}
				
				/*viewProifileList.add("name:"+obj[1].toString());
				viewProifileList.add("region:"+obj[8].toString());
				viewProifileList.add("role:"+obj[9].toString());*/
				
				manageUserViewProDto.setName(obj[3].toString());
				manageUserViewProDto.setEmpCode(obj[1].toString());
				//manageUserViewProDto.setRegion(obj[8].toString());
				//manageUserViewProDto.setRole(obj[9].toString());
				roleList.add(obj[9].toString());
				regionList.add(obj[8].toString());
				
			}
			String[] regionArr = new String[regionList.size()];
			String[] roleArr = new String[roleList.size()];
			int i=0;
			int j=0;
			for(String obj:regionList) {
				regionArr[i++] = obj;
				manageUserViewProDto.setRegion(Arrays.toString(regionArr).replace("[", "").replace("]", ""));
			}
			
			for(String obj:roleList) {
				roleArr[j++] = obj;
				manageUserViewProDto.setRole(Arrays.toString(roleArr).replace("[", "").replace("]", ""));
			}

		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new BlueDartException("DB Down", "Unable to connect Database");
		}  
		return manageUserViewProDto;

	} 
}
