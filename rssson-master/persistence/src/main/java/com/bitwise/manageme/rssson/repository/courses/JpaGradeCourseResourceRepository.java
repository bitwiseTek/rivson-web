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
import com.bitwise.manageme.rssson.domain.courses.GradeCourseResource;
import com.bitwise.manageme.rssson.domain.courses.GradeCourseResource_;

@Repository("gradeCourseResourceRpository")
public class JpaGradeCourseResourceRepository implements GradeCourseResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaGradeCourseResourceRepository.class);
	
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
	public void delete(GradeCourseResource gradeCourseResource) {
		logger.info("Deleting grade course resource with ID " + gradeCourseResource.getId());
		this.em.remove(gradeCourseResource);
	}

	@Override
	public void delete(Iterable<? extends GradeCourseResource> arg0) {
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
	public Iterable<GradeCourseResource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeCourseResource findOne(Long id) {
		return this.em.createNamedQuery("GradeCourseResource.findById", GradeCourseResource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends GradeCourseResource> S save(S gradeCourseResource) {
		logger.info("Adding grade course resource with ID " + gradeCourseResource.getId());
		return this.em.merge(gradeCourseResource);
	}

	@Override
	public <S extends GradeCourseResource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeCourseResource> findAll() {
		return this.em.createNamedQuery("GradeCourseResource.findAll", GradeCourseResource.class).getResultList();
	}

	@Override
	public List<GradeCourseResource> findByCourse(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<GradeCourseResource> query = cb.createQuery(GradeCourseResource.class);
		Root<GradeCourseResource> gradeCourseResource = query.from(GradeCourseResource.class);
		query.select(gradeCourseResource);
		query.where(cb.equal(gradeCourseResource.get(GradeCourseResource_.course), course));
		return em.createQuery(query).getResultList();
	}

}
