package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 28/09/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentSubject;

public interface StudentSubjectService {
	
	public StudentSubject findById(Long id);

	public List<StudentSubject> findAll();
	
	public List<StudentSubject> findAllOne();
	
	public List<StudentSubject> findAllTwo();
	
	public StudentSubject save(StudentSubject studentSubject);
	
	public void delete(StudentSubject studentSubject);
	
	public List<StudentSubject> findAllRegisteredOne();
	
	public List<StudentSubject> findAllRegisteredTwo();
}
