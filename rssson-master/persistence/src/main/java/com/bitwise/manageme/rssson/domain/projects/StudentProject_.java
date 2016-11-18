package com.bitwise.manageme.rssson.domain.projects;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.students.Student;

@StaticMetamodel(StudentProject.class)
public abstract class StudentProject_ {

	public static volatile SingularAttribute<StudentProject, Long> id;
	
	public static volatile SetAttribute<StudentProject, Project> project;
	
	public static volatile SingularAttribute<StudentProject, Boolean> archived;
	
	public static volatile SetAttribute<StudentProject, Student> student;
}
