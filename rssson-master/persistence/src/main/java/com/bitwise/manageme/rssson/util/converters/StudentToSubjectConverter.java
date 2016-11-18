package com.bitwise.manageme.rssson.util.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.service.courses.CourseStudentService;

@Component
public class StudentToSubjectConverter implements Converter<Object, CourseStudent> {

	@Autowired
	private CourseStudentService courseStudentService;
	
	@Override
	public CourseStudent convert(Object element) {
		Long id = Long.parseLong((String)element);
		CourseStudent student = courseStudentService.findById(id);
		System.out.println("Student: " +student);
		return student;
	}

}
