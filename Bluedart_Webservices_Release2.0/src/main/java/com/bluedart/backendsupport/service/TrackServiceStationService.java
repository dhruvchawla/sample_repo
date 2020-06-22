/**
 * 
 */
package com.bluedart.backendsupport.service;

import java.io.IOException;
import java.util.List;

import com.bluedart.backendsupport.dto.ServiceStationDTO;
import com.bluedart.exception.BlueDartException;

/**
 * @author Velayutham Balasubramanian
 *
 */
public interface TrackServiceStationService {
	
	public List<ServiceStationDTO> getServiceStationsByLocationName(String locationName,String ipAddress) throws IOException, BlueDartException;
	
	public List<ServiceStationDTO> getServiceStationsByPincode(String pincode,String ipAddress) throws BlueDartException;

	
}
