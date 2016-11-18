package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class SexList {

private static Map<String, String> sexes = new TreeMap<String, String>();
	
	public static Map<String, String> listOfSexes() {
		sexes.put("ML", "MALE");
		sexes.put("FL", "FEMALE");
		return sexes;
	}
	
	public static Map<String, String> getSexes() {
		for (String sex : listOfSexes().values()) {
			System.out.println(sex);
		}
		return sexes;
	}
}
