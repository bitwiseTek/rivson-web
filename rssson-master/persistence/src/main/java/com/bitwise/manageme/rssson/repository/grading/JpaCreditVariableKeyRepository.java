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

import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;
import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey_;

@Repository("creditVariableKeyRepository")
public class JpaCreditVariableKeyRepository implements CreditVariableKeyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCreditVariableKeyRepository.class);
	
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
	public void delete(CreditVariableKey arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CreditVariableKey> arg0) {
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
	public Iterable<CreditVariableKey> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditVariableKey findOne(Long id) {
		return this.em.createNamedQuery("CreditVariableKey.findById", CreditVariableKey.class).setParameter("id", id).getSingleResult();

	}

	@Override
	public <S extends CreditVariableKey> S save(S creditVariableKey) {
		logger.info("Adding credit variable key with ID " + creditVariableKey.getId());
		return this.em.merge(creditVariableKey);
	}

	@Override
	public <S extends CreditVariableKey> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditVariableKey> findAll() {		
		return this.em.createNamedQuery("CreditVariableKey.findAll", CreditVariableKey.class).getResultList();

	}

	@Override
	public CreditVariableKey findByKey(String key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CreditVariableKey> query = cb.createQuery(CreditVariableKey.class);
		Root<CreditVariableKey> creditVariableKey = query.from(CreditVariableKey.class);
		query.select(creditVariableKey);
		query.where(cb.equal(creditVariableKey.get(CreditVariableKey_.variableKey), key));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<CreditVariableKey> findUserEditableCreditVariableKeys() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CreditVariableKey> query = cb.createQuery(CreditVariableKey.class);
		Root<CreditVariableKey> creditVariableKey = query.from(CreditVariableKey.class);
		query.select(creditVariableKey);
		query.where(cb.equal(creditVariableKey.get(CreditVariableKey_.userEditable), Boolean.TRUE));
		return em.createQuery(query).getResultList();
	}

}
