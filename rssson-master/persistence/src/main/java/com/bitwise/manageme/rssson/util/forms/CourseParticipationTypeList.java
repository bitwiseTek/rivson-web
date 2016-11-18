package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class CourseParticipationTypeList {

private static Map<String, String> types = new TreeMap<String, String>();
	
	public static Map<String, String> listOfPartTypes() {
		types.put("ON", "ONLINE");
		types.put("OC", "ON-CAMPUS");
		
		return types;
	}
	
	public static Map<String, String> getPartTypes() {
		for (String option : listOfPartTypes().values()) {
			System.out.println(option);
		}
		return types;
	}
}
