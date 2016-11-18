package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;

public interface StudentExaminationTypeService {

	public List<StudentExaminationType> findAll();
	
	public StudentExaminationType save(StudentExaminationType examType);
}
