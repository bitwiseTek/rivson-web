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
import java.util.List;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.base.CourseBaseVariable;
import com.bitwise.manageme.rssson.domain.base.CourseEducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.users.User;

@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, Long> id;
	
	public static volatile SingularAttribute<Course, String> name;
	
	public static volatile SetAttribute<Course, User> creator;
	
	public static volatile SingularAttribute<Course, Date> created;
	
	public static volatile SetAttribute<Course, User> lastModifier;
	
	public static volatile SingularAttribute<Course, Date> lastModified;
	
	public static volatile SingularAttribute<Course, String> description;
	
	public static volatile SetAttribute<Course, Subject> subject;
	
	public static volatile SingularAttribute<Course, Integer> courseNumber;
	
	public static volatile ListAttribute<Course, List<CourseEducationType>> courseEducationTypes;
	
	public static volatile ListAttribute<Course, List<CourseBaseVariable>> variables;
	
	public static volatile SingularAttribute<Course, Integer> maxParticipantCount;
	
	public static volatile SetAttribute<Course, CourseState> state;
	
	public static volatile SetAttribute<Course, CourseType> type;
	
	public static volatile SingularAttribute<Course, String> nameExtension;
	
	public static volatile SingularAttribute<Course, Date> beginDate;
	
	public static volatile SingularAttribute<Course, Date> endDate;
	
	public static volatile SingularAttribute<Course, Double> distanceTeachingDays;
	
	public static volatile SingularAttribute<Course, Double> distanceTeachingHours;
	
	public static volatile SingularAttribute<Course, Double> planningHours;
	
	public static volatile SingularAttribute<Course, Double> localTeachingDays;
	
	public static volatile SingularAttribute<Course, Double> teachingHours;
	
	public static volatile SingularAttribute<Course, Double> assessingHours;
	
	public static volatile ListAttribute<Course, List<CourseComponent>> courseComponents;
	
	public static volatile ListAttribute<Course, List<BasicCourseResource>> basicCourseResources;
	
	public static volatile ListAttribute<Course, List<StudentCourseResource>> studentCourseResources;
	
	public static volatile ListAttribute<Course, List<GradeCourseResource>> gradeCourseResources;
	
	public static volatile ListAttribute<Course, List<OtherCost>> otherCosts;
	
	public static volatile SingularAttribute<Course, Date> enrolmentTimeEnd;
	
	public static volatile SingularAttribute<Course, Boolean> archived;
	
	public static volatile SingularAttribute<Course, BigDecimal> courseFee;
	
	public static volatile SingularAttribute<Course, Currency> courseFeeCurrency;

}
