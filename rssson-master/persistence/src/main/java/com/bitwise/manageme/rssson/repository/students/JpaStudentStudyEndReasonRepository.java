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

import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason_;

@Repository("studentStudyEndReasonRepository")
public class JpaStudentStudyEndReasonRepository implements StudentStudyEndReasonRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentStudyEndReasonRepository.class);
	
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
	public void delete(StudentStudyEndReason endReason) {
		logger.info("Deleting student study end reason with ID " + endReason.getId());
		this.em.remove(endReason);
	}

	@Override
	public void delete(Iterable<? extends StudentStudyEndReason> arg0) {
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
	public Iterable<StudentStudyEndReason> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentStudyEndReason findOne(Long id) {
		return this.em.createNamedQuery("StudentStudyEndReason.findById", StudentStudyEndReason.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentStudyEndReason> S save(S endReason) {
		logger.info("Adding student study end reason with ID " + endReason.getId());
		return this.em.merge(endReason);
	}

	@Override
	public <S extends StudentStudyEndReason> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentStudyEndReason> findAll() {
		return this.em.createNamedQuery("StudentStudyEndReason.findAll", StudentStudyEndReason.class).getResultList();
	}

	@Override
	public List<StudentStudyEndReason> findByParentReasons(StudentStudyEndReason parentReason) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentStudyEndReason> query = cb.createQuery(StudentStudyEndReason.class);
		Root<StudentStudyEndReason> endReason = query.from(StudentStudyEndReason.class);
		query.select(endReason);
		
		if (parentReason == null) {
			cb.isNull(endReason.get(StudentStudyEndReason_.parentReason));
		} else {
			cb.equal(endReason.get(StudentStudyEndReason_.parentReason), parentReason);
		}
		
		return em.createQuery(query).getResultList();
	}

}
