package com.bluedart.common.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.CommodityDao;
import com.bluedart.common.dto.CommodityDto;
import com.bluedart.common.service.CommodityService;

/**
 * 
 * @author DH839598
 *
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityDao commodityDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.common.service.CommodityService#getCommodityDetails()
	 */
	@Override
	public List<CommodityDto> getCommodityDetails() {
		return commodityDao.getCommodityDetails();
	}

	
}
