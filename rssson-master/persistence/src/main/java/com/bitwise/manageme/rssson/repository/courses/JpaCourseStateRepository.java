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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.courses.CourseState;

@Repository("courseStateRepository")
public class JpaCourseStateRepository implements CourseStateRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseStateRepository.class);
	
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
	public void delete(CourseState arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseState> arg0) {
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
	public Iterable<CourseState> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseState findOne(Long id) {
		return this.em.createNamedQuery("CourseState.findById", CourseState.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseState> S save(S courseState) {
		logger.info("Adding course state with ID " + courseState.getId());
		return this.em.merge(courseState);
	}

	@Override
	public <S extends CourseState> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseState> findAll() {
		return this.em.createNamedQuery("CourseState.findAll", CourseState.class).getResultList();
	}

}
