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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.CourseEducationSubtype;

@Repository("courseEducationSubtypeRepository")
public class JpaCourseEducationSubtypeRepository implements CourseEducationSubtypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseEducationSubtypeRepository.class);
	
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
	public void delete(CourseEducationSubtype arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CourseEducationSubtype> arg0) {
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
	public Iterable<CourseEducationSubtype> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseEducationSubtype findOne(Long id) {
		return this.em.createNamedQuery("CourseEducationSubtype.findById", CourseEducationSubtype.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseEducationSubtype> S save(S educationSubtype) {
		logger.info("Adding course education subtype with ID " + educationSubtype.getId());
		return this.em.merge(educationSubtype);
	}

	@Override
	public <S extends CourseEducationSubtype> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseEducationSubtype> findAll() {
		return this.em.createNamedQuery("CourseEducationSubtype.findAll", CourseEducationSubtype.class).getResultList();
	}

}
