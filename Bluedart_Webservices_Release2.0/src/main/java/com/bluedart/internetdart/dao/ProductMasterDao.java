package com.bluedart.internetdart.dao;

import java.util.List;

import com.bluedart.internetdart.dto.ProductMasterDto;

/**
 * 
 * @author DH839598
 *
 */
public interface ProductMasterDao {
	
	/**
	 * 
	 * @return
	 */
	public List<ProductMasterDto> getAllProduct();

}
