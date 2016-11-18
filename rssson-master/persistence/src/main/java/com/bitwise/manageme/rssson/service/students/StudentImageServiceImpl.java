package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 12/09/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentImage;
import com.bitwise.manageme.rssson.repository.students.StudentImageRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentImageService")
public class StudentImageServiceImpl implements StudentImageService {

	@Autowired
	private StudentImageRepository studentImageRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentImage> findAll() {
		return Lists.newArrayList(this.studentImageRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public StudentImage findByStudent(Student student) {
		return this.studentImageRepo.findByStudent(student);
	}

	@Override
	public Boolean findStudentHasImage(Student student) {
		return this.studentImageRepo.findStudentHasImage(student);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentImage save(StudentImage image) {
		return this.studentImageRepo.save(image);
	}

	@Override
	public void delete(StudentImage image) {
		this.studentImageRepo.delete(image);
	}

	@Override
	public StudentImage findById(Long id) {
		return this.studentImageRepo.findOne(id);
	}

}
