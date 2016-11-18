package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;

public interface StudentExaminationTypeRepository extends CrudRepository<StudentExaminationType, Long> {

	public List<StudentExaminationType> findAll();
	
}
