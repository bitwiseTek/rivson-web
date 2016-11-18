package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.domain.courses.CourseComponent_;

@Repository("courseComponentRepository")
public class JpaCourseComponentRepository implements CourseComponentRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseComponentRepository.class);
	
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
	public void delete(CourseComponent courseComponent) {
		logger.info("Deleting course component with ID " + courseComponent.getId());
		this.em.remove(courseComponent);
	}

	@Override
	public void delete(Iterable<? extends CourseComponent> arg0) {
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
	public Iterable<CourseComponent> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseComponent findOne(Long id) {
		return this.em.createNamedQuery("CourseComponent.findById", CourseComponent.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseComponent> S save(S courseComponent) {
		logger.info("Adding course component with ID " + courseComponent.getId());
		return this.em.merge(courseComponent);
	}

	@Override
	public <S extends CourseComponent> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseComponent> findAll() {
		return this.em.createNamedQuery("CourseComponent.findAll", CourseComponent.class).getResultList();
	}

	@Override
	public List<CourseComponent> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseComponent> query = cb.createQuery(CourseComponent.class);
		Root<CourseComponent> courseComponent = query.from(CourseComponent.class);
		query.select(courseComponent);
		query.where(cb.and(cb.equal(courseComponent.get(CourseComponent_.course), course), 
				cb.equal(courseComponent.get(CourseComponent_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
