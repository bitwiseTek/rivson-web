package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class StateList {
	
	private static Map<String, String> states = new TreeMap<String, String>();
	
	public static Map<String, String> listOfStates() {
		states.put("AB", "Abia");
		states.put("AD", "Adamawa");
		states.put("AK", "Akwa-Ibom");
		states.put("AN", "Anambra");
		states.put("BA", "Bauchi");
		states.put("BY", "Bayelsa");
		states.put("BE", "Benue");
		states.put("BO", "Borno");
		states.put("CR", "Cross-River");
		states.put("DE", "Delta");
		states.put("EB", "Ebonyi");
		states.put("ED", "Edo");
		states.put("EK", "Ekiti");
		states.put("EG", "Enugu");
		states.put("FC", "F.C.T");
		states.put("GO", "Gombe");
		states.put("IM", "Imo");
		states.put("JG", "Jigawa");
		states.put("KD", "Kaduna");
		states.put("KA", "Kano");
		states.put("KT", "Katsina");
		states.put("KB", "Kebbi");
		states.put("KG", "Kogi");
		states.put("KW", "Kwara");
		states.put("LG", "Lagos");
		states.put("NA", "Nassarawa");
		states.put("NG", "Niger");
		states.put("OG", "Ogun");
		states.put("OD", "Ondo");
		states.put("OS", "Osun");
		states.put("OY", "Oyo");
		states.put("PL", "Plateau");
		states.put("RV", "Rivers");
		states.put("SO", "Sokoto");
		states.put("TB", "Taraba");
		states.put("YB", "Yobe");
		states.put("ZM", "Zamfara");
		
		return states;
	}
	
	public static Map<String, String> getStates() {
		for (String state : listOfStates().values()) {
			System.out.println(state);
		}
		return states;
	}
}
