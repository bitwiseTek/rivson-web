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
import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.repository.courses.CourseComponentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseComponentService")
public class CourseComponentServiceImpl implements CourseComponentService {

	@Autowired
	private CourseComponentRepository courseComponentRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseComponent> findAll() {
		return Lists.newArrayList(this.courseComponentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseComponent> findByCourses(Course course) {
		return this.courseComponentRepo.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseComponent save(CourseComponent courseComponent) {
		return this.courseComponentRepo.save(courseComponent);
	}

	@Override
	public void delete(CourseComponent courseComponent) {
		this.courseComponentRepo.delete(courseComponent);
	}

}
