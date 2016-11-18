package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface CourseStudentRepository extends CrudRepository<CourseStudent, Long> {

	public List<CourseStudent> findAll();
	
	public List<CourseStudent> findByStudents(Student student);
	
	public Long countByCourse(Course course);
	
	public List<CourseStudent> findByCoursesAndParticipationTypesIncludeArchived(Course course, List<String> participationTypes);
	
	public List<CourseStudent> findByCoursesIncludeArchived(Course course);
	
	public List<CourseStudent> findByCoursesAndParticipationTypes(Course course, List<String> participationTypes);
	
	public List<CourseStudent> findByCourses(Course course);
	
	public CourseStudent findByCourseAndStudent(Course course, Student student);
}
