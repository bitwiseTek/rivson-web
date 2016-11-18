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

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.repository.courses.CourseRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Course> findAll() {
		return Lists.newArrayList(this.courseRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> findBySubjects(Subject subject) {
		return this.courseRepo.findBySubjects(subject);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> findByCourseVariables(String key, String value) {
		return this.courseRepo.findByCourseVariables(key, value);
	}

	@Override
	@Transactional(readOnly=false)
	public Course save(Course course) {
		return this.courseRepo.save(course);
	}

	@Override
	public Course findByName(String name) {
		return this.courseRepo.findByName(name);
	}

	@Override
	public void delete(Course course) {
		this.courseRepo.delete(course);
	}

	@Override
	public Course findById(Long id) {
		return this.courseRepo.findOne(id);
	}

}
