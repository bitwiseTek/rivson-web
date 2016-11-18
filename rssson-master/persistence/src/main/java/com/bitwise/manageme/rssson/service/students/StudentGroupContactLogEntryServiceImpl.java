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

import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;
import com.bitwise.manageme.rssson.repository.students.StudentGroupContactLogEntryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentGroupContactLogEntryService")
public class StudentGroupContactLogEntryServiceImpl implements StudentGroupContactLogEntryService {

	@Autowired
	private StudentGroupContactLogEntryRepository studentGroupContactLogEntryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentGroupContactLogEntry> findAll() {
		return Lists.newArrayList(this.studentGroupContactLogEntryRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentGroupContactLogEntry> findByStudentGroups(StudentGroup group) {
		return this.studentGroupContactLogEntryRepo.findByStudentGroups(group);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentGroupContactLogEntry save(StudentGroupContactLogEntry logEntry) {
		return this.studentGroupContactLogEntryRepo.save(logEntry);
	}

}
