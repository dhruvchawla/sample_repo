package com.bluedart.trackingapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.dto.TrackingAPILicenseDto;
import com.bluedart.common.dto.TrackingAPIDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.trackingapi.service.TrackingApiLicenceManagementService;

@RestController
public class RoutingController {
	
	@Autowired
	private TrackingApiLicenceManagementService trackingAPIService; 
	

	@RequestMapping(value = "/trackapi/gettrackbyawbnolist/{awbNos}/{loginId}/{reqScanFlag}/{lickey}/{verno}", method = RequestMethod.GET,headers="Accept=application/json")
	public TrackingAPIDto getTrackByAwbNoList(@PathVariable String awbNos, @PathVariable String loginId, @PathVariable int reqScanFlag, @PathVariable String lickey, @PathVariable String verno) throws IOException, BlueDartException {
		List<String> awbList = new ArrayList<String>(Arrays.asList(awbNos.trim().split(",")));
		TrackingAPIDto trackingAPIDto =  trackingAPIService.getTrackByAwbNoList(awbList, loginId, reqScanFlag, lickey, verno);
		return trackingAPIDto;
	}
	
	@RequestMapping( value = "/trackapi/gettrackbyrefnolist", method = RequestMethod.POST )
	public TrackingAPIDto getTrackByRefNoList(@RequestBody TrackingAPIDto trackingAPIDto) throws IOException, BlueDartException {
		List<String> refList = new ArrayList<String>(Arrays.asList(trackingAPIDto.getRefNo().trim().split(",")));
		trackingAPIDto =  trackingAPIService.getTrackByRefNoList(refList, trackingAPIDto.getLoginId(), trackingAPIDto.getReqScanFlag(), trackingAPIDto.getLicKey(), trackingAPIDto.getVerNo());
		return trackingAPIDto;
	}
	
	@RequestMapping(value = "trackAPI/showLicenseKey/{loginId}/{type}", method = RequestMethod.GET,headers="Accept=application/json")
	public TrackingAPILicenseDto showLicenseKey(@PathVariable String loginId, @PathVariable String type){
		TrackingAPILicenseDto apiLicenseDto =  trackingAPIService.showLicenseKey(loginId, type);
		return apiLicenseDto;
	}
	
}
