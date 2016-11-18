package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 28/09/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.StudentSubject;
import com.bitwise.manageme.rssson.repository.students.StudentSubjectRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentSubjectService")
public class StudentSubjectServiceImpl implements StudentSubjectService {

	@Autowired
	private StudentSubjectRepository studentSubjectRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentSubject> findAll() {
		return Lists.newArrayList(this.studentSubjectRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StudentSubject save(StudentSubject studentSubject) {
		return this.studentSubjectRepo.save(studentSubject);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(StudentSubject studentSubject) {
		this.studentSubjectRepo.delete(studentSubject);
	}

	@Override
	@Transactional(readOnly=true)
	public StudentSubject findById(Long id) {
		return this.studentSubjectRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentSubject> findAllRegisteredOne() {
		return this.studentSubjectRepo.findAllRegisteredOne();
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentSubject> findAllOne() {
		return this.studentSubjectRepo.findAllOne();
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentSubject> findAllTwo() {
		return this.studentSubjectRepo.findAllTwo();
	}

	@Override
	public List<StudentSubject> findAllRegisteredTwo() {
		return this.studentSubjectRepo.findAllRegisteredTwo();
	}

}
