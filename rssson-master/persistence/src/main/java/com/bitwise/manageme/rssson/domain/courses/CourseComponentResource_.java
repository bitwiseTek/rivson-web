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

@StaticMetamodel(CourseComponentResource.class)
public abstract class CourseComponentResource_ {
	
	public static volatile SingularAttribute<CourseComponentResource, Long> id;
	
	public static volatile SetAttribute<CourseComponentResource, CourseComponent> courseComponent;
	
	public static volatile SetAttribute<CourseComponentResource, Resource> resource;
	
	public static volatile SingularAttribute<CourseComponentResource, Double> usagePercentage;

}
