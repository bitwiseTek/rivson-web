package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.users.StaffMemberImage;

@Repository("staffImageRepository")
public class JpaStaffMemberImageRepository implements StaffMemberImageRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStaffMemberImageRepository.class);
	
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
	public void delete(StaffMemberImage staffImage) {
		logger.info("Deleting staff image with ID " + staffImage.getId());
		this.em.remove(em.merge(staffImage));
	}

	@Override
	public void delete(Iterable<? extends StaffMemberImage> arg0) {
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
	public Iterable<StaffMemberImage> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffMemberImage findOne(Long id) {
		return this.em.createNamedQuery("StaffMemberImage.findById", StaffMemberImage.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StaffMemberImage> S save(S image) {
		logger.info("Adding staff image with ID " + image.getId());
		return this.em.merge(image);
	}

	@Override
	public <S extends StaffMemberImage> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffMemberImage> findAll() {
		return this.em.createNamedQuery("StaffMemberImage.findAll", StaffMemberImage.class).getResultList();
	}

	/*@Override
	public StaffMemberImage findByStaff(StaffMember student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean findStaffHasImage(StaffMember student) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
