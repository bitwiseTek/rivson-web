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

import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;

@Repository("studentExaminationTypeRepository")
public class JpaStudentExaminationTypeRepository implements StudentExaminationTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentExaminationTypeRepository.class);
	
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
	public void delete(StudentExaminationType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentExaminationType> arg0) {
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
	public Iterable<StudentExaminationType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentExaminationType findOne(Long id) {
		return this.em.createNamedQuery("StudentExaminationType.findById", StudentExaminationType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentExaminationType> S save(S examinationType) {
		logger.info("Adding examination type with ID " + examinationType.getId());
		return this.em.merge(examinationType);
	}

	@Override
	public <S extends StudentExaminationType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentExaminationType> findAll() {
		return this.em.createNamedQuery("StudentExaminationType.findAll", StudentExaminationType.class).getResultList();
	}

}
