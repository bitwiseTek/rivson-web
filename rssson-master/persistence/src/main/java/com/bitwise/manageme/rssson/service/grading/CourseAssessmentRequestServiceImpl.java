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

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessmentRequest;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.grading.CourseAssessmentRequestRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("courseAssessmentRequestService")
public class CourseAssessmentRequestServiceImpl implements CourseAssessmentRequestService {

	@Autowired
	private CourseAssessmentRequestRepository courseAssessmentRequestRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessmentRequest> findAll() {
		return Lists.newArrayList(this.courseAssessmentRequestRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessmentRequest> findByStudents(Student student) {
		return this.courseAssessmentRequestRepo.findByStudents(student);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessmentRequest> findByCoursesAndStudents(Course course, Student student) {
		return this.courseAssessmentRequestRepo.findByCoursesAndStudents(course, student);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseAssessmentRequest> findByCourseStudents(CourseStudent courseStudent) {
		return this.courseAssessmentRequestRepo.findByCourseStudents(courseStudent);
	}

	@Override
	@Transactional(readOnly=false)
	public CourseAssessmentRequest save(CourseAssessmentRequest assessmentRequest) {
		return this.courseAssessmentRequestRepo.save(assessmentRequest);
	}

}
