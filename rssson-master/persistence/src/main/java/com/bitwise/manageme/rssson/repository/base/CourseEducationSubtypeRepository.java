package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.CourseEducationSubtype;

public interface CourseEducationSubtypeRepository extends CrudRepository<CourseEducationSubtype, Long>{

	public List<CourseEducationSubtype> findAll();
	
}
