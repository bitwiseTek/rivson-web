package com.bitwise.manageme.rssson.repository.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.help.StudentManual;

public interface StudentManualRepository extends CrudRepository<StudentManual, Long> {

	public List<StudentManual> findAll();
	
	public StudentManual findByVersion(String manualVersion);
}
