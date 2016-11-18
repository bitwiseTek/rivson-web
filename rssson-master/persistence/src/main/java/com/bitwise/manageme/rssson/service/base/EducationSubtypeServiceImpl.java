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

import com.bitwise.manageme.rssson.domain.base.EducationSubtype;
import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.repository.base.EducationSubtypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("educationalSubtypeService")
public class EducationSubtypeServiceImpl implements EducationSubtypeService {

	@Autowired
	private EducationSubtypeRepository educationSubtypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<EducationSubtype> findAll() {
		return Lists.newArrayList(this.educationSubtypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public EducationSubtype findByCode(String code) {
		return this.educationSubtypeRepo.findByCode(code);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EducationSubtype> findByEducationType(EducationType educationType) {
		return this.educationSubtypeRepo.findByEducationType(educationType);
	}

	@Override
	@Transactional(readOnly=false)
	public EducationSubtype save(EducationSubtype subType) {
		return this.educationSubtypeRepo.save(subType);
	}

}
