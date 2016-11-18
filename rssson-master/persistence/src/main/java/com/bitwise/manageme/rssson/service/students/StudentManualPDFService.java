package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentManualPDF;

public interface StudentManualPDFService {

	public StudentManualPDF findById(Long id);
	
	public List<StudentManualPDF> findAll();
	
	public StudentManualPDF save(StudentManualPDF manualPDF);
}
