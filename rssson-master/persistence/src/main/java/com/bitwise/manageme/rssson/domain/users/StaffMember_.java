package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(StaffMember.class)
public abstract class StaffMember_ {

	public static volatile SingularAttribute<StaffMember, Long> id;
	
	public static volatile SingularAttribute<StaffMember, Boolean> archived;
	
	public static volatile SetAttribute<StaffMember, String> role;
}
