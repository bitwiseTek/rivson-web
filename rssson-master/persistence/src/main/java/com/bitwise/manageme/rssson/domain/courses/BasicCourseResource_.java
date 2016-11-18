package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BasicCourseResource.class)
public abstract class BasicCourseResource_ {

	public static volatile SingularAttribute<BasicCourseResource, Long> id;
	
	public static volatile SetAttribute<BasicCourseResource, Course> course;
	
	public static volatile SetAttribute<BasicCourseResource, com.bitwise.manageme.rssson.domain.resources.Resource> resource;
	
	public static volatile SingularAttribute<BasicCourseResource, Double> hours;
	
	public static volatile SetAttribute<BasicCourseResource, com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount> hourlyCost;
	
	public static volatile SingularAttribute<BasicCourseResource, Integer> units;
	
	public static volatile SetAttribute<BasicCourseResource, com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount> unitCost;
}
