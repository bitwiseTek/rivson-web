package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntryComment;

public interface StudentGroupContactLogEntryCommentService {

	public List<StudentGroupContactLogEntryComment> findAll();
	
	public List<StudentGroupContactLogEntryComment> findByEntries(StudentGroupContactLogEntry entry);
	
	public StudentGroupContactLogEntryComment save(StudentGroupContactLogEntryComment logEntryComment);
}
