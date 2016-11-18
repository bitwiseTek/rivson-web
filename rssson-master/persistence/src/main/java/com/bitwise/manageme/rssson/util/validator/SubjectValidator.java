package com.bitwise.manageme.rssson.util.validator;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.manageme.rssson.domain.base.Subject;

public class SubjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Subject.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "required", new  Object[] {"Subject Name"});
		ValidationUtils.rejectIfEmpty(errors, "code", "required", new  Object[] {"Subject Code"});
	}
}
