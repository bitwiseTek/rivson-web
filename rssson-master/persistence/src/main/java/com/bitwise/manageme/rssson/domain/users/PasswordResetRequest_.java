package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PasswordResetRequest.class)
public abstract class PasswordResetRequest_ {

	public static volatile SingularAttribute<PasswordResetRequest, Long> id;
	
	public static volatile SingularAttribute<PasswordResetRequest, String> secretAnswer;
	
	public static volatile SingularAttribute<PasswordResetRequest, Date> date;
}
