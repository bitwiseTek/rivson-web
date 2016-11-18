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

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariable;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariable_;

@Repository("courseStudentVariable")
public class JpaCourseStudentVariableRepository implements CourseStudentVariableRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseStudentVariableRepository.class);
	
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
	public void delete(CourseStudentVariable studentVariable) {
		logger.info("Deleting course student variable with ID " + studentVariable.getId());
		this.em.remove(studentVariable);
	}

	@Override
	public void delete(Iterable<? extends CourseStudentVariable> arg0) {
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
	public Iterable<CourseStudentVariable> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStudentVariable findOne(Long id) {
		return this.em.createNamedQuery("CourseStudentVariable.findById", CourseStudentVariable.class).setParameter("id", id).getSingleResult();

	}

	@Override
	public <S extends CourseStudentVariable> S save(S studentVariable) {
		logger.info("Adding course student variable key with ID " + studentVariable.getId());
		return this.em.merge(studentVariable);
	}

	@Override
	public <S extends CourseStudentVariable> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseStudentVariable> findAll() {
		return this.em.createNamedQuery("CourseStudentVariable.findAll", CourseStudentVariable.class).getResultList();
	}

	@Override
	public CourseStudentVariable findByCourseStudentAndKey(CourseStudent student, CourseStudentVariableKey key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudentVariable> query = cb.createQuery(CourseStudentVariable.class);
		Root<CourseStudentVariable> studentVariable = query.from(CourseStudentVariable.class);
		query.select(studentVariable);
		query.where(cb.and(cb.equal(studentVariable.get(CourseStudentVariable_.key), key), 
				cb.equal(studentVariable.get(CourseStudentVariable_.courseStudent), student)));
		return em.createQuery(query).getSingleResult();
	}

}
