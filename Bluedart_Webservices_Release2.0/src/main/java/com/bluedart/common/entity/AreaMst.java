package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author CH851827
 *
 */

@Entity
@Table(name = "WEBMASTER.AREAMST")
public class AreaMst implements Serializable {
   	
  	private static final long serialVersionUID = 1L;

	@Id
    
    @Column(name = "CAREA")
    private String carea;
    
	@Column(name = "CAREADESC")
	private String careadesc;
    
	@Column(name = "CSCRCD")
	private String cscrcd;
    
	@Column(name = "CSCRCDDESC")
	private String cscrcddesc;
	
    @Column(name = "CSTATE")
	private String cstate;
    
    @Column(name = "CTEL")
	private String ctel;
    
    @Column(name = "CFAX")
	private String cfax;
    
    @Column(name = "BEMBARGO")
	private String bembargo;
    
    @Column(name = "CDPSERV")
	private String cdpserv;
    
    @Column(name = "CIPSERV")
	private String cipserv;
    
    @Column(name = "CAPESERV")
	private String capeserv;
    
    @Column(name = "CSFCSERV")
	private String csfcserv;
    
    @Column(name = "CCLUSTER")
	private String ccluster;
    
    @Column(name = "CLOCTYPE")
	private String cloctype;
    
    @Column(name = "CCODSERV")
	private String ccodserv;
    
    @Column(name = "CFODSERV")
	private String cfodserv;
    
    @Column(name = "CCRDSERV")
	private String ccrdserv;
    
    @Column(name = "CPBAGDST")
	private String cpbagdst;
    
    @Column(name = "CIATACODE")
	private String ciatacode;
	
	@Column(name = "CDPZNB")
	private String cdpznb;
	
	@Column(name = "CREGION")
	private String cregion;
	
	@Column(name = "BCMPLOC")
	private String bcmploc;
	
	@Column(name = "CCNTRYCODE")
	private String ccntrycode;
	
	@Column(name = "CRPSERV")
	private String crpserv;
	
	@Column(name = "CRPASERV")
	private String crpaserv;
	
	@Column(name = "CRAPXSERV")
	private String crapxserv;
	
	@Column(name = "CRSFCSERV")
	private String crsfcserv;
	
		
	public String getCarea() {
		return carea;
	}
	public void setCarea(String carea) {
		this.carea = carea;
	}
	public String getCareadesc() {
		return careadesc;
	}
	public void setCareadesc(String careadesc) {
		this.careadesc = careadesc;
	}
	public String getCscrcd() {
		return cscrcd;
	}
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}
	public String getCscrcddesc() {
		return cscrcddesc;
	}
	public void setCscrcddesc(String cscrcddesc) {
		this.cscrcddesc = cscrcddesc;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCfax() {
		return cfax;
	}
	public void setCfax(String cfax) {
		this.cfax = cfax;
	}
	public String getBembargo() {
		return bembargo;
	}
	public void setBembargo(String bembargo) {
		this.bembargo = bembargo;
	}
	public String getCdpserv() {
		return cdpserv;
	}
	public void setCdpserv(String cdpserv) {
		this.cdpserv = cdpserv;
	}
	public String getCipserv() {
		return cipserv;
	}
	public void setCipserv(String cipserv) {
		this.cipserv = cipserv;
	}
	public String getCapeserv() {
		return capeserv;
	}
	public void setCapeserv(String capeserv) {
		this.capeserv = capeserv;
	}
	public String getCsfcserv() {
		return csfcserv;
	}
	public void setCsfcserv(String csfcserv) {
		this.csfcserv = csfcserv;
	}
	public String getCcluster() {
		return ccluster;
	}
	public void setCcluster(String ccluster) {
		this.ccluster = ccluster;
	}
	public String getCloctype() {
		return cloctype;
	}
	public void setCloctype(String cloctype) {
		this.cloctype = cloctype;
	}
	public String getCcodserv() {
		return ccodserv;
	}
	public void setCcodserv(String ccodserv) {
		this.ccodserv = ccodserv;
	}
	public String getCfodserv() {
		return cfodserv;
	}
	public void setCfodserv(String cfodserv) {
		this.cfodserv = cfodserv;
	}
	public String getCcrdserv() {
		return ccrdserv;
	}
	public void setCcrdserv(String ccrdserv) {
		this.ccrdserv = ccrdserv;
	}
	public String getCpbagdst() {
		return cpbagdst;
	}
	public void setCpbagdst(String cpbagdst) {
		this.cpbagdst = cpbagdst;
	}
	public String getCiatacode() {
		return ciatacode;
	}
	public void setCiatacode(String ciatacode) {
		this.ciatacode = ciatacode;
	}
	public String getCdpznb() {
		return cdpznb;
	}
	public void setCdpznb(String cdpznb) {
		this.cdpznb = cdpznb;
	}
	public String getCregion() {
		return cregion;
	}
	public void setCregion(String cregion) {
		this.cregion = cregion;
	}
	public String getBcmploc() {
		return bcmploc;
	}
	public void setBcmploc(String bcmploc) {
		this.bcmploc = bcmploc;
	}
	public String getCcntrycode() {
		return ccntrycode;
	}
	public void setCcntrycode(String ccntrycode) {
		this.ccntrycode = ccntrycode;
	}
	public String getCrpserv() {
		return crpserv;
	}
	public void setCrpserv(String crpserv) {
		this.crpserv = crpserv;
	}
	public String getCrpaserv() {
		return crpaserv;
	}
	public void setCrpaserv(String crpaserv) {
		this.crpaserv = crpaserv;
	}
	public String getCrapxserv() {
		return crapxserv;
	}
	public void setCrapxserv(String crapxserv) {
		this.crapxserv = crapxserv;
	}
	public String getCrsfcserv() {
		return crsfcserv;
	}
	public void setCrsfcserv(String crsfcserv) {
		this.crsfcserv = crsfcserv;
	}
	@Override
	public String toString() {
		return "AreaMst [carea=" + carea + ", careadesc=" + careadesc
				+ ", cscrcd=" + cscrcd + ", cscrcddesc=" + cscrcddesc
				+ ", cstate=" + cstate + ", ctel=" + ctel + ", cfax=" + cfax
				+ ", bembargo=" + bembargo + ", cdpserv=" + cdpserv
				+ ", cipserv=" + cipserv + ", capeserv=" + capeserv
				+ ", csfcserv=" + csfcserv + ", ccluster=" + ccluster
				+ ", cloctype=" + cloctype + ", ccodserv=" + ccodserv
				+ ", cfodserv=" + cfodserv + ", ccrdserv=" + ccrdserv
				+ ", cpbagdst=" + cpbagdst + ", ciatacode=" + ciatacode
				+ ", cdpznb=" + cdpznb + ", cregion=" + cregion + ", bcmploc="
				+ bcmploc + ", ccntrycode=" + ccntrycode + ", crpserv="
				+ crpserv + ", crpaserv=" + crpaserv + ", crapxserv="
				+ crapxserv + ", crsfcserv=" + crsfcserv + "]";
	}
	
		
}
