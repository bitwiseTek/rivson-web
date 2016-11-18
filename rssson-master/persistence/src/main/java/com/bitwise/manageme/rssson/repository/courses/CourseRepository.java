package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	public List<Course> findAll();
	
	public List<Course> findBySubjects(Subject subject);
	
	public Course findByName(String name);
	
	public List<Course> findByCourseVariables(String key, String value);
}
