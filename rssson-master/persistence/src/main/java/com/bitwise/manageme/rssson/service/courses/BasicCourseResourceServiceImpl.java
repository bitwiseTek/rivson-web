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

import com.bitwise.manageme.rssson.domain.courses.BasicCourseResource;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.repository.courses.BasicCourseResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("basicCourseResourceService")
public class BasicCourseResourceServiceImpl implements BasicCourseResourceService {

	@Autowired
	private BasicCourseResourceRepository basicCourseResourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<BasicCourseResource> findAll() {
		return Lists.newArrayList(this.basicCourseResourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<BasicCourseResource> findByCourses(Course course) {
		return this.basicCourseResourceRepo.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=false)
	public BasicCourseResource save(BasicCourseResource courseResource) {
		return this.basicCourseResourceRepo.save(courseResource);
	}

	@Override
	public void delete(BasicCourseResource courseResource) {
		this.basicCourseResourceRepo.delete(courseResource);
	}

}
