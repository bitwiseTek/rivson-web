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
import com.bitwise.manageme.rssson.domain.courses.CourseUser;

public interface CourseUserRepository extends CrudRepository<CourseUser, Long>{

	public List<CourseUser> findAll();
	
	public List<CourseUser> findByCourses(Course course);
}
