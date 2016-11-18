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

import com.bitwise.manageme.rssson.domain.grading.GradingScale;
import com.bitwise.manageme.rssson.repository.grading.GradingScaleRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("gradingScaleService")
public class GradingScaleServiceImpl implements GradingScaleService {

	@Autowired
	private GradingScaleRepository gradingScaleRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<GradingScale> findAll() {
		return Lists.newArrayList(this.gradingScaleRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public GradingScale save(GradingScale scale) {
		return this.gradingScaleRepo.save(scale);
	}

	@Override
	public void delete(GradingScale scale) {
		this.gradingScaleRepo.delete(scale);
	}

	@Override
	public GradingScale findById(Long id) {
		return this.gradingScaleRepo.findOne(id);
	}

	@Override
	public GradingScale findByName(String name) {
		return this.gradingScaleRepo.findByName(name);
	}

}
