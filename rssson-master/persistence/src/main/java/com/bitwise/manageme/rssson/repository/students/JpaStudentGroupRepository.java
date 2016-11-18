package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.Date;
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
import com.bitwise.manageme.rssson.domain.students.StudentGroup_;

@Repository("studentGroupRepository")
public class JpaStudentGroupRepository implements StudentGroupRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentGroupRepository.class);
	
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
	public void delete(StudentGroup arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentGroup> arg0) {
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
	public Iterable<StudentGroup> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentGroup findOne(Long id) {
		return this.em.createNamedQuery("StudentGroup.findById", StudentGroup.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentGroup> S save(S studentGroup) {
		logger.info("Adding student group with ID " + studentGroup.getId());
		studentGroup.setCreated(new Date(System.currentTimeMillis()));
		return this.em.merge(studentGroup);
	}

	@Override
	public <S extends StudentGroup> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentGroup> findAll() {
		return this.em.createNamedQuery("StudentGroup.findAll", StudentGroup.class).getResultList();
	}

	@Override
	public List<StudentGroup> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentGroup> query = cb.createQuery(StudentGroup.class);
		Root<StudentGroup> studentGroup = query.from(StudentGroup.class);
		query.select(studentGroup);
		query.where(cb.and(cb.equal(studentGroup.get(StudentGroup_.student), student), 
				cb.equal(studentGroup.get(StudentGroup_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}
	//To Do
	//1. searchStudentGroups()
	//2. searchStudentGroupsBasic()
}
