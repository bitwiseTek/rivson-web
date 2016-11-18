package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.CourseStaffMemberRole;

public interface CourseStaffMemberRoleRepository extends CrudRepository<CourseStaffMemberRole, Long>{

	public List<CourseStaffMemberRole> findAll();

}
