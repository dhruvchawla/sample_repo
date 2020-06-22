package com.bluedart.pod.dto;


import java.io.Serializable;
import java.util.List;

/**
 * @author AK765612
 *
 */
public class InboundOutboundFilterDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String valueType;
	private int security;
	private List<SpslistDTO> serviceProductServiceList;
	private List<ProdlistDTO> prodList;
	private List<PacklistDTO> packtypeList;
	
	//private List<ServiceProdListDTO> serviceProdListDTOList;

	
	public String getUserId() {
		return userId;
	}

	
	public int getSecurity() {
		return security;
	}


	public void setSecurity(int security) {
		this.security = security;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public List<SpslistDTO> getServiceProductServiceList() {
		return serviceProductServiceList;
	}

	public void setServiceProductServiceList(List<SpslistDTO> serviceProductServiceList) {
		this.serviceProductServiceList = serviceProductServiceList;
	}

	public List<ProdlistDTO> getProdList() {
		return prodList;
	}

	public void setProdList(List<ProdlistDTO> prodList) {
		this.prodList = prodList;
	}

	public List<PacklistDTO> getPacktypeList() {
		return packtypeList;
	}

	public void setPacktypeList(List<PacklistDTO> packtypeList) {
		this.packtypeList = packtypeList;
	}

	/*public List<ServiceProdListDTO> getServiceProdListDTOList() {
		return serviceProdListDTOList;
	}

	public void setServiceProdListDTOList(List<ServiceProdListDTO> serviceProdListDTOList) {
		this.serviceProdListDTOList = serviceProdListDTOList;
	}*/

	

}
