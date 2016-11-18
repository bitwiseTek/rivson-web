package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.StudentManualPDF;
import com.bitwise.manageme.rssson.repository.students.StudentManualPDFRepository;

@Transactional
@Service("studentManualPDFService")
public class StudentManualPDFServiceImpl implements StudentManualPDFService {

	@Autowired
	private StudentManualPDFRepository studentManualRepo;
	
	@Override
	@Transactional(readOnly=true)
	public StudentManualPDF findById(Long id) {
		return this.studentManualRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentManualPDF> findAll() {
		return this.studentManualRepo.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public StudentManualPDF save(StudentManualPDF manualPDF) {
		return this.studentManualRepo.save(manualPDF);
	}

}
