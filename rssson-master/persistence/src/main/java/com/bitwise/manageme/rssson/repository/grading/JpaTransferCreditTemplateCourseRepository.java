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

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;
import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplateCourse;
import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplateCourse_;

@Repository("transferCreditTemplateCourseRepository")
public class JpaTransferCreditTemplateCourseRepository implements TransferCreditTemplateCourseRepository {

	final Logger logger = LoggerFactory.getLogger(JpaTransferCreditTemplateCourseRepository.class);
	
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
	public void delete(TransferCreditTemplateCourse creditTemplateCourse) {
		logger.info("Deleting transfer credit template course with ID " + creditTemplateCourse.getId());
		this.em.remove(creditTemplateCourse);
	}

	@Override
	public void delete(Iterable<? extends TransferCreditTemplateCourse> arg0) {
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
	public Iterable<TransferCreditTemplateCourse> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferCreditTemplateCourse findOne(Long id) {
		return this.em.createNamedQuery("TransferCreditTemplateCourse.findById", TransferCreditTemplateCourse.class).setParameter("id", id).getSingleResult();

	}

	@Override
	public <S extends TransferCreditTemplateCourse> S save(S creditTemplateCourse) {
		logger.info("Adding transfer credit template course with ID " + creditTemplateCourse.getId());
		return this.em.merge(creditTemplateCourse);
	}

	@Override
	public <S extends TransferCreditTemplateCourse> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferCreditTemplateCourse> findAll() {
		return this.em.createNamedQuery("TransferCreditTemplateCourse.findAll", TransferCreditTemplateCourse.class).getResultList();
	}

	@Override
	public List<TransferCreditTemplateCourse> findByTemplates(TransferCreditTemplate template) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<TransferCreditTemplateCourse> query = cb.createQuery(TransferCreditTemplateCourse.class);
		Root<TransferCreditTemplateCourse> creditTemplateCourse = query.from(TransferCreditTemplateCourse.class);
		query.select(creditTemplateCourse);
		query.where(cb.equal(creditTemplateCourse.get(TransferCreditTemplateCourse_.transferCreditTemplate), template));
		return em.createQuery(query).getResultList();
	}
	//TO DO
			//1. seacrhResult()

}
