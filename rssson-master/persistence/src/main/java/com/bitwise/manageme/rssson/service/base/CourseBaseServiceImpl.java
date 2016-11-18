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
import com.bitwise.manageme.rssson.repository.base.CourseBaseRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseBaseService")
public class CourseBaseServiceImpl implements CourseBaseService {

	@Autowired
	private CourseBaseRepository courseBaseRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseBase> findAll() {
		return Lists.newArrayList(this.courseBaseRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public CourseBase save(CourseBase base) {
		return this.courseBaseRepo.save(base);
	}

	@Override
	public CourseBase findByName(String name) {
		return this.courseBaseRepo.findByName(name);
	}

	@Override
	public CourseBase findByCode(String courseCode) {
		return this.courseBaseRepo.findByCode(courseCode);
	}

	@Override
	public void delete(CourseBase base) {
		this.courseBaseRepo.delete(base);
	}

	@Override
	public CourseBase findById(Long id) {
		return this.courseBaseRepo.findOne(id);
	}

}
