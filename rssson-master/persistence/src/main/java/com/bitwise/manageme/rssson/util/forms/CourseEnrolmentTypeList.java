package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class CourseEnrolmentTypeList {

private static Map<String, String> types = new TreeMap<String, String>();
	
	public static Map<String, String> listOfEnrolmentTypes() {
		types.put("ON", "ONLINE");
		types.put("OF", "OFFLINE");
		
		return types;
	}
	
	public static Map<String, String> getEnrolmentTypes() {
		for (String option : listOfEnrolmentTypes().values()) {
			System.out.println(option);
		}
		return types;
	}
}
