package com.bluedart.trackdart.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import com.bluedart.trackdart.dto.ImageDartDto;

/**
 * 
 * @author DH839598
 *
 */
public interface ImageDartDao {

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
	public List<ImageDartDto> validateAndGetPodImages(String awbNos, String ndc,String loginId);

	/**
	 * 
	 * @param awbNo
	 * @param ndc
	 * @return
	 */
	public List<Blob> getPodImage(String awbNo, String ndc);
	
	public Map<String, String> getDCImagePermission(String loginId,String awbNo);

}
