package com.bitwise.manageme.rssson.repository.resources;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.resources.WorkResource;

@Repository("workResourceRepository")
public class JpaWorkResourceRepository implements WorkResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaWorkResourceRepository.class);
	
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
	public void delete(WorkResource arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends WorkResource> arg0) {
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
	public Iterable<WorkResource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkResource findOne(Long id) {
		return this.em.createNamedQuery("WorkResource.findById", WorkResource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends WorkResource> S save(S workResource) {
		logger.info("Adding work resource with ID " + workResource.getId());
		return this.em.merge(workResource);
	}

	@Override
	public <S extends WorkResource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkResource> findAll() {
		return this.em.createNamedQuery("WorkResource.findAll", WorkResource.class).getResultList();
	}

}
