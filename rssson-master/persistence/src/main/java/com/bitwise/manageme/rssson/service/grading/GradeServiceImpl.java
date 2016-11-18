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

import com.bitwise.manageme.rssson.domain.grading.Grade;
import com.bitwise.manageme.rssson.repository.grading.GradeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Grade> findAll() {
		return Lists.newArrayList(this.gradeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public Grade save(Grade grade) {
		return this.gradeRepo.save(grade);
	}

	@Override
	public void delete(Grade grade) {
		this.gradeRepo.delete(grade);
	}

	@Override
	public Grade findById(Long id) {
		return this.gradeRepo.findOne(id);
	}

	@Override
	public Grade findByName(String name) {
		return this.gradeRepo.findByName(name);
	}

}
