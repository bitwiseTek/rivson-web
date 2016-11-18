package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentManualPDF;

public interface StudentManualPDFRepository extends CrudRepository<StudentManualPDF, Long> {

	public List<StudentManualPDF> findAll();
	
}
