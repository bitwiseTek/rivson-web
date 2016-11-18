package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.users.StaffMemberSubject;

@Repository("staffMemberSubjectRepository")
public class JpaStaffMemberSubjectRepository implements StaffMemberSubjectRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStaffMemberSubjectRepository.class);
	
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
	public void delete(StaffMemberSubject staffSubject) {
		logger.info("Deleting course staff subject link with ID: " + staffSubject.getId());
		this.em.remove(em.merge(staffSubject));

	}

	@Override
	public void delete(Iterable<? extends StaffMemberSubject> arg0) {
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
	public Iterable<StaffMemberSubject> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffMemberSubject findOne(Long id) {
		StaffMemberSubject staffSubject = em.createNamedQuery("StaffMemberSubject.findById", StaffMemberSubject.class).setParameter("id", id).getSingleResult();
		if (staffSubject != null) {
			Hibernate.initialize(staffSubject.getCourseStaff());
		}
		return staffSubject;
	}

	@Override
	public <S extends StaffMemberSubject> S save(S staffSubject) {
		logger.info("Adding link course staff subject with ID: " + staffSubject.getId());
		return this.em.merge(staffSubject);
	}

	@Override
	public <S extends StaffMemberSubject> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffMemberSubject> findAll() {
		return this.em.createNamedQuery("StaffMemberSubject.findAll", StaffMemberSubject.class).getResultList();
	}

}
