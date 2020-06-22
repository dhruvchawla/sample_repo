package com.bluedart.internetdart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.internetdart.dao.InternetDartDao;
import com.bluedart.internetdart.dto.PinDescDto;
import com.bluedart.internetdart.dto.SearchDto;
import com.bluedart.internetdart.dto.StreamDataDto;
import com.bluedart.internetdart.dto.StreamReportDto;
import com.bluedart.internetdart.dto.ViewOnlineDto;
import com.bluedart.internetdart.service.InternetDartService;


/**
 * 
 * @author DH839598
 *
 */
@Service
public class InternetDartServiceImpl implements InternetDartService {
	
	@Autowired
	private InternetDartDao internetDartDao;

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.InternetDartService#viewOnline(com.bluedart.internetdart.dto.SearchDto)
	 */
	@Override
	public ViewOnlineDto viewOnline(SearchDto searchDto) {
		return internetDartDao.viewOnline(searchDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.InternetDartService#getStreamDataDto(com.bluedart.internetdart.dto.SearchDto)
	 */
	@Override
	public StreamDataDto getStreamDataDto(SearchDto searchDto) {
		return internetDartDao.getStreamDataDto(searchDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.InternetDartService#getStreamReportDto(com.bluedart.internetdart.dto.SearchDto)
	 */
	@Override
	public StreamReportDto getStreamReportDto(SearchDto searchDto) {
		return internetDartDao.getStreamReportDto(searchDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.InternetDartService#getServiceability(java.lang.String)
	 */
	@Override
	public List<PinDescDto> getServiceability(String cityName) {
		return internetDartDao.getServiceability(cityName);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.InternetDartService#getCustomerName(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCustomerName(String areaCode, String custCode) {
		return internetDartDao.getCustomerName(areaCode, custCode);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.InternetDartService#checkFlag(java.lang.String, java.lang.String)
	 */
	@Override
	public int checkFlag(String loginId, String flag) {
		return internetDartDao.checkFlag(loginId, flag);
	}

	 

}
