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

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry_;

@Repository("studentContactLogEntryRepository")
public class JpaStudentContactLogEntryRepository implements StudentContactLogEntryRepository {
	
	final Logger logger = LoggerFactory.getLogger(JpaStudentContactLogEntryRepository.class);
	
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
	public void delete(StudentContactLogEntry arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentContactLogEntry> arg0) {
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
	public Iterable<StudentContactLogEntry> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentContactLogEntry findOne(Long id) {
		return this.em.createNamedQuery("StudentContactLogEntry.findById", StudentContactLogEntry.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentContactLogEntry> S save(S studentContactLogEntry) {
		logger.info("Adding student contact log entry with ID " + studentContactLogEntry.getId());
		return this.em.merge(studentContactLogEntry);
	}

	@Override
	public <S extends StudentContactLogEntry> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentContactLogEntry> findAll() {
		return this.em.createNamedQuery("StudentContactLogEntry.findAll", StudentContactLogEntry.class).getResultList();
	}

	@Override
	public List<StudentContactLogEntry> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentContactLogEntry> query = cb.createQuery(StudentContactLogEntry.class);
		Root<StudentContactLogEntry> studentContactLogEntry = query.from(StudentContactLogEntry.class);
		query.select(studentContactLogEntry);
		query.where(cb.and(cb.equal(studentContactLogEntry.get(StudentContactLogEntry_.student), student), 
				cb.equal(studentContactLogEntry.get(StudentContactLogEntry_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
