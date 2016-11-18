package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;

public interface CourseStaffMemberRepository extends CrudRepository<CourseStaffMember, Long> {

	public List<CourseStaffMember> findAll();
	
	public List<CourseStaffMember> findByCourses(Course course);
}
