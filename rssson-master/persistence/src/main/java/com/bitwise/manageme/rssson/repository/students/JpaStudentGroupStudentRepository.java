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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupStudent;
import com.bitwise.manageme.rssson.domain.students.StudentGroupStudent_;

@Repository("studentGroupStudentRepository")
public class JpaStudentGroupStudentRepository implements StudentGroupStudentRepository {
	final Logger logger = LoggerFactory.getLogger(JpaStudentGroupStudentRepository.class);
	
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
	public void delete(StudentGroupStudent studentGroupStudent) {
		logger.info("Deleting student group student with ID " + studentGroupStudent.getId());
		this.em.remove(studentGroupStudent);
	}

	@Override
	public void delete(Iterable<? extends StudentGroupStudent> arg0) {
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
	public Iterable<StudentGroupStudent> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentGroupStudent findOne(Long id) {
		return this.em.createNamedQuery("StudentGroupStudent.findById", StudentGroupStudent.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentGroupStudent> S save(S studentGroupStudent) {
		logger.info("Adding student group student with ID " + studentGroupStudent.getId());
		return this.em.merge(studentGroupStudent);
	}

	@Override
	public <S extends StudentGroupStudent> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentGroupStudent> findAll() {
		return this.em.createNamedQuery("StudentGroupStudent.findAll", StudentGroupStudent.class).getResultList();
	}

	@Override
	public StudentGroupStudent findByStudentGroupAndStudent(StudentGroup group, Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentGroupStudent> query = cb.createQuery(StudentGroupStudent.class);
		Root<StudentGroupStudent> studentGroupStudent = query.from(StudentGroupStudent.class);
		query.select(studentGroupStudent);
		query.where(cb.and(cb.equal(studentGroupStudent.get(StudentGroupStudent_.student), student), 
				cb.equal(studentGroupStudent.get(StudentGroupStudent_.studentGroup), group)));
		return em.createQuery(query).getSingleResult();
	}

}
