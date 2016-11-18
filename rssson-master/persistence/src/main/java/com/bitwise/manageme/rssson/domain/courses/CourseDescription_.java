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

import com.bitwise.manageme.rssson.domain.base.CourseBase;

@StaticMetamodel(CourseDescription.class)
public abstract class CourseDescription_ {
	
	public static volatile SingularAttribute<CourseDescription, Long> id;
	
	public static volatile SetAttribute<CourseDescription, CourseBase> courseBase;
	
	public static volatile SingularAttribute<CourseDescription, String> description;

}
