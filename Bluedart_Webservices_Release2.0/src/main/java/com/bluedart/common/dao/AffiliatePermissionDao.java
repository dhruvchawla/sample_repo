package com.bluedart.common.dao;

import java.util.List;

import com.bluedart.common.dto.AffiliatePermissionDto;

/**
 * @author AN765570
 *
 */
public interface AffiliatePermissionDao {

	public List<AffiliatePermissionDto> getAffiliateLevelPermissions(String loginId, String areaCode, String customerCode, String permissionName);
}
