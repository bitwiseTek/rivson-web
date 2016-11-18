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

import com.bitwise.manageme.rssson.domain.students.StudentGroupUser;

@Repository("studentGroupUserRepository")
public class JpaStudentGroupUserRepository implements StudentGroupUserRepository {
	
	final Logger logger = LoggerFactory.getLogger(JpaStudentGroupUserRepository.class);
	
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
	public void delete(StudentGroupUser studentGroupUser) {
		logger.info("Deleting student group user with ID " + studentGroupUser.getId());
		this.em.remove(studentGroupUser);
	}

	@Override
	public void delete(Iterable<? extends StudentGroupUser> arg0) {
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
	public Iterable<StudentGroupUser> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentGroupUser findOne(Long id) {
		return this.em.createNamedQuery("StudentGroupUser.findById", StudentGroupUser.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentGroupUser> S save(S studentGroupUser) {
		logger.info("Adding student group user with ID " + studentGroupUser.getId());
		return this.em.merge(studentGroupUser);
	}

	@Override
	public <S extends StudentGroupUser> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentGroupUser> findAll() {
		return this.em.createNamedQuery("StudentGroupUser.findAll", StudentGroupUser.class).getResultList();
	}

}
