package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
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

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariable;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariable_;
import com.bitwise.manageme.rssson.domain.courses.Course;

@Repository("courseBaseVariableRepository")
public class JpaCourseBaseVariableRepository implements CourseBaseVariableRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseBaseRepository.class);
	
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
	public void delete(CourseBaseVariable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseBaseVariable> arg0) {
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
	public Iterable<CourseBaseVariable> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseBaseVariable findOne(Long id) {
		return this.em.createNamedQuery("CourseBaseVariable.findById", CourseBaseVariable.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseBaseVariable> S save(S baseVariable) {
		logger.info("Adding course base variable with ID " + baseVariable.getId());
		return this.em.merge(baseVariable);
	}

	@Override
	public <S extends CourseBaseVariable> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseBaseVariable> findAll() {
		return this.em.createNamedQuery("CourseBaseVariable.findAll", CourseBaseVariable.class).getResultList();
	}

	@Override
	public CourseBaseVariable findByCourseAndVariableKey(Course course, CourseBaseVariableKey key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseBaseVariable> query = cb.createQuery(CourseBaseVariable.class);
		Root<CourseBaseVariable> baseVariable = query.from(CourseBaseVariable.class);
		query.select(baseVariable);
		query.where(cb.and(cb.equal(baseVariable.get(CourseBaseVariable_.courseBase), course),
				cb.equal(baseVariable.get(CourseBaseVariable_.key), key)));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<CourseBaseVariable> findByCourseBase(CourseBase courseBase) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseBaseVariable> query = cb.createQuery(CourseBaseVariable.class);
		Root<CourseBaseVariable> baseVariable = query.from(CourseBaseVariable.class);
		query.select(baseVariable);
		query.where(cb.equal(baseVariable.get(CourseBaseVariable_.courseBase), courseBase));
		return em.createQuery(query).getResultList();
	}
	
	//TO DO
	//1. setCourseVariable(Course course, String key, String value)
	//2. findByCourseAndVariableKey(Course course, String key)

}
