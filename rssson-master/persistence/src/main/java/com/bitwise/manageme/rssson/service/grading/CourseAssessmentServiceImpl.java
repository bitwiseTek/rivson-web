package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessment;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.grading.CourseAssessmentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseAssessmentService")
public class CourseAssessmentServiceImpl implements CourseAssessmentService {

	@Autowired
	private CourseAssessmentRepository courseAssessmentRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessment> findAll() {
		return Lists.newArrayList(this.courseAssessmentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessment> findByStudents(Student student) {
		return this.courseAssessmentRepo.findByStudents(student);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessment> findAByStudentsAndSubjects(Student student, Subject subject) {
		return this.courseAssessmentRepo.findAByStudentsAndSubjects(student, subject);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessment> findByStudentsAndCourses(Student student, Course course) {
		return this.courseAssessmentRepo.findByStudentsAndCourses(student, course);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseAssessment findByCourseStudent(CourseStudent courseStudent) {
		return this.courseAssessmentRepo.findByCourseStudent(courseStudent);
	}

	@Override
	public Long countByStudent(Student student) {
		return this.courseAssessmentRepo.countByStudent(student);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseAssessment save(CourseAssessment courseAssessment) {
		return this.courseAssessmentRepo.save(courseAssessment);
	}

}
