package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.users.User;

@StaticMetamodel(CreditLink.class)
public abstract class CreditLink_ {

	public static volatile SingularAttribute<CreditLink, Long> id;
	
	public static volatile SingularAttribute<CreditLink, Date> created;
	
	public static volatile SingularAttribute<CreditLink, Boolean> archived;
	
	public static volatile SetAttribute<CreditLink, User> creator;
	
	public static volatile SetAttribute<CreditLink, Student> student;
	
	public static volatile SetAttribute<CreditLink, Credit> credit;
}
