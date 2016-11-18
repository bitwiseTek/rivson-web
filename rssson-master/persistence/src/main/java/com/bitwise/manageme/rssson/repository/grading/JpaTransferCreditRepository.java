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
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.grading.TransferCredit;
import com.bitwise.manageme.rssson.domain.grading.TransferCredit_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("transferCreditRepository")
public class JpaTransferCreditRepository implements TransferCreditRepository {

	final Logger logger = LoggerFactory.getLogger(JpaTransferCreditRepository.class);
	
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
	public void delete(TransferCredit arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends TransferCredit> arg0) {
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
	public Iterable<TransferCredit> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferCredit findOne(Long id) {
		return this.em.createNamedQuery("TransferCredit.findById", TransferCredit.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends TransferCredit> S save(S transferCredit) {
		logger.info("Adding transfer credit with ID " + transferCredit.getId());
		return this.em.merge(transferCredit);
	}

	@Override
	public <S extends TransferCredit> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferCredit> findAll() {
		return this.em.createNamedQuery("TransferCredit.findAll", TransferCredit.class).getResultList();
	}

	@Override
	public List<TransferCredit> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<TransferCredit> query = cb.createQuery(TransferCredit.class);
		Root<TransferCredit> transferCredit = query.from(TransferCredit.class);
		query.select(transferCredit);
		query.where(cb.and(cb.equal(transferCredit.get(TransferCredit_.student), student), 
				cb.equal(transferCredit.get(TransferCredit_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<TransferCredit> findByStudentsAndSubjects(Student student, Subject subject) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<TransferCredit> query = cb.createQuery(TransferCredit.class);
		Root<TransferCredit> transferCredit = query.from(TransferCredit.class);
		query.select(transferCredit);
		query.where(cb.and(cb.equal(transferCredit.get(TransferCredit_.student), student), 
				cb.equal(transferCredit.get(TransferCredit_.subject), subject),
				cb.equal(transferCredit.get(TransferCredit_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public Long countByStudent(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<TransferCredit> transferCredit = query.from(TransferCredit.class);
		query.select(cb.count(transferCredit));
		query.where(cb.and(cb.equal(transferCredit.get(TransferCredit_.student), student), 
				cb.equal(transferCredit.get(TransferCredit_.archived), Boolean.FALSE)));
		return em.createQuery(query).getSingleResult();
	}

}
