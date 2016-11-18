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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.base.Subject_;

@Repository("subjectRepository")
public class JpaSubjectRepository implements SubjectRepository {

	final Logger logger = LoggerFactory.getLogger(JpaSubjectRepository.class);
	
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
	public void delete(Subject subject) {
		logger.info("Deleting subject with ID " + subject.getId());
		this.em.remove(em.merge(subject));
	}

	@Override
	public void delete(Iterable<? extends Subject> arg0) {
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
	public Iterable<Subject> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject findOne(Long id) {
		return this.em.createNamedQuery("Subject.findById", Subject.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Subject> S save(S subject) {
		logger.info("Adding subject with ID " + subject.getId());
		return this.em.merge(subject);
	}

	@Override
	public <S extends Subject> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> findAll() {
		return this.em.createNamedQuery("Subject.findAll", Subject.class).getResultList();
	}

	@Override
	public Subject findByCode(String code) {
		TypedQuery<Subject> query = em.createNamedQuery("Subject.findByCode", Subject.class).setParameter("code", code);
		List<Subject> codes = query.getResultList();
		return codes.size() == 1 ? codes.get(0) : null;
	}

	@Override
	public List<Subject> findByEducationTypes(EducationType type) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Subject> query = cb.createQuery(Subject.class);
		Root<Subject> subject = query.from(Subject.class);
		query.select(subject);
		query.where(cb.equal(subject.get(Subject_.educationType), type));
		return em.createQuery(query).getResultList();
	}

	@Override
	public Subject findByName(String name) {
		TypedQuery<Subject> query = em.createNamedQuery("Subject.findByName", Subject.class).setParameter("name", name);
		List<Subject> names = query.getResultList();
		return names.size() == 1 ? names.get(0) : null;
	}

	//TO DO
	//1. searchSubjectsBasic()
}
