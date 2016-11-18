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

import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntryComment;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntryComment_;

@Repository("studentContactLogEntryCommentRepository")
public class JpaStudentContactLogEntryCommentRepository implements StudentContactLogEntryCommentRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentContactLogEntryCommentRepository.class);
	
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
	public void delete(StudentContactLogEntryComment arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentContactLogEntryComment> arg0) {
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
	public Iterable<StudentContactLogEntryComment> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentContactLogEntryComment findOne(Long id) {
		return this.em.createNamedQuery("StudentContactLogEntryComment.findById", StudentContactLogEntryComment.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentContactLogEntryComment> S save(S studentContactLogEntryComment) {
		logger.info("Adding student contact log entry comment with ID " + studentContactLogEntryComment.getId());
		return this.em.merge(studentContactLogEntryComment);
	}

	@Override
	public <S extends StudentContactLogEntryComment> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentContactLogEntryComment> findAll() {
		return this.em.createNamedQuery("StudentContactLogEntryComment.findAll", StudentContactLogEntryComment.class).getResultList();
	}

	@Override
	public List<StudentContactLogEntryComment> findByEntries(StudentContactLogEntry entry) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentContactLogEntryComment> query = cb.createQuery(StudentContactLogEntryComment.class);
		Root<StudentContactLogEntryComment> studentContactLogEntryComment = query.from(StudentContactLogEntryComment.class);
		query.select(studentContactLogEntryComment);
		query.where(cb.and(cb.equal(studentContactLogEntryComment.get(StudentContactLogEntryComment_.entry), entry), 
				cb.equal(studentContactLogEntryComment.get(StudentContactLogEntryComment_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
