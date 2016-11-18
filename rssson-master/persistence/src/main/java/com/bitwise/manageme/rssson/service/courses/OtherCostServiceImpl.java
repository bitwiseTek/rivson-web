package com.bitwise.manageme.rssson.service.courses;
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

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.OtherCost;
import com.bitwise.manageme.rssson.repository.courses.OtherCostRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("otherCostService")
public class OtherCostServiceImpl implements OtherCostService {

	@Autowired
	private OtherCostRepository otherCostRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<OtherCost> findAll() {
		return Lists.newArrayList(this.otherCostRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<OtherCost> findByCourses(Course course) {
		return this.otherCostRepo.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=false)
	public OtherCost save(OtherCost otherCost) {
		return this.otherCostRepo.save(otherCost);
	}

	@Override
	public void delete(OtherCost otherCost) {
		this.otherCostRepo.delete(otherCost);
	}

}
