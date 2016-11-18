package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Long> id;
	
	public static volatile SingularAttribute<User, String> username;
	
	public static volatile SingularAttribute<User, String> password;
	
	public static volatile SingularAttribute<User, Boolean> archived;
}
