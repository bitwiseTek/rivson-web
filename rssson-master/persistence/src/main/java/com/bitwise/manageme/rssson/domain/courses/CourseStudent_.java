package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.students.Student;

@StaticMetamodel(CourseStudent.class)
public abstract class CourseStudent_ {
	
public static volatile SingularAttribute<CourseStudent, Long> id;
	
	public static volatile SingularAttribute<CourseStudent, Date> enrolmentTime;
	
	public static volatile SetAttribute<CourseStudent, Student> student;
	
	public static volatile SetAttribute<CourseStudent, String> participationType;
	
	public static volatile SetAttribute<CourseStudent, String> courseEnrolmentType;
	
	public static volatile SetAttribute<CourseStudent, com.bitwise.manageme.rssson.domain.base.CourseOptionality> optionality;
	
	public static volatile SingularAttribute<CourseStudent, com.bitwise.manageme.rssson.domain.base.BillingDetails> billingDetails;
	
	public static volatile SetAttribute<CourseStudent, BigDecimal> lodgingFee;
	
	public static volatile SetAttribute<CourseStudent, Currency> lodgingFeeFrequency;
	
	public static volatile SetAttribute<CourseStudent, com.bitwise.manageme.rssson.domain.accommodation.Room> room;
	
	public static volatile SingularAttribute<CourseStudent, Boolean> archived;
	
	public static volatile SetAttribute<CourseStudent, Course> course;
	
	public static volatile SingularAttribute<CourseStudent, String> organization;
	
	public static volatile SingularAttribute<CourseStudent, String> additionalInfo;

}
