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

import com.bitwise.manageme.rssson.domain.projects.StudentProject;

@StaticMetamodel(ProjectAssessment.class)
public abstract class ProjectAssessment_ {

	public static volatile SingularAttribute<ProjectAssessment, Boolean> archived;
	
	public static volatile SetAttribute<ProjectAssessment, StudentProject> studentProject;
}
