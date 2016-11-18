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

import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;

@Repository("studentEducationalLevelRepository")
public class JpaStudentEducationalLevelRepository implements StudentEducationalLevelRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentEducationalLevelRepository.class);
	
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
	public void delete(StudentEducationalLevel arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentEducationalLevel> arg0) {
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
	public Iterable<StudentEducationalLevel> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentEducationalLevel findOne(Long id) {
		return this.em.createNamedQuery("StudentEducationalLevel.findById", StudentEducationalLevel.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentEducationalLevel> S save(S studentEducationalLevel) {
		logger.info("Adding student educational level with ID " + studentEducationalLevel.getId());
		return this.em.merge(studentEducationalLevel);
	}

	@Override
	public <S extends StudentEducationalLevel> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentEducationalLevel> findAll() {
		return this.em.createNamedQuery("StudentEducationalLevel.findAll", StudentEducationalLevel.class).getResultList();
	}

}
