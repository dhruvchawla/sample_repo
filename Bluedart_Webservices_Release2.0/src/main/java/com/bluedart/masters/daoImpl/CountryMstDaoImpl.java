package com.bluedart.masters.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.entity.CountryMst;
import com.bluedart.masters.dao.CountryMstDao;
import com.bluedart.masters.dto.CountryMstDto;

/**
 * 
 * @author DH839598
 *
 */
@Repository
public class CountryMstDaoImpl extends BaseDaoImpl implements CountryMstDao {
	
	private static final Logger logger = Logger.getLogger(CountryMstDaoImpl.class); 
	@Transactional
	@Override
	public List<CountryMstDto> getCountryList() {
		List<CountryMstDto>  countryMstDtoList = null;
		try{
		CountryMstDto countryMstDto;
		countryMstDtoList = new ArrayList<>();
		Criteria criteria = getSession().createCriteria(CountryMst.class).addOrder(Order.asc("countryName"));
		List<CountryMst> countryMstList = (List<CountryMst>) criteria.list();
		for(CountryMst countryMst : countryMstList){
			countryMstDto = new CountryMstDto();
			countryMstDto.setCountryCode(countryMst.getCountryCode());
			countryMstDto.setCountryName(countryMst.getCountryName());
			countryMstDtoList.add(countryMstDto);
		}
		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
		}
		
		return countryMstDtoList;
	}

}
