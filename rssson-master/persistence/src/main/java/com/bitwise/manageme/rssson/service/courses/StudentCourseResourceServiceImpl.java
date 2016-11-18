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
import com.bitwise.manageme.rssson.domain.courses.StudentCourseResource;
import com.bitwise.manageme.rssson.repository.courses.StudentCourseResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentCourseResourceService")
public class StudentCourseResourceServiceImpl implements StudentCourseResourceService {

	@Autowired
	private StudentCourseResourceRepository studentCourseResourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentCourseResource> findAll() {
		return Lists.newArrayList(this.studentCourseResourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentCourseResource> findByCourses(Course course) {
		return this.studentCourseResourceRepo.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentCourseResource save(StudentCourseResource courseResource) {
		return this.studentCourseResourceRepo.save(courseResource);
	}

	@Override
	public void delete(StudentCourseResource courseResource) {
		this.studentCourseResourceRepo.delete(courseResource);
	}

}
