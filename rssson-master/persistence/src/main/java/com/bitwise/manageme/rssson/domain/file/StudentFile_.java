package com.bitwise.manageme.rssson.domain.file;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.students.Student;

@StaticMetamodel(StudentFile.class)
public abstract class StudentFile_ {

	public static volatile SingularAttribute<StudentFile, Long> id;
	
	public static volatile SetAttribute<StudentFile, Student> student;
	
	public static volatile SingularAttribute<StudentFile, Boolean> archived;
}
