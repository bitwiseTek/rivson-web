package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CourseType.class)
public abstract class CourseType_ {
	
	public static volatile SingularAttribute<CourseType, Long> id;
	
	public static volatile SingularAttribute<CourseType, String> name;
	
	public static volatile SingularAttribute<CourseType, Boolean> archived;

}
