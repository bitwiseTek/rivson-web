package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.students.StudentManualPDF;

@Repository("studentManualPDFRepository")
public class JpaStudentManualPDFRepository implements StudentManualPDFRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentManualPDFRepository.class);
	
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
	public void delete(StudentManualPDF arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentManualPDF> arg0) {
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
	public Iterable<StudentManualPDF> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentManualPDF findOne(Long id) {
		return this.em.createNamedQuery("StudentManualPDF.findById", StudentManualPDF.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentManualPDF> S save(S manualPDF) {
		logger.info("Adding manual with ID: " + manualPDF.getId());
		return this.em.merge(manualPDF);
	}

	@Override
	public <S extends StudentManualPDF> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentManualPDF> findAll() {
		return this.em.createNamedQuery("StudentManualPDF.findAll", StudentManualPDF.class).getResultList();
	}

}
