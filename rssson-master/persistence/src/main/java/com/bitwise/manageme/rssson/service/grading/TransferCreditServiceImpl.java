package com.bitwise.manageme.rssson.service.grading;
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

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.grading.TransferCredit;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.grading.TransferCreditRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("transferCreditService")
public class TransferCreditServiceImpl implements TransferCreditService {

	@Autowired
	private TransferCreditRepository transferCreditRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<TransferCredit> findAll() {
		return Lists.newArrayList(this.transferCreditRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<TransferCredit> findByStudents(Student student) {
		return this.transferCreditRepo.findByStudents(student);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TransferCredit> findByStudentsAndSubjects(Student student, Subject subject) {
		return this.transferCreditRepo.findByStudentsAndSubjects(student, subject);
	}

	@Override
	public Long countByStudent(Student student) {
		return this.transferCreditRepo.countByStudent(student);
	}

	@Override
	@Transactional(readOnly=false)
	public TransferCredit save(TransferCredit transferCredit) {
		return this.transferCreditRepo.save(transferCredit);
	}

}
