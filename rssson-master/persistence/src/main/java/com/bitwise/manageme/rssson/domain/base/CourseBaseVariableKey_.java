package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CourseBaseVariableKey.class)
public abstract class CourseBaseVariableKey_ {

	public static volatile SingularAttribute<CourseBaseVariableKey, Long> id;
	
	public static volatile SingularAttribute<CourseBaseVariableKey, Boolean> userEditable;
	
	public static volatile SingularAttribute<CourseBaseVariableKey, String> variableKey;
	
	public static volatile SingularAttribute<CourseBaseVariableKey, String> variableName;
	
	public static volatile SetAttribute<CourseBaseVariableKey, VariableType> variableType;

}
