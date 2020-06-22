package com.bluedart.common.dao;

import java.util.List;

import com.bluedart.common.dto.CurrencyDto;

public interface CurrencyDao {
	
	public List<CurrencyDto> getListOfCurrencyCode();

}
