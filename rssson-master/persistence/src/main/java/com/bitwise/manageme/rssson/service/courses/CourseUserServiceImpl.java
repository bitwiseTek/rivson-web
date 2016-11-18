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
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.repository.courses.CourseUserRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseUserService")
public class CourseUserServiceImpl implements CourseUserService {

	@Autowired
	private CourseUserRepository courseUserRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseUser> findAll() {
		return Lists.newArrayList(this.courseUserRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseUser> findByCourses(Course course) {
		return this.courseUserRepo.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseUser save(CourseUser courseUser) {
		return this.courseUserRepo.save(courseUser);
	}

	@Override
	public CourseUser findById(Long id) {
		return this.courseUserRepo.findOne(id);
	}

	@Override
	public void delete(CourseUser user) {
		this.courseUserRepo.delete(user);
	}

}
