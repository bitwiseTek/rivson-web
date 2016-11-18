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

import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;
import com.bitwise.manageme.rssson.repository.students.StudentExaminationTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentExaminationTypeService")
public class StudentExaminationTypeServiceImpl implements StudentExaminationTypeService {

	@Autowired
	private StudentExaminationTypeRepository studentExaminationTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentExaminationType> findAll() {
		return Lists.newArrayList(this.studentExaminationTypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StudentExaminationType save(StudentExaminationType examType) {
		return this.studentExaminationTypeRepo.save(examType);
	}

}
