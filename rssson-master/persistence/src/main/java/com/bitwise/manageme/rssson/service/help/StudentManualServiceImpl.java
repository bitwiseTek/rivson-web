package com.bitwise.manageme.rssson.service.help;
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

import com.bitwise.manageme.rssson.domain.help.StudentManual;
import com.bitwise.manageme.rssson.repository.help.StudentManualRepository;

@Transactional
@Service("studentManualService")
public class StudentManualServiceImpl implements StudentManualService {

	@Autowired
	private StudentManualRepository studentManualRepo;
	
	@Override
	@Transactional(readOnly=true)
	public StudentManual findById(Long id) {
		return this.studentManualRepo.findOne(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentManual> findAll() {
		return this.studentManualRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public StudentManual findByVersion(String manualVersion) {
		return this.studentManualRepo.findByVersion(manualVersion);
	}
	
	@Override
	@Transactional(readOnly=false)
	public StudentManual save(StudentManual manualVersion) {
		return this.studentManualRepo.save(manualVersion);
	}

}
