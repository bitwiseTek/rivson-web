package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.CourseType;

public interface CourseTypeRepository extends CrudRepository<CourseType, Long> {

	public List<CourseType> findAll();
	
	public List<CourseType> findByName(String name);
}
