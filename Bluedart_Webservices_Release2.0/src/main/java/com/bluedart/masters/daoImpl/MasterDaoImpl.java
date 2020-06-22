package com.bluedart.masters.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.masters.dao.MasterDao;
import com.bluedart.masters.dto.CountryDto;
import com.bluedart.masters.dto.StateDto;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author CH848113
 */
@Repository
public class MasterDaoImpl extends BaseDaoImpl implements MasterDao{
	private static final Logger logger = Logger.getLogger(MasterDaoImpl.class); 
	
	@Transactional
	@Override
	public AreaDTO getSABR(String pinCode) throws BlueDartException {
		
		AreaDTO area = null;
		try{
			
			SQLQuery query = getSession().createSQLQuery("select distinct area.CSCRCD,area.CAREA,area.CBRANCH,area.CREGION from AREAMST area, "
					+ "PINCDMST pin where pin.CSCRCD=area.CSCRCD and pin.CPINCODE  =:pinCode"); 
			query.setParameter("pinCode", pinCode);
			List<Object[]> serviceStationCodes = query.list();
			for (Object[] serviceStationCode : serviceStationCodes) {
				
			if(serviceStationCode != null ){
				area = new AreaDTO();
				area.setCscrcd(serviceStationCode[0].toString());
				area.setCarea(serviceStationCode[1].toString());
				area.setCbranch(serviceStationCode[2].toString());
				area.setCregion(serviceStationCode[3].toString());
				}
			}
		}
		catch(BlueDartException e){
			logger.error("EXCEPTION TYPE :",e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		finally{
			
		}
		return area;

	}
	
	@Transactional
	@Override
	public List<StateDto> getStates() throws BlueDartException {
		
		List<StateDto> statesList = new ArrayList<>();
		try {
			
			statesList = new ArrayList<StateDto>();
			String queryString = "Select distinct state.CSTATECD, state.CSTATE from STATEMST state";
			Query query =  getSession().createSQLQuery(queryString);
			StateDto stateDto;
			List<Object[]> stateList = query.list();
			for (Object[] states : stateList) {
				
			if(states != null ){
				stateDto = new StateDto();
				stateDto.setStateId(states[0].toString());
				stateDto.setStateDescription(states[1].toString());
				statesList.add(stateDto);
				}
			}
			
			System.out.println("States List Size is :"+statesList.size());
		} catch (BlueDartException exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} finally {
			logger.debug("-----------------In GetStates Finally Block---------------------");
		}
		
		
		Collections.sort(statesList,new StateComparatorUtil());
		
		return statesList;
	}
	
	@Transactional
	@Override
	public List<CountryDto> getCountries() throws BlueDartException {
		
		List<CountryDto> countries = new ArrayList<>();
		try {
			
			countries = new ArrayList<CountryDto>();
			String queryString = "select country.CCNTRYCODE,country.CCNTRYNAME from CNTRYMST country";
			Query query =  getSession().createSQLQuery(queryString);
			CountryDto countryDto = new CountryDto();
			List<Object[]> countryList = query.list();
			
			countryDto.setCountryId("IN");
			countryDto.setCountryDescription("INDIA");
			countries.add(countryDto);
			
			for (Object[] countrys : countryList) {
				
			if(countrys != null ){
				countryDto = new CountryDto();
				countryDto.setCountryId(countrys[0].toString());
				countryDto.setCountryDescription(countrys[1].toString());
				countries.add(countryDto);
				}
			}
			
			System.out.println("Countries List Size is :"+countries.size());
		} catch (BlueDartException exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} finally {
			logger.debug("-----------------In get countries Finally Block---------------------");
		}
		Collections.sort(countries,new CountryComparatorUtil());
		return countries;
	}
	
}	

class StateComparatorUtil implements Comparator<StateDto>{  
	
	public int compare(StateDto obj1, StateDto obj2) {
		   //ascending order
		   return obj1.getStateDescription().compareTo(obj2.getStateDescription());
	    }
}

class CountryComparatorUtil implements Comparator<CountryDto>{  
	
	public int compare(CountryDto obj1, CountryDto obj2) {
		   //ascending order
		   return obj1.getCountryDescription().compareTo(obj2.getCountryDescription());
	    }
}
	