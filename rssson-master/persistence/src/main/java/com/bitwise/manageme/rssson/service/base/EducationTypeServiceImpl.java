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
import com.bitwise.manageme.rssson.repository.base.EducationTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("educationTypeService")
public class EducationTypeServiceImpl implements EducationTypeService {

	@Autowired
	private EducationTypeRepository educationTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<EducationType> findAll() {
		return Lists.newArrayList(this.educationTypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public EducationType findByCode(String code) {
		return this.educationTypeRepo.findByCode(code);
	}

	@Override
	@Transactional(readOnly=false)
	public EducationType save(EducationType type) {
		return this.educationTypeRepo.save(type);
	}

}
