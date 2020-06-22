package com.bluedart.masters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.masters.dao.CountryMstDao;
import com.bluedart.masters.dto.CountryMstDto;
import com.bluedart.masters.service.CountryMstService;

/**
 * 
 * @author DH839598
 *
 */

@Service
public class CountryMstServiceImpl implements CountryMstService {
	
	@Autowired
	private CountryMstDao countryMstDao;

	@Override
	public List<CountryMstDto> getCountryList() {
		return countryMstDao.getCountryList();
	}

}
