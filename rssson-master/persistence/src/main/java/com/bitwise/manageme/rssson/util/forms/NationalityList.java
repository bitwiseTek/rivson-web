package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class NationalityList {

private static Map<String, String> nationalities = new TreeMap<String, String>();
	
	public static Map<String, String> listOfNationalities() {
		nationalities.put("NG", "Nigerian");
		nationalities.put("AF", "Afghan");
		nationalities.put("AR", "Argentine");
		nationalities.put("AU", "Australian");
		nationalities.put("AT", "Austrian");
		nationalities.put("BE", "Belgian");
		nationalities.put("MA", "Moroccoan");
		nationalities.put("MZ", "Mozambican");
		nationalities.put("NA", "Namibian");
		nationalities.put("NL", "Deutsch");
		nationalities.put("NZ", "New Zealander");
		nationalities.put("NI", "Nicaraguan");
		nationalities.put("NE", "Nigerien");
		nationalities.put("KP", "North Korean");
		nationalities.put("NO", "Norwegian");
		nationalities.put("PK", "Pakistani");
		nationalities.put("PA", "Panamanian");
		nationalities.put("PY", "Paraguan");
		nationalities.put("PE", "Peruan");
		
		return nationalities;
	}
	
	public static Map<String, String> getNationalities() {
		for (String nationality : listOfNationalities().values()) {
			System.out.println(nationality);
		}
		return nationalities;
	}
	
}
