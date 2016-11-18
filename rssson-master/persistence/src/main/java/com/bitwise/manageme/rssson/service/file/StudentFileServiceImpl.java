package com.bitwise.manageme.rssson.service.file;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.file.StudentFile;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.file.StudentFileRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentFileService")
public class StudentFileServiceImpl implements StudentFileService {

	@Autowired
	private StudentFileRepository studentFileRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentFile> findAll() {
		return Lists.newArrayList(this.studentFileRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentFile> findByStudent(Student student) {
		return this.studentFileRepo.findByStudent(student);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentFile save(StudentFile studentFile) {
		return this.studentFileRepo.save(studentFile);
	}

}
