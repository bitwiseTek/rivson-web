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

@StaticMetamodel(StudentGroup.class)
public abstract class StudentGroup_ {

	public static volatile SingularAttribute<StudentGroup, Boolean> archived;
	
	public static volatile SetAttribute<StudentGroup, StudentGroup> studentGroup;
	
	public static volatile SetAttribute<StudentGroup, Student> student;
}
