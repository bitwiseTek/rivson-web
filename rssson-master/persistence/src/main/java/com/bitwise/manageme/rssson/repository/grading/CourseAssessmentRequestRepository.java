package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessmentRequest;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CourseAssessmentRequestRepository extends CrudRepository<CourseAssessmentRequest, Long> {

	public List<CourseAssessmentRequest> findAll();
	
	public List<CourseAssessmentRequest> findByStudents(Student student);
	
	public List<CourseAssessmentRequest> findByCoursesAndStudents(Course course, Student student);
	
	public List<CourseAssessmentRequest> findByCourseStudents(CourseStudent courseStudent);
	
}
