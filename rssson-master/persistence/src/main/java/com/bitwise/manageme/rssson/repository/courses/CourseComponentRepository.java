package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseComponent;

public interface CourseComponentRepository extends CrudRepository<CourseComponent, Long> {

	public List<CourseComponent> findAll();
	
	public List<CourseComponent> findByCourses(Course course);
}
