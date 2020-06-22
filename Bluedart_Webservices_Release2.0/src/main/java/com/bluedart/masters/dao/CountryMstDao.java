package com.bluedart.masters.dao;

import java.util.List;

import com.bluedart.masters.dto.CountryMstDto;

/**
 * 
 * @author DH839598
 *
 */
public interface CountryMstDao {

	/**
	 * 
	 * @return
	 */
	public List<CountryMstDto> getCountryList();
}
