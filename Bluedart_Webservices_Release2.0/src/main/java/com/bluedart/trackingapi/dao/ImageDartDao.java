package com.bluedart.trackingapi.dao;

import java.sql.Blob;
import java.util.List;

import com.bluedart.common.dto.ImageDartAwbNo;

/**
 * 
 * @author DH839598
 *
 */
public interface ImageDartDao {
	
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
	 */
	public List<ImageDartAwbNo> validatePodImages(List<String> awbNos, String ndc);
	
}
