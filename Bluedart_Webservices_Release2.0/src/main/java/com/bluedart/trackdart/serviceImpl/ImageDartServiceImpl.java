package com.bluedart.trackdart.serviceImpl;

import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.trackdart.dao.ImageDartDao;
import com.bluedart.trackdart.dto.ImageDartDto;
import com.bluedart.trackdart.service.ImageDartService;

/**
 * 
 * @author DH839598
 *
 */
@Service
public class ImageDartServiceImpl implements ImageDartService {

	private static final Logger logger = Logger.getLogger(ImageDartServiceImpl.class);

	@Autowired 
	private ImageDartDao imageDartDao;

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.ImageDartService#getPodImage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Blob getPodImage(String loginId, String awbNo, String ndc) {
		logger.debug(" ImageDartServiceImpl : getPodImage");
		return imageDartDao.getPodImage(loginId, awbNo, ndc);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.ImageDartService#validateAndGetPodImages(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ImageDartDto> validateAndGetPodImages(String awbNos, String ndc,String loginId) {
		logger.debug(" ImageDartServiceImpl : validatePodImages");
		return imageDartDao.validateAndGetPodImages(awbNos, ndc,loginId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.ImageDartService#getPodImage(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Blob> getPodImage(String awbNo, String ndc) {
		logger.debug(" ImageDartServiceImpl : getPodImage");
		return imageDartDao.getPodImage(awbNo, ndc);
	}

}
