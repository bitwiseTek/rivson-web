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

import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntryComment;
import com.bitwise.manageme.rssson.repository.students.StudentGroupContactLogEntryCommentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentGroupContactLogEntryCommentService")
public class StudentGroupContactLogEntryCommentServiceImpl implements StudentGroupContactLogEntryCommentService {

	@Autowired
	private StudentGroupContactLogEntryCommentRepository studentGroupContactLogEntryCommentRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentGroupContactLogEntryComment> findAll() {
		return Lists.newArrayList(this.studentGroupContactLogEntryCommentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentGroupContactLogEntryComment> findByEntries(StudentGroupContactLogEntry entry) {
		return this.studentGroupContactLogEntryCommentRepo.findByEntries(entry);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentGroupContactLogEntryComment save(StudentGroupContactLogEntryComment logEntryComment) {
		return this.studentGroupContactLogEntryCommentRepo.save(logEntryComment);
	}

}
