package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariable;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;

public interface CourseStudentVariableRepository extends CrudRepository<CourseStudentVariable, Long> {

	public List<CourseStudentVariable> findAll();
	
	public CourseStudentVariable findByCourseStudentAndKey(CourseStudent student, CourseStudentVariableKey key);
}
