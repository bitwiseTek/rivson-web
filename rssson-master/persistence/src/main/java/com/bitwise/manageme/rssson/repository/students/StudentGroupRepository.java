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

public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {

	public List<StudentGroup> findAll();
	
	public List<StudentGroup> findByStudents(Student student);
}
