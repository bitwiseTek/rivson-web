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
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntity;

@Repository("changeLogEntryEntityRepository")
public class JpaChangeLogEntryEntityRepository implements ChangeLogEntryEntityRepository {

	final Logger logger = LoggerFactory.getLogger(JpaChangeLogEntryEntityRepository.class);
	
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
	public void delete(ChangeLogEntryEntity arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ChangeLogEntryEntity> arg0) {
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
	public Iterable<ChangeLogEntryEntity> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChangeLogEntryEntity findOne(Long id) {
		return this.em.createNamedQuery("ChangeLogEntryEntity.findById", ChangeLogEntryEntity.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ChangeLogEntryEntity> S save(S logEntryEntity) {
		logger.info("Adding change log entry entity with ID " + logEntryEntity.getId());
		return this.em.merge(logEntryEntity);
	}

	@Override
	public <S extends ChangeLogEntryEntity> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChangeLogEntryEntity> findAll() {
		return this.em.createNamedQuery("ChangeLogEntryEntity.findAll", ChangeLogEntryEntity.class).getResultList();
	}

	@Override
	public ChangeLogEntryEntity findByName(String name) {
		Query query = this.em.createNamedQuery("ChangeLogEntryEntity.findByName", ChangeLogEntryEntity.class).setParameter("name", name);
		List<ChangeLogEntryEntity> result = query.getResultList();
		return result.size() == 1 ? result.get(0) : null;
	}

}
