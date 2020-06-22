package com.bluedart.trackingapi.serviceimpl;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.trackingapi.dao.ImageDartDao;
import com.bluedart.common.dto.ImageDartAwbNo;
import com.bluedart.trackingapi.service.ImageDartService;

/**
 * 
 * @author DH839598
 *
 */
@Service
public class TrackingAPIImageDartServiceImpl implements ImageDartService {
	
	@Autowired
	private ImageDartDao imageDartDao;

	@Override
	public Blob getPodImage(String awbNo, String ndc) {
		return imageDartDao.getPodImage(awbNo, ndc);
	}

	@Override
	public Blob getPodImage(String loginId, String awbNo, String ndc) {
		return imageDartDao.getPodImage(loginId, awbNo, ndc);
	}

	@Override
	public List<ImageDartAwbNo> validatePodImages(List<String> awbNos, String ndc) {
		return imageDartDao.validatePodImages(awbNos, ndc);
	}
}
