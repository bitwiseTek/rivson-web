package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.Grade;

@Repository("gradeRepository")
public class JpaGradeRepository implements GradeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaGradeRepository.class);
	
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
	public void delete(Grade grade) {
		logger.info("Deleting grade with ID " + grade.getId());
		this.em.remove(em.merge(grade));
	}

	@Override
	public void delete(Iterable<? extends Grade> arg0) {
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
	public Iterable<Grade> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grade findOne(Long id) {
		return this.em.createNamedQuery("Grade.findById", Grade.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Grade> S save(S grade) {
		logger.info("Adding grade with ID " + grade.getId());
		return this.em.merge(grade);
	}

	@Override
	public <S extends Grade> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> findAll() {
		return this.em.createNamedQuery("Grade.findAll", Grade.class).getResultList();
	}

	@Override
	public Grade findByName(String grade) {
		TypedQuery<Grade> query = em.createNamedQuery("Grade.findByName", Grade.class).setParameter("grade", grade);
		List<Grade> grades = query.getResultList();
		return grades.size() == 1 ? grades.get(0) : null;
	}

}
