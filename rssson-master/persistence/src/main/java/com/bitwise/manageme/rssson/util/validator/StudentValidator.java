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

import com.bitwise.manageme.rssson.domain.students.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Student.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "studentId", "required", new  Object[] {"Student Id"});
	}

}
