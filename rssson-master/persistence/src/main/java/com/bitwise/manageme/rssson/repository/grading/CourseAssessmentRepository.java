package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessment;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CourseAssessmentRepository extends CrudRepository<CourseAssessment, Long> {

	public List<CourseAssessment> findAll();
	
	public List<CourseAssessment> findByStudents(Student student);
	
	public List<CourseAssessment> findAByStudentsAndSubjects(Student student, Subject subject);
	
	public List<CourseAssessment> findByStudentsAndCourses(Student student, Course course);
	
	public CourseAssessment findByCourseStudent(CourseStudent courseStudent);
	
	public Long countByStudent(Student student);
	
}
