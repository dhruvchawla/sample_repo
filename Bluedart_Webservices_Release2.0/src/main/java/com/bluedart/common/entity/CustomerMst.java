package com.bluedart.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author PR334023
 *
 */
@Entity
@Table(name = "CUSTMST")
public class CustomerMst {

	@Id
	@Column(name = "CAREA")
	private String customerArea;
	@Column(name = "CCUSTCODE")
	private String customerCode;
	@Column(name = "CSCRCD")
	private String cscrcd;
	@Column(name = "CCUSTNAME")
	private String customerName; // NOT NULL
	@Column(name = "CCONTACT")
	private String customerContact;
	@Column(name = "CCUSTADR1")
	private String customerAddr1;
	@Column(name = "CCUSTADR2")
	private String customerAddr2;
	@Column(name = "CCUSTADR3")
	private String customerAddr3;
	@Column(name = "CCUSTPIN")
	private String customerPincode;
	@Column(name = "CCUSTTEL")
	private String customerPhone;
	@Column(name = "CCUSTTLX")
	private String customerTlx;
	@Column(name = "CCUSTFAX")
	private String customerFax;
	@Column(name = "BDLVNOPRT")
	private String bdlvnoprt;
	@Column(name = "CGCODE")
	private String cgCode;
	@Column(name = "CSGCODE")
	private String csgCode;
	@Column(name = "CDEPTCODE")
	private String cdeptCode;
	@Column(name = "CDEPTNAME")
	private String cdeptName;
	@Column(name = "CENTITYCD")
	private String centityCd;
	@Column(name = "CSALEMPCD")
	private String csalempcd;
	@Column(name = "CMKTSGTCD")
	private String cmktsgtcd;
	@Column(name = "CDESMAKER")
	private String cdesMaker;
	@Column(name = "CDESIG")
	private String cdesig;
	@Column(name = "DBIRTHDT")
	private Date dbirthDt;
	@Column(name = "CAREAGPCD")
	private String careaGpcd;
	@Column(name = "CEDPGPCD")
	private String cedpgpcd;
	@Column(name = "CALLGPCD")
	private String callGpcd;
	@Column(name = "CCSHCRD")
	private String ccshcrd;
	@Column(name = "BOFFCR")
	private String boffcr;
	@Column(name = "BPOD")
	private String bpod;
	@Column(name = "BSPSLAB")
	private String bspslab;
	@Column(name = "DEFFDATE")
	private Date defDate;
	@Column(name = "CDSCBHSE")
	private String cdscbhse;
	@Column(name = "BROCKBOTT")
	private String brockbott;
	@Column(name = "NBILLFREQ")
	private String nbillFreq;
	@Column(name = "DBILLDATE")
	private Date dbillDate;
	@Column(name = "BCONSOLID")
	private String bconsolid;
	@Column(name = "CCUSTTYPE")
	private String ccustType;
	@Column(name = "DENTDATE")
	private Date dentdate;
	@Column(name = "DREVDATE")
	private Date drevDate;
	@Column(name = "DSIGNDATE")
	private Date dsigndate;
	@Column(name = "BADDON")
	private String baddon;
	@Column(name = "BUPDATE")
	private String bupdate;
	@Column(name = "CLEADEMPCD")
	private String cleadempcd;
	@Column(name = "CWGTFLG")
	private String cwgtFlg;
	@Column(name = "CCUSTCAT")
	private String ccustCat;
	@Column(name = "CAGNTCODE")
	private String cagntCode;
	@Column(name = "BSMARTDN")
	private String bsmartdn;
	@Column(name = "BWAREDN")
	private String bwaredn;
	@Column(name = "CPFLAG")
	private String cpFlaf;
	@Column(name = "NINSPER")
	private String ninsper;
	@Column(name = "CBILLOC")
	private String cbilLoc;
	@Column(name = "NCFTVAL")
	private Integer ncftVal;
	@Column(name = "CGROUP")
	private String cGroup;
	@Column(name = "NDPAMT")
	private Integer ndpAmt;
	@Column(name = "CDPFLAG")
	private String cdpFlag;
	@Column(name = "CIDCUST")
	private String cidCust;
	@Column(name = "NAPEXFS")
	private Integer napexfs;
	@Column(name = "NSFCFS")
	private Integer nsfcfs;
	@Column(name = "DEXPDATE")
	private Date dexpDate;
	@Column(name = "CNETFLAG")
	private String cnetFlag;
	@Column(name = "SEMPEFFDT")
	private Date sempeffdt;
	@Column(name = "CRTOWTREST")
	private String crtowtrest;
	@Column(name = "NCREDITDAYS")
	private Integer ncreditDays;
	@Column(name = "NREMINDERDAYS")
	private Integer nreminderDays;
	@Column(name = "B_APPROVED")
	private String bApproved;
	@Column(name = "DLAST_APPROVED")
	private Date dlastApproved;
	@Column(name = "CAPPROVED_ID")
	private String capprovedId;
	@Column(name = "CCOLEMPCD")
	private String ccolEmpCd;
	@Column(name = "DENTRYDT")
	private Date dentrydt;
	@Column(name = "CEPOFLAG")
	private String cepoFlag;
	@Column(name = "DDHLDATE")
	private Date ddhlDate;
	@Column(name = "CCOMPGRP")
	private String ccompGrp;
	@Column(name = "CCENTBILL")
	private String ccentBill;
	@Column(name = "CCENTPROD")
	private String ccentProd;
	@Column(name = "CDSTNCODE")
	private String cdstnCode;
	@Column(name = "CCOLLCODE")
	private String ccollCode;
	@Column(name = "NVCHCKP")
	private Integer nvchckp;
	@Column(name = "NVCKAMT")
	private Integer nvckamt;
	@Column(name = "DOFDATE")
	private Date dofDate;
	@Column(name = "CVOLWTEXMP")
	private String cvoletexmp;
	@Column(name = "CHOFLAG")
	private String choflag;
	@Column(name = "CCOLLBRAN")
	private String ccollBran;
	@Column(name = "CDHLCODE")
	private String cdhlCode;
	@Column(name = "CORGSIGN")
	private String corgsign;
	@Column(name = "NDCDAYS")
	private Integer ndcDays;
	@Column(name = "NCUSTTAT")
	private Integer ncustTat;
	@Column(name = "CPDCRSTLOC")
	private String cpdcrstLoc;
	@Column(name = "CPDCTRKLOC")
	private String cpdctrkLoc;
	@Column(name = "NNSLGRACE")
	private Integer nnslGrace;
	@Column(name = "CDHLOBCODE")
	private String cdhlobCode;
	
