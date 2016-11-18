package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
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

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.base.LGA_;

@Repository("lgaRepository")
public class JpaLGARepository implements LGARepository {

	final Logger logger = LoggerFactory.getLogger(JpaLGARepository.class);
	
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
	public void delete(LGA arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends LGA> arg0) {
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
	public Iterable<LGA> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LGA findOne(Long id) {
		return this.em.createNamedQuery("LGA.findById", LGA.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends LGA> S save(S lga) {
		logger.info("Adding LGA with ID " + lga.getId());
		return this.em.merge(lga);
	}

	@Override
	public <S extends LGA> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LGA> findAll() {
		return this.em.createNamedQuery("LGA.findAll", LGA.class).getResultList();
	}

	@Override
	public LGA findByCode(String code) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<LGA> query = cb.createQuery(LGA.class);
		Root<LGA> lga = query.from(LGA.class);
		query.select(lga);
		query.where(cb.equal(lga.get(LGA_.code), code));
		return em.createQuery(query).getSingleResult();
	}

}
