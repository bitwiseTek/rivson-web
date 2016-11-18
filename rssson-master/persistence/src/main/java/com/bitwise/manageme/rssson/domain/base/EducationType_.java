package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EducationType.class)
public abstract class EducationType_ {

	public static volatile SingularAttribute<EducationType, Long> id;
	
	public static volatile SingularAttribute<EducationType, String> name;
	
	public static volatile SingularAttribute<EducationType, String> code;
	
	public static volatile SingularAttribute<EducationType, Boolean> archived;
}
