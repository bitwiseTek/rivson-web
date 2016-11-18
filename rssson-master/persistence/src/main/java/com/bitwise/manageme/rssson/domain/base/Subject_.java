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

@StaticMetamodel(Subject.class)
public abstract class Subject_ {
	
public static volatile SingularAttribute<Subject, Long> id;
	
	public static volatile SingularAttribute<Subject, String> code;
	
	public static volatile SingularAttribute<Subject, String> name;
	
	public static volatile SetAttribute<Subject, EducationType> educationType;
	
	public static volatile SingularAttribute<Subject, Boolean> archived;

}
