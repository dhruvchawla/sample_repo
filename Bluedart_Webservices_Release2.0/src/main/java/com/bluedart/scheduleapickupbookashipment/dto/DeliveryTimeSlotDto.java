package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author DH839598
 *
 */
public class DeliveryTimeSlotDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = 2239043872298249099L;
	
	private String timeSlot;
	
	private List<DeliveryTimeSlotDto> listOfTimeSlot;

	/**
	 * @return the timeSlot
	 */
	public String getTimeSlot() {
		return timeSlot;
	}

	/**
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	/**
	 * @return the listOfTimeSlot
	 */
	public List<DeliveryTimeSlotDto> getListOfTimeSlot() {
		return listOfTimeSlot;
	}

	/**
	 * @param listOfTimeSlot the listOfTimeSlot to set
	 */
	public void setListOfTimeSlot(List<DeliveryTimeSlotDto> listOfTimeSlot) {
		this.listOfTimeSlot = listOfTimeSlot;
	}

	 
	
	
	
	
	
	
	
	
	
	
	
	
}
