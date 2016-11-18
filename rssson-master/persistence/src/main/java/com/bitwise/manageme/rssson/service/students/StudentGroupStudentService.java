package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupStudent;

public interface StudentGroupStudentService {

	public List<StudentGroupStudent> findAll();
	
	public StudentGroupStudent findByStudentGroupAndStudent(StudentGroup group, Student student);
	
	public StudentGroupStudent save(StudentGroupStudent groupStudent);
	
	public void delete(StudentGroupStudent groupStudent);

}
