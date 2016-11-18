package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
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

import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntryComment;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntryComment_;

@Repository("studentGroupContactLogEntryCommentRepository")
public class JpaStudentGroupContactLogEntryCommentRepository implements StudentGroupContactLogEntryCommentRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentGroupContactLogEntryCommentRepository.class);
	
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
	public void delete(StudentGroupContactLogEntryComment arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentGroupContactLogEntryComment> arg0) {
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
	public Iterable<StudentGroupContactLogEntryComment> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentGroupContactLogEntryComment findOne(Long id) {
		return this.em.createNamedQuery("StudentGroupContactLogEntryComment.findById", StudentGroupContactLogEntryComment.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentGroupContactLogEntryComment> S save(S logEntryComment) {
		logger.info("Adding student group log entry comment with ID " + logEntryComment.getId());
		return this.em.merge(logEntryComment);
	}

	@Override
	public <S extends StudentGroupContactLogEntryComment> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentGroupContactLogEntryComment> findAll() {
		return this.em.createNamedQuery("StudentGroupContactLogEntryComment.findAll", StudentGroupContactLogEntryComment.class).getResultList();
	}

	@Override
	public List<StudentGroupContactLogEntryComment> findByEntries(StudentGroupContactLogEntry entry) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentGroupContactLogEntryComment> query = cb.createQuery(StudentGroupContactLogEntryComment.class);
		Root<StudentGroupContactLogEntryComment> logEntryComment = query.from(StudentGroupContactLogEntryComment.class);
		query.select(logEntryComment);
		query.where(cb.and(cb.equal(logEntryComment.get(StudentGroupContactLogEntryComment_.entry), entry), 
				cb.equal(logEntryComment.get(StudentGroupContactLogEntryComment_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
