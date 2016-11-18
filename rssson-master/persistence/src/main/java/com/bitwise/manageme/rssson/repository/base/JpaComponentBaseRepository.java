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

import com.bitwise.manageme.rssson.domain.base.ComponentBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey_;

@Repository("componentBaseRepository")
public class JpaComponentBaseRepository implements ComponentBaseRepository {

	final Logger logger = LoggerFactory.getLogger(JpaComponentBaseRepository.class);
	
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
	public void delete(ComponentBase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ComponentBase> arg0) {
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
	public Iterable<ComponentBase> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComponentBase findOne(Long id) {
		return this.em.createNamedQuery("ComponentBase.findById", ComponentBase.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ComponentBase> S save(S componentBase) {
		logger.info("Adding a component base with ID " + componentBase.getId());
		return this.em.merge(componentBase);
	}

	@Override
	public <S extends ComponentBase> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComponentBase> findAll() {
		return this.em.createNamedQuery("ComponentBase.findAll", ComponentBase.class).getResultList();
	}

	@Override
	public CourseBaseVariableKey findByVariableKey(String key) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<CourseBaseVariableKey> query = cb.createQuery(CourseBaseVariableKey.class);
		Root<CourseBaseVariableKey> variableKey = query.from(CourseBaseVariableKey.class);
		query.select(variableKey);
		query.where(cb.equal(variableKey.get(CourseBaseVariableKey_.variableKey), key));
		return em.createQuery(query).getSingleResult();
	}

}
