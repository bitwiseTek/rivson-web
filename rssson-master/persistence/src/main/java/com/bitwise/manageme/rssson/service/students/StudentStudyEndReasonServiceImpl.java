package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.repository.students.StudentStudyEndReasonRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentStudyEndReasonService")
public class StudentStudyEndReasonServiceImpl implements StudentStudyEndReasonService {

	@Autowired
	private StudentStudyEndReasonRepository studentStudyEndReasonRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentStudyEndReason> findAll() {
		return Lists.newArrayList(this.studentStudyEndReasonRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentStudyEndReason> findByParentReasons(StudentStudyEndReason parentReason) {
		return this.studentStudyEndReasonRepo.findByParentReasons(parentReason);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentStudyEndReason save(StudentStudyEndReason endReason) {
		return this.studentStudyEndReasonRepo.save(endReason);
	}

	@Override
	public void delete(StudentStudyEndReason endReason) {
		this.studentStudyEndReasonRepo.delete(endReason);
	}

}
