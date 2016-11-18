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

public interface CourseBaseRepository extends CrudRepository<CourseBase, Long>{

	public List<CourseBase> findAll();
	
	public CourseBase findByName(String name);
	
	public CourseBase findByCode(String courseCode);
}
