package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariable;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.courses.Course;

public interface CourseBaseVariableService {

	public List<CourseBaseVariable> findAll();
	
	public CourseBaseVariable findByCourseAndVariableKey(Course course, CourseBaseVariableKey key);
	
	public List<CourseBaseVariable> findByCourseBase(CourseBase courseBase);
	
	public CourseBaseVariable save(CourseBaseVariable baseVariable);
}
