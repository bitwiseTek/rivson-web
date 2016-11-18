package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent_;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessmentRequest;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessmentRequest_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("courseAssessmentRequest")
public class JpaCourseAssessmentRequestRepository implements CourseAssessmentRequestRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseAssessmentRequestRepository.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CourseAssessmentRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseAssessmentRequest> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CourseAssessmentRequest> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseAssessmentRequest findOne(Long id) {
		return this.em.createNamedQuery("CourseAssessmentRequest.findById", CourseAssessmentRequest.class).setParameter("id", id).getSingleResult();

	}

	@Override
	public <S extends CourseAssessmentRequest> S save(S car) {
		logger.info("Adding course assessment request with ID " + car.getId());
		return this.em.merge(car);
	}

	@Override
	public <S extends CourseAssessmentRequest> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseAssessmentRequest> findAll() {
		return this.em.createNamedQuery("CourseAssessmentRequest.findAll", CourseAssessmentRequest.class).getResultList();

	}

	@Override
	public List<CourseAssessmentRequest> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessmentRequest> query = cb.createQuery(CourseAssessmentRequest.class);
		Root<CourseAssessmentRequest> car = query.from(CourseAssessmentRequest.class);
		Join<CourseAssessmentRequest, CourseStudent> courseStudentJoin = car.join(CourseAssessmentRequest_.courseStudent);
		query.select(car);
		query.where(cb.and(cb.equal(courseStudentJoin.get(CourseStudent_.student), student), 
				cb.equal(car.get(CourseAssessmentRequest_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseAssessmentRequest> findByCoursesAndStudents(Course course, Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessmentRequest> query = cb.createQuery(CourseAssessmentRequest.class);
		Root<CourseAssessmentRequest> car = query.from(CourseAssessmentRequest.class);
		Join<CourseAssessmentRequest, CourseStudent> courseStudentJoin = car.join(CourseAssessmentRequest_.courseStudent);
		query.select(car);
		query.where(cb.and(cb.equal(courseStudentJoin.get(CourseStudent_.student), student), 
				cb.equal(courseStudentJoin.get(CourseStudent_.course), course),
				cb.equal(car.get(CourseAssessmentRequest_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseAssessmentRequest> findByCourseStudents(CourseStudent courseStudent) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessmentRequest> query = cb.createQuery(CourseAssessmentRequest.class);
		Root<CourseAssessmentRequest> car = query.from(CourseAssessmentRequest.class);
		query.select(car);
		query.where(cb.and(cb.equal(car.get(CourseAssessmentRequest_.courseStudent), courseStudent), 
				cb.equal(car.get(CourseAssessmentRequest_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
