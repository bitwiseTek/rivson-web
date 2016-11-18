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

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.UserVariable;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey;
import com.bitwise.manageme.rssson.domain.users.UserVariable_;

@Repository("userVariableRepository")
public class JpaUserVariableRepository implements UserVariableRepository {

	final Logger logger = LoggerFactory.getLogger(JpaUserVariableRepository.class);
	
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
	public void delete(UserVariable userVariable) {
		logger.info("Deleting user variable with ID " + userVariable.getId());
		this.em.remove(userVariable);
	}

	@Override
	public void delete(Iterable<? extends UserVariable> arg0) {
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
	public Iterable<UserVariable> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVariable findOne(Long id) {
		return this.em.createNamedQuery("UserVariable.findById", UserVariable.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends UserVariable> S save(S userVariable) {
		logger.info("Adding user variable with ID " + userVariable.getId());
		return this.em.merge(userVariable);
	}

	@Override
	public <S extends UserVariable> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVariable> findAll() {
		return this.em.createNamedQuery("UserVariable.findAll", UserVariable.class).getResultList();
	}

	@Override
	public UserVariable findByUserAndVariableKey(User user, UserVariableKey key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<UserVariable> query = cb.createQuery(UserVariable.class);
		Root<UserVariable> userVariable = query.from(UserVariable.class);
		query.select(userVariable);
		query.where(cb.and(cb.equal(userVariable.get(UserVariable_.user), user), 
				cb.equal(userVariable.get(UserVariable_.key), key)));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<UserVariable> findByUsers(User user) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<UserVariable> query = cb.createQuery(UserVariable.class);
		Root<UserVariable> userVariable = query.from(UserVariable.class);
		query.select(userVariable);
		query.where(cb.and(cb.equal(userVariable.get(UserVariable_.user), user)));
		return em.createQuery(query).getResultList();
	}

}
