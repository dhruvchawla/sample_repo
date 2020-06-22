package com.bluedart.common.dto;

import java.io.Serializable;

public class DimensionEntityDto implements Serializable{
	
	private static final long serialVersionUID = 192534330342395234L;

	private String Breadth;
	private String Height;
	private String Length;

	
	
	public String getBreadth() {
		return Breadth;
	}
	public void setBreadth(String breadth) {
		Breadth = breadth;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public String getLength() {
		return Length;
	}
	public void setLength(String length) {
		Length = length;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
