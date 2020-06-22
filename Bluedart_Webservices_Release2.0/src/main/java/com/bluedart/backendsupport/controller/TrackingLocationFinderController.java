package com.bluedart.backendsupport.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.backendsupport.dto.ServiceStationDTO;
import com.bluedart.exception.FinderServiceException;
import com.bluedart.backendsupport.service.TrackServiceStationService;

@RestController
public class TrackingLocationFinderController {

	@Autowired
	private TrackServiceStationService serviceStationService; 

	@RequestMapping(value = "/windowssupport/trackservicestationsbylocationname/{locationName}/{ipAddress}", method = RequestMethod.GET,headers="Accept=application/json")
	public ServiceStationDTO trackServiceStationsByLocationName( @PathVariable String locationName,@PathVariable String ipAddress ) throws IOException, FinderServiceException {
		ServiceStationDTO serviceStationDTO = null;
		List<ServiceStationDTO> serviceStationDtoList =  serviceStationService.getServiceStationsByLocationName( locationName,ipAddress );
		if(serviceStationDtoList != null){
			serviceStationDTO = new ServiceStationDTO();
			serviceStationDTO.setServiceStationDTOList(serviceStationDtoList);
		}
		
		return serviceStationDTO;
	}
	
	@RequestMapping(value = "/windowssupport/trackservicestationsbypincode/{pincode}/{ipAddress}", method = RequestMethod.GET,headers="Accept=application/json")
	public ServiceStationDTO trackServiceStationsByPincode( @PathVariable String pincode, @PathVariable String ipAddress ) throws IOException, FinderServiceException {
		ServiceStationDTO serviceStationDTO = null;
		List<ServiceStationDTO> serviceStationDtoList =  serviceStationService.getServiceStationsByPincode( pincode,ipAddress );
		if(serviceStationDtoList != null){
			serviceStationDTO = new ServiceStationDTO();
			serviceStationDTO.setServiceStationDTOList(serviceStationDtoList);
		}
		
		return serviceStationDTO;
	}
}
