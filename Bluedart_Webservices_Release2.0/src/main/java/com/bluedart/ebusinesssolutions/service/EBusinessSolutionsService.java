package com.bluedart.ebusinesssolutions.service;

import com.bluedart.ebusinesssolutions.dto.EBusinessSolutionsDto;
import com.bluedart.exception.BlueDartException;

/*
 * @author CH848113 
 */

public interface EBusinessSolutionsService {
	public boolean submitEBusinessSolutions(EBusinessSolutionsDto eBusinessSolutions)throws BlueDartException;
}
