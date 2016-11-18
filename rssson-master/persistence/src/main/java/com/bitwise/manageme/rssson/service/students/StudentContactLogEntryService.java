package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;

public interface StudentContactLogEntryService {

	public List<StudentContactLogEntry> findAll();
	
	public List<StudentContactLogEntry> findByStudents(Student student);
	
	public StudentContactLogEntry save(StudentContactLogEntry logEntry);
	
}
