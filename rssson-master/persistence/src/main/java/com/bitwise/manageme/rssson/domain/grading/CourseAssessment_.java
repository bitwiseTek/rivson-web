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

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;

@StaticMetamodel(CourseAssessment.class)
public abstract class CourseAssessment_ {

	public static volatile SingularAttribute<CourseAssessment, Long> id;
	
	public static volatile SetAttribute<CourseAssessment, CourseStudent> courseStudent;
	
	public static volatile SingularAttribute<CourseAssessment, Boolean> archived;
}
