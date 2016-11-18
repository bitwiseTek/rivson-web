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
import com.bitwise.manageme.rssson.domain.courses.GradeCourseResource;
import com.bitwise.manageme.rssson.repository.courses.GradeCourseResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("gradeCourseResourceService")
public class GradeCourseResourceServiceImpl implements GradeCourseResourceService {

	@Autowired
	private GradeCourseResourceRepository gradeCourseResourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<GradeCourseResource> findAll() {
		return Lists.newArrayList(this.gradeCourseResourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<GradeCourseResource> findByCourse(Course course) {
		return this.gradeCourseResourceRepo.findByCourse(course);
	}

	@Override
	@Transactional(readOnly=false)
	public GradeCourseResource save(GradeCourseResource courseResource) {
		return this.gradeCourseResourceRepo.save(courseResource);
	}

	@Override
	public void delete(GradeCourseResource courseResource) {
		this.gradeCourseResourceRepo.delete(courseResource);
	}

}
