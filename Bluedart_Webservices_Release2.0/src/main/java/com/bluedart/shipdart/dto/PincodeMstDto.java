/**
 * 
 */
package com.bluedart.shipdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author CH851827
 *
 */
public class PincodeMstDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpincode;
	private String cpindesc;
	private String carea;
	private String cscrcd;
	private String cservflag;
	private String ccrcrdscr;
	private String cflag;
	
	public String getCpincode() {
		return cpincode;
	}
	
	public void setCpincode(String cpincode) {
		this.cpincode = cpincode;
	}
	
	public String getCpindesc() {
		return cpindesc;
	}
	
	public void setCpindesc(String cpindesc) {
		this.cpindesc = cpindesc;
	}
	
	public String getCarea() {
		return carea;
	}
	
	public void setCarea(String carea) {
		this.carea = carea;
	}
	
	public String getCscrcd() {
		return cscrcd;
	}
	
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}
	
	public String getCservflag() {
		return cservflag;
	}
	
	public void setCservflag(String cservflag) {
		this.cservflag = cservflag;
	}
	
	public String getCcrcrdscr() {
		return ccrcrdscr;
	}
	
	public void setCcrcrdscr(String ccrcrdscr) {
		this.ccrcrdscr = ccrcrdscr;
	}
	
	public String getCflag() {
		return cflag;
	}
	
	public void setCflag(String cflag) {
		this.cflag = cflag;
	}

	@Override
	public String toString() {
		return "PincodeMstDto [cpincode=" + cpincode + ", cpindesc=" + cpindesc
				+ ", carea=" + carea + ", cscrcd=" + cscrcd + ", cservflag="
				+ cservflag + ", ccrcrdscr=" + ccrcrdscr + ", cflag=" + cflag
				+ "]";
	}
	
	
}
