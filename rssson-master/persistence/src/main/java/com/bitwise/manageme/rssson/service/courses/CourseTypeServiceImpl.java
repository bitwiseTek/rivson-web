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

import com.bitwise.manageme.rssson.domain.courses.CourseType;
import com.bitwise.manageme.rssson.repository.courses.CourseTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseTypeService")
public class CourseTypeServiceImpl implements CourseTypeService {

	@Autowired
	private CourseTypeRepository courseTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseType> findAll() {
		return Lists.newArrayList(this.courseTypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseType> findByName(String name) {
		return this.courseTypeRepo.findByName(name);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseType save(CourseType courseType) {
		return this.courseTypeRepo.save(courseType);
	}

}
