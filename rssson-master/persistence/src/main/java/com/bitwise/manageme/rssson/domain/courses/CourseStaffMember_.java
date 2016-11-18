package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.users.StaffMember;

@StaticMetamodel(CourseStaffMember.class)
public abstract class CourseStaffMember_ {

	public static volatile SingularAttribute<CourseStaffMember, Long> id;
	
	public static volatile SetAttribute<CourseStaffMember, StaffMember> staffMember;
	
	public static volatile SetAttribute<CourseStaffMember, Course> course;
	
	public static volatile SetAttribute<CourseStaffMember, CourseStaffMemberRole> role;

}
