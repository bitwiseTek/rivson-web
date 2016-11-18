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

@StaticMetamodel(CourseStudentVariableKey.class)
public abstract class CourseStudentVariableKey_ {
	
	public static volatile SingularAttribute<CourseStudentVariableKey, Long> id;
	
	public static volatile SingularAttribute<CourseStudentVariableKey, Boolean> userEditable;
	
	public static volatile SingularAttribute<CourseStudentVariableKey, String> variableKey;
	
	public static volatile SingularAttribute<CourseStudentVariableKey, String> variableName;
	
	public static volatile SetAttribute<CourseStudentVariableKey, com.bitwise.manageme.rssson.domain.base.VariableType> variableType;
	

}
