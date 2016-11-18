package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;

public interface CourseStudentVariableKeyService {

	public List<CourseStudentVariableKey> findAll();
	
	public CourseStudentVariableKey findByKey(String key);
	
	public List<CourseStudentVariableKey> findUserEditableCourseStudentVariableKeys();
	
	public CourseStudentVariableKey save(CourseStudentVariableKey key);
}
