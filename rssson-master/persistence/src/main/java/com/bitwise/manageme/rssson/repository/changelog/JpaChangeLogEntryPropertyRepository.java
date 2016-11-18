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

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryProperty;

@Repository("changeLogEntryPropertyRepository")
public class JpaChangeLogEntryPropertyRepository implements ChangeLogEntryPropertyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaChangeLogEntryPropertyRepository.class);
	
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
	public void delete(ChangeLogEntryProperty arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ChangeLogEntryProperty> arg0) {
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
	public Iterable<ChangeLogEntryProperty> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChangeLogEntryProperty findOne(Long id) {
		return this.em.createNamedQuery("ChangeLogEntryProperty.findById", ChangeLogEntryProperty.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ChangeLogEntryProperty> S save(S logEntryProperty) {
		logger.info("Adding change log entry property with ID " + logEntryProperty.getId());
		return this.em.merge(logEntryProperty);
	}

	@Override
	public <S extends ChangeLogEntryProperty> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChangeLogEntryProperty> findAll() {
		return this.em.createNamedQuery("ChangeLogEntryProperty.findAll", ChangeLogEntryProperty.class).getResultList();
	}

	@Override
	public ChangeLogEntryProperty findLatestByEntryEntityProperty(ChangeLogEntryEntityProperty property, String entityId) {
		Query query = this.em.createNamedQuery("ChangeLogEntryProperty.findByPropertyAndEntityId", ChangeLogEntryProperty.class)
				.setParameter("property", property)
				.setParameter("entityId", entityId);
		List<ChangeLogEntryProperty> result = query.getResultList();
		return result.size() == 1 ? result.get(0) : null;
	}

}
