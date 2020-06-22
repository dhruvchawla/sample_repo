/**
 * 
 */
package com.bluedart.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CH851827
 *
 */

@Entity
@Table(name = "UPLOADLOG_T")
public class ShipDartLog implements Serializable {
	
	private static final long serialVersionUID = 3651966726745692378L;

    @Id
    
    @Column(name = "LOGINID")
	private String loginId;
    
    @Column(name = "FILENAME")
	private String fileName;
    
    @Column(name = "UPLOADDATE")
	private Date uploadDate;
    
    @Column(name = "UPLOADTIME")
	private String uploadTime;
    
    @Column(name = "STATUS")
	private String status;
    
    @Column(name = "LENGTH")
	private Long fileSize;
    
    @Column(name = "FILETYPE")
	private String fileType;

	public String getLoginId() {
		return loginId;
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
	
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
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
		return "ShipDartLog [loginId=" + loginId + ", fileName=" + fileName
				+ ", uploadDate=" + uploadDate + ", uploadTime=" + uploadTime
				+ ", status=" + status + ", fileSize=" + fileSize
				+ ", fileType=" + fileType + "]";
	}
    
}
