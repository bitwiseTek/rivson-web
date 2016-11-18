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

import com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount;

@StaticMetamodel(OtherCost.class)
public abstract class OtherCost_ {

	public static volatile SingularAttribute<OtherCost, Long> id;
	
	public static volatile SetAttribute<OtherCost, Course> course;
	
	public static volatile SetAttribute<OtherCost, MonetaryAmount> cost;
	
	public static volatile SingularAttribute<OtherCost, String> name;
}
