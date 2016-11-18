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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntryPath;
import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntryPath_;

@Repository("accessLogEntryPathRepository")
public class JpaAccessLogEntryPathRepository implements AccessLogEntryPathRepository {

final Logger logger = LoggerFactory.getLogger(JpaAccessLogEntryPathRepository.class);
	
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
	public void delete(AccessLogEntryPath arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends AccessLogEntryPath> arg0) {
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
	public List<AccessLogEntryPath> findAll() {
		return this.em.createNamedQuery("AccessLogEntryPath.findAll", AccessLogEntryPath.class).getResultList();
	}

	@Override
	public Iterable<AccessLogEntryPath> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessLogEntryPath findOne(Long id) {
		return this.em.createNamedQuery("AccessLogEntryPath.findById", AccessLogEntryPath.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends AccessLogEntryPath> S save(S accessLog) {
		logger.info("Adding access log entry path with ID" + accessLog.getId());
		return this.em.merge(accessLog);
	}

	@Override
	public <S extends AccessLogEntryPath> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessLogEntryPath findByPath(String path) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<AccessLogEntryPath> query = cb.createQuery(AccessLogEntryPath.class);
		Root<AccessLogEntryPath> accessLog = query.from(AccessLogEntryPath.class);
		query.select(accessLog);
		query.where(cb.equal(accessLog.get(AccessLogEntryPath_.path), path));
		return em.createQuery(query).getSingleResult();
	}

}
