package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;

public interface CourseUserService {

	public List<CourseUser> findAll();
	
	public CourseUser findById(Long id);
	
	public List<CourseUser> findByCourses(Course course);
	
	public CourseUser save(CourseUser courseUser);
	
	public void delete(CourseUser user);
}
