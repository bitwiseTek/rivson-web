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

import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("billingDetailsRepository")
public class JpaBillingDetailsRepository implements BillingDetailsRepository {

	final Logger logger = LoggerFactory.getLogger(JpaBillingDetailsRepository.class);
	
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
	public void delete(BillingDetails billingDetails) {
		logger.info("Deleting billing details with ID " + billingDetails.getId());
		this.em.remove(billingDetails);
	}

	@Override
	public void delete(Iterable<? extends BillingDetails> arg0) {
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
	public Iterable<BillingDetails> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillingDetails findOne(Long id) {
		return this.em.createNamedQuery("BillingDetails.findById", BillingDetails.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public <S extends BillingDetails> S save(S billingDetails) {
		logger.info("Adding billing details with ID " + billingDetails.getId());
		return this.em.merge(billingDetails);
	}

	@Override
	public <S extends BillingDetails> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BillingDetails> findAll() {
		return this.em.createNamedQuery("BillingDetails.findAll", BillingDetails.class).getResultList();
	}

	@Override
	public List<BillingDetails> findByStudent(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<BillingDetails> query = cb.createQuery(BillingDetails.class);
		Root<CourseStudent> courseStudent = query.from(CourseStudent.class);
		query.select(courseStudent.get(CourseStudent_.billingDetails));
		query.where(cb.equal(courseStudent.get(CourseStudent_.student), student));
		query.groupBy(courseStudent.get(CourseStudent_.billingDetails));
		return em.createQuery(query).getResultList();
	}

}
