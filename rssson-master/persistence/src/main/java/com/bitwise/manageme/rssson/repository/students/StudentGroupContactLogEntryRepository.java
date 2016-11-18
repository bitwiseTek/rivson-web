package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;

public interface StudentGroupContactLogEntryRepository extends CrudRepository<StudentGroupContactLogEntry, Long> {

	public List<StudentGroupContactLogEntry> findAll();
	
	public List<StudentGroupContactLogEntry> findByStudentGroups(StudentGroup group);
	
}
