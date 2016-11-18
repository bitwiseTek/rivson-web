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

import com.bitwise.manageme.rssson.domain.base.CourseEducationType;

@Repository("courseEducationType")
public class JpaCourseEducationTypeRepository implements CourseEducationTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaCourseEducationTypeRepository.class);
	
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
	public void delete(CourseEducationType educationType) {
		logger.info("Deleting course education type with ID " + educationType.getId());
		this.em.remove(educationType);
	}

	@Override
	public void delete(Iterable<? extends CourseEducationType> arg0) {
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
	public Iterable<CourseEducationType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseEducationType findOne(Long id) {
		return this.em.createNamedQuery("CourseEducationType.findById", CourseEducationType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends CourseEducationType> S save(S educationType) {
		logger.info("Adding course education type with ID " + educationType.getId());
		return this.em.merge(educationType);
	}

	@Override
	public <S extends CourseEducationType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseEducationType> findAll() {
		return this.em.createNamedQuery("CourseEducationType.findAll", CourseEducationType.class).getResultList();
	}

}
