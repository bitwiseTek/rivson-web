package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;

@Repository("staffManualPDFRepository")
public class JpaStaffMemberManualPDFRepository implements StaffMemberManualPDFRepository {

	Logger logger = LoggerFactory.getLogger(JpaStaffMemberManualPDFRepository.class);
	
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
	public void delete(StaffMemberManualPDF arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StaffMemberManualPDF> arg0) {
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
	public Iterable<StaffMemberManualPDF> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffMemberManualPDF findOne(Long id) {
		return this.em.createNamedQuery("StaffMemberManualPDF.findById", StaffMemberManualPDF.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StaffMemberManualPDF> S save(S manualPDF) {
		logger.info("Adding manual with ID: " + manualPDF.getId());
		return this.em.merge(manualPDF);
	}

	@Override
	public <S extends StaffMemberManualPDF> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffMemberManualPDF> findAll() {
		return this.em.createNamedQuery("StaffMemberManualPDF.findAll", StaffMemberManualPDF.class).getResultList();
	}

}