	@Column(name = "CPANDCARD")
	private String cpandcard;
	@Column(name = "CFINACNO")
	private String cFinAcNo;
	@Column(name = "CPANVERIFIED")
	private String cpanVerified;
	@Column(name = "CCOMPGRPVARI")
	private String ccompGrpvari;
	@Column(name = "DMODIFYDATE")
	private Date dmodifyDate;
	@Column(name = "CBILLCUSTNAME")
	private String cbillCustName;
	@Column(name = "CCSEMPCD")
	private String ccsEmpcd;
	@Column(name = "CGSTN_UIDCODE")
	private String cgstn_uidcode;
	@Column(name = "CGSTNSTATECODE")
	private String cgstnStateCode;
	/*
	
	@Column(name = "DTRACK_INSERT")
	private Timestamp dtrackInsert;
	@Column(name = "DTRACK_UPDATE")
	private Timestamp dtrackUpdate;
	@Column(name = "CCUSTID")
	private String ccustId;
*/
	
	/**
	 * @return the customerArea
	 */
	public String getCustomerArea() {
		return customerArea;
	}

	/**
	 * @param customerArea
	 *            the customerArea to set
	 */
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}

	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode
	 *            the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return the cscrcd
	 */
	public String getCscrcd() {
		return cscrcd;
	}

	/**
	 * @param cscrcd
	 *            the cscrcd to set
	 */
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerContact
	 */
	public String getCustomerContact() {
		return customerContact;
	}

	/**
	 * @param customerContact
	 *            the customerContact to set
	 */
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	/**
	 * @return the customerAddr1
	 */
	public String getCustomerAddr1() {
		return customerAddr1;
	}

	/**
	 * @param customerAddr1
	 *            the customerAddr1 to set
	 */
	public void setCustomerAddr1(String customerAddr1) {
		this.customerAddr1 = customerAddr1;
	}

	/**
	 * @return the customerAddr2
	 */
	public String getCustomerAddr2() {
		return customerAddr2;
	}

	/**
	 * @param customerAddr2
	 *            the customerAddr2 to set
	 */
	public void setCustomerAddr2(String customerAddr2) {
		this.customerAddr2 = customerAddr2;
	}

	/**
	 * @return the customerAddr3
	 */
	public String getCustomerAddr3() {
		return customerAddr3;
	}

	/**
	 * @param customerAddr3
	 *            the customerAddr3 to set
	 */
	public void setCustomerAddr3(String customerAddr3) {
		this.customerAddr3 = customerAddr3;
	}

	/**
	 * @return the customerPincode
	 */
	public String getCustomerPincode() {
		return customerPincode;
	}

	/**
	 * @param customerPincode
	 *            the customerPincode to set
	 */
	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}

	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * @param customerPhone
	 *            the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * @return the customerTlx
	 */
	public String getCustomerTlx() {
		return customerTlx;
	}

	/**
	 * @param customerTlx
	 *            the customerTlx to set
	 */
	public void setCustomerTlx(String customerTlx) {
		this.customerTlx = customerTlx;
	}

	/**
	 * @return the customerFax
	 */
	public String getCustomerFax() {
		return customerFax;
	}

	/**
	 * @param customerFax
	 *            the customerFax to set
	 */
	public void setCustomerFax(String customerFax) {
		this.customerFax = customerFax;
	}

	/**
	 * @return the bdlvnoprt
	 */
	public String getBdlvnoprt() {
		return bdlvnoprt;
	}

	/**
	 * @param bdlvnoprt
	 *            the bdlvnoprt to set
	 */
	public void setBdlvnoprt(String bdlvnoprt) {
		this.bdlvnoprt = bdlvnoprt;
	}

	/**
	 * @return the cgCode
	 */
	public String getCgCode() {
		return cgCode;
	}

	/**
	 * @param cgCode
	 *            the cgCode to set
	 */
	public void setCgCode(String cgCode) {
		this.cgCode = cgCode;
	}

	/**
	 * @return the csgCode
	 */
	public String getCsgCode() {
		return csgCode;
	}

	/**
	 * @param csgCode
	 *            the csgCode to set
	 */
	public void setCsgCode(String csgCode) {
		this.csgCode = csgCode;
	}

	/**
	 * @return the cdeptCode
	 */
	public String getCdeptCode() {
		return cdeptCode;
	}

	/**
	 * @param cdeptCode
	 *            the cdeptCode to set
	 */
	public void setCdeptCode(String cdeptCode) {
		this.cdeptCode = cdeptCode;
	}

	/**
	 * @return the cdeptName
	 */
	public String getCdeptName() {
		return cdeptName;
	}

	/**
	 * @param cdeptName
	 *            the cdeptName to set
	 */
	public void setCdeptName(String cdeptName) {
		this.cdeptName = cdeptName;
	}

	/**
	 * @return the centityCd
	 */
	public String getCentityCd() {
		return centityCd;
	}

	/**
	 * @param centityCd
	 *            the centityCd to set
	 */
	public void setCentityCd(String centityCd) {
		this.centityCd = centityCd;
	}

	/**
	 * @return the csalempcd
	 */
	public String getCsalempcd() {
		return csalempcd;
	}

	/**
	 * @param csalempcd
	 *            the csalempcd to set
	 */
	public void setCsalempcd(String csalempcd) {
		this.csalempcd = csalempcd;
	}

	/**
	 * @return the cmktsgtcd
	 */
	public String getCmktsgtcd() {
		return cmktsgtcd;
	}

	/**
	 * @param cmktsgtcd
	 *            the cmktsgtcd to set
	 */
	public void setCmktsgtcd(String cmktsgtcd) {
		this.cmktsgtcd = cmktsgtcd;
	}

	/**
	 * @return the cdesMaker
	 */
	public String getCdesMaker() {
		return cdesMaker;
	}

	/**
	 * @param cdesMaker
	 *            the cdesMaker to set
	 */
	public void setCdesMaker(String cdesMaker) {
		this.cdesMaker = cdesMaker;
	}

	/**
	 * @return the cdesig
	 */
	public String getCdesig() {
		return cdesig;
	}

	/**
	 * @param cdesig
	 *            the cdesig to set
	 */
	public void setCdesig(String cdesig) {
		this.cdesig = cdesig;
	}

	/**
	 * @return the dbirthDt
	 */
	public Date getDbirthDt() {
		return dbirthDt;
	}

	/**
	 * @param dbirthDt
	 *            the dbirthDt to set
	 */
	public void setDbirthDt(Date dbirthDt) {
		this.dbirthDt = dbirthDt;
	}

	/**
	 * @return the careaGpcd
	 */
	public String getCareaGpcd() {
		return careaGpcd;
	}

	/**
	 * @param careaGpcd
	 *            the careaGpcd to set
	 */
	public void setCareaGpcd(String careaGpcd) {
		this.careaGpcd = careaGpcd;
	}

	/**
	 * @return the cedpgpcd
	 */
	public String getCedpgpcd() {
		return cedpgpcd;
	}

	/**
	 * @param cedpgpcd
	 *            the cedpgpcd to set
	 */
	public void setCedpgpcd(String cedpgpcd) {
		this.cedpgpcd = cedpgpcd;
	}

	/**
	 * @return the callGpcd
	 */
	public String getCallGpcd() {
		return callGpcd;
	}

	/**
	 * @param callGpcd
	 *            the callGpcd to set
	 */
	public void setCallGpcd(String callGpcd) {
		this.callGpcd = callGpcd;
	}

	/**
	 * @return the ccshcrd
	 */
	public String getCcshcrd() {
		return ccshcrd;
	}

	/**
	 * @param ccshcrd
	 *            the ccshcrd to set
	 */
	public void setCcshcrd(String ccshcrd) {
		this.ccshcrd = ccshcrd;
	}

	/**
	 * @return the boffcr
	 */
	public String getBoffcr() {
		return boffcr;
	}

	/**
	 * @param boffcr
	 *            the boffcr to set
	 */
	public void setBoffcr(String boffcr) {
		this.boffcr = boffcr;
	}

	/**
	 * @return the bpod
	 */
	public String getBpod() {
		return bpod;
	}

	/**
	 * @param bpod
	 *            the bpod to set
	 */
	public void setBpod(String bpod) {
		this.bpod = bpod;
	}

	/**
	 * @return the bspslab
	 */
	public String getBspslab() {
		return bspslab;
	}

	/**
	 * @param bspslab
	 *            the bspslab to set
	 */
	public void setBspslab(String bspslab) {
		this.bspslab = bspslab;
	}

	/**
	 * @return the defDate
	 */
	public Date getDefDate() {
		return defDate;
	}

	/**
	 * @param defDate
	 *            the defDate to set
	 */
	public void setDefDate(Date defDate) {
		this.defDate = defDate;
	}

	/**
	 * @return the cdscbhse
	 */
	public String getCdscbhse() {
		return cdscbhse;
	}

	/**
	 * @param cdscbhse
	 *            the cdscbhse to set
	 */
	public void setCdscbhse(String cdscbhse) {
		this.cdscbhse = cdscbhse;
	}

	/**
	 * @return the brockbott
	 */
	public String getBrockbott() {
		return brockbott;
	}

	/**
	 * @param brockbott
	 *            the brockbott to set
	 */
	public void setBrockbott(String brockbott) {
		this.brockbott = brockbott;
	}

	/**
	 * @return the nbillFreq
	 */
	public String getNbillFreq() {
		return nbillFreq;
	}

	/**
	 * @param nbillFreq
	 *            the nbillFreq to set
	 */
	public void setNbillFreq(String nbillFreq) {
		this.nbillFreq = nbillFreq;
	}

	/**
	 * @return the dbillDate
	 */
	public Date getDbillDate() {
		return dbillDate;
	}

	/**
	 * @param dbillDate
	 *            the dbillDate to set
	 */
	public void setDbillDate(Date dbillDate) {
		this.dbillDate = dbillDate;
	}

	/**
	 * @return the bconsolid
	 */
	public String getBconsolid() {
		return bconsolid;
	}

	/**
	 * @param bconsolid
	 *            the bconsolid to set
	 */
	public void setBconsolid(String bconsolid) {
		this.bconsolid = bconsolid;
	}

	/**
	 * @return the ccustType
	 */
	public String getCcustType() {
		return ccustType;
	}

	/**
	 * @param ccustType
	 *            the ccustType to set
	 */
	public void setCcustType(String ccustType) {
		this.ccustType = ccustType;
	}

	/**
	 * @return the dentdate
	 */
	public Date getDentdate() {
		return dentdate;
	}

	/**
	 * @param dentdate
	 *            the dentdate to set
	 */
	public void setDentdate(Date dentdate) {
		this.dentdate = dentdate;
	}

	/**
	 * @return the drevDate
	 */
	public Date getDrevDate() {
		return drevDate;
	}

	/**
	 * @param drevDate
	 *            the drevDate to set
	 */
	public void setDrevDate(Date drevDate) {
		this.drevDate = drevDate;
	}

	/**
	 * @return the dsigndate
	 */
	public Date getDsigndate() {
		return dsigndate;
	}

	/**
	 * @param dsigndate
	 *            the dsigndate to set
	 */
	public void setDsigndate(Date dsigndate) {
		this.dsigndate = dsigndate;
	}

	/**
	 * @return the baddon
	 */
	public String getBaddon() {
		return baddon;
	}

	/**
	 * @param baddon
	 *            the baddon to set
	 */
	public void setBaddon(String baddon) {
		this.baddon = baddon;
	}

	/**
	 * @return the bupdate
	 */
	public String getBupdate() {
		return bupdate;
	}

	/**
	 * @param bupdate
	 *            the bupdate to set
	 */
	public void setBupdate(String bupdate) {
		this.bupdate = bupdate;
	}

	/**
	 * @return the cleadempcd
	 */
	public String getCleadempcd() {
		return cleadempcd;
	}

	/**
	 * @param cleadempcd
	 *            the cleadempcd to set
	 */
	public void setCleadempcd(String cleadempcd) {
		this.cleadempcd = cleadempcd;
	}

	/**
	 * @return the cwgtFlg
	 */
	public String getCwgtFlg() {
		return cwgtFlg;
	}

	/**
	 * @param cwgtFlg
	 *            the cwgtFlg to set
	 */
	public void setCwgtFlg(String cwgtFlg) {
		this.cwgtFlg = cwgtFlg;
	}

	/**
	 * @return the ccustCat
	 */
	public String getCcustCat() {
		return ccustCat;
	}

	/**
	 * @param ccustCat
	 *            the ccustCat to set
	 */
	public void setCcustCat(String ccustCat) {
		this.ccustCat = ccustCat;
	}

	/**
	 * @return the cagntCode
	 */
	public String getCagntCode() {
		return cagntCode;
	}

	/**
	 * @param cagntCode
	 *            the cagntCode to set
	 */
	public void setCagntCode(String cagntCode) {
		this.cagntCode = cagntCode;
	}

	/**
	 * @return the bsmartdn
	 */
	public String getBsmartdn() {
		return bsmartdn;
	}

	/**
	 * @param bsmartdn
	 *            the bsmartdn to set
	 */
	public void setBsmartdn(String bsmartdn) {
		this.bsmartdn = bsmartdn;
	}

	/**
	 * @return the bwaredn
	 */
	public String getBwaredn() {
		return bwaredn;
	}

	/**
	 * @param bwaredn
	 *            the bwaredn to set
	 */
	public void setBwaredn(String bwaredn) {
		this.bwaredn = bwaredn;
	}

	/**
	 * @return the cpFlaf
	 */
	public String getCpFlaf() {
		return cpFlaf;
	}

	/**
	 * @param cpFlaf
	 *            the cpFlaf to set
	 */
	public void setCpFlaf(String cpFlaf) {
		this.cpFlaf = cpFlaf;
	}

	/**
	 * @return the ninsper
	 */
	public String getNinsper() {
		return ninsper;
	}

	/**
	 * @param ninsper
	 *            the ninsper to set
	 */
	public void setNinsper(String ninsper) {
		this.ninsper = ninsper;
	}

	/**
	 * @return the cbilLoc
	 */
	public String getCbilLoc() {
		return cbilLoc;
	}

	/**
	 * @param cbilLoc
	 *            the cbilLoc to set
	 */
	public void setCbilLoc(String cbilLoc) {
		this.cbilLoc = cbilLoc;
	}

	/**
	 * @return the ncftVal
	 */
	public Integer getNcftVal() {
		return ncftVal;
	}

	/**
	 * @param ncftVal
	 *            the ncftVal to set
	 */
	public void setNcftVal(Integer ncftVal) {
		this.ncftVal = ncftVal;
	}

	/**
	 * @return the cGroup
	 */
	public String getcGroup() {
		return cGroup;
	}

	/**
	 * @param cGroup
	 *            the cGroup to set
	 */
	public void setcGroup(String cGroup) {
		this.cGroup = cGroup;
	}

	/**
	 * @return the ndpAmt
	 */
	public Integer getNdpAmt() {
		return ndpAmt;
	}

	/**
	 * @param ndpAmt
	 *            the ndpAmt to set
	 */
	public void setNdpAmt(Integer ndpAmt) {
		this.ndpAmt = ndpAmt;
	}

	/**
	 * @return the cdpFlag
	 */
	public String getCdpFlag() {
		return cdpFlag;
	}

	/**
	 * @param cdpFlag
	 *            the cdpFlag to set
	 */
	public void setCdpFlag(String cdpFlag) {
		this.cdpFlag = cdpFlag;
	}

	/**
	 * @return the cidCust
	 */
	public String getCidCust() {
		return cidCust;
	}

	/**
	 * @param cidCust
	 *            the cidCust to set
	 */
	public void setCidCust(String cidCust) {
		this.cidCust = cidCust;
	}

	/**
	 * @return the napexfs
	 */
	public Integer getNapexfs() {
		return napexfs;
	}

	/**
	 * @param napexfs
	 *            the napexfs to set
	 */
	public void setNapexfs(Integer napexfs) {
		this.napexfs = napexfs;
	}

	/**
	 * @return the nsfcfs
	 */
	public Integer getNsfcfs() {
		return nsfcfs;
	}

	/**
	 * @param nsfcfs
	 *            the nsfcfs to set
	 */
	public void setNsfcfs(Integer nsfcfs) {
		this.nsfcfs = nsfcfs;
	}

	/**
	 * @return the dexpDate
	 */
	public Date getDexpDate() {
		return dexpDate;
	}

	/**
	 * @param dexpDate
	 *            the dexpDate to set
	 */
	public void setDexpDate(Date dexpDate) {
		this.dexpDate = dexpDate;
	}

	/**
	 * @return the cnetFlag
	 */
	public String getCnetFlag() {
		return cnetFlag;
	}

	/**
	 * @param cnetFlag
	 *            the cnetFlag to set
	 */
	public void setCnetFlag(String cnetFlag) {
		this.cnetFlag = cnetFlag;
	}

	/**
	 * @return the sempeffdt
	 */
	public Date getSempeffdt() {
		return sempeffdt;
	}

	/**
	 * @param sempeffdt
	 *            the sempeffdt to set
	 */
	public void setSempeffdt(Date sempeffdt) {
		this.sempeffdt = sempeffdt;
	}

	/**
	 * @return the crtowtrest
	 */
	public String getCrtowtrest() {
		return crtowtrest;
	}

	/**
	 * @param crtowtrest
	 *            the crtowtrest to set
	 */
	public void setCrtowtrest(String crtowtrest) {
		this.crtowtrest = crtowtrest;
	}

	/**
	 * @return the ncreditDays
	 */
	public Integer getNcreditDays() {
		return ncreditDays;
	}

	/**
	 * @param ncreditDays
	 *            the ncreditDays to set
	 */
	public void setNcreditDays(Integer ncreditDays) {
		this.ncreditDays = ncreditDays;
	}

	/**
	 * @return the nreminderDays
	 */
	public Integer getNreminderDays() {
		return nreminderDays;
	}

	/**
	 * @param nreminderDays
	 *            the nreminderDays to set
	 */
	public void setNreminderDays(Integer nreminderDays) {
		this.nreminderDays = nreminderDays;
	}

	/**
	 * @return the bApproved
	 */
	public String getbApproved() {
		return bApproved;
	}

	/**
	 * @param bApproved
	 *            the bApproved to set
	 */
	public void setbApproved(String bApproved) {
		this.bApproved = bApproved;
	}

	/**
	 * @return the dlastApproved
	 */
	public Date getDlastApproved() {
		return dlastApproved;
	}

	/**
	 * @param dlastApproved
	 *            the dlastApproved to set
	 */
	public void setDlastApproved(Date dlastApproved) {
		this.dlastApproved = dlastApproved;
	}

	/**
	 * @return the capprovedId
	 */
	public String getCapprovedId() {
		return capprovedId;
	}

	/**
	 * @param capprovedId
	 *            the capprovedId to set
	 */
	public void setCapprovedId(String capprovedId) {
		this.capprovedId = capprovedId;
	}

	/**
	 * @return the ccolEmpCd
	 */
	public String getCcolEmpCd() {
		return ccolEmpCd;
	}

	/**
	 * @param ccolEmpCd
	 *            the ccolEmpCd to set
	 */
	public void setCcolEmpCd(String ccolEmpCd) {
		this.ccolEmpCd = ccolEmpCd;
	}

	/**
	 * @return the dentrydt
	 */
	public Date getDentrydt() {
		return dentrydt;
	}

	/**
	 * @param dentrydt
	 *            the dentrydt to set
	 */
	public void setDentrydt(Date dentrydt) {
		this.dentrydt = dentrydt;
	}

	/**
	 * @return the cepoFlag
	 */
	public String getCepoFlag() {
		return cepoFlag;
	}

	/**
	 * @param cepoFlag
	 *            the cepoFlag to set
	 */
	public void setCepoFlag(String cepoFlag) {
		this.cepoFlag = cepoFlag;
	}

	/**
	 * @return the ddhlDate
	 */
	public Date getDdhlDate() {
		return ddhlDate;
	}

	/**
	 * @param ddhlDate
	 *            the ddhlDate to set
	 */
	public void setDdhlDate(Date ddhlDate) {
		this.ddhlDate = ddhlDate;
	}

	/**
	 * @return the ccompGrp
	 */
	public String getCcompGrp() {
		return ccompGrp;
	}

	/**
	 * @param ccompGrp
	 *            the ccompGrp to set
	 */
	public void setCcompGrp(String ccompGrp) {
		this.ccompGrp = ccompGrp;
	}

	/**
	 * @return the ccentBill
	 */
	public String getCcentBill() {
		return ccentBill;
	}

	/**
	 * @param ccentBill
	 *            the ccentBill to set
	 */
	public void setCcentBill(String ccentBill) {
		this.ccentBill = ccentBill;
	}

	/**
	 * @return the ccentProd
	 */
	public String getCcentProd() {
		return ccentProd;
	}

	/**
	 * @param ccentProd
	 *            the ccentProd to set
	 */
	public void setCcentProd(String ccentProd) {
		this.ccentProd = ccentProd;
	}

	/**
	 * @return the cdstnCode
	 */
	public String getCdstnCode() {
		return cdstnCode;
	}

	/**
	 * @param cdstnCode
	 *            the cdstnCode to set
	 */
	public void setCdstnCode(String cdstnCode) {
		this.cdstnCode = cdstnCode;
	}

	/**
	 * @return the ccollCode
	 */
	public String getCcollCode() {
		return ccollCode;
	}

	/**
	 * @param ccollCode
	 *            the ccollCode to set
	 */
	public void setCcollCode(String ccollCode) {
		this.ccollCode = ccollCode;
	}

	/**
	 * @return the nvchckp
	 */
	public Integer getNvchckp() {
		return nvchckp;
	}

	/**
	 * @param nvchckp
	 *            the nvchckp to set
	 */
	public void setNvchckp(Integer nvchckp) {
		this.nvchckp = nvchckp;
	}

	/**
	 * @return the nvckamt
	 */
	public Integer getNvckamt() {
		return nvckamt;
	}

	/**
	 * @param nvckamt
	 *            the nvckamt to set
	 */
	public void setNvckamt(Integer nvckamt) {
		this.nvckamt = nvckamt;
	}

	/**
	 * @return the dofDate
	 */
	public Date getDofDate() {
		return dofDate;
	}

	/**
	 * @param dofDate
	 *            the dofDate to set
	 */
	public void setDofDate(Date dofDate) {
		this.dofDate = dofDate;
	}

	/**
	 * @return the cvoletexmp
	 */
	public String getCvoletexmp() {
		return cvoletexmp;
	}

	/**
	 * @param cvoletexmp
	 *            the cvoletexmp to set
	 */
	public void setCvoletexmp(String cvoletexmp) {
		this.cvoletexmp = cvoletexmp;
	}

	/**
	 * @return the choflag
	 */
	public String getChoflag() {
		return choflag;
	}

	/**
	 * @param choflag
	 *            the choflag to set
	 */
	public void setChoflag(String choflag) {
		this.choflag = choflag;
	}

	/**
	 * @return the ccollBran
	 */
	public String getCcollBran() {
		return ccollBran;
	}

	/**
	 * @param ccollBran
	 *            the ccollBran to set
	 */
	public void setCcollBran(String ccollBran) {
		this.ccollBran = ccollBran;
	}

	/**
	 * @return the cdhlCode
	 */
	public String getCdhlCode() {
		return cdhlCode;
	}

	/**
	 * @param cdhlCode
	 *            the cdhlCode to set
	 */
	public void setCdhlCode(String cdhlCode) {
		this.cdhlCode = cdhlCode;
	}

	/**
	 * @return the corgsign
	 */
	public String getCorgsign() {
		return corgsign;
	}

	/**
	 * @param corgsign
	 *            the corgsign to set
	 */
	public void setCorgsign(String corgsign) {
		this.corgsign = corgsign;
	}

	/**
	 * @return the ndcDays
	 */
	public Integer getNdcDays() {
		return ndcDays;
	}

	/**
	 * @param ndcDays
	 *            the ndcDays to set
	 */
	public void setNdcDays(Integer ndcDays) {
		this.ndcDays = ndcDays;
	}

	/**
	 * @return the ncustTat
	 */
	public Integer getNcustTat() {
		return ncustTat;
	}

	/**
	 * @param ncustTat
	 *            the ncustTat to set
	 */
	public void setNcustTat(Integer ncustTat) {
		this.ncustTat = ncustTat;
	}

	/**
	 * @return the cpdcrstLoc
	 */
	public String getCpdcrstLoc() {
		return cpdcrstLoc;
	}

	/**
	 * @param cpdcrstLoc
	 *            the cpdcrstLoc to set
	 */
	public void setCpdcrstLoc(String cpdcrstLoc) {
		this.cpdcrstLoc = cpdcrstLoc;
	}

	/**
	 * @return the cpdctrkLoc
	 */
	public String getCpdctrkLoc() {
		return cpdctrkLoc;
	}

	/**
	 * @param cpdctrkLoc
	 *            the cpdctrkLoc to set
	 */
	public void setCpdctrkLoc(String cpdctrkLoc) {
		this.cpdctrkLoc = cpdctrkLoc;
	}

	/**
	 * @return the nnslGrace
	 */
	public Integer getNnslGrace() {
		return nnslGrace;
	}

	/**
	 * @param nnslGrace
	 *            the nnslGrace to set
	 */
	public void setNnslGrace(Integer nnslGrace) {
		this.nnslGrace = nnslGrace;
	}

	/**
	 * @return the cdhlobCode
	 */
	public String getCdhlobCode() {
		return cdhlobCode;
	}

	/**
	 * @param cdhlobCode
	 *            the cdhlobCode to set
	 */
	public void setCdhlobCode(String cdhlobCode) {
		this.cdhlobCode = cdhlobCode;
	}

	
	public String getCpandcard() {
		return cpandcard;
	}

	public void setCpandcard(String cpandcard) {
		this.cpandcard = cpandcard;
	}

	public String getcFinAcNo() {
		return cFinAcNo;
	}

	public void setcFinAcNo(String cFinAcNo) {
		this.cFinAcNo = cFinAcNo;
	}

	public String getCpanVerified() {
		return cpanVerified;
	}

	public void setCpanVerified(String cpanVerified) {
		this.cpanVerified = cpanVerified;
	}

	public String getCcompGrpvari() {
		return ccompGrpvari;
	}

	public void setCcompGrpvari(String ccompGrpvari) {
		this.ccompGrpvari = ccompGrpvari;
	}

	public Date getDmodifyDate() {
		return dmodifyDate;
	}

	public void setDmodifyDate(Date dmodifyDate) {
		this.dmodifyDate = dmodifyDate;
	}

	public String getCbillCustName() {
		return cbillCustName;
	}

	public void setCbillCustName(String cbillCustName) {
		this.cbillCustName = cbillCustName;
	}

	public String getCcsEmpcd() {
		return ccsEmpcd;
	}

	public void setCcsEmpcd(String ccsEmpcd) {
		this.ccsEmpcd = ccsEmpcd;
	}

	public String getCgstn_uidcode() {
		return cgstn_uidcode;
	}

	public void setCgstn_uidcode(String cgstn_uidcode) {
		this.cgstn_uidcode = cgstn_uidcode;
	}

	public String getCgstnStateCode() {
		return cgstnStateCode;
	}

	public void setCgstnStateCode(String cgstnStateCode) {
		this.cgstnStateCode = cgstnStateCode;
	}

	@Override
	public String toString() {
		return "CustomerMst [customerArea=" + customerArea + ", customerCode="
				+ customerCode + ", cscrcd=" + cscrcd + ", customerName="
				+ customerName + ", customerContact=" + customerContact
				+ ", customerAddr1=" + customerAddr1 + ", customerAddr2="
				+ customerAddr2 + ", customerAddr3=" + customerAddr3
				+ ", customerPincode=" + customerPincode + ", customerPhone="
				+ customerPhone + ", customerTlx=" + customerTlx
				+ ", customerFax=" + customerFax + ", bdlvnoprt=" + bdlvnoprt
				+ ", cgCode=" + cgCode + ", csgCode=" + csgCode
				+ ", cdeptCode=" + cdeptCode + ", cdeptName=" + cdeptName
				+ ", centityCd=" + centityCd + ", csalempcd=" + csalempcd
				+ ", cmktsgtcd=" + cmktsgtcd + ", cdesMaker=" + cdesMaker
				+ ", cdesig=" + cdesig + ", dbirthDt=" + dbirthDt
				+ ", careaGpcd=" + careaGpcd + ", cedpgpcd=" + cedpgpcd
				+ ", callGpcd=" + callGpcd + ", ccshcrd=" + ccshcrd
				+ ", boffcr=" + boffcr + ", bpod=" + bpod + ", bspslab="
				+ bspslab + ", defDate=" + defDate + ", cdscbhse=" + cdscbhse
				+ ", brockbott=" + brockbott + ", nbillFreq=" + nbillFreq
				+ ", dbillDate=" + dbillDate + ", bconsolid=" + bconsolid
				+ ", ccustType=" + ccustType + ", dentdate=" + dentdate
				+ ", drevDate=" + drevDate + ", dsigndate=" + dsigndate
				+ ", baddon=" + baddon + ", bupdate=" + bupdate
				+ ", cleadempcd=" + cleadempcd + ", cwgtFlg=" + cwgtFlg
				+ ", ccustCat=" + ccustCat + ", cagntCode=" + cagntCode
				+ ", bsmartdn=" + bsmartdn + ", bwaredn=" + bwaredn
				+ ", cpFlaf=" + cpFlaf + ", ninsper=" + ninsper + ", cbilLoc="
				+ cbilLoc + ", ncftVal=" + ncftVal + ", cGroup=" + cGroup
				+ ", ndpAmt=" + ndpAmt + ", cdpFlag=" + cdpFlag + ", cidCust="
				+ cidCust + ", napexfs=" + napexfs + ", nsfcfs=" + nsfcfs
				+ ", dexpDate=" + dexpDate + ", cnetFlag=" + cnetFlag
				+ ", sempeffdt=" + sempeffdt + ", crtowtrest=" + crtowtrest
				+ ", ncreditDays=" + ncreditDays + ", nreminderDays="
				+ nreminderDays + ", bApproved=" + bApproved
				+ ", dlastApproved=" + dlastApproved + ", capprovedId="
				+ capprovedId + ", ccolEmpCd=" + ccolEmpCd + ", dentrydt="
				+ dentrydt + ", cepoFlag=" + cepoFlag + ", ddhlDate="
				+ ddhlDate + ", ccompGrp=" + ccompGrp + ", ccentBill="
				+ ccentBill + ", ccentProd=" + ccentProd + ", cdstnCode="
				+ cdstnCode + ", ccollCode=" + ccollCode + ", nvchckp="
				+ nvchckp + ", nvckamt=" + nvckamt + ", dofDate=" + dofDate
				+ ", cvoletexmp=" + cvoletexmp + ", choflag=" + choflag
				+ ", ccollBran=" + ccollBran + ", cdhlCode=" + cdhlCode
				+ ", corgsign=" + corgsign + ", ndcDays=" + ndcDays
				+ ", ncustTat=" + ncustTat + ", cpdcrstLoc=" + cpdcrstLoc
				+ ", cpdctrkLoc=" + cpdctrkLoc + ", nnslGrace=" + nnslGrace
				+ ", cdhlobCode=" + cdhlobCode + ", cpandcard=" + cpandcard
				+ ", cFinAcNo=" + cFinAcNo + ", cpanVerified=" + cpanVerified
				+ ", ccompGrpvari=" + ccompGrpvari + ", dmodifyDate="
				+ dmodifyDate + ", cbillCustName=" + cbillCustName
				+ ", ccsEmpcd=" + ccsEmpcd + ", cgstn_uidcode=" + cgstn_uidcode
				+ ", cgstnStateCode=" + cgstnStateCode + "]";
	}


}
