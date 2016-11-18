package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariable;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.courses.Course;

public interface CourseBaseVariableRepository extends CrudRepository<CourseBaseVariable, Long> {

	public List<CourseBaseVariable> findAll();
	
	public CourseBaseVariable findByCourseAndVariableKey(Course course, CourseBaseVariableKey key);
	
	public List<CourseBaseVariable> findByCourseBase(CourseBase courseBase);
}
