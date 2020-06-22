package com.bluedart.trackdart.dto;

import java.io.Serializable;
import java.util.Map;

public class ImageDartDto implements Serializable {
	
	private static final long serialVersionUID = -4811015699589630979L;
	
	private String awbNo;
	private byte[] byteImage;
	private String errorCode;
	private Map<String, byte[]> map;
	boolean isDCImage;
	private boolean isImagePermission = false;
	
	public boolean isDCImage() {
		return isDCImage;
	}
	public void setDCImage(boolean isDCImage) {
		this.isDCImage = isDCImage;
	}
	/**
	 * 
	 * @return the awbNo
	 */
	public String getAwbNo() {
		return awbNo;
	}
	/**
	 * @param awbNo the awbNo to set
	 */
	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}
	/**
	 * @return the byteImage
	 */
	public byte[] getByteImage() {
		return byteImage;
	}
	/**
	 * @param byteImage the byteImage to set
	 */
	public void setByteImage(byte[] byteImage) {
		this.byteImage = byteImage;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the map
	 */
	public Map<String, byte[]> getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, byte[]> map) {
		this.map = map;
	}
	public boolean isImagePermission() {
		return isImagePermission;
	}
	public void setImagePermission(boolean isImagePermission) {
		this.isImagePermission = isImagePermission;
	}
	

	

}
