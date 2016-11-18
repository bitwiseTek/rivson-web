package com.bitwise.manageme.rssson.repository.file;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
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

import com.bitwise.manageme.rssson.domain.file.StudentFile;
import com.bitwise.manageme.rssson.domain.file.StudentFile_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("studentFileRepository")
public class JpaStudentFileRepository implements StudentFileRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentFileRepository.class);
	
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
	public void delete(StudentFile arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentFile> arg0) {
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
	public Iterable<StudentFile> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentFile findOne(Long id) {
		return this.em.createNamedQuery("StudentFile.findById", StudentFile.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentFile> S save(S studentFile) {
		logger.info("Adding a student file with ID " + studentFile.getId());
		return this.em.merge(studentFile);
	}

	@Override
	public <S extends StudentFile> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentFile> findAll() {
		return this.em.createNamedQuery("StudentFile.findAll", StudentFile.class).getResultList();
	}

	@Override
	public List<StudentFile> findByStudent(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentFile> query = cb.createQuery(StudentFile.class);
		Root<StudentFile> studentFile = query.from(StudentFile.class);
		query.select(studentFile);
		query.where(cb.and(cb.equal(studentFile.get(StudentFile_.student), student), 
				cb.equal(studentFile.get(StudentFile_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
