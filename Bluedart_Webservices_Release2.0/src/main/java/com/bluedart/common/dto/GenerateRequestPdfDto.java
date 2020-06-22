package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

public class GenerateRequestPdfDto implements Serializable {
	
	private static final long serialVersionUID = 192534330331234L;
	
	private String modifieddate;
	private String cattention;
	private String ccaltmob;
	private String ccmdtycode;
	private String ccneeadr1;
	private String ccneeadr2;
	private String ccneeadr3;
	private String ccneename;
	private String ccneepin;
	private String cctmno;
	private String ccustadr1;
	private String ccustadr2;
	private String ccustadr3;
	private String ccustcode;
	private String ccustareacode;
	private String ccustname;
	private String ccustpin;
	private String ccusttel;
	private String cdstarea;
	private String cdstscrcd;
	private int ckgpound;  // C - default value '0'
	private String clputime;
	
	private String cmrksnos1; // Y, Mandatory, commodity description
	private String cmrksnos2;
	private String cmrksnos3;
	
	private String cmloccode;
	private String coffcltime;
	private String corgarea;
	private String corgscrcd;
	
	private String cpacktype; // N
	
	private String cprodcode;
	private String cprodtype;
	private String cputime;
	private String csender;
	private String csubcode; // N, Optional(Vendor code)
	private String dcustedd;
	private String deptdtdlv;
	private String dinvdate;
	private String dlpudate;
	private String dpudate;
	private String dvalidupto; // C Credit card Expiry date   - Mandatory if  Payment done by Credit card
	private String ispuregistered;
	private double nactwgt;
	private double ncolamt; //C COD/DOD Collectable amount 
	private int ncshmemno;
	private double ndclrdval;
	private int ndeferreddeliverydays;
	private int nitemcnt;
	private double nmiscchg2;
	private int npcs;
	private double nweight;
	private List<DimensionEntityDto> dimensionEntityDto;
	private double Breadth;
	private double Height;
	private double Length;
	private double SlabWeight;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	private String loggedInUserEmailId;
	private String shipperEmailId;
	
	private int tokenno;
	private String ccneetel;
	
	private GSTDetailsDto gstDetailsDto;
	
//	private String cfodcodflg;
//	private String ccodfavour;//C
//	private String ccodpayble;// C
	private String ccrcardno; // C Credit card No   - Mandatory if  Payment done by Credit card
	private String ccardcode; // C  Credit card Type   - Mandatory if  Payment done by Credit card (Type 10 : Visa Card,20: Master card ,30 : Diner`s Card
	private String ccardhold; //  C Credit card holder    - Mandatory if  Payment done by Credit card
	private String cilloc;// C Currency Code , Mandatory For Intl outbound
	private String ccustmob; //C Shipper Mobile No ,Mandatory for all Cash 
	private String cflm; //C Commercial /Non Commercial flag ,Mandatory for Intl Outbound
	private String ccntrycode; //C, Country Code , Mandatory For Intl O/B
	private String cisddn; // N

	private String cbatchno;//Y Mandatory - For website 5599
	private String cmode;//Y Mandatory
	private String cpumode;//N    C:  Counter Drop ,P: Pickup 
	
	private String ccneeadrdt; //N
	
	private String cdescrip1; // N PaperWork description 1
	private String cdescrip2; // N PaperWork description 2
	private String cdescrip3; // N PaperWork description 3
	
	private String ccneecode; //Y, Mandatory, but not used in service
	private String ccneemob; //Y, Mandatory, but not used in service;
	
	private String cintlcitynm;
	private String cntryname;
	
	private String ccrcrdref;
	
	private String cprodfeature;
	private String overHandlingShipmnt; // only for international shipment
	private String saturdayDel; // only for international shipment
	private String commNonCom; // only for international shipment
	private String dtpShipment; // only for international shipment
	private String CFODCODFLG;// For COD/DOD shipments  , Mode of Payment collection from consignee , C: Cash, D : DD ,Q : Cheque
	private String CCODFAVOUR;
	private String CCODPAYBLE;
	
	private String cinvno;
	
	private String cfovtype;
	private String cIncoTerms;
	
	private String cStateCode;
	
