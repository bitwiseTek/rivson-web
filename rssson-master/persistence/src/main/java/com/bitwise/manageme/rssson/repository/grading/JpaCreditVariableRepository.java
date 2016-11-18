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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditVariable;
import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;
import com.bitwise.manageme.rssson.domain.grading.CreditVariable_;

@Repository("creditVariableRepository")
public class JpaCreditVariableRepository implements CreditVariableRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCreditVariableRepository.class);
	
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
	public void delete(CreditVariable creditVariable) {
		logger.info("Deleting credit variable with ID " + creditVariable.getId());
		this.em.remove(creditVariable);
	}

	@Override
	public void delete(Iterable<? extends CreditVariable> arg0) {
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
	public Iterable<CreditVariable> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditVariable findOne(Long id) {
		return this.em.createNamedQuery("CreditVariable.findById", CreditVariable.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CreditVariable> S save(S creditVariable) {
		logger.info("Adding credit variable with ID " + creditVariable.getId());
		return this.em.merge(creditVariable);
	}

	@Override
	public <S extends CreditVariable> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditVariable> findAll() {
		return this.em.createNamedQuery("CreditVariable.findAll", CreditVariable.class).getResultList();
	}

	@Override
	public CreditVariable findByCreditAndKey(Credit credit, CreditVariableKey key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CreditVariable> query = cb.createQuery(CreditVariable.class);
		Root<CreditVariable> creditVariable = query.from(CreditVariable.class);
		query.select(creditVariable);
		query.where(cb.and(cb.equal(creditVariable.get(CreditVariable_.credit), credit), 
				cb.equal(creditVariable.get(CreditVariable_.key), key)));
		return em.createQuery(query).getSingleResult();
	}

}
