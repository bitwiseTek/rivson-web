package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.Course_;

@Repository("courseRepository")
public class JpaCourseRepository implements CourseRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseRepository.class);
	
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
	public void delete(Course arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Course> arg0) {
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
	public Iterable<Course> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findOne(Long id) {
		return this.em.createNamedQuery("Course.findById", Course.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Course> S save(S course) {
		logger.info("Adding course with ID " + course.getId());
		course.setBeginDate(new Date(System.currentTimeMillis()));
		return this.em.merge(course);
	}

	@Override
	public <S extends Course> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		return this.em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<Course> findBySubjects(Subject subject) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Course> query = cb.createQuery(Course.class);
		Root<Course> course = query.from(Course.class);
		query.select(course);
		query.where(cb.and(cb.equal(course.get(Course_.subject), subject), 
				cb.equal(course.get(Course_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Course> findByCourseVariables(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	} //TO DO 

	@Override
	public Course findByName(String name) {
		TypedQuery<Course> query = em.createNamedQuery("Course.findByName", Course.class).setParameter("name", name);
		List<Course> courses = query.getResultList();
		return courses.size() == 1 ? courses.get(0) : null;
	}

	//TO DO
	//1. searchCourses()
	//2. searchCoursesBasic()
}
