package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.security.Role;
import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class UserBuilder extends EntityBuilder<User> {

	@Override
	void initProduct() {
		this.product = new User();
	}
	
	public UserBuilder name(String firstName, String lastName, String middleName) {
		this.product.setFirstName(firstName);
		this.product.setLastName(lastName);
		this.product.setMiddleName(middleName);
		return this;
	}
	
	public UserBuilder credentials(String username, String password, String confirmPassword, String secretQuestion, String secretAnswer, 
			DateTime lastLogin, DateTime lastLogout) {
		this.product.setUsername(username);
		this.product.setPassword(password);
		this.product.setConfirmPassword(confirmPassword);
		this.product.setSecretQuestion(secretQuestion);
		this.product.setSecretAnswer(secretAnswer);
		this.product.setLastLogin(lastLogin);
		this.product.setLastLogout(lastLogout);
		return this;
	}
	
	public UserBuilder userDetails(String systemId, String sex, Boolean secureInfo, Boolean isActive, String streetAddress, String postalCode, 
			String city, String country, String primaryNumber, String secondaryNumber, String primaryAddress, String secondaryAddress) {
		this.product.setSystemId(systemId);
		this.product.setSex(sex);
		this.product.setSecureInfo(secureInfo);
		this.product.setIsActive(isActive);
		this.product.setStreetAddress(streetAddress);
		this.product.setPostalCode(postalCode);
		this.product.setCity(city);
		this.product.setCountry(country);
		this.product.setPrimaryNumber(primaryNumber);
		this.product.setSecondaryNumber(secondaryNumber);
		this.product.setPrimaryAddress(primaryAddress);
		this.product.setSecondaryAddress(secondaryAddress);
		return this;
	}
	
	public UserBuilder roles(Role role, User... roles) {
		this.product.getRoles().add(role);
		for (User user : roles) {
			user.getRoles().add(role);
		}
	return this;
	}
	
	public UserBuilder archived(Boolean archived) {
		this.product.setArchived(archived);
		return this;
	}

	@Override
	User assembleProduct() {
		return this.product;
	}

}
