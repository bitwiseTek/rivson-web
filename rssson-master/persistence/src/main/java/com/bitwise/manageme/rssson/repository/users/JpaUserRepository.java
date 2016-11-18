package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 11/09/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.User_;

@Repository("userRepository")
public class JpaUserRepository implements UserRepository {

	final Logger logger = LoggerFactory.getLogger(JpaUserRepository.class);
	
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
	@Transactional
	public void delete(User user) {
		logger.info("Deleting User with ID: " + user.getId());
		this.em.remove(em.merge(user));
	}

	@Override
	public void delete(Iterable<? extends User> arg0) {
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
	public Iterable<User> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(Long id) {
		User user = em.createNamedQuery("User.findById", User.class).setParameter("id", id).getSingleResult();
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	@Transactional
	public <S extends User> S save(S user) {
		logger.info("Adding/Updating user with ID " + user.getId());
		return this.em.merge(user);
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return this.em.createNamedQuery("User.findAll", User.class).getResultList();
	}

	@Override
	public User findByUsernameAndPassword(String username, String passwordEncoded) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> user = query.from(User.class);
		query.select(user);
		query.where(cb.and(cb.equal(user.get(User_.username), username), 
				cb.equal(user.get(User_.password), passwordEncoded)));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public User findByUsername(String username) {
		TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class).setParameter("username", username);
		List<User> users = query.getResultList();
		User user = users.size() == 1 ? users.get(0) : null;
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public User findBySystemId(String systemId) {
		TypedQuery<User> query = em.createNamedQuery("User.findBySystemId", User.class).setParameter("systemId", systemId);
		List<User> systemIds = query.getResultList();
		User user = systemIds.size() == 1 ? systemIds.get(0) : null;
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public Iterable<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		TypedQuery<User> query = em.createQuery("select u from User u", User.class);
		Page<User> userPage = new PageImpl<User>(query.getResultList());
		return userPage;
	}

	@Override
	public Page<User> findBySystemId(String systemId, Pageable pageable) {
		TypedQuery<User> query = em.createNamedQuery("User.findBySystemId", User.class).setParameter("systemId", systemId);
		Page<User> userPage = new PageImpl<User>(query.getResultList());
		return userPage;
	}

	@Override
	public Page<User> findByUsername(String username, Pageable pageable) {
		TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class).setParameter("username", username);
		Page<User> userPage = new PageImpl<User>(query.getResultList());
		return userPage;
	}

}
