package com.bluedart.pod.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PodObjDto implements SQLData, Serializable {

	private static final long serialVersionUID = 1L;

	private String sql_type;
	private String pcawbno;
	private String pcprodcode;
	private String pcorgscrcd;
	private String pcdstscrcd;
	private String pcstatcode;
	private String pcstattype;
	private String pdstatdate;
	private String pcstattime;
	private String pcqrygrp;
	private String pcstatgrp;
	private String pcstatdesc;
	private String pcstatdesc1;
	private String pcstatdesc2;
	private String pcloccode;
	private String pclocdesc;
	private String pcrecdby;
	private String pcrelation;
	private String pclocpincode;
	private String pclocstatecode;
	private String pcloccntrycode;

	public String getSql_type() {
		return sql_type;
	}

	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}

	public String getPcawbno() {
		return pcawbno;
	}

	public void setPcawbno(String pcawbno) {
		this.pcawbno = pcawbno;
	}

	public String getPcprodcode() {
		return pcprodcode;
	}

	public void setPcprodcode(String pcprodcode) {
		this.pcprodcode = pcprodcode;
	}

	public String getPcorgscrcd() {
		return pcorgscrcd;
	}

	public void setPcorgscrcd(String pcorgscrcd) {
		this.pcorgscrcd = pcorgscrcd;
	}

	public String getPcdstscrcd() {
		return pcdstscrcd;
	}

	public void setPcdstscrcd(String pcdstscrcd) {
		this.pcdstscrcd = pcdstscrcd;
	}

	public String getPcstatcode() {
		return pcstatcode;
	}

	public void setPcstatcode(String pcstatcode) {
		this.pcstatcode = pcstatcode;
	}

	public String getPcstattype() {
		return pcstattype;
	}

	public void setPcstattype(String pcstattype) {
		this.pcstattype = pcstattype;
	}

	public String getPdstatdate() {
		return pdstatdate;
	}

	public void setPdstatdate(String pdstatdate) {
		this.pdstatdate = pdstatdate;
	}

	public String getPcstattime() {
		return pcstattime;
	}

	public void setPcstattime(String pcstattime) {
		this.pcstattime = pcstattime;
	}

	public String getPcqrygrp() {
		return pcqrygrp;
	}

	public void setPcqrygrp(String pcqrygrp) {
		this.pcqrygrp = pcqrygrp;
	}

	public String getPcstatgrp() {
		return pcstatgrp;
	}

	public void setPcstatgrp(String pcstatgrp) {
		this.pcstatgrp = pcstatgrp;
	}

	public String getPcstatdesc() {
		return pcstatdesc;
	}

	public void setPcstatdesc(String pcstatdesc) {
		this.pcstatdesc = pcstatdesc;
	}

	public String getPcstatdesc1() {
		return pcstatdesc1;
	}

	public void setPcstatdesc1(String pcstatdesc1) {
		this.pcstatdesc1 = pcstatdesc1;
	}

	public String getPcstatdesc2() {
		return pcstatdesc2;
	}

	public void setPcstatdesc2(String pcstatdesc2) {
		this.pcstatdesc2 = pcstatdesc2;
	}

	public String getPcloccode() {
		return pcloccode;
	}

	public void setPcloccode(String pcloccode) {
		this.pcloccode = pcloccode;
	}

	public String getPclocdesc() {
		return pclocdesc;
	}

	public void setPclocdesc(String pclocdesc) {
		this.pclocdesc = pclocdesc;
	}

	public String getPcrecdby() {
		return pcrecdby;
	}

	public void setPcrecdby(String pcrecdby) {
		this.pcrecdby = pcrecdby;
	}

	public String getPcrelation() {
		return pcrelation;
	}

	public void setPcrelation(String pcrelation) {
		this.pcrelation = pcrelation;
	}

	public String getPclocpincode() {
		return pclocpincode;
	}

	public void setPclocpincode(String pclocpincode) {
		this.pclocpincode = pclocpincode;
	}

	public String getPclocstatecode() {
		return pclocstatecode;
	}

	public void setPclocstatecode(String pclocstatecode) {
		this.pclocstatecode = pclocstatecode;
	}

	public String getPcloccntrycode() {
		return pcloccntrycode;
	}

	public void setPcloccntrycode(String pcloccntrycode) {
		this.pcloccntrycode = pcloccntrycode;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}

	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(typeName);
		setPcawbno(paramSQLInput.readNString());
		setPcprodcode(paramSQLInput.readNString());
		setPcorgscrcd(paramSQLInput.readNString());
		setPcdstscrcd(paramSQLInput.readNString());
		setPcstatcode(paramSQLInput.readNString());
		setPcstattype(paramSQLInput.readNString());
		setPdstatdate(paramSQLInput.readNString());
		setPcstattime(paramSQLInput.readNString());
		setPcqrygrp(paramSQLInput.readNString());
		setPcstatgrp(paramSQLInput.readNString());
		setPcstatdesc(paramSQLInput.readNString());
		setPcstatdesc1(paramSQLInput.readNString());
		setPcstatdesc2(paramSQLInput.readNString());
		setPcloccode(paramSQLInput.readNString());
		setPclocdesc(paramSQLInput.readNString());
		setPcrecdby(paramSQLInput.readNString());
		setPclocpincode(paramSQLInput.readNString());
		setPclocstatecode(paramSQLInput.readNString());
		setPcrelation(paramSQLInput.readNString());
		setPcloccntrycode(paramSQLInput.readNString());
	}

	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
	}

}
