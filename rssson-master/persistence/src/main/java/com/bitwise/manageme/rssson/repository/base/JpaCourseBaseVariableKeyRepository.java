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

import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey_;

@Repository("courseBaseVariableKeyRepository")
public class JpaCourseBaseVariableKeyRepository implements CourseBaseVariableKeyRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseBaseVariableKeyRepository.class);
	
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
	public void delete(CourseBaseVariableKey arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseBaseVariableKey> arg0) {
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
	public Iterable<CourseBaseVariableKey> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseBaseVariableKey findOne(Long id) {
		return this.em.createNamedQuery("CourseBaseVariableKey.findById", CourseBaseVariableKey.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseBaseVariableKey> S save(S baseVariableKey) {
		logger.info("Adding course base variable key with ID " + baseVariableKey.getId());
		return this.em.merge(baseVariableKey);
	}

	@Override
	public <S extends CourseBaseVariableKey> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseBaseVariableKey> findAll() {
		return this.em.createNamedQuery("CourseBaseVariableKey.findAll", CourseBaseVariableKey.class).getResultList();
	}

	@Override
	public CourseBaseVariableKey findByVariableKey(String key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseBaseVariableKey> query = cb.createQuery(CourseBaseVariableKey.class);
		Root<CourseBaseVariableKey> baseVariableKey = query.from(CourseBaseVariableKey.class);
		query.select(baseVariableKey);
		query.where(cb.equal(baseVariableKey.get(CourseBaseVariableKey_.variableKey), key));
		return em.createQuery(query).getSingleResult();
	}

}
