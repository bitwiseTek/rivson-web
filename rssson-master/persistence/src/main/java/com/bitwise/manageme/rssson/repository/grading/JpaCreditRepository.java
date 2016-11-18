package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.Credit;

@Repository("creditRepository")
public class JpaCreditRepository implements CreditRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCreditRepository.class);
	
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
	public void delete(Credit arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Credit> arg0) {
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
	public Iterable<Credit> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credit findOne(Long id) {
		return this.em.createNamedQuery("Credit.findById", Credit.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Credit> S save(S credit) {
		logger.info("Adding credit with ID " + credit.getId());
		return this.em.merge(credit);
	}

	@Override
	public <S extends Credit> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credit> findAll() {
		return this.em.createNamedQuery("Credit.findAll", Credit.class).getResultList();
	}

}
