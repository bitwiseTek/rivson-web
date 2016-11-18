package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntryComment;

public interface StudentContactLogEntryCommentRepository extends CrudRepository<StudentContactLogEntryComment, Long> {

	public List<StudentContactLogEntryComment> findAll();
	
	public List<StudentContactLogEntryComment> findByEntries(StudentContactLogEntry entry);
}
