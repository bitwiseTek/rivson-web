package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.Grade;

public interface GradeService {

	public List<Grade> findAll();
	
	public Grade findById(Long id);
	
	public Grade findByName(String name);
	
	public Grade save(Grade grade);
	
	public void delete(Grade grade);
}
