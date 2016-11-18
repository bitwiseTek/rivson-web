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

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.repository.courses.CourseStaffMemberRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseStaffMemberService")
public class CourseStaffMemberServiceImpl implements CourseStaffMemberService {

	@Autowired
	private CourseStaffMemberRepository courseStaffMemberRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseStaffMember> findAll() {
		return Lists.newArrayList(this.courseStaffMemberRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStaffMember> findByCourses(Course course) {
		return this.courseStaffMemberRepo.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseStaffMember save(CourseStaffMember staffMember) {
		return this.courseStaffMemberRepo.save(staffMember);
	}

	@Override
	public void delete(CourseStaffMember staffMember) {
		this.courseStaffMemberRepo.delete(staffMember);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseStaffMember findById(Long id) {
		return this.courseStaffMemberRepo.findOne(id);
	}

}
