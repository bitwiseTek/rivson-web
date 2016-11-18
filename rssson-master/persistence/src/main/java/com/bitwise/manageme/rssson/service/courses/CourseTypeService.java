package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.CourseType;

public interface CourseTypeService {

	public List<CourseType> findAll();
	
	public List<CourseType> findByName(String name);
	
	public CourseType save(CourseType courseType);
}
