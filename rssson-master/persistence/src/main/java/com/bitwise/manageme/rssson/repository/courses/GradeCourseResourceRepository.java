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
import com.bitwise.manageme.rssson.domain.courses.GradeCourseResource;

public interface GradeCourseResourceRepository extends CrudRepository<GradeCourseResource, Long> {

	public List<GradeCourseResource> findAll();
	
	public List<GradeCourseResource> findByCourse(Course course);
}
