package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserVariableKey.class)
public abstract class UserVariableKey_ {

	public static volatile SingularAttribute<UserVariableKey, String> variableKey;
	
	public static volatile SingularAttribute<UserVariableKey, Boolean> userEditable;
}
