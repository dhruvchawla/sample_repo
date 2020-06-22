package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ValueAddedServiceDto implements SQLData, Serializable {

	private static final long serialVersionUID = 7046031377004517344L;
	
	private String sql_type;
	private String cprodcode;
	private String cpacktype;
	private String cpackdesc;
	private String CSUBPRDCD;
	private String CSUBPRDNM;
	
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	public String getCprodcode() {
		return cprodcode;
	}
	public void setCprodcode(String cprodcode) {
		this.cprodcode = cprodcode;
	}
	public String getCpacktype() {
		return cpacktype;
	}
	public void setCpacktype(String cpacktype) {
		this.cpacktype = cpacktype;
	}
	public String getCpackdesc() {
		return cpackdesc;
	}
	public void setCpackdesc(String cpackdesc) {
		this.cpackdesc = cpackdesc;
	}
	public String getCSUBPRDCD() {
		return CSUBPRDCD;
	}
	public void setCSUBPRDCD(String cSUBPRDCD) {
		CSUBPRDCD = cSUBPRDCD;
	}
	
	public String getCSUBPRDNM() {
		return CSUBPRDNM;
	}
	public void setCSUBPRDNM(String cSUBPRDNM) {
		CSUBPRDNM = cSUBPRDNM;
	}
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {

		setSql_type(getSql_type());
		setCprodcode(paramSQLInput.readNString());
		setCpacktype(paramSQLInput.readNString());
		setCpackdesc(paramSQLInput.readNString());
		setCSUBPRDCD(paramSQLInput.readNString());
		setCSUBPRDNM(paramSQLInput.readNString());
	}
	
	
	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// Empty
	}
	
	
	

}
