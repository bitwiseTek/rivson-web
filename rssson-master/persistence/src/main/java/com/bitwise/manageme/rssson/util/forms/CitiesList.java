package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class CitiesList {
	
private static Map<String, String> cities = new TreeMap<String, String>();
	
	public static Map<String, String> listOfCities() {
		cities.put("PH", "PHC");
		cities.put("LG", "LAG");
		cities.put("AJ", "ABJ");
		cities.put("UY", "UYO");
		cities.put("ON", "ONI");
		cities.put("YN", "YEN");
		cities.put("CA", "CAL");
		cities.put("WA", "WAR");
		cities.put("AB", "ABK");
		cities.put("BE", "BEN");
		cities.put("EG", "ENU");
		cities.put("OW", "OWR");
		cities.put("ZA", "ZAR");
		
		return cities;
	}
	
	public static Map<String, String> getCities() {
		for (String city : listOfCities().values()) {
			System.out.println(city);
		}
		return cities;
	}

}
