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

@StaticMetamodel(EducationSubtype.class)
public abstract class EducationSubtype_ {

	public static volatile SingularAttribute<EducationSubtype, Long> id;
	
	public static volatile SingularAttribute<EducationSubtype, String> name;
	
	public static volatile SingularAttribute<EducationSubtype, String> code;
	
	public static volatile SingularAttribute<EducationSubtype, Boolean> archived;
	
	public static volatile SetAttribute<EducationSubtype, EducationType> educationType;
}
