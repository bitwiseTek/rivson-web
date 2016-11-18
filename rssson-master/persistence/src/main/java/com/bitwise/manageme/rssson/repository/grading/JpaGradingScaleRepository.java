package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.GradingScale;

@Repository("gradingScaleRepository")
public class JpaGradingScaleRepository implements GradingScaleRepository {

	final Logger logger = LoggerFactory.getLogger(JpaGradingScaleRepository.class);
	
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
	public void delete(GradingScale gradingScale) {
		logger.info("Deleting grading scale with ID " + gradingScale.getId());
		this.em.remove(em.merge(gradingScale));
	}

	@Override
	public void delete(Iterable<? extends GradingScale> arg0) {
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
	public Iterable<GradingScale> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradingScale findOne(Long id) {
		return this.em.createNamedQuery("GradingScale.findById", GradingScale.class).setParameter("id", id).getSingleResult();

	}

	@Override
	public <S extends GradingScale> S save(S gradingScale) {
		logger.info("Adding grading scale with ID " + gradingScale.getId());
		return this.em.merge(gradingScale);
	}

	@Override
	public <S extends GradingScale> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradingScale> findAll() {
		return this.em.createNamedQuery("GradingScale.findAll", GradingScale.class).getResultList();

	}

	@Override
	public GradingScale findByName(String name) {
		TypedQuery<GradingScale> query = em.createNamedQuery("GradingScale.findByName", GradingScale.class).setParameter("name", name);
		List<GradingScale> gradingScales = query.getResultList();
		return gradingScales.size() == 1 ? gradingScales.get(0) : null;
	}

}
