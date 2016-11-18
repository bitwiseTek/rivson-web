package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class RolesList {

private static Map<String, String> roles = new TreeMap<String, String>();
	
	public static Map<String, String> listOfRoles() {
		roles.put("SA", "ROLE_SUPER_ADMIN");
		roles.put("AD", "ROLE_ADMINISTRATOR");
		roles.put("EV", "ROLE_EVERYONE");
		roles.put("GU", "ROLE_GUEST");
		roles.put("US", "ROLE_USER");
		roles.put("ST", "ROLE_STUDENT");
		roles.put("LC", "ROLE_LECTURER");
		roles.put("MN", "ROLE_MANAGER");
		roles.put("TS", "ROLE_TRUSTED_SYSTEM");
		roles.put("PL", "ROLE_STUDY_PROGRAMME_LEADER");
		roles.put("SG", "ROLE_STUDY_GUIDER");
		
		return roles;
	}
	
	public static Map<String, String> getRoles() {
		for (String role : listOfRoles().values()) {
			System.out.println(role);
		}
		return roles;
	}
}
