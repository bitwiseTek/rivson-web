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
import com.bitwise.manageme.rssson.domain.courses.OtherCost;
import com.bitwise.manageme.rssson.domain.courses.OtherCost_;

@Repository("otherCostRepository")
public class JpaOtherCostRepository implements OtherCostRepository {

	final Logger logger = LoggerFactory.getLogger(OtherCost.class);
	
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
	public void delete(OtherCost otherCost) {
		logger.info("Deleting other cost with ID " + otherCost.getId());
		this.em.remove(otherCost);
	}

	@Override
	public void delete(Iterable<? extends OtherCost> arg0) {
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
	public Iterable<OtherCost> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OtherCost findOne(Long id) {
		return this.em.createNamedQuery("OtherCost.findById", OtherCost.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends OtherCost> S save(S otherCost) {
		logger.info("Adding other cost with ID " + otherCost.getId());
		return this.em.merge(otherCost);
	}

	@Override
	public <S extends OtherCost> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OtherCost> findAll() {
		return this.em.createNamedQuery("OtherCost.findAll", OtherCost.class).getResultList();
	}

	@Override
	public List<OtherCost> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<OtherCost> query = cb.createQuery(OtherCost.class);
		Root<OtherCost> otherCost = query.from(OtherCost.class);
		query.select(otherCost);
		query.where(cb.equal(otherCost.get(OtherCost_.course), course));
		return em.createQuery(query).getResultList();
	}

}
