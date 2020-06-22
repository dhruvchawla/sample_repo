package com.bluedart.common.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.exception.DataException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.CommodityDao;
import com.bluedart.common.dto.CommodityDto;
import com.bluedart.common.entity.CommodityMaster;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */
@Repository
public class CommodityDaoImpl extends BaseDaoImpl implements CommodityDao {
	private static final Logger logger = Logger.getLogger(CommodityDaoImpl.class);
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.common.dao.CommodityDao#getCommodityDetails()
	 */
	@Transactional
	@Override
	public List<CommodityDto> getCommodityDetails() {
		List<CommodityDto> commodityDtoList = new ArrayList<>();
		try{
			Criteria criteria = getSession().createCriteria(CommodityMaster.class);
			List<CommodityMaster> commodityMasters = criteria.list();
			for(CommodityMaster commodityMaster : commodityMasters) {
				CommodityDto commodityDto = new CommodityDto();
				CopyUtils.copy(commodityMaster, commodityDto);
				commodityDtoList.add(commodityDto);
			}
		}catch(DataException dataException){
			logger.error("EXCEPTION TYPE :",dataException);
			
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			logger.debug("-------------getCommodityDetails finally--------------------");
		}
		return commodityDtoList;
	}

}
