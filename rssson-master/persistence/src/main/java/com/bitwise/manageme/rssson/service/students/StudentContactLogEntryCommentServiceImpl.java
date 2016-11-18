package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntryComment;
import com.bitwise.manageme.rssson.repository.students.StudentContactLogEntryCommentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentContactLogEntryCommentService")
public class StudentContactLogEntryCommentServiceImpl implements StudentContactLogEntryCommentService {

	@Autowired
	private StudentContactLogEntryCommentRepository studentContactLogEntryCommentRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentContactLogEntryComment> findAll() {
		return Lists.newArrayList(this.studentContactLogEntryCommentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentContactLogEntryComment> findByEntries(StudentContactLogEntry entry) {
		return this.studentContactLogEntryCommentRepo.findByEntries(entry);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentContactLogEntryComment save(StudentContactLogEntryComment logEntryComment) {
		return this.studentContactLogEntryCommentRepo.save(logEntryComment);
	}

}
