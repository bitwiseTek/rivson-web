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

@StaticMetamodel(StudentContactLogEntryComment.class)
public abstract class StudentContactLogEntryComment_ {

	public static volatile SingularAttribute<StudentContactLogEntryComment, Boolean> archived;
	
	public static volatile SetAttribute<StudentContactLogEntryComment, StudentContactLogEntry> entry;
}
