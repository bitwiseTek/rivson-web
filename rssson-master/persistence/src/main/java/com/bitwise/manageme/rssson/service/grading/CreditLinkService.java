package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditLink;
import com.bitwise.manageme.rssson.domain.grading.CreditType;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CreditLinkService {

	public List<CreditLink> findAll();
	
	public List<CreditLink> findByStudentsAndTypes(Student student, CreditType creditType);
	
	public List<CreditLink> findByStudents(Student student);
	
	public Long countByStudent(Student student);
	
	public CreditLink findByStudentAndCredit(Student student, Credit credit);
	
	public CreditLink save(CreditLink creditLink);
}
