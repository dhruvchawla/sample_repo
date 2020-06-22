package com.bluedart.trackdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author DH839598
 * @version 1.1 - 11/July/2016
 *
 */
public class ShipmentSO implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private String cawbno;
	private String crefno;
	private String cprodcode;
	private String cproddesc;
	private String ccustcode;
	private String corgscrcd;
	private String corgscrdesc;
	private String corgarea;
	private String corgareadesc;
	private String cdstscrcd;
	private String cdstscrdesc;
	private String cdstarea;
	private String cdstareadesc;
	private String cstattype;
	private String cstatcode;
	private String dstatdate;
	private String cstattime;
	private String cqrygrp;
	private String cstatgrp;
	private String cstatdesc;
	private String cstatdesc1;
	private String cstatdesc2;
	private String dpudate;
	private String cputime;
	private String cmode;
	private String cprodtype;
	private String ccmdtycode;
	private String npcs;
	private String nweight;
	private String nactwgt;
	private String namt;
	private String cmloccode;
	private String ctrncode;
	private String cpuemplcd;
	private String deptdtdlv;
	private String dbatchdt;
	private String cadecode;
	private String ntokenno;
	private String ndiscamt;
	private String ncommamt;
	private String csender;
	private String cattention;
	private String crecdby;
	private String crelation;
	private String cidtype;
	private String cidno;
	private String csplinst;
	private String cbillno;
	private String cbillcac;
	private String cpacktype;
	private String cfoccode;
	private String ckgpound;
	private String ccneecode;
	private String cshpcname;
	private String cshpcadr1;
	private String cshpcadr2;
	private String cshpcadr3;
	private String cshpcpin;
	private String cshpctel;
	private String cshpctlx;
	private String cshpcfax;
	private String cconscname;
	private String cconscadr1;
	private String cconscadr2;
	private String cconscadr3;
	private String cconscpin;
	private String cconsctel;
	private String cconsctlx;
	private String cconscfax;
	private String cstatus;
	private String cnewawbno;
	private String cnewprodcode;
	private String cneworgarea;
	private String cfocdesc;
	private String ccmdtyname;
	private String cemailid;
	private String cmobileno;
	private String cpoddc;
	private String cDestStateCode;
	private String cDestCntryCode;
	
	private List<PodSO> podSOList;
	
	//Lable
	private String formalDateFlag;
	private String pickupDateFlag;
	private String countryOrigin;
	private String from;
	private String countryDelivery;
	private String to;
	private String showStatus;
	private String showTick;
	private String showFullImage;
	private String showHalfImage;
	private String dateOfDelivery;
	private String timeOfDelivery;
	private String recipient;
	private String newWayBillNo;
	private String exptDateOfDelivery;
	private String splinst;
	private String shippedProgressBar;
	private String deliveryProgressBar;
	private String inTransitProgressBar;
	private String serviceFlag;
	private String showConsigneeAddress;
	private String showPackType;
	private String showProdType;
	private String secLevelFlag;
	
	
	
	
	 
	

	
	
	
	 
	 
	public String getSecLevelFlag() {
		return secLevelFlag;
	}
	public void setSecLevelFlag(String secLevelFlag) {
		this.secLevelFlag = secLevelFlag;
	}
	public String getShowProdType() {
		return showProdType;
	}
	public void setShowProdType(String showProdType) {
		this.showProdType = showProdType;
	}
	public String getShowConsigneeAddress() {
		return showConsigneeAddress;
	}
	public void setShowConsigneeAddress(String showConsigneeAddress) {
		this.showConsigneeAddress = showConsigneeAddress;
	}
	public String getShowPackType() {
		return showPackType;
	}
	public void setShowPackType(String showPackType) {
		this.showPackType = showPackType;
	}
	public String getServiceFlag() {
		return serviceFlag;
	}
	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}
	public List<PodSO> getPodSOList() {
		return podSOList;
	}
	public void setPodSOList(List<PodSO> podSOList) {
		this.podSOList = podSOList;
	}
	public String getShippedProgressBar() {
		return shippedProgressBar;
	}
	public void setShippedProgressBar(String shippedProgressBar) {
		this.shippedProgressBar = shippedProgressBar;
	}
	public String getDeliveryProgressBar() {
		return deliveryProgressBar;
	}
	public void setDeliveryProgressBar(String deliveryProgressBar) {
		this.deliveryProgressBar = deliveryProgressBar;
	}
	public String getInTransitProgressBar() {
		return inTransitProgressBar;
	}
	public void setInTransitProgressBar(String inTransitProgressBar) {
		this.inTransitProgressBar = inTransitProgressBar;
	}
	public String getShowStatus() {
		return showStatus;
	}
	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}
	public String getCawbno() {
		return cawbno;
	}
	public void setCawbno(String cawbno) {
		this.cawbno = cawbno;
	}
	public String getCrefno() {
		return crefno;
	}
	public void setCrefno(String crefno) {
		this.crefno = crefno;
	}
	public String getCprodcode() {
		return cprodcode;
	}
	public void setCprodcode(String cprodcode) {
		this.cprodcode = cprodcode;
	}
	public String getCproddesc() {
		return cproddesc;
	}
	public void setCproddesc(String cproddesc) {
		this.cproddesc = cproddesc;
	}
	public String getCcustcode() {
		return ccustcode;
	}
	public void setCcustcode(String ccustcode) {
		this.ccustcode = ccustcode;
	}
	public String getCorgscrcd() {
		return corgscrcd;
	}
	public void setCorgscrcd(String corgscrcd) {
		this.corgscrcd = corgscrcd;
	}
	public String getCorgscrdesc() {
		return corgscrdesc;
	}
	public void setCorgscrdesc(String corgscrdesc) {
		this.corgscrdesc = corgscrdesc;
	}
	public String getCorgarea() {
		return corgarea;
	}
	public void setCorgarea(String corgarea) {
		this.corgarea = corgarea;
	}
	public String getCorgareadesc() {
		return corgareadesc;
	}
	public void setCorgareadesc(String corgareadesc) {
		this.corgareadesc = corgareadesc;
	}
	public String getCdstscrcd() {
		return cdstscrcd;
	}
	public void setCdstscrcd(String cdstscrcd) {
		this.cdstscrcd = cdstscrcd;
	}
	public String getCdstscrdesc() {
		return cdstscrdesc;
	}
	public void setCdstscrdesc(String cdstscrdesc) {
		this.cdstscrdesc = cdstscrdesc;
	}
	public String getCdstarea() {
		return cdstarea;
	}
	public void setCdstarea(String cdstarea) {
		this.cdstarea = cdstarea;
	}
	public String getCdstareadesc() {
		return cdstareadesc;
	}
	public void setCdstareadesc(String cdstareadesc) {
		this.cdstareadesc = cdstareadesc;
	}
	public String getCstattype() {
		return cstattype;
	}
	public void setCstattype(String cstattype) {
		this.cstattype = cstattype;
	}
	public String getCstatcode() {
		return cstatcode;
	}
	public void setCstatcode(String cstatcode) {
		this.cstatcode = cstatcode;
	}
	public String getDstatdate() {
		return dstatdate;
	}
	public void setDstatdate(String dstatdate) {
		this.dstatdate = dstatdate;
	}
	public String getCstattime() {
		return cstattime;
	}
	public void setCstattime(String cstattime) {
		this.cstattime = cstattime;
	}
	public String getCqrygrp() {
		return cqrygrp;
	}
	public void setCqrygrp(String cqrygrp) {
		this.cqrygrp = cqrygrp;
	}
	public String getCstatgrp() {
		return cstatgrp;
	}
	public void setCstatgrp(String cstatgrp) {
		this.cstatgrp = cstatgrp;
	}
	public String getCstatdesc() {
		return cstatdesc;
	}
	public void setCstatdesc(String cstatdesc) {
		this.cstatdesc = cstatdesc;
	}
	public String getCstatdesc1() {
		return cstatdesc1;
	}
	public void setCstatdesc1(String cstatdesc1) {
		this.cstatdesc1 = cstatdesc1;
	}
	public String getCstatdesc2() {
		return cstatdesc2;
	}
	public void setCstatdesc2(String cstatdesc2) {
		this.cstatdesc2 = cstatdesc2;
	}
	public String getDpudate() {
		return dpudate;
	}
	public void setDpudate(String dpudate) {
		this.dpudate = dpudate;
	}
	public String getCputime() {
		return cputime;
	}
	public void setCputime(String cputime) {
		this.cputime = cputime;
	}
	public String getCmode() {
		return cmode;
	}
	public void setCmode(String cmode) {
		this.cmode = cmode;
	}
	public String getCprodtype() {
		return cprodtype;
	}
	public void setCprodtype(String cprodtype) {
		this.cprodtype = cprodtype;
	}
	public String getCcmdtycode() {
		return ccmdtycode;
	}
	public void setCcmdtycode(String ccmdtycode) {
		this.ccmdtycode = ccmdtycode;
	}
	public String getNpcs() {
		return npcs;
	}
	public void setNpcs(String npcs) {
		this.npcs = npcs;
	}
	public String getNweight() {
		return nweight;
	}
	public void setNweight(String nweight) {
		this.nweight = nweight;
	}
	public String getNactwgt() {
		return nactwgt;
	}
	public void setNactwgt(String nactwgt) {
		this.nactwgt = nactwgt;
	}
	public String getNamt() {
		return namt;
	}
	public void setNamt(String namt) {
		this.namt = namt;
	}
	public String getCmloccode() {
		return cmloccode;
	}
	public void setCmloccode(String cmloccode) {
		this.cmloccode = cmloccode;
	}
	public String getCtrncode() {
		return ctrncode;
	}
	public void setCtrncode(String ctrncode) {
		this.ctrncode = ctrncode;
	}
	public String getCpuemplcd() {
		return cpuemplcd;
	}
	public void setCpuemplcd(String cpuemplcd) {
		this.cpuemplcd = cpuemplcd;
	}
	public String getDeptdtdlv() {
		return deptdtdlv;
	}
	public void setDeptdtdlv(String deptdtdlv) {
		this.deptdtdlv = deptdtdlv;
	}
	public String getDbatchdt() {
		return dbatchdt;
	}
	public void setDbatchdt(String dbatchdt) {
		this.dbatchdt = dbatchdt;
	}
	public String getCadecode() {
		return cadecode;
	}
	public void setCadecode(String cadecode) {
		this.cadecode = cadecode;
	}
	public String getNtokenno() {
		return ntokenno;
	}
	public void setNtokenno(String ntokenno) {
		this.ntokenno = ntokenno;
	}
	public String getNdiscamt() {
		return ndiscamt;
	}
	public void setNdiscamt(String ndiscamt) {
		this.ndiscamt = ndiscamt;
	}
	public String getNcommamt() {
		return ncommamt;
	}
	public void setNcommamt(String ncommamt) {
		this.ncommamt = ncommamt;
	}
	public String getCsender() {
		return csender;
	}
	public void setCsender(String csender) {
		this.csender = csender;
	}
	public String getCattention() {
		return cattention;
	}
	public void setCattention(String cattention) {
		this.cattention = cattention;
	}
	public String getCrecdby() {
		return crecdby;
	}
	public void setCrecdby(String crecdby) {
		this.crecdby = crecdby;
	}
	public String getCrelation() {
		return crelation;
	}
	public void setCrelation(String crelation) {
		this.crelation = crelation;
	}
	public String getCidtype() {
		return cidtype;
	}
	public void setCidtype(String cidtype) {
		this.cidtype = cidtype;
	}
	public String getCidno() {
		return cidno;
	}
	public void setCidno(String cidno) {
		this.cidno = cidno;
	}
	public String getCsplinst() {
		return csplinst;
	}
	public void setCsplinst(String csplinst) {
		this.csplinst = csplinst;
	}
	public String getCbillno() {
		return cbillno;
	}
	public void setCbillno(String cbillno) {
		this.cbillno = cbillno;
	}
	public String getCbillcac() {
		return cbillcac;
	}
	public void setCbillcac(String cbillcac) {
		this.cbillcac = cbillcac;
	}
	public String getCpacktype() {
		return cpacktype;
	}
	public void setCpacktype(String cpacktype) {
		this.cpacktype = cpacktype;
	}
	public String getCfoccode() {
		return cfoccode;
	}
	public void setCfoccode(String cfoccode) {
		this.cfoccode = cfoccode;
	}
	public String getCkgpound() {
		return ckgpound;
	}
	public void setCkgpound(String ckgpound) {
		this.ckgpound = ckgpound;
	}
	public String getCcneecode() {
		return ccneecode;
	}
	public void setCcneecode(String ccneecode) {
		this.ccneecode = ccneecode;
	}
	public String getCshpcname() {
		return cshpcname;
	}
	public void setCshpcname(String cshpcname) {
		this.cshpcname = cshpcname;
	}
	public String getCshpcadr1() {
		return cshpcadr1;
	}
	public void setCshpcadr1(String cshpcadr1) {
		this.cshpcadr1 = cshpcadr1;
	}
	public String getCshpcadr2() {
		return cshpcadr2;
	}
	public void setCshpcadr2(String cshpcadr2) {
		this.cshpcadr2 = cshpcadr2;
	}
	public String getCshpcadr3() {
		return cshpcadr3;
	}
	public void setCshpcadr3(String cshpcadr3) {
		this.cshpcadr3 = cshpcadr3;
	}
	public String getCshpcpin() {
		return cshpcpin;
	}
	public void setCshpcpin(String cshpcpin) {
		this.cshpcpin = cshpcpin;
	}
	public String getCshpctel() {
		return cshpctel;
	}
	public void setCshpctel(String cshpctel) {
		this.cshpctel = cshpctel;
	}
	public String getCshpctlx() {
		return cshpctlx;
	}
	public void setCshpctlx(String cshpctlx) {
		this.cshpctlx = cshpctlx;
	}
	public String getCshpcfax() {
		return cshpcfax;
	}
	public void setCshpcfax(String cshpcfax) {
		this.cshpcfax = cshpcfax;
	}
	public String getCconscname() {
		return cconscname;
	}
	public void setCconscname(String cconscname) {
		this.cconscname = cconscname;
	}
	public String getCconscadr1() {
		return cconscadr1;
	}
	public void setCconscadr1(String cconscadr1) {
		this.cconscadr1 = cconscadr1;
	}
	public String getCconscadr2() {
		return cconscadr2;
	}
	public void setCconscadr2(String cconscadr2) {
		this.cconscadr2 = cconscadr2;
	}
	public String getCconscadr3() {
		return cconscadr3;
	}
	public void setCconscadr3(String cconscadr3) {
		this.cconscadr3 = cconscadr3;
	}
	public String getCconscpin() {
		return cconscpin;
	}
	public void setCconscpin(String cconscpin) {
		this.cconscpin = cconscpin;
	}
	public String getCconsctel() {
		return cconsctel;
	}
	public void setCconsctel(String cconsctel) {
		this.cconsctel = cconsctel;
	}
	public String getCconsctlx() {
		return cconsctlx;
	}
	public void setCconsctlx(String cconsctlx) {
		this.cconsctlx = cconsctlx;
	}
	public String getCconscfax() {
		return cconscfax;
	}
	public void setCconscfax(String cconscfax) {
		this.cconscfax = cconscfax;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}
	public String getCnewawbno() {
		return cnewawbno;
	}
	public void setCnewawbno(String cnewawbno) {
		this.cnewawbno = cnewawbno;
	}
	public String getCnewprodcode() {
		return cnewprodcode;
	}
	public void setCnewprodcode(String cnewprodcode) {
		this.cnewprodcode = cnewprodcode;
	}
	public String getCneworgarea() {
		return cneworgarea;
	}
	public void setCneworgarea(String cneworgarea) {
		this.cneworgarea = cneworgarea;
	}
	public String getCfocdesc() {
		return cfocdesc;
	}
	public void setCfocdesc(String cfocdesc) {
		this.cfocdesc = cfocdesc;
	}
	public String getCcmdtyname() {
		return ccmdtyname;
	}
	public void setCcmdtyname(String ccmdtyname) {
		this.ccmdtyname = ccmdtyname;
	}
	public String getCemailid() {
		return cemailid;
	}
	public void setCemailid(String cemailid) {
		this.cemailid = cemailid;
	}
	public String getCmobileno() {
		return cmobileno;
	}
	public void setCmobileno(String cmobileno) {
		this.cmobileno = cmobileno;
	}
	public String getCpoddc() {
		return cpoddc;
	}
	public void setCpoddc(String cpoddc) {
		this.cpoddc = cpoddc;
	}
	public String getcDestStateCode() {
		return cDestStateCode;
	}
	public void setcDestStateCode(String cDestStateCode) {
		this.cDestStateCode = cDestStateCode;
	}
	public String getcDestCntryCode() {
		return cDestCntryCode;
	}
	public void setcDestCntryCode(String cDestCntryCode) {
		this.cDestCntryCode = cDestCntryCode;
	}
	public String getFormalDateFlag() {
		return formalDateFlag;
	}
	public void setFormalDateFlag(String formalDateFlag) {
		this.formalDateFlag = formalDateFlag;
	}
	public String getPickupDateFlag() {
		return pickupDateFlag;
	}
	public void setPickupDateFlag(String pickupDateFlag) {
		this.pickupDateFlag = pickupDateFlag;
	}
	public String getCountryOrigin() {
		return countryOrigin;
	}
	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getCountryDelivery() {
		return countryDelivery;
	}
	public void setCountryDelivery(String countryDelivery) {
		this.countryDelivery = countryDelivery;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getShowTick() {
		return showTick;
	}
	public void setShowTick(String showTick) {
		this.showTick = showTick;
	}
	public String getShowFullImage() {
		return showFullImage;
	}
	public void setShowFullImage(String showFullImage) {
		this.showFullImage = showFullImage;
	}
	public String getShowHalfImage() {
		return showHalfImage;
	}
	public void setShowHalfImage(String showHalfImage) {
		this.showHalfImage = showHalfImage;
	}
	public String getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(String dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public String getTimeOfDelivery() {
		return timeOfDelivery;
	}
	public void setTimeOfDelivery(String timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getNewWayBillNo() {
		return newWayBillNo;
	}
	public void setNewWayBillNo(String newWayBillNo) {
		this.newWayBillNo = newWayBillNo;
	}
	public String getExptDateOfDelivery() {
		return exptDateOfDelivery;
	}
	public void setExptDateOfDelivery(String exptDateOfDelivery) {
		this.exptDateOfDelivery = exptDateOfDelivery;
	}
	public String getSplinst() {
		return splinst;
	}
	public void setSplinst(String splinst) {
		this.splinst = splinst;
	}
	
	
	
	
	 
	 
	
	

}
