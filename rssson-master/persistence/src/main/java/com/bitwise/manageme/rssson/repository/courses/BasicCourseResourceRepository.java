package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.BasicCourseResource;
import com.bitwise.manageme.rssson.domain.courses.Course;

public interface BasicCourseResourceRepository extends CrudRepository<BasicCourseResource, Long> {

	public List<BasicCourseResource> findAll();
	
	public List<BasicCourseResource> findByCourses(Course course);
}
