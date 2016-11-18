package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class CourseOptionalityList {
	
	private static Map<String, String> optionality = new TreeMap<String, String>();
	
	public static Map<String, String> listOfOptionalities() {
		optionality.put("MA", "MANDATORY");
		optionality.put("OP", "OPTIONAL");
		
		return optionality;
	}
	
	public static Map<String, String> getOptionalities() {
		for (String option : listOfOptionalities().values()) {
			System.out.println(option);
		}
		return optionality;
	}

}
