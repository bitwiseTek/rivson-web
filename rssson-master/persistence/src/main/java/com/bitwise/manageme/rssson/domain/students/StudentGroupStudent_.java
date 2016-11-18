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

@StaticMetamodel(StudentGroupStudent.class)
public abstract class StudentGroupStudent_ {

	public static volatile SingularAttribute<StudentGroupStudent, StudentGroup> studentGroup;
	
	public static volatile SetAttribute<StudentGroupStudent, Student> student;
}
