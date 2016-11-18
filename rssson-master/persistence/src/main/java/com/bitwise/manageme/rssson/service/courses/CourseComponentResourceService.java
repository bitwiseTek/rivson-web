package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.domain.courses.CourseComponentResource;

public interface CourseComponentResourceService {

	public List<CourseComponentResource> findAll();
	
	public List<CourseComponentResource> findByCourseComponents(CourseComponent courseComponent);
	
	public CourseComponentResource save(CourseComponentResource courseComponentResource);
	
	public void delete(CourseComponentResource courseComponentResource);

}
