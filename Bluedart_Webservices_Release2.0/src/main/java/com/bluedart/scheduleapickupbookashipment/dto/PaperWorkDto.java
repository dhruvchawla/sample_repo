package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PaperWorkDto implements SQLData, Serializable {

	private static final long serialVersionUID = 1925343303343921234L;
	
	private String sql_type;
	private String cscrcd;
	private String cstatecd;
	private String CREGLDESC;
	
	
	public String getSql_type() {
		return sql_type;
	}

	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}

	public String getCscrcd() {
		return cscrcd;
	}

	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}

	public String getCstatecd() {
		return cstatecd;
	}

	public void setCstatecd(String cstatecd) {
		this.cstatecd = cstatecd;
	}

	public String getCREGLDESC() {
		return CREGLDESC;
	}

	public void setCREGLDESC(String cREGLDESC) {
		CREGLDESC = cREGLDESC;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}

	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(getSql_type());
		setCscrcd(paramSQLInput.readNString());
		setCstatecd(paramSQLInput.readNString());
		setCREGLDESC(paramSQLInput.readNString());
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// Empty
	}

}
