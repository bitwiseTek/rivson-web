package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CourseEducationType.class)
public abstract class CourseEducationType_ {

	public static volatile SetAttribute<CourseEducationType, CourseBase> courseBase;
	
	public static volatile SetAttribute<CourseEducationType, EducationType> educationType;
}
