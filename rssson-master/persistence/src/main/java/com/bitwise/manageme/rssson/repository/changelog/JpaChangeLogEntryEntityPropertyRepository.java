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
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;

@Repository("changeLogEntryEntityProperty")
public class JpaChangeLogEntryEntityPropertyRepository implements ChangeLogEntryEntityPropertyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaChangeLogEntryEntityPropertyRepository.class);
	
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
	public void delete(ChangeLogEntryEntityProperty arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ChangeLogEntryEntityProperty> arg0) {
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
	public Iterable<ChangeLogEntryEntityProperty> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChangeLogEntryEntityProperty findOne(Long id) {
		return this.em.createNamedQuery("ChangeLogEntryEntityProperty.findById", ChangeLogEntryEntityProperty.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ChangeLogEntryEntityProperty> S save(S logEntryEntityProperty) {
		logger.info("Adding change log entry entity property with ID " + logEntryEntityProperty.getId());
		return this.em.merge(logEntryEntityProperty);
	}

	@Override
	public <S extends ChangeLogEntryEntityProperty> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChangeLogEntryEntityProperty> findAll() {
		return this.em.createNamedQuery("ChangeLogEntryEntityProperty.findAll", ChangeLogEntryEntityProperty.class).getResultList();
	}

	@Override
	public ChangeLogEntryEntityProperty findByEntityAndName(ChangeLogEntryEntity entity, String name) {
		Query query = this.em.createNamedQuery("ChangeLogEntryEntityProperty.findByEntityAndName", ChangeLogEntryEntityProperty.class)
				.setParameter("entity", entity)
				.setParameter("name", name);
		List<ChangeLogEntryEntityProperty> result = query.getResultList();
		return result.size() == 1 ? result.get(0) : null;
	}

}
