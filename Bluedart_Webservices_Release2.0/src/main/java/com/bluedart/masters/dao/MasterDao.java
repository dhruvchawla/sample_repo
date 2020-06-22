package com.bluedart.masters.dao;

import java.util.List;

import com.bluedart.common.dto.AreaDTO;
import com.bluedart.exception.BlueDartException;
import com.bluedart.masters.dto.CountryDto;
import com.bluedart.masters.dto.StateDto;

/*
 * @author CH848113
 * 
 */
public interface MasterDao {
	public AreaDTO getSABR(String pinCode) throws  BlueDartException;
	
	public List<StateDto> getStates() throws  BlueDartException;
	public List<CountryDto> getCountries() throws  BlueDartException;
	

}
