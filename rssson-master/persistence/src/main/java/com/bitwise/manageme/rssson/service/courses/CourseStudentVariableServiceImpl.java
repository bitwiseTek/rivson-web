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

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariable;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;
import com.bitwise.manageme.rssson.repository.courses.CourseStudentVariableRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseStudentVariableService")
public class CourseStudentVariableServiceImpl implements CourseStudentVariableService {

	@Autowired
	private CourseStudentVariableRepository courseStudentVariableRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseStudentVariable> findAll() {
		return Lists.newArrayList(this.courseStudentVariableRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CourseStudentVariable findByCourseStudentAndKey(CourseStudent student, CourseStudentVariableKey key) {
		return this.courseStudentVariableRepo.findByCourseStudentAndKey(student, key);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseStudentVariable save(CourseStudentVariable studentVariable) {
		return this.courseStudentVariableRepo.save(studentVariable);
	}

	@Override
	public void delete(CourseStudentVariable studentVariable) {
		this.courseStudentVariableRepo.delete(studentVariable);
	}

}
