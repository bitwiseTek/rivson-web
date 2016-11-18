package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.repository.base.EducationalLengthRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("educationalLengthService")
public class EducationalLengthServiceImpl implements EducationalLengthService {

	@Autowired
	private EducationalLengthRepository educationalLengthRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<EducationalLength> findAll() {
		return Lists.newArrayList(this.educationalLengthRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public EducationalLength save(EducationalLength length) {
		return this.educationalLengthRepo.save(length);
	}

	@Override
	@Transactional(readOnly=true)
	public EducationalLength findById(Long id) {
		return this.educationalLengthRepo.findOne(id);
	}

}
