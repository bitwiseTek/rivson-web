package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.CourseState;

public interface CourseStateRepository extends CrudRepository<CourseState, Long> {

	public List<CourseState> findAll();
}
