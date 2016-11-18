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

import com.bitwise.manageme.rssson.domain.base.CourseEducationType;
import com.bitwise.manageme.rssson.repository.base.CourseEducationTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseEducationTypeService")
public class CourseEducationTypeServiceImpl implements CourseEducationTypeService {

	@Autowired
	private CourseEducationTypeRepository courseEducationTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseEducationType> findAll() {
		return Lists.newArrayList(this.courseEducationTypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public CourseEducationType save(CourseEducationType educationType) {
		return this.courseEducationTypeRepo.save(educationType);
	}

}
