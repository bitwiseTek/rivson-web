package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupStudent;

public interface StudentGroupStudentRepository extends CrudRepository<StudentGroupStudent, Long> {

	public List<StudentGroupStudent> findAll();
	
	public StudentGroupStudent findByStudentGroupAndStudent(StudentGroup group, Student student);
}
