package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.util.List;

public class ValueAddedPaperWorkDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = -7326503571685783050L;
	
	private List<ValueAddedServiceDto> valueAddedServiceDtoList;
	private List<PaperWorkDto> paperWorkDtoList;
	
	public List<ValueAddedServiceDto> getValueAddedServiceDtoList() {
		return valueAddedServiceDtoList;
	}
	public void setValueAddedServiceDtoList(List<ValueAddedServiceDto> valueAddedServiceDtoList) {
		this.valueAddedServiceDtoList = valueAddedServiceDtoList;
	}
	public List<PaperWorkDto> getPaperWorkDtoList() {
		return paperWorkDtoList;
	}
	public void setPaperWorkDtoList(List<PaperWorkDto> paperWorkDtoList) {
		this.paperWorkDtoList = paperWorkDtoList;
	}
	
	
	
	
	

}
