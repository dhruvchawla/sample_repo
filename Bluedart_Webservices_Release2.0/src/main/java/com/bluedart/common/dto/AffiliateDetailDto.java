package com.bluedart.common.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
/**
 * 
 * @author PR334023
 *
 */
public class AffiliateDetailDto implements SQLData, Serializable {

	private static final long serialVersionUID = -7051197897214943436L;
	
	private String sql_type;
	private String loginId;
	private String custCode;
	private String areaCode;
	private String bpFlag;
	private String custName;
	private Integer valid;
	private String created_by;
	private String cbaseaffiliate;
	private Integer affiliateId;
	
	public Integer getAffiliateId() {
		return affiliateId;
	}
	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}
	public String getCbaseaffiliate() {
		return cbaseaffiliate;
	}
	public void setCbaseaffiliate(String cbaseaffiliate) {
		this.cbaseaffiliate = cbaseaffiliate;
	}
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = "UPROFILE4.AFFOBJ_BD_ADMIN";
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getBpFlag() {
		return bpFlag;
	}
	public void setBpFlag(String bpFlag) {
		this.bpFlag = bpFlag;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
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
		setSql_type(getSql_type());
		setLoginId(paramSQLInput.readNString());
		setCustCode(paramSQLInput.readNString());
		setAreaCode(paramSQLInput.readNString());
		setBpFlag(paramSQLInput.readNString());
		setCustName(paramSQLInput.readNString());
		setValid(paramSQLInput.readInt());
		setCreated_by(paramSQLInput.readNString());
		setCbaseaffiliate(paramSQLInput.readNString());
		
	}
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(getLoginId());
	    paramSQLOutput.writeString(getCustCode());
	    paramSQLOutput.writeString(getAreaCode());
	    paramSQLOutput.writeString(getBpFlag());
	    paramSQLOutput.writeString(getCustName());
	    paramSQLOutput.writeInt(getValid());
	    paramSQLOutput.writeString(getCreated_by());
	    paramSQLOutput.writeString(getCbaseaffiliate());
	}
	
}