	private String loginId;
	
	
	public String getcIncoTerms() {
		return cIncoTerms;
	}
	public void setcIncoTerms(String cIncoTerms) {
		this.cIncoTerms = cIncoTerms;
	}
	public String getCdescrip3() {
		return cdescrip3;
	}
	public void setCdescrip3(String cdescrip3) {
		this.cdescrip3 = cdescrip3;
	}
	public String getCFODCODFLG() {
		return CFODCODFLG;
	}
	public void setCFODCODFLG(String cFODCODFLG) {
		CFODCODFLG = cFODCODFLG;
	}
	public String getCCODFAVOUR() {
		return CCODFAVOUR;
	}
	public void setCCODFAVOUR(String cCODFAVOUR) {
		CCODFAVOUR = cCODFAVOUR;
	}
	public String getCCODPAYBLE() {
		return CCODPAYBLE;
	}
	public void setCCODPAYBLE(String cCODPAYBLE) {
		CCODPAYBLE = cCODPAYBLE;
	}
	public String getSaturdayDel() {
		return saturdayDel;
	}
	public void setSaturdayDel(String saturdayDel) {
		this.saturdayDel = saturdayDel;
	}
	public String getCommNonCom() {
		return commNonCom;
	}
	public void setCommNonCom(String commNonCom) {
		this.commNonCom = commNonCom;
	}
	public String getDtpShipment() {
		return dtpShipment;
	}
	public void setDtpShipment(String dtpShipment) {
		this.dtpShipment = dtpShipment;
	}
	public String getOverHandlingShipmnt() {
		return overHandlingShipmnt;
	}
	public void setOverHandlingShipmnt(String overHandlingShipmnt) {
		this.overHandlingShipmnt = overHandlingShipmnt;
	}
	public String getShipperEmailId() {
		return shipperEmailId;
	}
	public void setShipperEmailId(String shipperEmailId) {
		this.shipperEmailId = shipperEmailId;
	}
	public boolean isErrorOccured() {
		return errorOccured;
	}
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<DimensionEntityDto> getDimensionEntityDto() {
		return dimensionEntityDto;
	}
	public void setDimensionEntityDto(List<DimensionEntityDto> dimensionEntityDto) {
		this.dimensionEntityDto = dimensionEntityDto;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getCattention() {
		return cattention;
	}
	public void setCattention(String cattention) {
		this.cattention = cattention;
	}
	public String getCcaltmob() {
		return ccaltmob;
	}
	public void setCcaltmob(String ccaltmob) {
		this.ccaltmob = ccaltmob;
	}
	public String getCcmdtycode() {
		return ccmdtycode;
	}
	public void setCcmdtycode(String ccmdtycode) {
		this.ccmdtycode = ccmdtycode;
	}
	public String getCcneeadr1() {
		return ccneeadr1;
	}
	public void setCcneeadr1(String ccneeadr1) {
		this.ccneeadr1 = ccneeadr1;
	}
	public String getCcneeadr2() {
		return ccneeadr2;
	}
	public void setCcneeadr2(String ccneeadr2) {
		this.ccneeadr2 = ccneeadr2;
	}
	public String getCcneeadr3() {
		return ccneeadr3;
	}
	public void setCcneeadr3(String ccneeadr3) {
		this.ccneeadr3 = ccneeadr3;
	}
	public String getCcneename() {
		return ccneename;
	}
	public void setCcneename(String ccneename) {
		this.ccneename = ccneename;
	}
	public String getCcneepin() {
		return ccneepin;
	}
	public void setCcneepin(String ccneepin) {
		this.ccneepin = ccneepin;
	}
	public String getCctmno() {
		return cctmno;
	}
	public void setCctmno(String cctmno) {
		this.cctmno = cctmno;
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
	public String getCcustcode() {
		return ccustcode;
	}
	public void setCcustcode(String ccustcode) {
		this.ccustcode = ccustcode;
	}
	public String getCcustname() {
		return ccustname;
	}
	public void setCcustname(String ccustname) {
		this.ccustname = ccustname;
	}
	public String getCcustpin() {
		return ccustpin;
	}
	public void setCcustpin(String ccustpin) {
		this.ccustpin = ccustpin;
	}
	public String getCdstarea() {
		return cdstarea;
	}
	public void setCdstarea(String cdstarea) {
		this.cdstarea = cdstarea;
	}
	public String getCdstscrcd() {
		return cdstscrcd;
	}
	public void setCdstscrcd(String cdstscrcd) {
		this.cdstscrcd = cdstscrcd;
	}
	public int getCkgpound() {
		return ckgpound;
	}
	public void setCkgpound(int ckgpound) {
		this.ckgpound = ckgpound;
	}
	public String getClputime() {
		return clputime;
	}
	public void setClputime(String clputime) {
		this.clputime = clputime;
	}
	public String getCmloccode() {
		return cmloccode;
	}
	public void setCmloccode(String cmloccode) {
		this.cmloccode = cmloccode;
	}
	public String getCoffcltime() {
		return coffcltime;
	}
	public void setCoffcltime(String coffcltime) {
		this.coffcltime = coffcltime;
	}
	public String getCorgarea() {
		return corgarea;
	}
	public void setCorgarea(String corgarea) {
		this.corgarea = corgarea;
	}
	public String getCorgscrcd() {
		return corgscrcd;
	}
	public void setCorgscrcd(String corgscrcd) {
		this.corgscrcd = corgscrcd;
	}
	public String getCprodcode() {
		return cprodcode;
	}
	public void setCprodcode(String cprodcode) {
		this.cprodcode = cprodcode;
	}
	public String getCputime() {
		return cputime;
	}
	public void setCputime(String cputime) {
		this.cputime = cputime;
	}
	public String getCsender() {
		return csender;
	}
	public void setCsender(String csender) {
		this.csender = csender;
	}
	public String getDcustedd() {
		return dcustedd;
	}
	public void setDcustedd(String dcustedd) {
		this.dcustedd = dcustedd;
	}
	public String getDeptdtdlv() {
		return deptdtdlv;
	}
	public void setDeptdtdlv(String deptdtdlv) {
		this.deptdtdlv = deptdtdlv;
	}
	public String getDinvdate() {
		return dinvdate;
	}
	public void setDinvdate(String dinvdate) {
		this.dinvdate = dinvdate;
	}
	public String getDlpudate() {
		return dlpudate;
	}
	public void setDlpudate(String dlpudate) {
		this.dlpudate = dlpudate;
	}
	public String getDpudate() {
		return dpudate;
	}
	public void setDpudate(String dpudate) {
		this.dpudate = dpudate;
	}
	public String getDvalidupto() {
		return dvalidupto;
	}
	public void setDvalidupto(String dvalidupto) {
		this.dvalidupto = dvalidupto;
	}
	public String getIspuregistered() {
		return ispuregistered;
	}
	public void setIspuregistered(String ispuregistered) {
		this.ispuregistered = ispuregistered;
	}
	public double getNactwgt() {
		return nactwgt;
	}
	public void setNactwgt(double nactwgt) {
		this.nactwgt = nactwgt;
	}
	public double getNcolamt() {
		return ncolamt;
	}
	public void setNcolamt(double ncolamt) {
		this.ncolamt = ncolamt;
	}
	public int getNcshmemno() {
		return ncshmemno;
	}
	public void setNcshmemno(int ncshmemno) {
		this.ncshmemno = ncshmemno;
	}
	public double getNdclrdval() {
		return ndclrdval;
	}
	public void setNdclrdval(double ndclrdval) {
		this.ndclrdval = ndclrdval;
	}
	public int getNdeferreddeliverydays() {
		return ndeferreddeliverydays;
	}
	public void setNdeferreddeliverydays(int ndeferreddeliverydays) {
		this.ndeferreddeliverydays = ndeferreddeliverydays;
	}
	public int getNitemcnt() {
		return nitemcnt;
	}
	public void setNitemcnt(int nitemcnt) {
		this.nitemcnt = nitemcnt;
	}
	public double getNmiscchg2() {
		return nmiscchg2;
	}
	public void setNmiscchg2(double nmiscchg2) {
		this.nmiscchg2 = nmiscchg2;
	}
	public int getNpcs() {
		return npcs;
	}
	public void setNpcs(int npcs) {
		this.npcs = npcs;
	}
	public double getNweight() {
		return nweight;
	}
	public void setNweight(double nweight) {
		this.nweight = nweight;
	}
	
	public double getBreadth() {
		return Breadth;
	}
	public void setBreadth(double breadth) {
		Breadth = breadth;
	}
	public double getHeight() {
		return Height;
	}
	public void setHeight(double height) {
		Height = height;
	}
	public double getLength() {
		return Length;
	}
	public void setLength(double length) {
		Length = length;
	}
	public double getSlabWeight() {
		return SlabWeight;
	}
	public void setSlabWeight(double slabWeight) {
		SlabWeight = slabWeight;
	}
	public String getLoggedInUserEmailId() {
		return loggedInUserEmailId;
	}
	public void setLoggedInUserEmailId(String loggedInUserEmailId) {
		this.loggedInUserEmailId = loggedInUserEmailId;
	}
	public String getCcneetel() {
		return ccneetel;
	}
	public void setCcneetel(String ccneetel) {
		this.ccneetel = ccneetel;
	}
	
	
	///newly added fields
	public String getCcntrycode() {
		return ccntrycode;
	}
	public void setCcntrycode(String ccntrycode) {
		this.ccntrycode = ccntrycode;
	}
	public String getCcusttel() {
		return ccusttel;
	}
	public void setCcusttel(String ccusttel) {
		this.ccusttel = ccusttel;
	}
	public String getCmrksnos1() {
		return cmrksnos1;
	}
	public void setCmrksnos1(String cmrksnos1) {
		this.cmrksnos1 = cmrksnos1;
	}
	public String getCmrksnos2() {
		return cmrksnos2;
	}
	public void setCmrksnos2(String cmrksnos2) {
		this.cmrksnos2 = cmrksnos2;
	}
	public String getCmrksnos3() {
		return cmrksnos3;
	}
	public void setCmrksnos3(String cmrksnos3) {
		this.cmrksnos3 = cmrksnos3;
	}
	public String getCpacktype() {
		return cpacktype;
	}
	public void setCpacktype(String cpacktype) {
		this.cpacktype = cpacktype;
	}
	public String getCprodtype() {
		return cprodtype;
	}
	public void setCprodtype(String cprodtype) {
		this.cprodtype = cprodtype;
	}
	public String getCsubcode() {
		return csubcode;
	}
	public void setCsubcode(String csubcode) {
		this.csubcode = csubcode;
	}
	public int getTokenno() {
		return tokenno;
	}
	public void setTokenno(int tokenno) {
		this.tokenno = tokenno;
	}
	public GSTDetailsDto getGstDetailsDto() {
		return gstDetailsDto;
	}
	public void setGstDetailsDto(GSTDetailsDto gstDetailsDto) {
		this.gstDetailsDto = gstDetailsDto;
	}
	public String getCmode() {
		return cmode;
	}
	public void setCmode(String cmode) {
		this.cmode = cmode;
	}
	public String getCbatchno() {
		return cbatchno;
	}
	public void setCbatchno(String cbatchno) {
		this.cbatchno = cbatchno;
	}
	public String getCpumode() {
		return cpumode;
	}
	public void setCpumode(String cpumode) {
		this.cpumode = cpumode;
	}
	public String getCcneeadrdt() {
		return ccneeadrdt;
	}
	public void setCcneeadrdt(String ccneeadrdt) {
		this.ccneeadrdt = ccneeadrdt;
	}
	public String getCdescrip1() {
		return cdescrip1;
	}
	public void setCdescrip1(String cdescrip1) {
		this.cdescrip1 = cdescrip1;
	}
	public String getCdescrip2() {
		return cdescrip2;
	}
	public void setCdescrip2(String cdescrip2) {
		this.cdescrip2 = cdescrip2;
	}
	public String getCcneecode() {
		return ccneecode;
	}
	public void setCcneecode(String ccneecode) {
		this.ccneecode = ccneecode;
	}
	public String getCcrcardno() {
		return ccrcardno;
	}
	public void setCcrcardno(String ccrcardno) {
		this.ccrcardno = ccrcardno;
	}
	public String getCcardcode() {
		return ccardcode;
	}
	public void setCcardcode(String ccardcode) {
		this.ccardcode = ccardcode;
	}
	public String getCcardhold() {
		return ccardhold;
	}
	public void setCcardhold(String ccardhold) {
		this.ccardhold = ccardhold;
	}
	public String getCcneemob() {
		return ccneemob;
	}
	public void setCcneemob(String ccneemob) {
		this.ccneemob = ccneemob;
	}
	public String getCilloc() {
		return cilloc;
	}
	public void setCilloc(String cilloc) {
		this.cilloc = cilloc;
	}
	public String getCcustmob() {
		return ccustmob;
	}
	public void setCcustmob(String ccustmob) {
		this.ccustmob = ccustmob;
	}
	public String getCflm() {
		return cflm;
	}
	public void setCflm(String cflm) {
		this.cflm = cflm;
	}
	public String getCisddn() {
		return cisddn;
	}
	public void setCisddn(String cisddn) {
		this.cisddn = cisddn;
	}
	
	public String getCintlcitynm() {
		return cintlcitynm;
	}
	public void setCintlcitynm(String cintlcitynm) {
		this.cintlcitynm = cintlcitynm;
	}
	
	public String getCntryname() {
		return cntryname;
	}
	public void setCntryname(String cntryname) {
		this.cntryname = cntryname;
	}
	
	public String getCcrcrdref() {
		return ccrcrdref;
	}
	public void setCcrcrdref(String ccrcrdref) {
		this.ccrcrdref = ccrcrdref;
	}
	public String getCprodfeature() {
		return cprodfeature;
	}
	public void setCprodfeature(String cprodfeature) {
		this.cprodfeature = cprodfeature;
	}
	public String getCinvno() {
		return cinvno;
	}
	public void setCinvno(String cinvno) {
		this.cinvno = cinvno;
	}
	
	public String getCfovtype() {
		return cfovtype;
	}
	public void setCfovtype(String cfovtype) {
		this.cfovtype = cfovtype;
	}
	public String getCcustareacode() {
		return ccustareacode;
	}
	public void setCcustareacode(String ccustareacode) {
		this.ccustareacode = ccustareacode;
	}
	public String getcStateCode() {
		return cStateCode;
	}
	public void setcStateCode(String cStateCode) {
		this.cStateCode = cStateCode;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
}
