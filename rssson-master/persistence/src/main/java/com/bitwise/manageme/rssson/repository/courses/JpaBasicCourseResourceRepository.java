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

import com.bitwise.manageme.rssson.domain.courses.BasicCourseResource;
import com.bitwise.manageme.rssson.domain.courses.BasicCourseResource_;
import com.bitwise.manageme.rssson.domain.courses.Course;

@Repository("basicCourseResourceRepository")
public class JpaBasicCourseResourceRepository implements BasicCourseResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaBasicCourseResourceRepository.class);
	
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
	public void delete(BasicCourseResource basicCourseResource) {
		logger.info("Deleting basic course resource with ID " + basicCourseResource.getId());
		this.em.remove(basicCourseResource);
	}

	@Override
	public void delete(Iterable<? extends BasicCourseResource> arg0) {
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
	public Iterable<BasicCourseResource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicCourseResource findOne(Long id) {
		return this.em.createNamedQuery("BasicCourseResource.findById", BasicCourseResource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends BasicCourseResource> S save(S basicCourseResource) {
		logger.info("Adding basic course resource with ID " + basicCourseResource.getId());
		return this.em.merge(basicCourseResource);
	}

	@Override
	public <S extends BasicCourseResource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasicCourseResource> findAll() {
		return this.em.createNamedQuery("BasicCourseResource.findAll", BasicCourseResource.class).getResultList();
	}

	@Override
	public List<BasicCourseResource> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<BasicCourseResource> query = cb.createQuery(BasicCourseResource.class);
		Root<BasicCourseResource> basicCourseResource = query.from(BasicCourseResource.class);
		query.select(basicCourseResource);
		query.where(cb.equal(basicCourseResource.get(BasicCourseResource_.course), course));
		return em.createQuery(query).getResultList();
	}

}
