package com.bitwise.manageme.rssson.repository.accesslog;
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

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntry;

@Repository("accessLogEntryRepository")
public class JpaAccessLogEntryRepository implements AccessLogEntryRepository {
	
	final Logger logger = LoggerFactory.getLogger(JpaAccessLogEntryRepository.class);
	
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
	public void delete(AccessLogEntry arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends AccessLogEntry> arg0) {
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
	public List<AccessLogEntry> findAll() {
		return em.createNamedQuery("AccessLogEntry.findAll", AccessLogEntry.class).getResultList();
	}

	@Override
	public Iterable<AccessLogEntry> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessLogEntry findOne(Long id) {
		return em.createNamedQuery("AccessLogEntry.findById", AccessLogEntry.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends AccessLogEntry> S save(S accessLog) {
		logger.info("Adding access log with ID " + accessLog.getId() );
		return this.em.merge(accessLog);
	}

	@Override
	public <S extends AccessLogEntry> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
