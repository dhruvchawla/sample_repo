package com.bluedart.common.dto;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author DH839598
 * 
 */
public class EmailContent implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String from;

	private String replyTo;

	private String to;

	private String cc;
	
	private String bcc;
	
	private String subject;

	private String text;
	
	private List<String> listOfTOAddress;
	
	private List<String> listOfCCAddress;
	
	private File file;
	
	private Map < String, Object > model;
	 

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the replyTo
	 */
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * @param replyTo the replyTo to set
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * @return the bcc
	 */
	public String getBcc() {
		return bcc;
	}

	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the listOfTOAddress
	 */
	public List<String> getListOfTOAddress() {
		return listOfTOAddress;
	}

	/**
	 * @param listOfTOAddress the listOfTOAddress to set
	 */
	public void setListOfTOAddress(List<String> listOfTOAddress) {
		this.listOfTOAddress = listOfTOAddress;
	}

	/**
	 * @return the listOfCCAddress
	 */
	public List<String> getListOfCCAddress() {
		return listOfCCAddress;
	}

	/**
	 * @param listOfCCAddress the listOfCCAddress to set
	 */
	public void setListOfCCAddress(List<String> listOfCCAddress) {
		this.listOfCCAddress = listOfCCAddress;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
	 
    public Map < String, Object > getModel() {
        return model;
    }
 
    public void setModel(Map < String, Object > model) {
        this.model = model;
    }
	
	
	

	 
	
}
