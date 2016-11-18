package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.StudentCourseResource;

public interface StudentCourseResourceService {

	public List<StudentCourseResource> findAll();
	
	public List<StudentCourseResource> findByCourses(Course course);
	
	public StudentCourseResource save(StudentCourseResource courseResource);
	
	public void delete(StudentCourseResource courseResource);
	
}
