package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.BasicCourseResource;
import com.bitwise.manageme.rssson.domain.courses.Course;

public interface BasicCourseResourceService {

	public List<BasicCourseResource> findAll();
	
	public List<BasicCourseResource> findByCourses(Course course);
	
	public BasicCourseResource save(BasicCourseResource courseResource);
	
	public void delete(BasicCourseResource courseResource);
}
