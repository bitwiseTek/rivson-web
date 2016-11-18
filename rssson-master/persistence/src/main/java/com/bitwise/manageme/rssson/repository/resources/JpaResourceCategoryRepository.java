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

import com.bitwise.manageme.rssson.domain.resources.ResourceCategory;

@Repository("resourceCategoryRepository")
public class JpaResourceCategoryRepository implements ResourceCategoryRepository {

	final Logger logger = LoggerFactory.getLogger(JpaResourceCategoryRepository.class);
	
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
	public void delete(ResourceCategory resourceCategory) {
		logger.info("Deleting resource category with ID " + resourceCategory.getId());
		this.em.remove(resourceCategory);
	}

	@Override
	public void delete(Iterable<? extends ResourceCategory> arg0) {
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
	public Iterable<ResourceCategory> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceCategory findOne(Long id) {
		return this.em.createNamedQuery("ResourceCategory.findById", ResourceCategory.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ResourceCategory> S save(S resourceCategory) {
		logger.info("Adding resource category with ID " + resourceCategory.getId());
		return this.em.merge(resourceCategory);
	}

	@Override
	public <S extends ResourceCategory> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceCategory> findAll() {
		return this.em.createNamedQuery("ResourceCategory.findAll", ResourceCategory.class).getResultList();
	}

}
