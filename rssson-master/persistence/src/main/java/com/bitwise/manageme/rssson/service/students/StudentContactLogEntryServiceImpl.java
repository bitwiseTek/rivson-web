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

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.repository.students.StudentContactLogEntryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentContactLogEntryService")
public class StudentContactLogEntryServiceImpl implements StudentContactLogEntryService {

	@Autowired
	private StudentContactLogEntryRepository studentContactLogEntryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentContactLogEntry> findAll() {
		return Lists.newArrayList(this.studentContactLogEntryRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentContactLogEntry> findByStudents(Student student) {
		return this.studentContactLogEntryRepo.findByStudents(student);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentContactLogEntry save(StudentContactLogEntry logEntry) {
		return this.studentContactLogEntryRepo.save(logEntry);
	}

}
