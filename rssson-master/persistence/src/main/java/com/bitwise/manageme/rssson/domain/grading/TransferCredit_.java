package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.students.Student;

@StaticMetamodel(TransferCredit.class)
public abstract class TransferCredit_ {

	public static volatile SingularAttribute<TransferCredit, Boolean> archived;
	
	public static volatile SetAttribute<TransferCredit, Student> student;
	
	public static volatile SetAttribute<TransferCredit, Subject> subject;
}
