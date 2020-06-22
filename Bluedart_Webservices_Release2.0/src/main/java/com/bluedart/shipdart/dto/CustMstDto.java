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
public class CustMstDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String carea;
	private String ccustcode;
	private String cscrcd; 
	private String ccustname; 
	private String ccontact; 
	private String ccustadr1; 
	private String ccustadr2; 
	private String ccustadr3; 
	private String ccustpin; 
	private String ccusttel; 
	private String ccusttlx; 
	private String ccustfax; 
	private String ccshcrd; 
	private String boffcr; 
	private String bspslab; 
	private String cwgtflg; 
	private String cpflag;
	

	public String getCarea() {
		return carea;
	}
	public void setCarea(String carea) {
		this.carea = carea;
	}
	public String getCcustcode() {
		return ccustcode;
	}
	public void setCcustcode(String ccustcode) {
		this.ccustcode = ccustcode;
	}
	public String getCscrcd() {
		return cscrcd;
	}
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}
	public String getCcustname() {
		return ccustname;
	}
	public void setCcustname(String ccustname) {
		this.ccustname = ccustname;
	}
	public String getCcontact() {
		return ccontact;
	}
	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}
	public String getCcustadr1() {
		return ccustadr1;
	}
	public void setCcustadr1(String ccustadr1) {
		this.ccustadr1 = ccustadr1;
	}
	public String getCcustadr2() {
		return ccustadr2;
	}
	public void setCcustadr2(String ccustadr2) {
		this.ccustadr2 = ccustadr2;
	}
	public String getCcustadr3() {
		return ccustadr3;
	}
	public void setCcustadr3(String ccustadr3) {
		this.ccustadr3 = ccustadr3;
	}
	public String getCcustpin() {
		return ccustpin;
	}
	public void setCcustpin(String ccustpin) {
		this.ccustpin = ccustpin;
	}
	public String getCcusttel() {
		return ccusttel;
	}
	public void setCcusttel(String ccusttel) {
		this.ccusttel = ccusttel;
	}
	public String getCcusttlx() {
		return ccusttlx;
	}
	public void setCcusttlx(String ccusttlx) {
		this.ccusttlx = ccusttlx;
	}
	public String getCcustfax() {
		return ccustfax;
	}
	public void setCcustfax(String ccustfax) {
		this.ccustfax = ccustfax;
	}
	public String getCcshcrd() {
		return ccshcrd;
	}
	public void setCcshcrd(String ccshcrd) {
		this.ccshcrd = ccshcrd;
	}
	public String getBoffcr() {
		return boffcr;
	}
	public void setBoffcr(String boffcr) {
		this.boffcr = boffcr;
	}
	public String getBspslab() {
		return bspslab;
	}
	public void setBspslab(String bspslab) {
		this.bspslab = bspslab;
	}
	public String getCwgtflg() {
		return cwgtflg;
	}
	public void setCwgtflg(String cwgtflg) {
		this.cwgtflg = cwgtflg;
	}
	public String getCpflag() {
		return cpflag;
	}
	public void setCpflag(String cpflag) {
		this.cpflag = cpflag;
	}
	@Override
	public String toString() {
		return "CustMstDto [carea=" + carea + ", ccustcode=" + ccustcode
				+ ", cscrcd=" + cscrcd + ", ccustname=" + ccustname
				+ ", ccontact=" + ccontact + ", ccustadr1=" + ccustadr1
				+ ", ccustadr2=" + ccustadr2 + ", ccustadr3=" + ccustadr3
				+ ", ccustpin=" + ccustpin + ", ccusttel=" + ccusttel
				+ ", ccusttlx=" + ccusttlx + ", ccustfax=" + ccustfax
				+ ", ccshcrd=" + ccshcrd + ", boffcr=" + boffcr + ", bspslab="
				+ bspslab + ", cwgtflg=" + cwgtflg + ", cpflag=" + cpflag + "]";
	} 
	
		
}
