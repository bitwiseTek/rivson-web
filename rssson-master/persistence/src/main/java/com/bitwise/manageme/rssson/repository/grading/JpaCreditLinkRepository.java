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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditLink;
import com.bitwise.manageme.rssson.domain.grading.CreditLink_;
import com.bitwise.manageme.rssson.domain.grading.CreditType;
import com.bitwise.manageme.rssson.domain.grading.Credit_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("creditLinkRepository")
public class JpaCreditLinkRepository implements CreditLinkRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCreditLinkRepository.class);
	
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
	public void delete(CreditLink arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CreditLink> arg0) {
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
	public Iterable<CreditLink> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditLink findOne(Long id) {
		return this.em.createNamedQuery("CreditLink.findById", CreditLink.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CreditLink> S save(S creditLink) {
		logger.info("Adding credit link with ID " + creditLink.getId());
		return this.em.merge(creditLink);
	}

	@Override
	public <S extends CreditLink> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditLink> findAll() {
		return this.em.createNamedQuery("CreditLink.findAll", CreditLink.class).getResultList();
	}

	@Override
	public List<CreditLink> findByStudentsAndTypes(Student student, CreditType creditType) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CreditLink> query = cb.createQuery(CreditLink.class);
		Root<CreditLink> creditLink = query.from(CreditLink.class);
		Join<CreditLink, Credit> creditJoin = creditLink.join(CreditLink_.credit);
		query.select(creditLink);
		query.where(cb.and(cb.equal(creditLink.get(CreditLink_.student), student), 
				cb.equal(creditLink.get(CreditLink_.archived), Boolean.FALSE),
				cb.equal(creditJoin.get(Credit_.creditType), creditType)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<CreditLink> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CreditLink> query = cb.createQuery(CreditLink.class);
		Root<CreditLink> creditLink = query.from(CreditLink.class);
		query.select(creditLink);
		query.where(cb.and(cb.equal(creditLink.get(CreditLink_.student), student), 
				cb.equal(creditLink.get(CreditLink_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public Long countByStudent(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<CreditLink> creditLink = query.from(CreditLink.class);
		query.select(cb.count(creditLink));
		query.where(cb.and(cb.equal(creditLink.get(CreditLink_.student), student), 
				cb.equal(creditLink.get(CreditLink_.archived), Boolean.FALSE)));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public CreditLink findByStudentAndCredit(Student student, Credit credit) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CreditLink> query = cb.createQuery(CreditLink.class);
		Root<CreditLink> creditLink = query.from(CreditLink.class);
		query.select(creditLink);
		query.where(cb.and(cb.equal(creditLink.get(CreditLink_.student), student), 
				cb.equal(creditLink.get(CreditLink_.credit), credit), 
				cb.equal(creditLink.get(CreditLink_.archived), Boolean.FALSE)));
		return em.createQuery(query).getSingleResult();
	}

}
