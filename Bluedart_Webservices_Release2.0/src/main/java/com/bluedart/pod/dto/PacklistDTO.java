package com.bluedart.pod.dto;
import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PacklistDTO implements SQLData, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql_type;
	private String cprodcode;
	private String cpacktype;
	private String cpackdesc;
	private String csubprodcd;
    private String csubprdnm;
	 
    
	
	public String getCsubprdnm() {
		return csubprdnm;
	}
	public void setCsubprdnm(String csubprdnm) {
		this.csubprdnm = csubprdnm;
	}
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
	public String getCsubprodcd() {
		return csubprodcd;
	}
	public void setCsubprodcd(String csubprodcd) {
		this.csubprodcd = csubprodcd;
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
	setCprodcode(paramSQLInput.readNString());
	setCpacktype(paramSQLInput.readNString());
	setCpackdesc(paramSQLInput.readNString());
	setCsubprodcd(paramSQLInput.readNString());
	setCsubprdnm(paramSQLInput.readNString());
	}
	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}

