package com.bluedart.common.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.CurrencyDao;
import com.bluedart.common.dto.CurrencyDto;
import com.bluedart.common.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDao currencyDao;
	
	@Override
	public List<CurrencyDto> getListOfCurrencyCode() {
		return currencyDao.getListOfCurrencyCode();
	} 
	
	
}
