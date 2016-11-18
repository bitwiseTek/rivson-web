package com.bitwise.manageme.rssson.dto.user;
/**
 *  
 * @author Sika Kay
 * @date 14/09/16
 *
 */
import java.io.Serializable;

import com.bitwise.manageme.rssson.domain.users.User;

public class UserDto extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public UserDto() {
		
	}
	
	public UserDto(Long id, String systemId, String firstName, String lastName, String middleName, String sex, String role, String username) {
		super();
		this.id = id;
		this.systemId = systemId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.sex = sex;
		this.role = role;
		this.username = username;
	}
	
	private Long id;
	
	private String systemId;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String sex;
	
	private String role;
	
	private Boolean isActive;
	
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
