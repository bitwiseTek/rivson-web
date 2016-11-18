package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
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

import com.bitwise.manageme.rssson.domain.users.UserVariableKey;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey_;

@Repository("userVariableKeyRepository")
public class JpaUserVariableKeyRepository implements UserVariableKeyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaUserVariableKeyRepository.class);
	
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
	public void delete(UserVariableKey arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends UserVariableKey> arg0) {
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
	public Iterable<UserVariableKey> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVariableKey findOne(Long id) {
		return this.em.createNamedQuery("UserVariableKey.findById", UserVariableKey.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends UserVariableKey> S save(S userVariableKey) {
		logger.info("Adding user variable key with ID " + userVariableKey.getId());
		return this.em.merge(userVariableKey);
	}

	@Override
	public <S extends UserVariableKey> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVariableKey> findAll() {
		return this.em.createNamedQuery("UserVariableKey.findAll", UserVariableKey.class).getResultList();
	}

	@Override
	public List<UserVariableKey> findUserEditableUserVariableKeys() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<UserVariableKey> query = cb.createQuery(UserVariableKey.class);
		Root<UserVariableKey> userVariableKey = query.from(UserVariableKey.class);
		query.select(userVariableKey);
		query.where(cb.and(cb.equal(userVariableKey.get(UserVariableKey_.userEditable), Boolean.TRUE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<UserVariableKey> findByUserEditable(Boolean editable) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<UserVariableKey> query = cb.createQuery(UserVariableKey.class);
		Root<UserVariableKey> userVariableKey = query.from(UserVariableKey.class);
		query.select(userVariableKey);
		query.where(cb.and(cb.equal(userVariableKey.get(UserVariableKey_.userEditable), Boolean.TRUE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public UserVariableKey findByVariableKey(String key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<UserVariableKey> query = cb.createQuery(UserVariableKey.class);
		Root<UserVariableKey> userVariableKey = query.from(UserVariableKey.class);
		query.select(userVariableKey);
		query.where(cb.and(cb.equal(userVariableKey.get(UserVariableKey_.variableKey), key)));
		return em.createQuery(query).getSingleResult();
	}

}
