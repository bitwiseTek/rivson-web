package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariable;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;

public interface CourseStudentVariableService {

	public List<CourseStudentVariable> findAll();
	
	public CourseStudentVariable findByCourseStudentAndKey(CourseStudent student, CourseStudentVariableKey key);
	
	public CourseStudentVariable save(CourseStudentVariable studentVariable);
	
	public void delete(CourseStudentVariable studentVariable);
}
