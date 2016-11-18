package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {

	public List<Grade> findAll();
	
	public Grade findByName(String grade);
}
