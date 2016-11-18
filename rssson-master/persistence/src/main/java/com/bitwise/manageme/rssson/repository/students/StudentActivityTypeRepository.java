package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentActivityType;

public interface StudentActivityTypeRepository extends CrudRepository<StudentActivityType, Long> {

	public List<StudentActivityType> findAll();
	
}
