package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntryComment;

public interface StudentContactLogEntryCommentService {

	public List<StudentContactLogEntryComment> findAll();
	
	public List<StudentContactLogEntryComment> findByEntries(StudentContactLogEntry entry);
	
	public StudentContactLogEntryComment save(StudentContactLogEntryComment logEntryComment);
}
