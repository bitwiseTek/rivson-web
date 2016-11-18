package com.bitwise.manageme.rssson.util.forms;

/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
public enum RoleType {
	SUPERADMIN("ROLE_SUPER_ADMIN"),
	ADMIN("ROLE_ADMIN"),
	STUDENT("ROLE_STUDENT"),
	LECTURER("ROLE_LECTURER"),
	STAFF("ROLE_STAFF"), 
	MANAGER("ROLE_MANAGER");
	
	String roleType;
	
	private RoleType(String roleType){
		this.roleType = roleType;
	}
	
	public String getRoleType(){
		return roleType;
	}
}
