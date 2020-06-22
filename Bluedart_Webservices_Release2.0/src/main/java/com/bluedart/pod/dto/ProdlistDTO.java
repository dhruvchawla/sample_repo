package com.bluedart.pod.dto;
import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ProdlistDTO implements SQLData, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql_type;
	private String prodcode;
	private String proddesc;
	
	
	
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	public String getProdcode() {
		return prodcode;
	}
	public void setProdcode(String prodcode) {
		this.prodcode = prodcode;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return sql_type;
	}
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		// TODO Auto-generated method stub
		setSql_type(getSql_type());
		setProdcode(paramSQLInput.readNString());
		setProddesc(paramSQLInput.readNString());
		
	}
	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
