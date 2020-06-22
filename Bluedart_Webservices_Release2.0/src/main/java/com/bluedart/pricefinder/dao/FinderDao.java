package com.bluedart.pricefinder.dao;

import com.bluedart.pricefinder.dto.RateAndTransitDTO;

/**
 * @author Subhransu Maharana
 * This is a DAO interface. 
 */
public interface FinderDao {

	/**
	 * 
	 * @param rateAndTransitDTO
	 * @return
	 * @Description This is a DAO interface method.
	 */
	public RateAndTransitDTO findTransitTimePrice(RateAndTransitDTO rateAndTransitDTO);


	
}
