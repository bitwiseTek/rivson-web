package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.grading.TransferCredit;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface TransferCreditRepository extends CrudRepository<TransferCredit, Long> {

	public List<TransferCredit> findAll();

	public List<TransferCredit> findByStudents(Student student);

	public List<TransferCredit> findByStudentsAndSubjects(Student student, Subject subject);
	
	public Long countByStudent(Student student);
}
