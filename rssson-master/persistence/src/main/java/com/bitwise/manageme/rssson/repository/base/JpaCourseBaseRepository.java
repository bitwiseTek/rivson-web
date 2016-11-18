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
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.CourseBase;

@Repository("courseBaseRepository")
public class JpaCourseBaseRepository implements CourseBaseRepository {

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
	public void delete(CourseBase base) {
		logger.info("Deleting course base with ID " + base.getId());
		this.em.remove(em.merge(base));
	}

	@Override
	public void delete(Iterable<? extends CourseBase> arg0) {
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
	public Iterable<CourseBase> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseBase findOne(Long id) {
		return this.em.createNamedQuery("CourseBase.findById", CourseBase.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseBase> S save(S courseBase) {
		logger.info("Adding course base with ID " + courseBase.getId());
		return this.em.merge(courseBase);
	}

	@Override
	public <S extends CourseBase> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseBase> findAll() {
		return this.em.createNamedQuery("CourseBase.findAll", CourseBase.class).getResultList();
	}

	@Override
	public CourseBase findByName(String name) {
		TypedQuery<CourseBase> query = em.createNamedQuery("CourseBase.findByName", CourseBase.class).setParameter("name", name);
		List<CourseBase> names = query.getResultList();
		return names.size() == 1 ? names.get(0) : null;
	}

	@Override
	public CourseBase findByCode(String courseCode) {
		TypedQuery<CourseBase> query = em.createNamedQuery("CourseBase.findByCourseCode", CourseBase.class).setParameter("courseCode", courseCode);
		List<CourseBase> codes = query.getResultList();
		return codes.size() == 1 ? codes.get(0) : null;
	}

}
