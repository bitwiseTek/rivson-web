package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntryComment;

public interface StudentGroupContactLogEntryCommentRepository extends CrudRepository<StudentGroupContactLogEntryComment, Long> {

	public List<StudentGroupContactLogEntryComment> findAll();
	
	public List<StudentGroupContactLogEntryComment> findByEntries(StudentGroupContactLogEntry entry);
}
