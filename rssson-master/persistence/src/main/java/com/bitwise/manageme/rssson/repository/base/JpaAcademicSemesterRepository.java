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

import com.bitwise.manageme.rssson.domain.base.AcademicSemester;

@Repository("academicSemester")
public class JpaAcademicSemesterRepository implements AcademicSemesterRepository {

	final Logger logger = LoggerFactory.getLogger(JpaAcademicSemesterRepository.class);
	
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
	public void delete(AcademicSemester arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends AcademicSemester> arg0) {
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
	public Iterable<AcademicSemester> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AcademicSemester findOne(Long id) {
		return this.em.createNamedQuery("AcademicSemester.findById", AcademicSemester.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends AcademicSemester> S save(S semester) {
		logger.info("Adding academic semster with ID " + semester.getId());
		return this.em.merge(semester);
	}

	@Override
	public <S extends AcademicSemester> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AcademicSemester> findAll() {
		return this.em.createNamedQuery("AcademicSemester.findAll", AcademicSemester.class).getResultList();
	}

}
