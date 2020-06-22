package com.bluedart.utils;

import java.util.Comparator;

import com.bluedart.contactus.dto.FeedBackReasonDto;


/**
 * @author CH848113
 */
public class FeedBackReasonComparatorUtil implements Comparator<FeedBackReasonDto>{  
	
	public int compare(FeedBackReasonDto obj1, FeedBackReasonDto obj2) {
		   //ascending order
		   return obj1.getReasonDescription().compareTo(obj2.getReasonDescription());
	    }
}
