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

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariable;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.repository.base.CourseBaseVariableRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseBaseVariableService")
public class CourseBaseVariableServiceImpl implements CourseBaseVariableService {

	@Autowired
	private CourseBaseVariableRepository courseBaseVariableRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseBaseVariable> findAll() {
		return Lists.newArrayList(this.courseBaseVariableRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CourseBaseVariable findByCourseAndVariableKey(Course course, CourseBaseVariableKey key) {
		return this.courseBaseVariableRepo.findByCourseAndVariableKey(course, key);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseBaseVariable> findByCourseBase(CourseBase courseBase) {
		return this.courseBaseVariableRepo.findByCourseBase(courseBase);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseBaseVariable save(CourseBaseVariable baseVariable) {
		return this.courseBaseVariableRepo.save(baseVariable);
	}

}
