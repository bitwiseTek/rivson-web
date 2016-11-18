package com.bitwise.manageme.rssson.repository.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.help.StaffManual;

@Repository("staffManualRepository")
public class JpaStaffManualRepository implements StaffManualRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStaffManualRepository.class);
	
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
	public void delete(StaffManual arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StaffManual> arg0) {
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
	public Iterable<StaffManual> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffManual findOne(Long id) {
		return this.em.createNamedQuery("StaffManual.findById", StaffManual.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StaffManual> S save(S staffManual) {
		logger.info("Adding staff manual with ID: " + staffManual.getId());
		return this.em.merge(staffManual);
	}

	@Override
	public <S extends StaffManual> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffManual> findAll() {
		return this.em.createNamedQuery("StaffManual.findAll", StaffManual.class).getResultList();
	}

	@Override
	public StaffManual findByVersion(String manualVersion) {
		TypedQuery<StaffManual> query = em.createNamedQuery("StaffManual.findByVersion", StaffManual.class).setParameter("manualVersion", manualVersion);
		List<StaffManual> manuals = query.getResultList();
		return manuals.size() == 1 ? manuals.get(0) : null;
	}
}
