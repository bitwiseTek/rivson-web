package com.bitwise.manageme.rssson.util.validator;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.manageme.rssson.domain.users.StaffMember;

public class StaffMemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (StaffMember.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "staffId", "required", new  Object[] {"Staff Id"});
	}
}
