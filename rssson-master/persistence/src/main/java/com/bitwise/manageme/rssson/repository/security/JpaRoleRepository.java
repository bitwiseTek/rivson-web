package com.bitwise.manageme.rssson.repository.security;
/**
 *  
 * @author Sika Kay
 * @date 13/11/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.security.Role;

@Repository("roleRepository")
public class JpaRoleRepository implements RoleRepository {

	final Logger logger = LoggerFactory.getLogger(JpaRoleRepository.class);
	
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
	public void delete(Role arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Role> arg0) {
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
	public Iterable<Role> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findOne(Long id) {
		return this.em.createNamedQuery("Role.findById", Role.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public <S extends Role> S save(S role) {
		logger.info("Adding role with ID " + role.getId());
		return this.em.merge(role);
	}

	@Override
	public <S extends Role> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		return this.em.createNamedQuery("Role.findAll", Role.class).getResultList();
	}

}
