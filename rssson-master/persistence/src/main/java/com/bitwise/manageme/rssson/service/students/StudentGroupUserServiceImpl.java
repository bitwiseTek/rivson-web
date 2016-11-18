package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.students.StudentGroupUser;
import com.bitwise.manageme.rssson.repository.students.StudentGroupUserRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentGroupUserService")
public class StudentGroupUserServiceImpl implements StudentGroupUserService {

	@Autowired
	private StudentGroupUserRepository studentGroupUserRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentGroupUser> findAll() {
		return Lists.newArrayList(this.studentGroupUserRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StudentGroupUser save(StudentGroupUser groupUser) {
		return this.studentGroupUserRepo.save(groupUser);
	}

	@Override
	public void delete(StudentGroupUser groupUser) {
		this.studentGroupUserRepo.delete(groupUser);
	}

}
