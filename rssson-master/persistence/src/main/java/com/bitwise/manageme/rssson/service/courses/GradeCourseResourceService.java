package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.GradeCourseResource;

public interface GradeCourseResourceService {

	public List<GradeCourseResource> findAll();
	
	public List<GradeCourseResource> findByCourse(Course course);
	
	public GradeCourseResource save(GradeCourseResource courseResource);
	
	public void delete(GradeCourseResource courseResource);

}
