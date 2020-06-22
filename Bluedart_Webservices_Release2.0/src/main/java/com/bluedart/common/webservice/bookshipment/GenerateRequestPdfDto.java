package com.bluedart.common.webservice.bookshipment;

import java.io.Serializable;

public class GenerateRequestPdfDto implements Serializable{
	
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
	private String ccustname;
	private String ccustpin;
	private String cdstarea;
	private String cdstscrcd;
	private String ckgpound;
	private String clputime;
	private String cmloccode;
	private String coffcltime;
	private String corgarea;
	private String corgscrcd;
	private String cprodcode;
	private String cputime;
	private String csender;
	private String dcustedd;
	private String deptdtdlv;
	private String dinvdate;
	private String dlpudate;
	private String dpudate;
	private String dvalidupto;
	private String ispuregistered;
	private String nactwgt;
	private String ncolamt;
	private String ncshmemno;
	private String ndclrdval;
	private String ndeferreddeliverydays;
	private String nitemcnt;
	private String nmiscchg2;
	private String npcs;
	private String nweight;
	//private List<DimensionEntityDto> dimensionEntityDto;	
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	
	
	
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
	/*public List<DimensionEntityDto> getDimensionEntityDto() {
		return dimensionEntityDto;
	}
	public void setDimensionEntityDto(List<DimensionEntityDto> dimensionEntityDto) {
		this.dimensionEntityDto = dimensionEntityDto;
	}*/
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
	public String getCkgpound() {
		return ckgpound;
	}
	public void setCkgpound(String ckgpound) {
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
	public String getNactwgt() {
		return nactwgt;
	}
	public void setNactwgt(String nactwgt) {
		this.nactwgt = nactwgt;
	}
	public String getNcolamt() {
		return ncolamt;
	}
	public void setNcolamt(String ncolamt) {
		this.ncolamt = ncolamt;
	}
	public String getNcshmemno() {
		return ncshmemno;
	}
	public void setNcshmemno(String ncshmemno) {
		this.ncshmemno = ncshmemno;
	}
	public String getNdclrdval() {
		return ndclrdval;
	}
	public void setNdclrdval(String ndclrdval) {
		this.ndclrdval = ndclrdval;
	}
	public String getNdeferreddeliverydays() {
		return ndeferreddeliverydays;
	}
	public void setNdeferreddeliverydays(String ndeferreddeliverydays) {
		this.ndeferreddeliverydays = ndeferreddeliverydays;
	}
	public String getNitemcnt() {
		return nitemcnt;
	}
	public void setNitemcnt(String nitemcnt) {
		this.nitemcnt = nitemcnt;
	}
	public String getNmiscchg2() {
		return nmiscchg2;
	}
	public void setNmiscchg2(String nmiscchg2) {
		this.nmiscchg2 = nmiscchg2;
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
	
	
	

}
