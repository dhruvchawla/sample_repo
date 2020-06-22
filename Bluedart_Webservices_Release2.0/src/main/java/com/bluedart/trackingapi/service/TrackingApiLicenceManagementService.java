package com.bluedart.trackingapi.service;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import com.bluedart.common.dto.TrackingAPILicenseDto;
import com.bluedart.common.dto.TrackingAPIDto;
import com.bluedart.exception.BlueDartException;

/**
 * 
 * @author SI334034
 *
 */
public interface TrackingApiLicenceManagementService {
	
	public TrackingAPILicenseDto showLicenseKey(String userLoginId, String type);
	
	public TrackingAPIDto getTrackByAwbNoList(List<String> awbNos, String loginId, int reqScanFlag, String lickey, String verno) throws IOException, BlueDartException;
	
	public TrackingAPIDto getTrackByRefNoList(List<String> refNos, String loginId, int reqScanFlag, String lickey, String verno) throws IOException, BlueDartException;
	

}
