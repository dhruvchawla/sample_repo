package com.bluedart.addressbook.dto;

import java.math.BigDecimal;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.List;

/**
 * 
 * @author TH334025
 *
 */
public class AffiliatesDto implements SQLData{
	
	private String sql_type;
	private String loginid;
	private String cc;
	private String ac;
	private String bpFlag;
	private String custname;
	private BigDecimal valid;
	private String message;
	 
	private List<AffiliatesDto> affiliatesDtoList;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
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
	

	public List<AffiliatesDto> getAffiliatesDtoList() {
		return affiliatesDtoList;
	}
	public void setAffiliatesDtoList(List<AffiliatesDto> affiliatesDtoList) {
		this.affiliatesDtoList = affiliatesDtoList;
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
	/**
	 * @return the errorOccured
	 */
	public boolean isErrorOccured() {
		return errorOccured;
	}
	/**
	 * @param errorOccured the errorOccured to set
	 */
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
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
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	
}