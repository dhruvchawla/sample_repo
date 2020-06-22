/**
 * 
 */
package com.bluedart.pod.util;

/**
 * @author SU854042
 *
 */
public enum StatusTypes {
	
	TNT_DELIVERED("DL"),
	TNT_INTRANSIT("IT"),
	TNT_RTO("RT"),
	TNT_REDIRECTED("RD"),
	TNT_UNDELIVERED("UD"),
	TNT_NOTFOUND("NF"),
	TNT_NOINFO("NI");
	
	private String status;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	private StatusTypes(String status){
		this.status = status;
		
	}
	
	
	 

}
