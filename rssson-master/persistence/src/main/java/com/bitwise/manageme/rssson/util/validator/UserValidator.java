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

public class UserValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean supports(Class<?> clazz) {
		return (User.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "systemId", "required", new  Object[] {"System Id"});
		ValidationUtils.rejectIfEmpty(errors, "firstName", "required", new  Object[] {"First Name"});
		ValidationUtils.rejectIfEmpty(errors, "lastName", "required", new  Object[] {"Last Name"});
		ValidationUtils.rejectIfEmpty(errors, "username", "required", new  Object[] {"Username"});
		ValidationUtils.rejectIfEmpty(errors, "password", "required", new Object[] {"Password"});
		ValidationUtils.rejectIfEmpty(errors, "streetAddress", "required", new Object[] {"Street Address"});
		ValidationUtils.rejectIfEmpty(errors, "primaryNumber", "required", new Object[] {"Phone Number"});
		ValidationUtils.rejectIfEmpty(errors, "primaryAddress", "required", new Object[] {"Email"});
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required", new Object[] {"Confirm Password"});
		ValidationUtils.rejectIfEmpty(errors, "secretQuestion", "required", new Object[] {"Secret Question"});
		ValidationUtils.rejectIfEmpty(errors, "secretAnswer", "required", new Object[] {"Secret Answer"});
		
		if (!errors.hasFieldErrors("email.primaryAddress")) {
			User user = (User) target;
			String email = user.getPrimaryAddress();
			if (!email.matches(EMAIL_PATTERN)) {
				errors.rejectValue("email.primaryAddress", "invalid.emailAddress");
			}
		}
		
		if (!errors.hasFieldErrors("confirmPassword")) {
			User user = (User) target;
			String password1 = user.getPassword();
			String password2 = user.getConfirmPassword();
			if (!password1.equalsIgnoreCase(password2)) {
				errors.rejectValue("confirmPassword", "validation.confirmPassword.mismatch");
			}
		}
	}


}
