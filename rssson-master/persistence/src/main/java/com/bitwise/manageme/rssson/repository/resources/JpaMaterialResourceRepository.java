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

import com.bitwise.manageme.rssson.domain.resources.MaterialResource;

@Repository("materialResourceRepository")
public class JpaMaterialResourceRepository implements MaterialResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaMaterialResourceRepository.class);
	
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
	public void delete(MaterialResource arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends MaterialResource> arg0) {
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
	public Iterable<MaterialResource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialResource findOne(Long id) {
		return this.em.createNamedQuery("MaterialResource.findById", MaterialResource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends MaterialResource> S save(S materialResource) {
		logger.info("Adding material resource with ID " + materialResource.getId());
		return this.em.merge(materialResource);
	}

	@Override
	public <S extends MaterialResource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaterialResource> findAll() {
		return this.em.createNamedQuery("MaterialResource.findAll", MaterialResource.class).getResultList();
	}

}
