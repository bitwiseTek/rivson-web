package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessment;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CourseAssessmentService {

	public List<CourseAssessment> findAll();
	
	public List<CourseAssessment> findByStudents(Student student);
	
	public List<CourseAssessment> findAByStudentsAndSubjects(Student student, Subject subject);
	
	public List<CourseAssessment> findByStudentsAndCourses(Student student, Course course);
	
	public CourseAssessment findByCourseStudent(CourseStudent courseStudent);
	
	public Long countByStudent(Student student);
	
	public CourseAssessment save(CourseAssessment courseAssessment);
	
}
