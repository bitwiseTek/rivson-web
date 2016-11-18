package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
//import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.StaffMember_;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.UserVariable;
import com.bitwise.manageme.rssson.domain.users.UserVariable_;
import com.bitwise.manageme.rssson.domain.users.User_;

@Repository("staffMemberRepository")
public class JpaStaffMemberRepository implements StaffMemberRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStaffMemberRepository.class);
	
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
	public void delete(StaffMember staffMember) {
		logger.info("Deleting staff member with ID " + staffMember.getId());
		this.em.remove(staffMember);
	}

	@Override
	public void delete(Iterable<? extends StaffMember> arg0) {
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
	public Iterable<StaffMember> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffMember findOne(Long id) {
		return this.em.createNamedQuery("StaffMember.findById", StaffMember.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StaffMember> S save(S staffMember) {
		logger.info("Adding staff member with ID " + staffMember.getId());
		return this.em.merge(staffMember);
	}

	@Override
	public <S extends StaffMember> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffMember> findAll() {
		return this.em.createNamedQuery("StaffMember.findAll", StaffMember.class).getResultList();
	}

	@Override
	public List<StaffMember> findByUserVariables(String key, String value) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StaffMember> query = cb.createQuery(StaffMember.class);
		Root<StaffMember> staffMember = query.from(StaffMember.class);
		Root<UserVariable> userVariable = query.from(UserVariable.class);
		Join<UserVariable, User> userJoin = userVariable.join(UserVariable_.user);
		query.select(staffMember);
		query.where(cb.and(cb.equal(userVariable.get(UserVariable_.key), key), 
				cb.equal(userVariable.get(UserVariable_.value), value), 
				cb.equal(userVariable.get(UserVariable_.user), userJoin), 
				cb.equal(userJoin.get(User_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<StaffMember> findByNotRoles(String role, Integer firstResult, Integer maxResult) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StaffMember> query = cb.createQuery(StaffMember.class);
		Root<StaffMember> staffMember = query.from(StaffMember.class);
		query.select(staffMember);
		query.where(cb.and(cb.equal(staffMember.get(StaffMember_.role), role), 
				cb.equal(staffMember.get(StaffMember_.archived), Boolean.FALSE)));
		
		TypedQuery<StaffMember> typedQuery = em.createQuery(query);
		
		if (firstResult != null) {
			typedQuery.setFirstResult(firstResult);
		}
		
		if (maxResult != null) {
			typedQuery.setMaxResults(maxResult);
		}
		return typedQuery.getResultList();
	}
	
	@Override
	public Page<StaffMember> findAll(Pageable pageable) {
		TypedQuery<StaffMember> query = em.createQuery("select s from StaffMember s", StaffMember.class);
		Page<StaffMember> staffPage = new PageImpl<StaffMember>(query.getResultList());
		return staffPage;
	}

	@Override
	public StaffMember findByStaffId(String staffId) {
		TypedQuery<StaffMember> query = em.createNamedQuery("StaffMember.findByStaffId", StaffMember.class).setParameter("staffId", staffId);
		List<StaffMember> staff = query.getResultList();
		return staff.size() == 1 ? staff.get(0) : null;
	}

	@Override
	public Page<StaffMember> findByStaffId(String staffId, Pageable pageable) {
		TypedQuery<StaffMember> query = em.createNamedQuery("StaffMember.findByStaffId", StaffMember.class).setParameter("staffId", staffId);
		Page<StaffMember> staffPage = new PageImpl<StaffMember>(query.getResultList());
		return staffPage;
	}

	@Override
	public Iterable<StaffMember> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public List<StaffMember> findByUniqueEmails(Email email) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StaffMember> query = cb.createQuery(StaffMember.class);
		Root<StaffMember> staffMember = query.from(StaffMember.class);
		Join<StaffMember, ContactInfo> contactInfoJoin = staffMember.join(StaffMember_.contactInfo);
		ListJoin<ContactInfo, Email> emailJoin = (ListJoin) contactInfoJoin.join(ContactInfo_.emails);
		Join<Email, ContactType> contactTypeJoin = emailJoin.join(Email_.contactType);
		query.select(staffMember);
		query.where(cb.and(cb.equal(emailJoin.get(Email_.address), email), 
				cb.equal(contactTypeJoin.get(ContactType_.nonUnique), Boolean.FALSE), 
				cb.equal(staffMember.get(StaffMember_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}*/

	//TO DO
	//1. searchUsersBasic()
	//2. searchUsers()
}
