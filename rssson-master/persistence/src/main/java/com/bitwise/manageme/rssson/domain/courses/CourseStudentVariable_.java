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

@StaticMetamodel(CourseStudentVariable.class)
public abstract class CourseStudentVariable_ {
	
	public static volatile SingularAttribute<CourseStudentVariable, Long> id;
	
	public static volatile SetAttribute<CourseStudentVariable, CourseStudent> courseStudent;
	
	public static volatile SetAttribute<CourseStudentVariable, CourseStudentVariableKey> key;
	
	public static volatile SingularAttribute<CourseStudentVariable, String> value;
}
