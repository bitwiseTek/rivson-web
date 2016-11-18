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

@StaticMetamodel(StudentGroupContactLogEntryComment.class)
public abstract class StudentGroupContactLogEntryComment_ {

	public static volatile SingularAttribute<StudentGroupContactLogEntryComment, Boolean> archived;
	
	public static volatile SetAttribute<StudentGroupContactLogEntryComment, StudentContactLogEntry> entry;
}
