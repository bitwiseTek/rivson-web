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

import com.bitwise.manageme.rssson.domain.courses.CourseState;
import com.bitwise.manageme.rssson.repository.courses.CourseStateRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseStateService")
public class CourseStateServiceImpl implements CourseStateService {

	@Autowired
	private CourseStateRepository courseStateRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseState> findAll() {
		return Lists.newArrayList(this.courseStateRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public CourseState save(CourseState courseState) {
		return this.courseStateRepo.save(courseState);
	}

}
