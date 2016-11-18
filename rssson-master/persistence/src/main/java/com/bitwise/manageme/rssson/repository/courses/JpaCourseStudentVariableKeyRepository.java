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

import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey;
import com.bitwise.manageme.rssson.domain.courses.CourseStudentVariableKey_;

@Repository("courseStudentVariableKeyRepository")
public class JpaCourseStudentVariableKeyRepository implements CourseStudentVariableKeyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseStudentVariableKeyRepository.class);
	
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
	public void delete(CourseStudentVariableKey arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseStudentVariableKey> arg0) {
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
	public Iterable<CourseStudentVariableKey> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStudentVariableKey findOne(Long id) {
		return this.em.createNamedQuery("CourseStudentVariableKey.findById", CourseStudentVariableKey.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseStudentVariableKey> S save(S studentVariableKey) {
		logger.info("Adding course student variable key with ID " + studentVariableKey.getId());
		return this.em.merge(studentVariableKey);
	}

	@Override
	public <S extends CourseStudentVariableKey> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseStudentVariableKey> findAll() {
		return this.em.createNamedQuery("CourseStudentVariableKey.findAll", CourseStudentVariableKey.class).getResultList();
	}

	@Override
	public CourseStudentVariableKey findByKey(String key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudentVariableKey> query = cb.createQuery(CourseStudentVariableKey.class);
		Root<CourseStudentVariableKey> studentVariableKey = query.from(CourseStudentVariableKey.class);
		query.select(studentVariableKey);
		query.where(cb.equal(studentVariableKey.get(CourseStudentVariableKey_.variableKey), key));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<CourseStudentVariableKey> findUserEditableCourseStudentVariableKeys() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseStudentVariableKey> query = cb.createQuery(CourseStudentVariableKey.class);
		Root<CourseStudentVariableKey> studentVariableKey = query.from(CourseStudentVariableKey.class);
		query.select(studentVariableKey);
		query.where(cb.equal(studentVariableKey.get(CourseStudentVariableKey_.userEditable), Boolean.TRUE));
		return em.createQuery(query).getResultList();
	}

}
