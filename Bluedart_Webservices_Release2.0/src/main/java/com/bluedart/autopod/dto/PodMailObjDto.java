package com.bluedart.autopod.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PodMailObjDto  implements SQLData, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1454978973126117386L;
	private String sql_type;
	private String LOGINID;
	private String EMAILID;
	private String FREQUENCY;
	private String REPORTTYPE;
	private String SORTORDER;
	private String CSTATUS;
	private String CREATEDBY;
	/**
	 * @return the sql_type
	 */
	public String getSql_type() {
		return sql_type;
	}
	/**
	 * @return the lOGINID
	 */
	public String getLOGINID() {
		return LOGINID;
	}
	/**
	 * @return the eMAILID
	 */
	public String getEMAILID() {
		return EMAILID;
	}
	/**
	 * @return the fREQUENCY
	 */
	public String getFREQUENCY() {
		return FREQUENCY;
	}
	/**
	 * @return the rEPORTTYPE
	 */
	public String getREPORTTYPE() {
		return REPORTTYPE;
	}
	/**
	 * @return the sORTORDER
	 */
	public String getSORTORDER() {
		return SORTORDER;
	}
	/**
	 * @return the cSTATUS
	 */
	public String getCSTATUS() {
		return CSTATUS;
	}
	/**
	 * @param sql_type the sql_type to set
	 */
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	/**
	 * @param lOGINID the lOGINID to set
	 */
	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}
	/**
	 * @param eMAILID the eMAILID to set
	 */
	public void setEMAILID(String eMAILID) {
		EMAILID = eMAILID;
	}
	/**
	 * @param fREQUENCY the fREQUENCY to set
	 */
	public void setFREQUENCY(String fREQUENCY) {
		FREQUENCY = fREQUENCY;
	}
	/**
	 * @param rEPORTTYPE the rEPORTTYPE to set
	 */
	public void setREPORTTYPE(String rEPORTTYPE) {
		REPORTTYPE = rEPORTTYPE;
	}
	/**
	 * @param sORTORDER the sORTORDER to set
	 */
	public void setSORTORDER(String sORTORDER) {
		SORTORDER = sORTORDER;
	}
	/**
	 * @param cSTATUS the cSTATUS to set
	 */
	public void setCSTATUS(String cSTATUS) {
		CSTATUS = cSTATUS;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(getSql_type());
		setLOGINID(paramSQLInput.readNString());
		setEMAILID(paramSQLInput.readNString());
		setFREQUENCY(paramSQLInput.readNString());
		setREPORTTYPE(paramSQLInput.readNString());
		setSORTORDER(paramSQLInput.readNString());
		setCSTATUS(paramSQLInput.readNString());
		//setCREATEDBY(paramSQLInput.readNString());
		
	}
	@Override
	public void writeSQL(SQLOutput arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return the cREATEDBY
	 */
	public String getCREATEDBY() {
		return CREATEDBY;
	}
	/**
	 * @param cREATEDBY the cREATEDBY to set
	 */
	public void setCREATEDBY(String cREATEDBY) {
		CREATEDBY = cREATEDBY;
	}
	
	 
	



	





	
	

	
	

}
