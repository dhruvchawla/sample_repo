package com.bluedart.contactus.daoImpl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.contactus.dao.ContactUsDao;
import com.bluedart.locationfinder.dao.ServiceStationDao;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author CH848113
 * Class is used to get the location code based on either pin code or location name.
 */
@Repository
public class ContactUsDaoImpl extends BaseDaoImpl implements ContactUsDao{
	
	private static final Logger log = Logger.getLogger(ContactUsDaoImpl.class);
	private Properties properties = new Properties();
	
	@Autowired
	private ServiceStationDao serviceStationDao;
	
	/*
	 * Method is used to get the location based on either location name or pincode
	 */
	@Transactional
	@Override
	public String getLocation(String locationName,String locationPinCode)  {
		log.debug("ContactUsDaoImpl : get location");
		String locationCode = null;
		try{
		
			if(locationPinCode != null && !(locationPinCode.isEmpty())){
				locationCode = getLocationCode(locationPinCode);
			}if(locationCode == null && locationName != null && !(locationName.isEmpty())){
				AreaDTO area =serviceStationDao.getAreaCodes(locationName);
				if(area != null){
					locationCode = area.getCarea();
				}
			}
			
		/* this code should not be removed,if location is other than India & location code not for India then
		default code should be set from defaultLocationConfig.properties */
		if(locationCode == null){
					properties.load(getClass().getClassLoader()
							.getResourceAsStream("defaultLocationConfig.properties"));
					locationCode = properties.getProperty("locationCode");
		}
		log.debug("Location code is :"+locationCode);
		} catch (IOException e) {
			log.error("EXCEPTION TYPE :",e);
			
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			
		}
		catch(DataBaseException e){
			log.error("EXCEPTION TYPE :",e);
			
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return locationCode;
	} 
	
	
	// method is used to get the location code based on pin code.
	private String getLocationCode(String locationPinCode){
		try{
			SQLQuery query = getSession().createSQLQuery("SELECT CAREA FROM PINCDMST where CPINCODE =:locationPinCode");
			query.setParameter("locationPinCode", locationPinCode);
			List locationCodes = query.list();
			if(!locationCodes.isEmpty()){
				return locationCodes.get(0).toString();
			}
		}
		catch(DataBaseException e){
			log.error("EXCEPTION TYPE :",e);
			
			return null;
		}
		
		return null;		
	}

	@Transactional
	@Override
	public Boolean isValidWayBillNo(String awbNo) {
		boolean isValid = false;
		try{
			SQLQuery query = getSession().createSQLQuery("select CAWBNO from shipment where CAWBNO =:awbNo");
			query.setParameter("awbNo", awbNo);
			List locationCodes = query.list();
			if(!locationCodes.isEmpty()){
				isValid = true;
				return isValid;
			}
		}
		catch(DataBaseException e){
			log.error("EXCEPTION TYPE :",e);
			
			return isValid;
		}
		return isValid;
	}
}
