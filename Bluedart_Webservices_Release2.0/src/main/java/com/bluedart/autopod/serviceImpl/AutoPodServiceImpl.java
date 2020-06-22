package com.bluedart.autopod.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.autopod.dao.AutoPodDao;
import com.bluedart.autopod.dto.AutoPodDto;
import com.bluedart.autopod.service.AutoPodService;

@Service
public class AutoPodServiceImpl implements AutoPodService {
	 private static final Logger logger = Logger.getLogger(AutoPodServiceImpl.class);
	 @Autowired
	 private AutoPodDao autoPodDao;

	
	@Override
	public AutoPodDto createPod(AutoPodDto autoPodDto) {
		logger.debug(" AutoPodServiceImpl : createPod");
		return autoPodDao.createPod(autoPodDto);
	}

	

	@Override
	public AutoPodDto searchPod(AutoPodDto autoPodDto) {
		logger.debug(" AutoPodServiceImpl : searchPod");
		return autoPodDao.searchPod(autoPodDto);
	}
	
	
	
	
	@Override
	public AutoPodDto editPod(AutoPodDto autoPodDto) {
		logger.debug(" AutoPodServiceImpl : editPod");
		return autoPodDao.editPod(autoPodDto);
	}
	


	@Override
	public AutoPodDto softDeletePod(AutoPodDto autoPodDto) {
		logger.debug(" softDeletePod : softDeletePod");
		return autoPodDao.softDeletePod(autoPodDto);
		
	}

}
