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

import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;
import com.bitwise.manageme.rssson.repository.students.StudentEducationalLevelRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentEducationalLevelService")
public class StudentEducationalLevelServiceImpl implements StudentEducationalLevelService {

	@Autowired
	private StudentEducationalLevelRepository studentEducationalLevelRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentEducationalLevel> findAll() {
		return Lists.newArrayList(this.studentEducationalLevelRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StudentEducationalLevel save(StudentEducationalLevel educationalLevel) {
		return this.studentEducationalLevelRepo.save(educationalLevel);
	}

}
