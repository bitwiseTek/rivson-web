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

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent_;
import com.bitwise.manageme.rssson.domain.courses.Course_;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessment;
import com.bitwise.manageme.rssson.domain.grading.CourseAssessment_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("courseAssessmentRepository")
public class JpaCourseAssessmentRepository implements CourseAssessmentRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseAssessmentRepository.class);
	
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
	public void delete(CourseAssessment arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseAssessment> arg0) {
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
	public Iterable<CourseAssessment> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseAssessment findOne(Long id) {
		return this.em.createNamedQuery("CourseAssessment.findById", CourseAssessment.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseAssessment> S save(S ca) {
		logger.info("Adding course assessment with ID " + ca.getId());
		return this.em.merge(ca);
	}

	@Override
	public <S extends CourseAssessment> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseAssessment> findAll() {
		return this.em.createNamedQuery("CourseAssessment.findAll", CourseAssessment.class).getResultList();
	}

	@Override
	public List<CourseAssessment> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessment> query = cb.createQuery(CourseAssessment.class);
		Root<CourseAssessment> ca = query.from(CourseAssessment.class);
		Join<CourseAssessment, CourseStudent> courseStudentJoin = ca.join(CourseAssessment_.courseStudent);
		Join<CourseStudent, Course> courseJoin = courseStudentJoin.join(CourseStudent_.course);
		query.select(ca);
		query.where(cb.and(cb.equal(courseStudentJoin.get(CourseStudent_.student), student), 
				cb.equal(ca.get(CourseAssessment_.archived), Boolean.FALSE), 
				cb.equal(courseJoin.get(Course_.archived), Boolean.FALSE), 
				cb.equal(courseStudentJoin.get(CourseStudent_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseAssessment> findAByStudentsAndSubjects(Student student, Subject subject) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessment> query = cb.createQuery(CourseAssessment.class);
		Root<CourseAssessment> ca = query.from(CourseAssessment.class);
		Join<CourseAssessment, CourseStudent> courseStudentJoin = ca.join(CourseAssessment_.courseStudent);
		Join<CourseStudent, Course> courseJoin = courseStudentJoin.join(CourseStudent_.course);
		query.select(ca);
		query.where(cb.and(cb.equal(courseStudentJoin.get(CourseStudent_.student), student), 
				cb.equal(ca.get(CourseAssessment_.archived), Boolean.FALSE), 
				cb.equal(courseJoin.get(Course_.archived), Boolean.FALSE), 
				cb.equal(courseJoin.get(Course_.subject), subject), 
				cb.equal(courseStudentJoin.get(CourseStudent_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseAssessment> findByStudentsAndCourses(Student student, Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessment> query = cb.createQuery(CourseAssessment.class);
		Root<CourseAssessment> ca = query.from(CourseAssessment.class);
		Join<CourseAssessment, CourseStudent> courseStudentJoin = ca.join(CourseAssessment_.courseStudent);
		Join<CourseStudent, Course> courseJoin = courseStudentJoin.join(CourseStudent_.course);
		query.select(ca);
		query.where(cb.and(cb.equal(courseStudentJoin.get(CourseStudent_.student), student), 
				cb.equal(courseStudentJoin.get(CourseStudent_.course), course),
				cb.equal(ca.get(CourseAssessment_.archived), Boolean.FALSE), 
				cb.equal(courseJoin.get(Course_.archived), Boolean.FALSE), 
				cb.equal(courseStudentJoin.get(CourseStudent_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public CourseAssessment findByCourseStudent(CourseStudent courseStudent) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseAssessment> query = cb.createQuery(CourseAssessment.class);
		Root<CourseAssessment> ca = query.from(CourseAssessment.class);
		query.select(ca);
		query.where(cb.equal(ca.get(CourseAssessment_.courseStudent), courseStudent));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public Long countByStudent(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<CourseAssessment> ca = query.from(CourseAssessment.class);
		Join<CourseAssessment, CourseStudent> courseStudentJoin = ca.join(CourseAssessment_.courseStudent);
		query.select(cb.count(ca));
		query.where(cb.and(cb.equal(courseStudentJoin.get(CourseStudent_.student), student), 
				cb.equal(ca.get(CourseAssessment_.archived), Boolean.FALSE), 
				cb.equal(courseStudentJoin.get(CourseStudent_.archived), Boolean.FALSE)));
		return em.createQuery(query).getSingleResult();
	}

}
