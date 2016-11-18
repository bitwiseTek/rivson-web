package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CourseStudentService {

	public CourseStudent findById(Long id);
	
	public List<CourseStudent> findAll();

	public List<CourseStudent> findByStudents(Student student);
	
	public Long countByCourse(Course course);
	
	public List<CourseStudent> findByCoursesAndParticipationTypesIncludeArchived(Course course, List<String> participationTypes);
	
	public List<CourseStudent> findByCoursesIncludeArchived(Course course);
	
	public List<CourseStudent> findByCoursesAndParticipationTypes(Course course, List<String> participationTypes);
	
	public List<CourseStudent> findByCourses(Course course);
	
	public CourseStudent findByCourseAndStudent(Course course, Student student);
	
	public CourseStudent save(CourseStudent courseStudent);
	
	public void delete(CourseStudent courseStudent);

	
}
