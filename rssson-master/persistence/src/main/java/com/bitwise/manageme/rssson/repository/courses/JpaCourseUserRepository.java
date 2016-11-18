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
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.domain.courses.CourseUser_;

@Repository("courseUserRepository")
public class JpaCourseUserRepository implements CourseUserRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseUserRepository.class);
	
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
	public void delete(CourseUser arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseUser> arg0) {
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
	public Iterable<CourseUser> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseUser findOne(Long id) {
		return this.em.createNamedQuery("CourseUser.findById", CourseUser.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseUser> S save(S courseUser) {
		logger.info("Adding course user with ID " + courseUser.getId());
		return this.em.merge(courseUser);
	}

	@Override
	public <S extends CourseUser> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseUser> findAll() {
		return this.em.createNamedQuery("CourseUser.findAll", CourseUser.class).getResultList();
	}

	@Override
	public List<CourseUser> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseUser> query = cb.createQuery(CourseUser.class);
		Root<CourseUser> courseUser = query.from(CourseUser.class);
		query.select(courseUser);
		query.where(cb.equal(courseUser.get(CourseUser_.course), course));
		return em.createQuery(query).getResultList();
	}

}
