package com.bluedart.internetdart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.internetdart.dao.ProductMasterDao;
import com.bluedart.internetdart.dto.ProductMasterDto;
import com.bluedart.internetdart.service.ProductMasterService;

/**
 * 
 * @author DH839598
 *
 */

@Service
public class ProductMasterServiceImpl implements ProductMasterService {
	
	@Autowired
	private ProductMasterDao productMasterDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.internetdart.service.ProductMasterService#getAllProduct()
	 */
	@Override
	public List<ProductMasterDto> getAllProduct() {
		return productMasterDao.getAllProduct();
	}

}
