package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;
import com.bitwise.manageme.rssson.domain.base.AcademicSemester;
import com.bitwise.manageme.rssson.domain.base.ComponentBase;
import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.base.EducationSubtype;
import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;
import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;
import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.base.VariableType;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.domain.courses.CourseState;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseType;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.domain.grading.Grade;
import com.bitwise.manageme.rssson.domain.grading.GradingScale;
import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.domain.security.Role;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentActivityType;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;
import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;
import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupStudent;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.domain.support.EntityBuilder.EntityBuilderManager;
import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey;

public class InitialDataSetup {
	
	public InitialDataSetup(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@PersistenceContext
	private EntityManager em;
	
	private Role role = new Role();
	
	private TransactionTemplate transactionTemplate;
	
	private AcademicSemester academicSemester;
	
	private ComponentBase componentBase;
	
	private CourseBase courseBase;
	
	private CourseBase courseBaseName;
	
	private CourseBaseVariableKey courseBaseVariableKey;
	
	private Course course;
	
	private CourseComponent courseComponent;
	
	private CourseState courseState;
	
	private CourseState courseStateName;
	
	private CourseStudent courseStudent;
	
	private CourseType courseType;
	
	private CourseType courseTypeName;
	
	private CourseUser courseUser;
	
	private CourseUser courseUserName;
	
	private EducationalLength educationalLength;
	
	private EducationalLength educationalLengthUnit;
	
	private EducationalTimeUnit educationalTimeUnit;
	
	private EducationSubtype educationSubtype;
	
	private EducationType educationType;
	
	private Grade grade;
	
	private GradingScale gradingScale;
	
	private LGA lga;
	
	private Project project;
	
	private Room room;
	
	private RoomType roomType;
	
	private StaffMember staffMember;
	
	private StudentActivityType studentActivityType;
	
	private Student student;
	
	private Student studentId;
	
	private StudentContactLogEntry studentContactLogEntry;
	
	private StudentEducationalLevel studentEducationalLevel;
	
	private StudentExaminationType studentExaminationType;
	
	private StudentGroup studentGroup;
	
	private StudentGroupStudent studentGroupStudent;
	
	private StudentStudyEndReason studentStudyEndReason;
	
	private StudentStudyEndReason parentReason;
	
	private StudyProgramme studyProgramme;
	
	private StudyProgrammeCategory studyProgrammeCategory;
	
	private StudyProgrammeCategory studyProgrammeCategoryName;
	
	private String state;
	
	private Subject subject;
	
	private User user;
	
	private User modifier;
	
	private User userRole = new User();
	
	private UserVariableKey userVariableKey;
	
	public void initialize() {
		EntityBuilderManager.setEntityManager(em);
		this.transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus status) {
				if (dataIsAlreadyPresent()) {
					return null;
				}
				
				//Tables Creation
				
				//GradingScale
				{
					InitialDataSetup.this.gradingScale = new GradingScaleBuilder() {
						{
							scale("4.0", "4.0 Grading Scale", false);
						}
					}.build();
					
					new GradingScaleBuilder() {
						{
							scale("5.0", "5.0 Grading Scale", false);
						}
					}.build();
				}
				
				//Grade
				{
					InitialDataSetup.this.grade = new GradeBuilder() {
						{
							gradingScale(InitialDataSetup.this.gradingScale);
							grade("A", "Excellent", false, false, "Excellent", 5.0);
						}
					}.build();
					
					new GradeBuilder() {
						{
							gradingScale(InitialDataSetup.this.gradingScale);
							grade("B", "Good", false, false, "Good", 4.0);
						}
					}.build();
					
					new GradeBuilder() {
						{
							gradingScale(InitialDataSetup.this.gradingScale);
							grade("C", "Average", false, false, "Pass", 3.0);
						}
					}.build();
					
					new GradeBuilder() {
						{
							gradingScale(InitialDataSetup.this.gradingScale);
							grade("D", "Poor", false, false, "Pass", 2.0);
						}
					}.build();
					
					new GradeBuilder() {
						{
							gradingScale(InitialDataSetup.this.gradingScale);
							grade("E", "Very Poor", false, false, "Pass", 1.0);
						}
					}.build();
					
					new GradeBuilder() {
						{
							gradingScale(InitialDataSetup.this.gradingScale);
							grade("F", "Fail", false, false, "Fail", 0.00);
						}
					}.build();
				}
				
				//Role
				{
					InitialDataSetup.this.role = new RoleBuilder() {
						{
							role("ROLE_SUPER_ADMIN");
						}
					}.build();
					
					new RoleBuilder() {
						{
							role("ROLE_ADMIN");
						}
					}.build();
					
					new RoleBuilder() {
						{
							role("ROLE_STUDENT");
						}
					}.build();
					
					new RoleBuilder() {
						{
							role("ROLE_LECTURER");
						}
					}.build();
					
					new RoleBuilder() {
						{
							role("ROLE_STAFF");
						}
					}.build();
					
					new RoleBuilder() {
						{
							role("ROLE_MANAGER");
						}
					}.build();
				}
				
				//User
				{
					InitialDataSetup.this.user = new UserBuilder() {
						{
							name("Kalada", "Sika", "Tamunoemi");
							userDetails("MG/ADM/16/001", "MALE", true, true, "No 9D Nzimiro Street, Old GRA", "500251", "PHC", "Nigeria", "07083472155", "08035504051", "sika.kayy@gmail.com", null);
							archived(true);
							credentials("superadmin", "$2a$10$aqNY.kMd1h2u1MbK2JUA8./3g2VM.BAB09kzHFpz6b6NQ57PBn/fy", "$2a$10$aqNY.kMd1h2u1MbK2JUA8./3g2VM.BAB09kzHFpz6b6NQ57PBn/fy", "What is your mother's maiden name?", "Elizabeth", new DateTime(DateTime.now()), new DateTime(DateTime.now()));
							roles(InitialDataSetup.this.role, InitialDataSetup.this.userRole);
						}
					}.build();
					
					new UserBuilder() {
						{
							name("Joshua", "Ohakwere-Eze", "Tochukwu");
							userDetails("MG/ADM/16/002", "MALE", true, true, "No 3 Trinity Road, Woji", "500102", "PHC", "Nigeria", "07035248946", "08162337355", "josh4och@yahoo.com", null);
							archived(true);
							credentials("admin", "$2a$10$K.P7Jl5IS7VXiA3DLZkoZe7ANrzAK9T9sd0nsVRBva6JsUneFkfGK", "$2a$10$K.P7Jl5IS7VXiA3DLZkoZe7ANrzAK9T9sd0nsVRBva6JsUneFkfGK", "What is your favorite dish?", "Beans", new DateTime(DateTime.now()), new DateTime(DateTime.now()));
							roles(InitialDataSetup.this.role, InitialDataSetup.this.userRole);
						}
					}.build();
				}
				
				//LGA
				{
					InitialDataSetup.this.lga = new LGABuilder() {
						{
							lga("Port-Harcourt", "PH", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Obio-Akpor","OA", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Ogu-Bolo","OG", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Eleme","EL", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Gokana","GK", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Khana","KH", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Oyigbo","OY", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Opobo-Nkoro","ON", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Andoni","AN", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Bonny","BO", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Degema","DG", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Asari-Toru","AS", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Akuku-Toru","AK", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Abua-Odual","AB", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Ahoada-West","AW", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Ahoada-East","AE", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Ogba-Egbema-Ndoni","OE", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Emuoha","EM", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Ikwerre","IK", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Omuma","OM", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Okrika","OK", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Etche","ET", false);
						}
					}.build();
					
					new LGABuilder() {
						{
							lga("Tai","TA", false);
						}
					}.build();
				}
				
				//AcademicSemester
				{
					InitialDataSetup.this.academicSemester = new AcademicSemesterBuilder() {
						{
							semester("1st Semester", new Date(), new Date(), "2016/2017", false);
						}
					}.build();
					
					new AcademicSemesterBuilder() {
						{
							semester("2nd Semester", new Date(), new Date(), "2016/2017", false);
						}
					}.build();
				}
				
				//EducationType
				{
					InitialDataSetup.this.educationType = new EducationTypeBuilder() {
						{
							educationType("Post-Basic", "PBA", false);
						}
					}.build();
					
					new EducationTypeBuilder() {
						{
							educationType("Nursery", "NUR", false);
						}
					}.build();
					
					new EducationTypeBuilder() {
						{
							educationType("Primary", "PRI", false);
						}
					}.build();
					
					new EducationTypeBuilder() {
						{
							educationType("Secondary", "SEC", false);
						}
					}.build();
					
					new EducationTypeBuilder() {
						{
							educationType("Tertiary", "TER", false);
						}
					}.build();
					
					new EducationTypeBuilder() {
						{
							educationType("College", "COL", false);
						}
					}.build();
					
					new EducationTypeBuilder() {
						{
							educationType("Nursery/Primary/Secondary", "NPA", false);
						}
					}.build();
				}
				
				//EducationSubtype
				{
					InitialDataSetup.this.educationSubtype = new EducationSubtypeBuilder() {
						{
							educationType(InitialDataSetup.this.educationType);
							subtype("Test Subtype #1", "TST1", false);
						}
					}.build();
					
					new EducationSubtypeBuilder() {
						{
							educationType(InitialDataSetup.this.educationType);
							subtype("Test Subtype #2", "TST2", false);
						}
					}.build();
					
					new EducationSubtypeBuilder() {
						{
							educationType(InitialDataSetup.this.educationType);
							subtype("Test Subtype #3", "TST3", false);
						}
					}.build();
					
					new EducationSubtypeBuilder() {
						{
							educationType(InitialDataSetup.this.educationType);
							subtype("Test Subtype #4", "TST4", false);
						}
					}.build();
				}
				
				//EducationalTimeUnit
				{
					InitialDataSetup.this.educationalTimeUnit = new EducationalTimeUnitBuilder() {
						{
							unit("NSN-Hour", 2880.0, "HR", false);
						}
					}.build();
					
					new EducationalTimeUnitBuilder() {
						{
							unit("NSN-Week", 72.0, "WK", false);
						}
					}.build();
				}
				
				//EducationalLength
				{
					InitialDataSetup.this.educationalLength = new EducationalLengthBuilder() {
						{
							educationalTimeUnit(InitialDataSetup.this.educationalTimeUnit);
							length(300.0);
						}
					}.build();
					
					new EducationalLengthBuilder() {
						{
							educationalTimeUnit(InitialDataSetup.this.educationalTimeUnit);
							length(130.0);
						}
					}.build();
				}
				
				//CourseBase
				{
					InitialDataSetup.this.courseBase = new CourseBaseBuilder() {
						{
							user(InitialDataSetup.this.user);
							modifier(InitialDataSetup.this.modifier);
							educationalLength(InitialDataSetup.this.educationalLength);
							educationalLengthUnit(InitialDataSetup.this.educationalLengthUnit);
							courseBaseDetails("NSN", "Nursing", "Nursing", new DateTime(System.currentTimeMillis()), new DateTime(System.currentTimeMillis()), 100l);
							archived(false);
						}
					}.build();
					
					new CourseBaseBuilder() {
						{
							user(InitialDataSetup.this.user);
							modifier(InitialDataSetup.this.modifier);
							educationalLength(InitialDataSetup.this.educationalLength);
							educationalLengthUnit(InitialDataSetup.this.educationalLengthUnit);
							courseBaseDetails("MWF", "Midwifery", "Midwifery", new DateTime(System.currentTimeMillis()), new DateTime(System.currentTimeMillis()), 150l);
							archived(false);
						}
					}.build();
				}
				
				//CourseState
				{
					InitialDataSetup.this.courseState = new CourseStateBuilder() {
						{
							courseState("In Progress", false);
						}
					}.build();
					
					new CourseStateBuilder() {
						{
							courseState("Planning", false);
						}
					}.build();
					
					new CourseStateBuilder() {
						{
							courseState("Ended", false);
						}
					}.build();
				}
				
				//Course Type
				{
					InitialDataSetup.this.courseType = new CourseTypeBuilder() {
						{
							type("Post-Basic", false);
						}
					}.build();
					
					new CourseTypeBuilder() {
						{
							type("Nursery", false);
						}
					}.build();
					
					new CourseTypeBuilder() {
						{
							type("Primary", false);
						}
					}.build();
					
					new CourseTypeBuilder() {
						{
							type("Secondary", false);
						}
					}.build();
					
					new CourseTypeBuilder() {
						{
							type("Tertiary", false);
						}
					}.build();
					
					new CourseTypeBuilder() {
						{
							type("College", false);
						}
					}.build();
					
					new CourseTypeBuilder() {
						{
							type("Nursery/Primary/Secondary", false);
						}
					}.build();
				}
				
				//ComponentBase
				{
					InitialDataSetup.this.componentBase = new ComponentBaseBuilder() {
						{
							educationalLength(InitialDataSetup.this.educationalLength);
							base("Test Module #1 Component #1", "Module component for testing #1", false);
						}
					}.build();
					
					new ComponentBaseBuilder() {
						{
							educationalLength(InitialDataSetup.this.educationalLength);
							base("Test Module #2 Component #2", "Module component for testing #2", false);
						}
					}.build();
					
					new ComponentBaseBuilder() {
						{
							educationalLength(InitialDataSetup.this.educationalLength);
							base("Test Course #1 Component #1", "Course component for testing #1", false);
						}
					}.build();
					
					new ComponentBaseBuilder() {
						{
							educationalLength(InitialDataSetup.this.educationalLength);
							base("Test Course #1 Component #2", "Test component for testing #2", false);
						}
					}.build();
					
					new ComponentBaseBuilder() {
						{
							educationalLength(InitialDataSetup.this.educationalLength);
							base("Test Course #2 Component #1", "Course component for testing #1", false);
						}
					}.build();
					
					new ComponentBaseBuilder() {
						{
							educationalLength(InitialDataSetup.this.educationalLength);
							base("Test Course #2 Component #2", "Course component for testing #2", false);
						}
					}.build();
				}
				
				//RoomType
				{
					InitialDataSetup.this.roomType = new RoomTypeBuilder() {
						{
							type("Single Room");
						}
					}.build();
					
					new RoomTypeBuilder() {
						{
							type("Double Room");
						}
					}.build();
				}
				
				//Course
				{
					InitialDataSetup.this.course = new CourseBuilder() {
						{
							courseBase(InitialDataSetup.this.courseBase);
							courseState(InitialDataSetup.this.courseState);
							courseType(InitialDataSetup.this.courseType);
							courseDetails("Registered Nurse Educator", 40.0, new Date(System.currentTimeMillis()), 30.0, 20.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 20.0, 20.0, 10.0);
						}
					}.build();
					
					new CourseBuilder() {
						{
							courseBase(InitialDataSetup.this.courseBase);
							courseState(InitialDataSetup.this.courseState);
							courseType(InitialDataSetup.this.courseType);
							courseDetails("Registered Midwife", 30.0, new Date(System.currentTimeMillis()), 20.0, 10.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 10.0, 10.0, 10.0);
						}
					}.build();
				}
				
				//CourseComponent
				{
					InitialDataSetup.this.courseComponent = new CourseComponentBuilder() {
						{
							course(InitialDataSetup.this.course);
							courseBase(InitialDataSetup.this.courseBase);
						}
					}.build();
					
					new CourseComponentBuilder() {
						{
							course(InitialDataSetup.this.course);
							courseBase(InitialDataSetup.this.courseBase);
						}
					}.build();
					
					new CourseComponentBuilder() {
						{
							course(InitialDataSetup.this.course);
							courseBase(InitialDataSetup.this.courseBase);
						}
					}.build();
					
					new CourseComponentBuilder() {
						{
							course(InitialDataSetup.this.course);
							courseBase(InitialDataSetup.this.courseBase);
						}
					}.build();
				}
				
				//Project
				{
					InitialDataSetup.this.project = new ProjectBuilder() {
						{
							user(InitialDataSetup.this.user);
							modifier(InitialDataSetup.this.modifier);
							educationalLength(InitialDataSetup.this.educationalLength);
							projectDetails("Test Project #1", "Project for Testing #1", new Date(), new Date(), false);
						}
					}.build();
					
					new ProjectBuilder() {
						{
							user(InitialDataSetup.this.user);
							modifier(InitialDataSetup.this.modifier);
							educationalLength(InitialDataSetup.this.educationalLength);
							projectDetails("Test Project #2", "Project for Testing #2", new Date(), new Date(), false);
						}
					}.build();
				}
				
				//CourseBaseVariableKey
				{
					InitialDataSetup.this.courseBaseVariableKey = new CourseBaseVariableKeyBuilder() {
						{
							variableType(VariableType.valueOf("TEXT"));
							courseVariableKey("TV1", "Test Variable #1 - text", false);
						}
					}.build();
					
					new CourseBaseVariableKeyBuilder() {
						{
							variableType(VariableType.valueOf("NUMBER"));
							courseVariableKey("TV2", "Test Variable #2 - number", false);
						}
					}.build();
					
					new CourseBaseVariableKeyBuilder() {
						{
							variableType(VariableType.valueOf("BOOLEAN"));
							courseVariableKey("TV3", "Test Variable #3 - boolean", false);
						}
					}.build();
				}
				
				//StudentEducationalLevel
				{
					InitialDataSetup.this.studentEducationalLevel = new StudentEducationalLevelBuilder() {
						{
							educationalLevel("W.A.S.S.C.E", false);
						}
					}.build();
					
					new StudentEducationalLevelBuilder() {
						{
							educationalLevel("Bachelors", false);
						}
					}.build();
				}
				
				//StudentExaminationType
				{
					InitialDataSetup.this.studentExaminationType = new StudentExaminationTypeBuilder() {
						{
							examinationType("Computer-Based (CBT)", false);
						}
					}.build();
					
					new StudentExaminationTypeBuilder() {
						{
							examinationType("Paper-Based", false);
						}
					}.build();
				}
				
				//StudyProgrammeCategory
				{
					InitialDataSetup.this.studyProgrammeCategory = new StudyProgrammeCategoryBuilder() {
						{
							educationType(InitialDataSetup.this.educationType);
							programmeCategory("Taught Programme", false);
						}
					}.build();
					
					new StudyProgrammeCategoryBuilder() {
						{
							educationType(InitialDataSetup.this.educationType);
							programmeCategory("Research Programme", false);
						}
					}.build();
				}
				
				//StudyProgramme
				{
					InitialDataSetup.this.studyProgramme = new StudyProgrammeBuilder() {
						{
							studyProgrammeCategory(InitialDataSetup.this.studyProgrammeCategory);
							programme("Nurse Education", "NSN1", false);
						}
					}.build();
				}
				
				//StudentStudyEndReason
				{
					InitialDataSetup.this.studentStudyEndReason = new StudentStudyEndReasonBuilder() {
						{
							parentReason(InitialDataSetup.this.parentReason);
							reason("PROGRAMME-IN-PROGRESS");
						}
					}.build();
					
					new StudentStudyEndReasonBuilder() {
						{
							parentReason(InitialDataSetup.this.parentReason);
							reason("PROGRAMME CONCLUDED");
						}
					}.build();
				}
				return null;
			}
			
			private Boolean dataIsAlreadyPresent() {
				return InitialDataSetup.this.em.createQuery("select count(u.id) from User u", Long.class).getSingleResult().longValue() > 0;
			}
		});
		EntityBuilderManager.clearEntityManager();
	}
	
}
