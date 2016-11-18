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

import com.bitwise.manageme.rssson.domain.courses.CourseComponent;
import com.bitwise.manageme.rssson.domain.courses.CourseComponentResource;
import com.bitwise.manageme.rssson.domain.courses.CourseComponentResource_;

@Repository("courseComponentResourceRepository")
public class JpaCourseComponentResourceRepository implements CourseComponentResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseComponentResourceRepository.class);
	
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
	public void delete(CourseComponentResource courseComponentResource) {
		logger.info("Deleting course component resource with ID " + courseComponentResource.getId());
		this.em.remove(courseComponentResource);
	}

	@Override
	public void delete(Iterable<? extends CourseComponentResource> arg0) {
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
	public Iterable<CourseComponentResource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseComponentResource findOne(Long id) {
		return this.em.createNamedQuery("CourseComponentResource.findById", CourseComponentResource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseComponentResource> S save(S courseComponentResource) {
		logger.info("Adding course component resource with ID " + courseComponentResource.getId());
		return this.em.merge(courseComponentResource);
	}

	@Override
	public <S extends CourseComponentResource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseComponentResource> findAll() {
		return this.em.createNamedQuery("CourseComponentResource.findAll", CourseComponentResource.class).getResultList();
	}

	@Override
	public List<CourseComponentResource> findByCourseComponents(CourseComponent courseComponent) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseComponentResource> query = cb.createQuery(CourseComponentResource.class);
		Root<CourseComponentResource> courseComponentResource = query.from(CourseComponentResource.class);
		query.select(courseComponentResource);
		query.where(cb.equal(courseComponentResource.get(CourseComponentResource_.courseComponent), courseComponent));
		return em.createQuery(query).getResultList();
	}

}
