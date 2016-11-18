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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.EducationType_;

@Repository("educationTypeRepository")
public class JpaEducationTypeRepository implements EducationTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaEducationTypeRepository.class);
	
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
	public void delete(EducationType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends EducationType> arg0) {
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
	public Iterable<EducationType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EducationType findOne(Long id) {
		return this.em.createNamedQuery("EducationType.findById", EducationType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public <S extends EducationType> S save(S educationType) {
		logger.info("Adding education type with ID " + educationType.getId());
		return this.em.merge(educationType);
	}

	@Override
	public <S extends EducationType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationType> findAll() {
		return this.em.createNamedQuery("EducationType.findAll", EducationType.class).getResultList();
	}

	@Override
	public EducationType findByCode(String code) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<EducationType> query = cb.createQuery(EducationType.class);
		Root<EducationType> educationType = query.from(EducationType.class);
		query.select(educationType);
		query.where(cb.equal(educationType.get(EducationType_.code), code));
		return em.createQuery(query).getSingleResult();
	}

}
