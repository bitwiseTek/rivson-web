package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.grading.TransferCredit;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface TransferCreditService {

	public List<TransferCredit> findAll();

	public List<TransferCredit> findByStudents(Student student);

	public List<TransferCredit> findByStudentsAndSubjects(Student student, Subject subject);
	
	public Long countByStudent(Student student);
	
	public TransferCredit save(TransferCredit transferCredit);
}
