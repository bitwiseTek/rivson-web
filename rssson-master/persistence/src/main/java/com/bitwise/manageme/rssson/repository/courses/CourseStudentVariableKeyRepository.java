package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;

public interface CourseStudentVariableKeyRepository extends CrudRepository<CourseStudentVariableKey, Long> {

	public List<CourseStudentVariableKey> findAll();
	
	public CourseStudentVariableKey findByKey(String key);
	
	public List<CourseStudentVariableKey> findUserEditableCourseStudentVariableKeys();
}
