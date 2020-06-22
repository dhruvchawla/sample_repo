package com.bluedart.internetdart.service;

import java.util.List;

import com.bluedart.internetdart.dto.PinDescDto;
import com.bluedart.internetdart.dto.SearchDto;
import com.bluedart.internetdart.dto.StreamDataDto;
import com.bluedart.internetdart.dto.StreamReportDto;
import com.bluedart.internetdart.dto.ViewOnlineDto;

/***
 * 
 * @author DH839598
 *
 */
public interface InternetDartService {

	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	public ViewOnlineDto viewOnline(SearchDto searchDto);
	
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	public StreamDataDto getStreamDataDto(SearchDto searchDto);
	
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	public StreamReportDto getStreamReportDto(SearchDto searchDto);
	
	/**
	 * 
	 * @param cityName
	 * @return
	 */
	public List<PinDescDto> getServiceability(String cityName);
	
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @return
	 */
	public String getCustomerName(String areaCode, String custCode);
	
	/**
	 * 
	 * @param loginId
	 * @param flag
	 * @return
	 */
	public int checkFlag(String loginId, String flag);
	
	
}
