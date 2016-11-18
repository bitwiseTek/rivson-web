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

import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;
import com.bitwise.manageme.rssson.repository.courses.CourseStudentVariableKeyRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseStudentVariableKeyService")
public class CourseStudentVariableKeyServiceImpl implements CourseStudentVariableKeyService {

	@Autowired
	private CourseStudentVariableKeyRepository courseStudentVariableKeyRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseStudentVariableKey> findAll() {
		return Lists.newArrayList(this.courseStudentVariableKeyRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CourseStudentVariableKey findByKey(String key) {
		return this.courseStudentVariableKeyRepo.findByKey(key);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStudentVariableKey> findUserEditableCourseStudentVariableKeys() {
		return this.courseStudentVariableKeyRepo.findUserEditableCourseStudentVariableKeys();
	}

	@Override
	@Transactional(readOnly=false)
	public CourseStudentVariableKey save(CourseStudentVariableKey key) {
		return this.courseStudentVariableKeyRepo.save(key);
	}

}
