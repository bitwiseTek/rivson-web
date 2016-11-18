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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.EducationSubtype;
import com.bitwise.manageme.rssson.domain.base.EducationSubtype_;
import com.bitwise.manageme.rssson.domain.base.EducationType;

@Repository("educationSubtypeRepository")
public class JpaEducationSubtypeRepository implements EducationSubtypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaEducationSubtypeRepository.class);
	
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
	public void delete(EducationSubtype arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends EducationSubtype> arg0) {
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
	public Iterable<EducationSubtype> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EducationSubtype findOne(Long id) {
		return this.em.createNamedQuery("EducationSubtype.findById", EducationSubtype.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends EducationSubtype> S save(S subType) {
		logger.info("Adding education subtype with ID " + subType.getId());
		return this.em.merge(subType);
	}

	@Override
	public <S extends EducationSubtype> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationSubtype> findAll() {
		return this.em.createNamedQuery("EducationSubtype.findAll", EducationSubtype.class).getResultList();
	}

	@Override
	public EducationSubtype findByCode(String code) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<EducationSubtype> query = cb.createQuery(EducationSubtype.class);
		Root<EducationSubtype> educationSubtype = query.from(EducationSubtype.class);
		query.select(educationSubtype);
		query.where(cb.equal(educationSubtype.get(EducationSubtype_.code), code));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<EducationSubtype> findByEducationType(EducationType educationType) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<EducationSubtype> query = cb.createQuery(EducationSubtype.class);
		Root<EducationSubtype> educationSubtype = query.from(EducationSubtype.class);
		query.select(educationSubtype);
		query.where(cb.and(cb.equal(educationSubtype.get(EducationSubtype_.archived), Boolean.FALSE),
				cb.equal(educationSubtype.get(EducationSubtype_.educationType), educationSubtype)));
		return em.createQuery(query).getResultList();
	}

}
