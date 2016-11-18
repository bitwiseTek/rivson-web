package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseComponent;

public interface CourseComponentService {

	public List<CourseComponent> findAll();
	
	public List<CourseComponent> findByCourses(Course course);
	
	public CourseComponent save(CourseComponent courseComponent);
	
	public void delete(CourseComponent courseComponent);
}
