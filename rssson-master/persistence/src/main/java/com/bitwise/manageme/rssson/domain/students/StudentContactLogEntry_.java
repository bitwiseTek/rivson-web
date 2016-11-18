package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(StudentContactLogEntry.class)
public abstract class StudentContactLogEntry_ {

	public static volatile SingularAttribute<StudentContactLogEntry, Boolean> archived;
	
	public static volatile SetAttribute<StudentContactLogEntry, Student> student;
}
