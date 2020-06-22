package com.bluedart.masters.dto;

import java.io.Serializable;
import java.util.Comparator;
/**
 * @author CH848113
 */
public class StateDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stateId;
	private String stateDescription;
	
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getStateDescription() {
		return stateDescription;
	}
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

/*	public static Comparator<StateDto> stateComparator = new Comparator<StateDto>() {

		public int compare(StateDto obj1, StateDto obj2) {
		   String stateDescription1 = obj1.getStateDescription().toLowerCase();
		   String stateDescription2 = obj2.getStateDescription().toLowerCase();

		   //ascending order
		   return stateDescription1.compareTo(stateDescription2);

		   //descending order
		   //return reasonDescription2.compareTo(reasonDescription1);
	    }};*/

	

}
