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

import com.bitwise.manageme.rssson.domain.resources.Resource;
import com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount;

@StaticMetamodel(StudentCourseResource.class)
public abstract class StudentCourseResource_ {

	public static volatile SingularAttribute<StudentCourseResource, Long> id;
	
	public static volatile SetAttribute<StudentCourseResource, Resource> resource;
	
	public static volatile SetAttribute<StudentCourseResource, Course> course;
	
	public static volatile SingularAttribute<StudentCourseResource, Double> hours;
	
	public static volatile SetAttribute<StudentCourseResource, MonetaryAmount> hourlyCost;
	
	public static volatile SetAttribute<StudentCourseResource, MonetaryAmount> unitCost;

}
