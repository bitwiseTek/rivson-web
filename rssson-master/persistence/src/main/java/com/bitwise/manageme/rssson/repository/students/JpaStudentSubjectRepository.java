package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.students.StudentSubject;

@Repository("studentSubjectRepository")
public class JpaStudentSubjectRepository implements StudentSubjectRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentSubjectRepository.class);
	
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
	public void delete(StudentSubject studentSubject) {
		logger.info("Deleting course student subject link with ID: " + studentSubject.getId());
		this.em.remove(em.merge(studentSubject));
	}

	@Override
	public void delete(Iterable<? extends StudentSubject> arg0) {
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
	public Iterable<StudentSubject> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentSubject findOne(Long id) {
		StudentSubject studentSubject = em.createNamedQuery("StudentSubject.findById", StudentSubject.class).setParameter("id", id).getSingleResult();
		if (studentSubject != null) {
			Hibernate.initialize(studentSubject.getCourseStudents());
		}
		return studentSubject;
	}

	@Override
	@Transactional
	public <S extends StudentSubject> S save(S studentSubject) {
		logger.info("Adding course student subject with ID: " + studentSubject.getId());
		return this.em.merge(studentSubject);
	}

	@Override
	public <S extends StudentSubject> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentSubject> findAll() {
		return this.em.createNamedQuery("StudentSubject.findAll", StudentSubject.class).getResultList();
	}

	@Override
	public List<StudentSubject> findAllOne() {
		return this.em.createNamedQuery("StudentSubject.findAllOne", StudentSubject.class).getResultList();
	}

	@Override
	public List<StudentSubject> findAllTwo() {
		return this.em.createNamedQuery("StudentSubject.findAllTwo", StudentSubject.class).getResultList();
	}

	@Override
	public List<StudentSubject> findAllRegisteredOne() {
		return this.em.createNamedQuery("StudentSubject.findAllRegisteredOne", StudentSubject.class).getResultList();
	}

	@Override
	public List<StudentSubject> findAllRegisteredTwo() {
		return this.em.createNamedQuery("StudentSubject.findAllRegisteredTwo", StudentSubject.class).getResultList();
	}

}
