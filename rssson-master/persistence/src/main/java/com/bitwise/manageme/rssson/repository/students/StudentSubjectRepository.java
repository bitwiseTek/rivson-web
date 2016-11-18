package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentSubject;

public interface StudentSubjectRepository extends CrudRepository<StudentSubject, Long> {

	public List<StudentSubject> findAll();
	
	public List<StudentSubject> findAllRegisteredOne();
	
	public List<StudentSubject> findAllRegisteredTwo();
	
	public List<StudentSubject> findAllOne();
	
	public List<StudentSubject> findAllTwo();

}
