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

import com.bitwise.manageme.rssson.domain.courses.CourseType;
import com.bitwise.manageme.rssson.domain.courses.CourseType_;

@Repository("courseTypeRepository")
public class JpaCourseTypeRepository implements CourseTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseTypeRepository.class);
	
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
	public void delete(CourseType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseType> arg0) {
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
	public Iterable<CourseType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseType findOne(Long id) {
		return this.em.createNamedQuery("CourseType.findById", CourseType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseType> S save(S courseType) {
		logger.info("Adding course type with ID " + courseType.getId());
		return this.em.merge(courseType);
	}

	@Override
	public <S extends CourseType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseType> findAll() {
		return this.em.createNamedQuery("CourseType.findAll", CourseType.class).getResultList();
	}

	@Override
	public List<CourseType> findByName(String name) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseType> query = cb.createQuery(CourseType.class);
		Root<CourseType> courseType = query.from(CourseType.class);
		query.select(courseType);
		query.where(cb.equal(courseType.get(CourseType_.name), name));
		return em.createQuery(query).getResultList();
	}

}
