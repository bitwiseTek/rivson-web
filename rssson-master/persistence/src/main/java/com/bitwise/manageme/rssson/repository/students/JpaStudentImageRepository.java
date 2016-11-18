package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 11/09/16
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
import com.bitwise.manageme.rssson.domain.students.StudentImage;
import com.bitwise.manageme.rssson.domain.students.StudentImage_;

@Repository("studentImageRepository")
public class JpaStudentImageRepository implements StudentImageRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentImageRepository.class);
	
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
	public void delete(StudentImage image) {
		logger.info("Deleting student image with ID " + image.getId());
		this.em.remove(image);
	}

	@Override
	public void delete(Iterable<? extends StudentImage> arg0) {
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
	public Iterable<StudentImage> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentImage findOne(Long id) {
		return this.em.createNamedQuery("StudentImage.findById", StudentImage.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentImage> S save(S image) {
		logger.info("Adding student image with ID " + image.getId());
		return this.em.merge(image);
	}

	@Override
	public <S extends StudentImage> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentImage> findAll() {
		return this.em.createNamedQuery("StudentImage.findAll", StudentImage.class).getResultList();
	}

	@Override
	public StudentImage findByStudent(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentImage> query = cb.createQuery(StudentImage.class);
		Root<StudentImage> image = query.from(StudentImage.class);
		query.select(image);
		query.where(cb.equal(image.get(StudentImage_.student), student));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public Boolean findStudentHasImage(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<StudentImage> image = query.from(StudentImage.class);
		query.select(cb.count(image));
		query.where(cb.equal(image.get(StudentImage_.student), student));
		return em.createQuery(query).getSingleResult() > 0;
	}

}
