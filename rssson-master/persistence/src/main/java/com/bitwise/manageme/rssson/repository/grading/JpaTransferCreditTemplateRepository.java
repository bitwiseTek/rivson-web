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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;

@Repository("transferCreditTemplateRepository")
public class JpaTransferCreditTemplateRepository implements TransferCreditTemplateRepository {

	final Logger logger = LoggerFactory.getLogger(JpaTransferCreditTemplateRepository.class);
	
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
	public void delete(TransferCreditTemplate creditTemplate) {
		logger.info("Deleting transfer credit template with ID " + creditTemplate.getId());
		this.em.remove(creditTemplate);
	}

	@Override
	public void delete(Iterable<? extends TransferCreditTemplate> arg0) {
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
	public Iterable<TransferCreditTemplate> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferCreditTemplate findOne(Long id) {
		return this.em.createNamedQuery("TransferCreditTemplate.findById", TransferCreditTemplate.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends TransferCreditTemplate> S save(S creditTemplate) {
		logger.info("Adding transfer credit template with ID " + creditTemplate.getId());
		return this.em.merge(creditTemplate);
	}

	@Override
	public <S extends TransferCreditTemplate> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferCreditTemplate> findAll() {
		return this.em.createNamedQuery("TransferCreditTemplate.findAll", TransferCreditTemplate.class).getResultList();
	}
}
