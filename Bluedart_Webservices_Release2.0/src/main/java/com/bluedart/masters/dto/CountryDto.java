package com.bluedart.masters.dto;

import java.io.Serializable;
import java.util.Comparator;
/**
 * @author CH848113
 */
public class CountryDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String countryId;
	private String countryDescription;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryDescription() {
		return countryDescription;
	}
	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}
	
	/*public static Comparator<CountryDto> countryComparator = new Comparator<CountryDto>() {

		public int compare(CountryDto obj1, CountryDto obj2) {
		   String countryDescription1 = obj1.getCountryDescription().toLowerCase();
		   String countryDescription2 = obj2.getCountryDescription().toLowerCase();

		   //ascending order
		   return countryDescription1.compareTo(countryDescription2);

		   //descending order
		   //return reasonDescription2.compareTo(reasonDescription1);
	    }};
*/
	
	

}
