package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.repository.base.SubjectRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Subject> findAll() {
		return Lists.newArrayList(this.subjectRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public Subject findByCode(String code) {
		return this.subjectRepo.findByCode(code);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Subject> findByEducationTypes(EducationType type) {
		return this.subjectRepo.findByEducationTypes(type);
	}

	@Override
	@Transactional(readOnly=false)
	public Subject save(Subject subject) {
		return this.subjectRepo.save(subject);
	}

	@Override
	public Subject findById(Long id) {
		return this.subjectRepo.findOne(id);
	}

	@Override
	public Subject findByName(String name) {
		return this.subjectRepo.findByName(name);
	}

	@Override
	public void delete(Subject subject) {
		this.subjectRepo.delete(subject);
	}

}
