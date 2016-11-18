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

public interface StudentGroupService {

	public List<StudentGroup> findAll();
	
	public List<StudentGroup> findByStudents(Student student);
	
	public StudentGroup save(StudentGroup studentGroup);
}
