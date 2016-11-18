package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;

public interface StudentGroupContactLogEntryService {

	public List<StudentGroupContactLogEntry> findAll();
	
	public List<StudentGroupContactLogEntry> findByStudentGroups(StudentGroup group);
	
	public StudentGroupContactLogEntry save(StudentGroupContactLogEntry logEntry);
}
