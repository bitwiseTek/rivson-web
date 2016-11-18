package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditLink;
import com.bitwise.manageme.rssson.domain.grading.CreditType;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CreditLinkRepository extends CrudRepository<CreditLink, Long> {

	public List<CreditLink> findAll();
	
	public List<CreditLink> findByStudentsAndTypes(Student student, CreditType creditType);
	
	public List<CreditLink> findByStudents(Student student);
	
	public Long countByStudent(Student student);
	
	public CreditLink findByStudentAndCredit(Student student, Credit credit);
}
