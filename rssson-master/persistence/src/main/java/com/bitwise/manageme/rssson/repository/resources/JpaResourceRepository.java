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

import com.bitwise.manageme.rssson.domain.resources.Resource;

@Repository("resourceRepository")
public class JpaResourceRepository implements ResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaResourceRepository.class);
	
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
	public void delete(Resource resource) {
		logger.info("Deleting resource with ID " + resource.getId());
		this.em.remove(resource);
	}

	@Override
	public void delete(Iterable<? extends Resource> arg0) {
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
	public Iterable<Resource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource findOne(Long id) {
		return this.em.createNamedQuery("Resource.findById", Resource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Resource> S save(S resource) {
		logger.info("Adding resource with ID " + resource.getId());
		return this.em.merge(resource);
	}

	@Override
	public <S extends Resource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> findAll() {
		return this.em.createNamedQuery("Resource.findAll", Resource.class).getResultList();
	}
	//TO DO
	//1. searchResourcesBasic()
	//2. searchResources()
}
