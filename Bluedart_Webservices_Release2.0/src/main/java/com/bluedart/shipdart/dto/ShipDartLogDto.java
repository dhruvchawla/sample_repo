package com.bluedart.shipdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author CH851827
 *
 */

public class ShipDartLogDto implements Serializable{
	
	private static final long serialVersionUID = 7702818549853435294L;
	
	private String loginId;
	
 	private String logs;	
	private String message;
   	
   	private String fileName;
	private Long fileSize;
	private String fileType;
  	private String uploadDate;
    private String uploadTime;	
	private String status;
	
	private String flag;
	private List<ShipDartLogDto> shipDartLogDtoList;    	
		
	public List<ShipDartLogDto> getShipDartLogDtoList() {
		return shipDartLogDtoList;
	}

	public void setShipdartLogDtoList(List<ShipDartLogDto> shipdartLogDtoList) {
		this.shipDartLogDtoList = shipdartLogDtoList;
	}	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getLogs() {
		return logs;
	}

	public void setLogs(String logs) {
		this.logs = logs;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "ShipDartLogDto [loginId=" + loginId + ", logs=" + logs
				+ ", message=" + message + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", fileType=" + fileType
				+ ", uploadDate=" + uploadDate + ", uploadTime=" + uploadTime
				+ ", status=" + status + ", flag=" + flag
				+ ", shipDartLogDtoList=" + shipDartLogDtoList + "]";
	}
	
	
}
