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
import com.bitwise.manageme.rssson.domain.courses.StudentCourseResource;

public interface StudentCourseResourceRepository extends CrudRepository<StudentCourseResource, Long>{

	public List<StudentCourseResource> findAll();
	
	public List<StudentCourseResource> findByCourses(Course course);
	
}
