package com.bluedart.masters.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.masters.dao.AffiliatesDao;
import com.bluedart.masters.dto.AffiliatesDto;
import com.bluedart.masters.service.AffiliatesService;

@Service
public class AffiliatesServiceImpl implements AffiliatesService{
	
	@Autowired
	private AffiliatesDao affiliatesDao;

	@Override
	public AffiliatesDto getAffiliates(String loginId) {
		return affiliatesDao.getAffiliates(loginId);
	}
	
	 
}