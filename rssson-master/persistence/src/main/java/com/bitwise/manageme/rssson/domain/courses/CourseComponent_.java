package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.util.List;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CourseComponent.class)
public abstract class CourseComponent_ {

	public static volatile SingularAttribute<CourseComponent, Long> id;
	
	public static volatile SingularAttribute<CourseComponent, String> name;
	
	public static volatile SingularAttribute<CourseComponent, String> description;
	
	public static volatile SetAttribute<CourseComponent, com.bitwise.manageme.rssson.domain.base.EducationalLength> length;
	
	public static volatile SingularAttribute<CourseComponent, Boolean> archived;
	
	public static volatile ListAttribute<Course, List<CourseComponentResource>> resources;
	
	public static volatile SetAttribute<CourseComponent, Course> course;
}
