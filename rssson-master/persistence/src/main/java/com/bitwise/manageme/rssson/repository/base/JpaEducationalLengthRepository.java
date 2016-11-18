package com.bitwise.manageme.rssson.repository.base;
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

import com.bitwise.manageme.rssson.domain.base.EducationalLength;

@Repository("educationLengthRepository")
public class JpaEducationalLengthRepository implements EducationalLengthRepository {

	final Logger logger = LoggerFactory.getLogger(JpaEducationalLengthRepository.class);
	
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
	public void delete(EducationalLength arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends EducationalLength> arg0) {
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
	public Iterable<EducationalLength> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EducationalLength findOne(Long id) {
		return this.em.createNamedQuery("EducationalLength.findById", EducationalLength.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends EducationalLength> S save(S educationalLength) {
		logger.info("Adding educational length with ID " + educationalLength.getId());
		return this.em.merge(educationalLength);
	}

	@Override
	public <S extends EducationalLength> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalLength> findAll() {
		return this.em.createNamedQuery("EducationalLength.findAll", EducationalLength.class).getResultList();
	}

}
