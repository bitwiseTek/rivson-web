package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;

@StaticMetamodel(CourseAssessmentRequest.class)
public abstract class CourseAssessmentRequest_ {

	public static volatile SingularAttribute<CourseAssessmentRequest, Long> id;
	
	public static volatile SetAttribute<CourseAssessmentRequest, CourseStudent> courseStudent;
	
	public static volatile SingularAttribute<CourseAssessmentRequest, String> requestText;
	
	public static volatile SingularAttribute<CourseAssessmentRequest, Date> created;
	
	public static volatile SingularAttribute<CourseAssessmentRequest, Boolean> archived;
}
