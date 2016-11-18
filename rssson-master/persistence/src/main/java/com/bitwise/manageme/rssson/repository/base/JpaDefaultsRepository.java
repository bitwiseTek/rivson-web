package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.Defaults;

@Repository("defaultsRepository")
public class JpaDefaultsRepository implements DefaultsRepository {

	final Logger logger = LoggerFactory.getLogger(JpaDefaultsRepository.class);
	
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
	public void delete(Defaults arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Defaults> arg0) {
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
	public Iterable<Defaults> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Defaults findOne(Long id) {
		return this.em.createNamedQuery("Defaults.findById", Defaults.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Defaults> S save(S defaults) {
		logger.info("Adding defaults with ID " + defaults.getId());
		return this.em.merge(defaults);
	}

	@Override
	public <S extends Defaults> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Defaults> findAll() {
		return this.em.createNamedQuery("Defaults.findAll", Defaults.class).getResultList();
	}

}
