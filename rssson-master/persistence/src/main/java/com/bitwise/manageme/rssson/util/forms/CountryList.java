package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class CountryList {
	
	private static Map<String, String> countries = new TreeMap<String, String>();
	
	public static Map<String, String> listOfCountries() {
		countries.put("NG", "Nigeria");
		countries.put("AF", "Afghanistan");
		countries.put("AR", "Argentina");
		countries.put("AU", "Australia");
		countries.put("AT", "Austria");
		countries.put("BE", "Belgium");
		countries.put("MA", "Morocco");
		countries.put("MZ", "Mozambique");
		countries.put("NA", "Namibia");
		countries.put("NL", "Netherlands");
		countries.put("NZ", "New Zealand");
		countries.put("NI", "Nicaragua");
		countries.put("NE", "Niger");
		countries.put("KP", "North Korea");
		countries.put("NO", "Norway");
		countries.put("PK", "Pakistan");
		countries.put("PA", "Panama");
		countries.put("PY", "Paraguay");
		countries.put("PE", "Peru");
		
		return countries;
	}
	
	public static Map<String, String> getCountries() {
		for (String country : listOfCountries().values()) {
			System.out.println(country);
		}
		return countries;
	}
	
}
