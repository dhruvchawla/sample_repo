/**
 * 
 */
package com.bluedart.backendsupport.dao;

import java.io.IOException;
import java.util.List;

import com.bluedart.backendsupport.dto.ServiceStationDTO;
import com.bluedart.exception.BlueDartException;

/**
 * @author Velayutham Balasubramanian
 *
 */
public interface TrackServiceStationDao {

	/**
	 * @param pincode
	 * @return
	 * @throws BlueDartException
	 * @throws InvalidInputFault
	 */
	public List<ServiceStationDTO> getServiceStationsByPincode(String pincode) throws BlueDartException;

	/**
	 
	 * @param locationName
	 * @return
	 * @throws BlueDartException
	 */
	List<ServiceStationDTO> getServiceStationsByLocationName(String locationName) throws IOException, BlueDartException;

	
}
