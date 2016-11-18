package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
 *
 */
import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;

@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Long> id;
	
	public static volatile SingularAttribute<Student, String> firstName;
	
	public static volatile SingularAttribute<Student, String> lastName;
	
	public static volatile SingularAttribute<Student, Boolean> archived;
	
	public static volatile SingularAttribute<Student, String> nickname;
	
	public static volatile SingularAttribute<Student, String> additionalInfo;
	
	public static volatile SetAttribute<Student, String> nationality;
	
	public static volatile SetAttribute<Student, StudentActivityType> activityType;
	
	public static volatile SetAttribute<Student, StudentExaminationType> examinationType;
	
	public static volatile SetAttribute<Student, StudentEducationalLevel> educationalLevel;
	
	public static volatile SetAttribute<Student, StudyProgramme> studyProgramme;
	
	public static volatile SingularAttribute<Student, Date> studyTimeEnd;
	
	public static volatile SingularAttribute<Student, Double> previousStudies;
	
	public static volatile SingularAttribute<Student, String> education;
	
	public static volatile SingularAttribute<Student, Boolean> lodging;
	
	public static volatile SingularAttribute<Student, Date> studyStartDate;
	
	public static volatile SingularAttribute<Student, Date> studyEndDate;
	
	public static volatile SingularAttribute<Student, StudentStudyEndReason> studyEndReason;
	
	public static volatile SingularAttribute<Student, String> studyEndText;
}
