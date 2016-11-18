package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LGA.class)
public class LGA_ {

	public static volatile SingularAttribute<LGA, Long> id;
	
	public static volatile SingularAttribute<LGA, String> code;
	
	public static volatile SingularAttribute<LGA, String> name;
	
	public static volatile SingularAttribute<LGA, Boolean> archived;
	
	public static volatile SingularAttribute<LGA, Long> version;
}
