package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ManageParcelShopPODUsersDbObjectDto implements SQLData,Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313341186062180948L;
	private String sql_type;
	
	private String cpscode;
	private String cscrcd;
	private String cregion;
	private String carea;
	private String cloginid;
	private String cusertype;
	private String cname;
	private String cenableflag;
	
	public String getCpscode() {
		return cpscode;
	}

	public void setCpscode(String cpscode) {
		this.cpscode = cpscode;
	}

	public String getCscrcd() {
		return cscrcd;
	}

	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}

	public String getCregion() {
		return cregion;
	}

	public void setCregion(String cregion) {
		this.cregion = cregion;
	}

	public String getCarea() {
		return carea;
	}

	public void setCarea(String carea) {
		this.carea = carea;
	}

	public String getCloginid() {
		return cloginid;
	}

	public void setCloginid(String cloginid) {
		this.cloginid = cloginid;
	}

	public String getCusertype() {
		return cusertype;
	}

	public void setCusertype(String cusertype) {
		this.cusertype = cusertype;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCenableflag() {
		return cenableflag;
	}

	public void setCenableflag(String cenableflag) {
		this.cenableflag = cenableflag;
	}
	public String getSql_type() {
		return sql_type;
	}

	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
		
	}
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(typeName);
		setCpscode(paramSQLInput.readNString());
		setCscrcd(paramSQLInput.readNString());
		setCregion(paramSQLInput.readNString());
		setCarea(paramSQLInput.readNString());
		setCloginid(paramSQLInput.readNString());
		setCusertype(paramSQLInput.readNString());
		setCname(paramSQLInput.readNString());
		setCenableflag(paramSQLInput.readNString());
		
	}

	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(cpscode);
		paramSQLOutput.writeString(cscrcd);
		paramSQLOutput.writeString(cregion);
		paramSQLOutput.writeString(carea);
		paramSQLOutput.writeString(cloginid);
		paramSQLOutput.writeString(cusertype);
		paramSQLOutput.writeString(cname);
		paramSQLOutput.writeString(cenableflag);
	}

	@Override
	public String toString() {
		return "ManageParcelShopPODUsersDbObjectDto [sql_type=" + sql_type + ", cpscode=" + cpscode + ", cscrcd="
				+ cscrcd + ", cregion=" + cregion + ", carea=" + carea + ", cloginid=" + cloginid + ", cusertype="
				+ cusertype + ", cname=" + cname + ", cenableflag=" + cenableflag + "]";
	}
	
	
}
