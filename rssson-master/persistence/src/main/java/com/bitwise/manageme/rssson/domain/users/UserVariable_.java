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

@StaticMetamodel(UserVariable.class)
public abstract class UserVariable_ {

	public static volatile SingularAttribute<UserVariable, String> value;
	
	public static volatile SetAttribute<UserVariable, UserVariableKey> key;
	
	public static volatile SetAttribute<UserVariable, User> user;
}
