/**
 * 
 */
package com.bluedart.pricefinder.service;

import com.bluedart.pricefinder.dto.RateAndTransitDTO;

/**
 * @author Subhransu Maharana
 * This is a service interface.  
 *
 */
public interface FinderService {

	/**
	 * 
	 * @param rateAndTransitDTO
	 * @return
	 * @Description This is a service interface method.
	 */
	public RateAndTransitDTO findTransitTimePrice(RateAndTransitDTO rateAndTransitDTO);


}
