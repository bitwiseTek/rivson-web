package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;

public interface CourseStaffMemberService {

	public List<CourseStaffMember> findAll();
	
	public CourseStaffMember findById(Long id);
	
	public List<CourseStaffMember> findByCourses(Course course);
	
	public CourseStaffMember save(CourseStaffMember staffMember);
	
	public void delete(CourseStaffMember staffMember);

}
