package com.bluedart.common.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.AffiliatePermissionDao;
import com.bluedart.common.dto.AffiliatePermissionDto;
import com.bluedart.common.service.AffiliatePermissionService;

@Service
public class AffiliatePermissionServiceImpl implements AffiliatePermissionService {

	@Autowired
	private AffiliatePermissionDao affiliatePermissionDao;
	
	@Override
	public List<AffiliatePermissionDto> getAffiliateLevelPermissions(String loginId,
			String areaCode, String customerCode,String permissionName) {
		
		if("null".equalsIgnoreCase(areaCode)){
			areaCode = null;
		}
		
		if("null".equalsIgnoreCase(customerCode)){
			customerCode = null;
		}
		
		return affiliatePermissionDao.getAffiliateLevelPermissions(loginId, areaCode, customerCode,permissionName);
	}

	
}
