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

import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentGroupContactLogEntry_;

@Repository("studentGroupContactLogEntryRepository")
public class JpaStudentGroupContactLogEntryRepository implements StudentGroupContactLogEntryRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentGroupContactLogEntryRepository.class);
	
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
	public void delete(StudentGroupContactLogEntry arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentGroupContactLogEntry> arg0) {
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
	public Iterable<StudentGroupContactLogEntry> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentGroupContactLogEntry findOne(Long id) {
		return this.em.createNamedQuery("StudentGroupContactLogEntry.findById", StudentGroupContactLogEntry.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentGroupContactLogEntry> S save(S logEntry) {
		logger.info("Adding student group log entry with ID " + logEntry.getId());
		return this.em.merge(logEntry);
	}

	@Override
	public <S extends StudentGroupContactLogEntry> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentGroupContactLogEntry> findAll() {
		return this.em.createNamedQuery("StudentGroupContactLogEntry.findAll", StudentGroupContactLogEntry.class).getResultList();
	}

	@Override
	public List<StudentGroupContactLogEntry> findByStudentGroups(StudentGroup group) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentGroupContactLogEntry> query = cb.createQuery(StudentGroupContactLogEntry.class);
		Root<StudentGroupContactLogEntry> logEntry = query.from(StudentGroupContactLogEntry.class);
		query.select(logEntry);
		query.where(cb.and(cb.equal(logEntry.get(StudentGroupContactLogEntry_.studentGroup), group), 
				cb.equal(logEntry.get(StudentGroupContactLogEntry_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
