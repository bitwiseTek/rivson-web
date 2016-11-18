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

import com.bitwise.manageme.rssson.domain.users.PasswordResetRequest;
import com.bitwise.manageme.rssson.domain.users.PasswordResetRequest_;

@Repository("passwordResetRequestRepository")
public class JpaPasswordResetRequestRepository implements PasswordResetRequestRepository {

	final Logger logger = LoggerFactory.getLogger(JpaPasswordResetRequestRepository.class);
	
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
	public void delete(PasswordResetRequest resetRequest) {
		logger.info("Deleting password reset request with ID " + resetRequest.getId());
		this.em.remove(resetRequest);
	}

	@Override
	public void delete(Iterable<? extends PasswordResetRequest> arg0) {
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
	public Iterable<PasswordResetRequest> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PasswordResetRequest findOne(Long id) {
		return this.em.createNamedQuery("PasswordResetRequest.findById", PasswordResetRequest.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends PasswordResetRequest> S save(S resetRequest) {
		logger.info("Adding password reset request with ID " + resetRequest.getId());
		return this.em.merge(resetRequest);
	}

	@Override
	public <S extends PasswordResetRequest> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PasswordResetRequest> findAll() {
		return this.em.createNamedQuery("PasswordResetRequest.findAll", PasswordResetRequest.class).getResultList();
	}

	@Override
	public PasswordResetRequest findBySecret(String secret) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<PasswordResetRequest> query = cb.createQuery(PasswordResetRequest.class);
		Root<PasswordResetRequest> resetRequest = query.from(PasswordResetRequest.class);
		query.select(resetRequest);
		query.where(cb.equal(resetRequest.get(PasswordResetRequest_.secretAnswer), secret));
		return em.createQuery(query).getSingleResult();
	}

}
