package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;

public interface CourseService {

	public Course findById(Long id);
	
	public List<Course> findAll();
	
	public List<Course> findBySubjects(Subject subject);
	
	public List<Course> findByCourseVariables(String key, String value);
	
	public Course findByName(String name);
	
	public Course save(Course course);
	
	public void delete(Course course);
}
