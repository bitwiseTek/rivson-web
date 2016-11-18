package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.Collections;
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
import com.bitwise.manageme.rssson.domain.courses.Course_;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.Student_;

@Repository("courseStudentRepository")
public class JpaCourseStudentRepository implements CourseStudentRepository {

	final Logger logger =  LoggerFactory.getLogger(JpaCourseStudentRepository.class);
	
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
	public void delete(CourseStudent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseStudent> arg0) {
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
	public Iterable<CourseStudent> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStudent findOne(Long id) {
		return this.em.createNamedQuery("CourseStudent.findById", CourseStudent.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseStudent> S save(S courseStudent) {
		logger.info("Adding course student with ID " + courseStudent.getId());
		return this.em.merge(courseStudent);
	}

	@Override
	public <S extends CourseStudent> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseStudent> findAll() {
		return this.em.createNamedQuery("CourseStudent.findAll", CourseStudent.class).getResultList();
	}

	@Override
	public List<CourseStudent> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudent> query = cb.createQuery(CourseStudent.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		Join<CourseStudent, Student> studentJoin = courseStudent.join(CourseStudent_.student);
		Join<CourseStudent, Course> courseJoin = courseStudent.join(CourseStudent_.course);
		query.select(courseStudent);
		query.where(cb.and(cb.equal(courseStudent.get(CourseStudent_.student), student), 
				cb.equal(courseStudent.get(CourseStudent_.archived), Boolean.FALSE)), 
				cb.equal(courseJoin.get(Course_.archived), Boolean.FALSE), 
		cb.equal(studentJoin.get(Student_.archived), Boolean.FALSE));
		return em.createQuery(query).getResultList();
	}

	@Override
	public Long countByCourse(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		Join<CourseStudent, Student> studentJoin = courseStudent.join(CourseStudent_.student);
		query.select(cb.count(courseStudent));
		query.where(cb.and(cb.equal(courseStudent.get(CourseStudent_.course), course), 
				cb.equal(courseStudent.get(CourseStudent_.archived), Boolean.FALSE)), 
		cb.equal(studentJoin.get(Student_.archived), Boolean.FALSE));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<CourseStudent> findByCoursesAndParticipationTypesIncludeArchived(Course course, List<String> participationTypes) {
		if (participationTypes == null || participationTypes.isEmpty()) {
			return Collections.emptyList();
		}
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudent> query = cb.createQuery(CourseStudent.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		query.select(courseStudent);
		query.where(cb.and(courseStudent.get(CourseStudent_.participationType).in(participationTypes)), 
				cb.equal(courseStudent.get(CourseStudent_.course), course));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseStudent> findByCoursesIncludeArchived(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudent> query = cb.createQuery(CourseStudent.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		query.select(courseStudent);
		query.where(cb.equal(courseStudent.get(CourseStudent_.course), course));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseStudent> findByCoursesAndParticipationTypes(Course course, List<String> participationTypes) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudent> query = cb.createQuery(CourseStudent.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		Join<CourseStudent, Student> studentJoin = courseStudent.join(CourseStudent_.student);
		query.select(courseStudent);
		query.where(cb.and(courseStudent.get(CourseStudent_.participationType).in(participationTypes),
				cb.equal(courseStudent.get(CourseStudent_.course), course), 
				cb.equal(courseStudent.get(CourseStudent_.archived), Boolean.FALSE)), 
		cb.equal(studentJoin.get(Student_.archived), Boolean.FALSE));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CourseStudent> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudent> query = cb.createQuery(CourseStudent.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		Join<CourseStudent, Student> studentJoin = courseStudent.join(CourseStudent_.student);
		query.select(courseStudent);
		query.where(cb.and(cb.equal(courseStudent.get(CourseStudent_.course), course), 
				cb.equal(courseStudent.get(CourseStudent_.archived), Boolean.FALSE)), 
		cb.equal(studentJoin.get(Student_.archived), Boolean.FALSE));
		return em.createQuery(query).getResultList();
	}

	@Override
	public CourseStudent findByCourseAndStudent(Course course, Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudent> query = cb.createQuery(CourseStudent.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		query.select(courseStudent);
		query.where(cb.and(cb.equal(courseStudent.get(CourseStudent_.course), course),
				cb.equal(courseStudent.get(CourseStudent_.student), student)), 
				cb.equal(courseStudent.get(CourseStudent_.archived), Boolean.FALSE));
		return em.createQuery(query).getSingleResult();
	}

}
