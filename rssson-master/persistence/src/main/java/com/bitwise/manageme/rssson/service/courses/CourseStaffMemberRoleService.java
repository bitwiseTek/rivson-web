package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.CourseStaffMemberRole;

public interface CourseStaffMemberRoleService {

	public List<CourseStaffMemberRole> findAll();
	
	public CourseStaffMemberRole save(CourseStaffMemberRole staffMemberRole);

}
