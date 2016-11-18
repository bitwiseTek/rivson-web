package com.bitwise.manageme.rssson.util.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.service.courses.CourseStaffMemberService;

@Component
public class StaffToSubjectConverter implements Converter<Object, CourseStaffMember> {

	@Autowired
	private CourseStaffMemberService staffService;
	
	@Override
	public CourseStaffMember convert(Object element) {
		Long id = Long.parseLong((String)element);
		CourseStaffMember staff = staffService.findById(id);
		System.out.println("Staff: " +staff);
		return staff;
	}

}
