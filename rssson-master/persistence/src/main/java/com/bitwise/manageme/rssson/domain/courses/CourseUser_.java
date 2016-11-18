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

@StaticMetamodel(CourseUser.class)
public abstract class CourseUser_ {

	public static volatile SingularAttribute<CourseUser, Long> id;
	
	public static volatile SetAttribute<CourseUser, Course> course;
}
