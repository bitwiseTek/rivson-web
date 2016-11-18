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
import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.repository.students.StudentGroupRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentGroupService")
public class StudentGroupServiceImpl implements StudentGroupService {

	@Autowired
	private StudentGroupRepository studentGroupRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentGroup> findAll() {
		return Lists.newArrayList(this.studentGroupRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentGroup> findByStudents(Student student) {
		return this.studentGroupRepo.findByStudents(student);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentGroup save(StudentGroup studentGroup) {
		return this.studentGroupRepo.save(studentGroup);
	}

}
