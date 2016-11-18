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

import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.domain.courses.CourseComponentResource;
import com.bitwise.manageme.rssson.repository.courses.CourseComponentResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseComponentResourceService")
public class CourseComponentResourceServiceImpl implements CourseComponentResourceService {

	@Autowired
	private CourseComponentResourceRepository courseComponentResourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseComponentResource> findAll() {
		return Lists.newArrayList(this.courseComponentResourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseComponentResource> findByCourseComponents(CourseComponent courseComponent) {
		return this.courseComponentResourceRepo.findByCourseComponents(courseComponent);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseComponentResource save(CourseComponentResource courseComponentResource) {
		return this.courseComponentResourceRepo.save(courseComponentResource);
	}

	@Override
	public void delete(CourseComponentResource courseComponentResource) {
		this.courseComponentResourceRepo.delete(courseComponentResource);
	}

}
