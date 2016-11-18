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

import com.bitwise.manageme.rssson.domain.changelog.TrackedEntityProperty;

@Repository("trackedEntityPropertyRepository")
public class JpaTrackedEntityPropertyRepository implements TrackedEntityPropertyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaTrackedEntityPropertyRepository.class);
	
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
	public void delete(TrackedEntityProperty trackedEntityProperty) {
		logger.info("Deleting tracked entity property with ID " + trackedEntityProperty.getId());
		this.em.remove(trackedEntityProperty);
	}

	@Override
	public void delete(Iterable<? extends TrackedEntityProperty> arg0) {
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
	public Iterable<TrackedEntityProperty> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrackedEntityProperty findOne(Long id) {
		return this.em.createNamedQuery("TrackedEntityProperty.findById", TrackedEntityProperty.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends TrackedEntityProperty> S save(S trackedEntityProperty) {
		logger.info("Adding tracked entity property with ID " + trackedEntityProperty.getId());
		return this.em.merge(trackedEntityProperty);
	}

	@Override
	public <S extends TrackedEntityProperty> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrackedEntityProperty> findAll() {
		return this.em.createNamedQuery("TrackedEntityProperty.findAll", TrackedEntityProperty.class).getResultList();
	}

	@Override
	public TrackedEntityProperty findByEntityAndProperty(String entity, String property) {
		Query query = this.em.createNamedQuery("TrackedEntityProperty.findByEntityAndProperty", TrackedEntityProperty.class)
				.setParameter("entity", entity)
				.setParameter("property", property);
		List<TrackedEntityProperty> result = query.getResultList();
		return result.size() == 1 ? result.get(0) : null;
	}

}
