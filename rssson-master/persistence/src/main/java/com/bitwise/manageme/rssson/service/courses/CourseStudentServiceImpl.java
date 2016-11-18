package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.courses.CourseStudentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseStudentService")
public class CourseStudentServiceImpl implements CourseStudentService {

	@Autowired
	private CourseStudentRepository courseStudentRepo;
	
	@Override
	public List<CourseStudent> findAll() {
		return Lists.newArrayList(this.courseStudentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStudent> findByStudents(Student student) {
		return this.courseStudentRepo.findByStudents(student);
	}

	@Override
	public Long countByCourse(Course course) {
		return this.courseStudentRepo.countByCourse(course);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStudent> findByCoursesAndParticipationTypesIncludeArchived(Course course, List<String> participationTypes) {
		return this.courseStudentRepo.findByCoursesAndParticipationTypesIncludeArchived(course, participationTypes);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStudent> findByCoursesIncludeArchived(Course course) {
		return this.courseStudentRepo.findByCoursesIncludeArchived(course);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStudent> findByCoursesAndParticipationTypes(Course course, List<String> participationTypes) {
		return this.courseStudentRepo.findByCoursesAndParticipationTypes(course, participationTypes);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseStudent> findByCourses(Course course) {
		return this.findByCourses(course);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseStudent findByCourseAndStudent(Course course, Student student) {
		return this.courseStudentRepo.findByCourseAndStudent(course, student);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseStudent save(CourseStudent courseStudent) {
		return this.courseStudentRepo.save(courseStudent);
	}

	@Override
	public void delete(CourseStudent courseStudent) {
		this.courseStudentRepo.delete(courseStudent);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseStudent findById(Long id) {
		return this.courseStudentRepo.findOne(id);
	}

}
