package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.OtherCost;

public interface OtherCostRepository extends CrudRepository<OtherCost, Long>{

	public List<OtherCost> findAll();
	
	public List<OtherCost> findByCourses(Course course);
}
