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

@StaticMetamodel(GradeCourseResource.class)
public abstract class GradeCourseResource_ {

	public static volatile SingularAttribute<GradeCourseResource, Long> id;
	
	public static volatile SetAttribute<GradeCourseResource, Course> course;
	
	public static volatile SetAttribute<GradeCourseResource, Resource> resource;
	
	public static volatile SingularAttribute<GradeCourseResource, Double> hours;
	
	public static volatile SetAttribute<GradeCourseResource, MonetaryAmount> hourlyCost;
	
	public static volatile SetAttribute<GradeCourseResource, MonetaryAmount> unitCost;
}
