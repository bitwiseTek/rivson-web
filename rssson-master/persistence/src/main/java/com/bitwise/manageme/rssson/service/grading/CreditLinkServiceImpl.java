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

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditLink;
import com.bitwise.manageme.rssson.domain.grading.CreditType;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.grading.CreditLinkRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("creditLinkService")
public class CreditLinkServiceImpl implements CreditLinkService {

	@Autowired
	private CreditLinkRepository creditLinkRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CreditLink> findAll() {
		return Lists.newArrayList(this.creditLinkRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CreditLink> findByStudentsAndTypes(Student student, CreditType creditType) {
		return this.creditLinkRepo.findByStudentsAndTypes(student, creditType);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CreditLink> findByStudents(Student student) {
		return this.findByStudents(student);
	}

	@Override
	public Long countByStudent(Student student) {
		return this.creditLinkRepo.countByStudent(student);
	}

	@Override
	@Transactional(readOnly=true)
	public CreditLink findByStudentAndCredit(Student student, Credit credit) {
		return this.creditLinkRepo.findByStudentAndCredit(student, credit);
	}

	@Override
	@Transactional(readOnly=false)
	public CreditLink save(CreditLink creditLink) {
		return this.creditLinkRepo.save(creditLink);
	}

}
