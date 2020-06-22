package com.bluedart.trackingapi.service;


import java.sql.Blob;
import java.util.List;

import com.bluedart.common.dto.ImageDartAwbNo;
import com.bluedart.exception.BlueDartException;

/**
 * 
 * @author DH839598
 *
 */
public interface ImageDartService {
	
	/**
	 * 
	 * @param awbNo
	 * @param ndc
	 * @return
	 */
	public Blob getPodImage(String awbNo, String ndc);
	
	/**
	 * 
	 * @param loginId
	 * @param awbNo
	 * @param ndc
	 * @return
	 */
	public Blob getPodImage(String loginId, String awbNo, String ndc);
	
	/**
	 * 
	 * @param awbNos
	 * @param ndc
	 * @return
	 * @throws TrackDartServiceException
	 */
	public List<ImageDartAwbNo> validatePodImages(List<String> awbNos, String ndc);
	
	
	
}
