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

@StaticMetamodel(CourseBaseVariable.class)
public abstract class CourseBaseVariable_ {

	public static volatile SingularAttribute<CourseBaseVariable, Long> id;
	
	public static volatile SetAttribute<CourseBaseVariable, CourseBase> courseBase;
	
	public static volatile SetAttribute<CourseBaseVariable, CourseBaseVariableKey> key;
	
	public static volatile SingularAttribute<CourseBaseVariable, String> value;
}
