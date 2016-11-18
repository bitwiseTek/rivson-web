package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.courses.CourseStaffMemberRole;

@Repository("courseStaffMemberRoleRepository")
public class JpaCourseStaffMemberRoleRepository implements CourseStaffMemberRoleRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseStaffMemberRoleRepository.class);
	
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
	public void delete(CourseStaffMemberRole arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseStaffMemberRole> arg0) {
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
	public Iterable<CourseStaffMemberRole> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStaffMemberRole findOne(Long id) {
		return this.em.createNamedQuery("CourseStaffMemberRole.findById", CourseStaffMemberRole.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseStaffMemberRole> S save(S staffMemberRole) {
		logger.info("Adding course staff member role with ID " + staffMemberRole.getId());
		return this.em.merge(staffMemberRole);
	}

	@Override
	public <S extends CourseStaffMemberRole> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseStaffMemberRole> findAll() {
		return this.em.createNamedQuery("CourseStaffMemberRole.findAll", CourseStaffMemberRole.class).getResultList();
	}

}
