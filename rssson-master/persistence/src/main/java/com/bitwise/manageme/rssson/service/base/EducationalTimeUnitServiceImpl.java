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

import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;
import com.bitwise.manageme.rssson.repository.base.EducationalTimeUnitRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("educationalTimeUnitService")
public class EducationalTimeUnitServiceImpl implements EducationalTimeUnitService {

	@Autowired
	private EducationalTimeUnitRepository educationalTimeUnitRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<EducationalTimeUnit> findAll() {
		return Lists.newArrayList(this.educationalTimeUnitRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public EducationalTimeUnit save(EducationalTimeUnit timeUnit) {
		return this.educationalTimeUnitRepo.save(timeUnit);
	}

	@Override
	@Transactional(readOnly=true)
	public EducationalTimeUnit findById(Long id) {
		return this.educationalTimeUnitRepo.findOne(id);
	}

}
