package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.StudentActivityType;
import com.bitwise.manageme.rssson.repository.students.StudentActivityTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentActivityTypeService")
public class StudentActivityTypeServiceImpl implements StudentActivityTypeService {

	@Autowired
	private StudentActivityTypeRepository studentActivityTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentActivityType> findAll() {
		return Lists.newArrayList(this.studentActivityTypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StudentActivityType save(StudentActivityType activityType) {
		return this.studentActivityTypeRepo.save(activityType);
	}

}
