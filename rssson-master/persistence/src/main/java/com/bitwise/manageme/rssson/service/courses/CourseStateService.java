package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.CourseState;

public interface CourseStateService {

	public List<CourseState> findAll();
	
	public CourseState save(CourseState courseState);
}
