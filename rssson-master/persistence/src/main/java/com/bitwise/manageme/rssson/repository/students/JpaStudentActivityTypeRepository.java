package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.students.StudentActivityType;

@Repository("studentActivityTypeRepository")
public class JpaStudentActivityTypeRepository implements StudentActivityTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentActivityTypeRepository.class);
	
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
	public void delete(StudentActivityType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentActivityType> arg0) {
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
	public Iterable<StudentActivityType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentActivityType findOne(Long id) {
		return this.em.createNamedQuery("StudentActivityType.findById", StudentActivityType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentActivityType> S save(S activityType) {
		logger.info("Adding student activity type with ID " + activityType.getId());
		return this.em.merge(activityType);
	}

	@Override
	public <S extends StudentActivityType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentActivityType> findAll() {
		return this.em.createNamedQuery("StudentActivityType.findAll", StudentActivityType.class).getResultList();
	}

}
