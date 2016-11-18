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

import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.repository.base.CourseBaseVariableKeyRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseBaseVariableKeyService")
public class CourseBaseVariableKeyServiceImpl implements CourseBaseVariableKeyService {

	@Autowired
	private CourseBaseVariableKeyRepository courseBaseVariableKeyRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseBaseVariableKey> findAll() {
		return Lists.newArrayList(this.courseBaseVariableKeyRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CourseBaseVariableKey findByVariableKey(String key) {
		return this.courseBaseVariableKeyRepo.findByVariableKey(key);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseBaseVariableKey save(CourseBaseVariableKey key) {
		return this.courseBaseVariableKeyRepo.save(key);
	}

}
