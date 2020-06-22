package com.bluedart.manageuserCA.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * 
 * @author TH334025
 *
 */
public class AffiliatesDto implements SQLData, Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sql_type;
	private String loginid;
	private String cc;
	private String ac;
	private String bpFlag;
	private String custname;
	private BigDecimal valid;
	private String created_by;
	private String baseAffiliateFlag;
	
	public String getBaseAffiliateFlag() {
		return baseAffiliateFlag;
	}
	public void setBaseAffiliateFlag(String baseAffiliateFlag) {
		this.baseAffiliateFlag = baseAffiliateFlag;
	}
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
		this.sql_type = "UPROFILE4.AFFOBJ_BD_ADMIN";
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
	
	
	public BigDecimal getValid() {
		return valid;
	}
	public void setValid(BigDecimal valid) {
		this.valid = valid;
	}
	
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
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
		setCreated_by(paramSQLInput.readNString());
		setBaseAffiliateFlag(paramSQLInput.readNString());
	}
	
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(getLoginid());
	    paramSQLOutput.writeString(getCc());
	    paramSQLOutput.writeString(getAc());
	    paramSQLOutput.writeString(getBpFlag());
	    paramSQLOutput.writeString(getCustname());
	    paramSQLOutput.writeBigDecimal(getValid());
	    paramSQLOutput.writeString(getCreated_by());
	    paramSQLOutput.writeString(getBaseAffiliateFlag()); 
	}
	
	
	
	
	
}
