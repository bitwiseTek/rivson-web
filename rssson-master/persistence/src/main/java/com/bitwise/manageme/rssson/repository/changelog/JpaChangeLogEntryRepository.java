package com.bitwise.manageme.rssson.repository.changelog;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntry;

@Repository("changeLogEntryRepository")
public class JpaChangeLogEntryRepository implements ChangeLogEntryRepository {

	final Logger logger = LoggerFactory.getLogger(JpaChangeLogEntryRepository.class);
	
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
	public void delete(ChangeLogEntry arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ChangeLogEntry> arg0) {
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
	public Iterable<ChangeLogEntry> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChangeLogEntry findOne(Long id) {
		return this.em.createNamedQuery("ChangeLogEntry.findById", ChangeLogEntry.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ChangeLogEntry> S save(S logEntry) {
		logger.info("Adding change log entry with ID " + logEntry.getId());
		return this.em.merge(logEntry);
	}

	@Override
	public <S extends ChangeLogEntry> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChangeLogEntry> findAll() {
		return this.em.createNamedQuery("ChangeLogEntry.findAll", ChangeLogEntry.class).getResultList();
	}

}
