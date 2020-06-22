package com.bluedart.common.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.CurrencyDao;
import com.bluedart.common.dto.CurrencyDto;
import com.bluedart.common.entity.CurrencyMaster;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */
@Repository
public class CurrencyDaoImpl extends BaseDaoImpl implements CurrencyDao {
	private static final Logger logger = Logger.getLogger(CurrencyDaoImpl.class); 
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.common.dao.CurrencyDao#getListOfCurrencyCode()
	 */
	@Transactional
	@Override
	public List<CurrencyDto> getListOfCurrencyCode() {
		List<CurrencyDto> currencyDtoList = new ArrayList<>();
		try{
			Criteria criteria = getSession().createCriteria(CurrencyMaster.class);
			List<CurrencyMaster> currencyMasters = criteria.list();
			for(CurrencyMaster currencyMaster : currencyMasters) {
				CurrencyDto currencyDto = new CurrencyDto();
				CopyUtils.copy(currencyMaster, currencyDto);
				currencyDtoList.add(currencyDto);
			}	
		}catch(DataBaseException dataBaseException){
			logger.error("EXCEPTION TYPE :",dataBaseException);
			
			
			//logger.error(dataBaseException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		finally{
			logger.debug("-------------getListOfCurrencyCode finally--------------------");
		}
		return currencyDtoList;
	}

}
