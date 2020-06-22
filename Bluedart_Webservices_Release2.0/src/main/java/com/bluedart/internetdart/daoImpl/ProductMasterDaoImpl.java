package com.bluedart.internetdart.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.entity.ProductMaster;
import com.bluedart.exception.DataBaseException;
import com.bluedart.internetdart.dao.ProductMasterDao;
import com.bluedart.internetdart.dto.ProductMasterDto;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */
@Repository
public class ProductMasterDaoImpl extends BaseDaoImpl implements ProductMasterDao {

	private static final Logger productMasterLogger = Logger.getLogger(ProductMasterDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluedart.internetdart.dao.ProductMasterDao#getAllProduct()
	 */
	@Transactional
	@Override
	public List<ProductMasterDto> getAllProduct() {
		productMasterLogger.debug(" ProductMasterDaoImpl : getAllProduct ");
		List<ProductMasterDto> productMasterDtosList = new ArrayList<>();
		try {
			Query query = getSession()
					.createQuery("SELECT prod FROM ProductMaster prod WHERE UPPER(SUBSTR(ctoSDisp, 1, 1)) = 'Y' order by productDesc");
			List<ProductMaster> productList = query.list();
			if (productList != null && !productList.isEmpty()) {
				for (ProductMaster productMaster : productList) {
					ProductMasterDto masterDto = new ProductMasterDto();
					CopyUtils.copy(productMaster, masterDto);
					productMasterDtosList.add(masterDto);
				}
			}
		} catch (Exception exception) {
			
			productMasterLogger.error("EXCEPTION TYPE :",exception);
		
			
		//	productMasterLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		productMasterLogger.trace(" ProductMasterDaoImpl : getAllProduct ");
		return productMasterDtosList;
	}

}
