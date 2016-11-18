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

import com.bitwise.manageme.rssson.domain.base.CourseEducationSubtype;
import com.bitwise.manageme.rssson.repository.base.CourseEducationSubtypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseEducationSubtypeService")
public class CourseEducationSubtypeServiceImpl implements CourseEducationSubtypeService {

	@Autowired
	private CourseEducationSubtypeRepository courseEducationSubtypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseEducationSubtype> findAll() {
		return Lists.newArrayList(this.courseEducationSubtypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public CourseEducationSubtype save(CourseEducationSubtype educationSubType) {
		return this.courseEducationSubtypeRepo.save(educationSubType);
	}

}
