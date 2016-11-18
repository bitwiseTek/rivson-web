package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.domain.courses.CourseComponentResource;

public interface CourseComponentResourceRepository extends CrudRepository<CourseComponentResource, Long> {

	public List<CourseComponentResource> findAll();
	
	public List<CourseComponentResource> findByCourseComponents(CourseComponent courseComponent);
}
