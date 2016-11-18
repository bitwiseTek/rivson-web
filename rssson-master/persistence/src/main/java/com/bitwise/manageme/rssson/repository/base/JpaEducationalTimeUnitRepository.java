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

import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;

@Repository("educationalTimeUnitRepository")
public class JpaEducationalTimeUnitRepository implements EducationalTimeUnitRepository {

	final Logger logger = LoggerFactory.getLogger(JpaEducationalTimeUnitRepository.class);
	
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
	public void delete(EducationalTimeUnit arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends EducationalTimeUnit> arg0) {
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
	public Iterable<EducationalTimeUnit> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EducationalTimeUnit findOne(Long id) {
		return this.em.createNamedQuery("EducationalTimeUnit.findById", EducationalTimeUnit.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends EducationalTimeUnit> S save(S timeUnit) {
		logger.info("Adding educational time unit with ID " + timeUnit.getId());
		return this.em.merge(timeUnit);
	}

	@Override
	public <S extends EducationalTimeUnit> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalTimeUnit> findAll() {
		return this.em.createNamedQuery("EducationalTimeUnit.findAll", EducationalTimeUnit.class).getResultList();
	}

}
