package com.bitwise.manageme.rssson.repository.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.help.StudentManual;

@Repository("studentManualRepository")
public class JpaStudentManualRepository implements StudentManualRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentManualRepository.class);
	
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
	public void delete(StudentManual arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentManual> arg0) {
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
	public Iterable<StudentManual> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentManual findOne(Long id) {
		return this.em.createNamedQuery("StudentManual.findById", StudentManual.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentManual> S save(S studentManual) {
		logger.info("Adding student manual with ID: " + studentManual.getId());
		return this.em.merge(studentManual);
	}

	@Override
	public <S extends StudentManual> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentManual> findAll() {
		return this.em.createNamedQuery("StudentManual.findAll", StudentManual.class).getResultList();
	}


	@Override
	public StudentManual findByVersion(String manualVersion) {
		TypedQuery<StudentManual> query = em.createNamedQuery("StudentManual.findByVersion", StudentManual.class).setParameter("manualVersion", manualVersion);
		List<StudentManual> manuals = query.getResultList();
		return manuals.size() == 1 ? manuals.get(0) : null;
	}

}
