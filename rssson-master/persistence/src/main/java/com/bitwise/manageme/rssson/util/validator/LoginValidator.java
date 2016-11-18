package com.bitwise.manageme.rssson.util.validator;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.manageme.rssson.domain.users.User;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (User.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "username", "required", new  Object[] {"Username"});
		ValidationUtils.rejectIfEmpty(errors, "password", "required", new Object[] {"Password"});
		
		if (errors.hasFieldErrors("username")) {
			errors.rejectValue("usermame", "Username field cannot be empty");
		}
		if (errors.hasFieldErrors("password")) {
			errors.rejectValue("password", "Password field cannot be empty");
		}
	}

}
