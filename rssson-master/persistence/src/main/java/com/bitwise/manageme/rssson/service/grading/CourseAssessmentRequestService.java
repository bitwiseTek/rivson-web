package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessmentRequest;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CourseAssessmentRequestService {

	public List<CourseAssessmentRequest> findAll();
	
	public List<CourseAssessmentRequest> findByStudents(Student student);
	
	public List<CourseAssessmentRequest> findByCoursesAndStudents(Course course, Student student);
	
	public List<CourseAssessmentRequest> findByCourseStudents(CourseStudent courseStudent);
	
	public CourseAssessmentRequest save(CourseAssessmentRequest assessmentRequest);
	
}
