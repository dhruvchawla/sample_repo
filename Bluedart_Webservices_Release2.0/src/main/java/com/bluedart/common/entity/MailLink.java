package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * @Author CH848113
 * 
 */
@Entity
@Table( name = "WEBMASTER.MAILLINK")
public class MailLink implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name = "CMAILLINK")
	private String cMailLink;
	
	@Column(name = "CINTERFACE")
	private String cInterface;
	
	@Column(name = "CMAILTO")
	private String cMailTo;
	
	@Column(name = "CMAILCC")
	private String cMailCC;
	
	@Column(name = "CMAILCC1")
	private String cMailCC1;

	public String getcMailLink() {
		return cMailLink;
	}

	public void setcMailLink(String cMailLink) {
		this.cMailLink = cMailLink;
	}

	public String getcInterface() {
		return cInterface;
	}

	public void setcInterface(String cInterface) {
		this.cInterface = cInterface;
	}

	public String getcMailTo() {
		return cMailTo;
	}

	public void setcMailTo(String cMailTo) {
		this.cMailTo = cMailTo;
	}

	public String getcMailCC() {
		return cMailCC;
	}

	public void setcMailCC(String cMailCC) {
		this.cMailCC = cMailCC;
	}

	public String getcMailCC1() {
		return cMailCC1;
	}

	public void setcMailCC1(String cMailCC1) {
		this.cMailCC1 = cMailCC1;
	}
	
	
	
}
