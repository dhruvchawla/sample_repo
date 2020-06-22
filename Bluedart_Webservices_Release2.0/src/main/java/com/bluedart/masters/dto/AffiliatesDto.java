package com.bluedart.masters.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.List;

public class AffiliatesDto implements SQLData, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String sql_type;
	private String loginid;
	private String cc;
	private String ac;
	private String bpFlag;
	private String custname;
	private BigDecimal valid;
	private String message;
	private String errorCode;
	
	private List<AffiliatesDto> affiliatesDtoList;
	 
	/**
	 * @return the sql_type
	 */
	public String getSql_type() {
		return sql_type;
	}
	/**
	 * @param sql_type the sql_type to set
	 */
	public void setSql_type(String sql_type) {
		this.sql_type = "UPROFILE4.AFFOBJ";
	}
	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}
	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}
	/**
	 * @return the ac
	 */
	public String getAc() {
		return ac;
	}
	/**
	 * @param ac the ac to set
	 */
	public void setAc(String ac) {
		this.ac = ac;
	}
	/**
	 * @return the bpFlag
	 */
	public String getBpFlag() {
		return bpFlag;
	}
	/**
	 * @param bpFlag the bpFlag to set
	 */
	public void setBpFlag(String bpFlag) {
		this.bpFlag = bpFlag;
	}
	
	 
	/**
	 * @return the custname
	 */
	public String getCustname() {
		return custname;
	}
	/**
	 * @param custname the custname to set
	 */
	public void setCustname(String custname) {
		this.custname = custname;
	}
	/**
	 * @return the valid
	 */
	public BigDecimal getValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(BigDecimal valid) {
		this.valid = valid;
	}
	
	
	/**
	 * @return the affiliatesDtoList
	 */
	public List<AffiliatesDto> getAffiliatesDtoList() {
		return affiliatesDtoList;
	}
	/**
	 * @param affiliatesDtoList the affiliatesDtoList to set
	 */
	public void setAffiliatesDtoList(List<AffiliatesDto> affiliatesDtoList) {
		this.affiliatesDtoList = affiliatesDtoList;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(typeName);
		setLoginid(paramSQLInput.readNString());
		setCc(paramSQLInput.readNString());
		setAc(paramSQLInput.readNString());
		setBpFlag(paramSQLInput.readNString());
		setCustname(paramSQLInput.readNString());
		setValid(paramSQLInput.readBigDecimal());
		
	}
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(getLoginid());
	    paramSQLOutput.writeString(getCc());
	    paramSQLOutput.writeString(getAc());
	    paramSQLOutput.writeString(getBpFlag());
	    paramSQLOutput.writeString(getCustname());
	    paramSQLOutput.writeBigDecimal(getValid());
		
	}
	
	
	
	
	
}
