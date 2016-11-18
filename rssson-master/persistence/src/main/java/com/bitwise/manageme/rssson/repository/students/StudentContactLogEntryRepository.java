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
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;

public interface StudentContactLogEntryRepository extends CrudRepository<StudentContactLogEntry, Long> {

	public List<StudentContactLogEntry> findAll();
	
	public List<StudentContactLogEntry> findByStudents(Student student);
	
}
