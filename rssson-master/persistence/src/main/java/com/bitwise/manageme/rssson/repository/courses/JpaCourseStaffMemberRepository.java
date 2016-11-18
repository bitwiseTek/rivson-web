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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember_;

@Repository("courseStaffMemberRepository")
public class JpaCourseStaffMemberRepository implements CourseStaffMemberRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseStaffMemberRepository.class);
	
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
	public void delete(CourseStaffMember staffMember) {
		logger.info("Deleting course staff member with ID " + staffMember.getId());
		this.em.remove(staffMember);
	}

	@Override
	public void delete(Iterable<? extends CourseStaffMember> arg0) {
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
	public Iterable<CourseStaffMember> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStaffMember findOne(Long id) {
		return this.em.createNamedQuery("CourseStaffMember.findById", CourseStaffMember.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseStaffMember> S save(S staffMember) {
		logger.info("Adding course staff member with ID " + staffMember.getId());
		return this.em.merge(staffMember);
	}

	@Override
	public <S extends CourseStaffMember> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseStaffMember> findAll() {
		return this.em.createNamedQuery("CourseStaffMember.findAll", CourseStaffMember.class).getResultList();
	}

	@Override
	public List<CourseStaffMember> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStaffMember> query = cb.createQuery(CourseStaffMember.class);
		Root<CourseStaffMember> staffMember = query.from(CourseStaffMember.class);
		query.select(staffMember);
		query.where(cb.equal(staffMember.get(CourseStaffMember_.course), course));
		return em.createQuery(query).getResultList();
	}

}
