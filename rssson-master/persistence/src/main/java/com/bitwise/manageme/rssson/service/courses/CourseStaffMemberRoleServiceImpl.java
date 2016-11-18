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

import com.bitwise.manageme.rssson.domain.courses.CourseStaffMemberRole;
import com.bitwise.manageme.rssson.repository.courses.CourseStaffMemberRoleRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseStaffMemberRoleService")
public class CourseStaffMemberRoleServiceImpl implements CourseStaffMemberRoleService {

	@Autowired
	private CourseStaffMemberRoleRepository courseStaffMemberRoleRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseStaffMemberRole> findAll() {
		return Lists.newArrayList(this.courseStaffMemberRoleRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public CourseStaffMemberRole save(CourseStaffMemberRole staffMemberRole) {
		return this.courseStaffMemberRoleRepo.save(staffMemberRole);
	}

}
