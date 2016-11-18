package com.bitwise.manageme.rssson.repository.courses;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
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

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.StudentCourseResource;
import com.bitwise.manageme.rssson.domain.courses.StudentCourseResource_;

@Repository("studentCourseResource")
public class JpaStudentCourseResourceRepository implements StudentCourseResourceRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentCourseResourceRepository.class);
	
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
	public void delete(StudentCourseResource courseResource) {
		logger.info("Deleting student course resource with ID " + courseResource.getId());
		this.em.remove(courseResource);	
	}

	@Override
	public void delete(Iterable<? extends StudentCourseResource> arg0) {
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
	public Iterable<StudentCourseResource> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourseResource findOne(Long id) {
		return this.em.createNamedQuery("StudentCourseResource.findById", StudentCourseResource.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentCourseResource> S save(S courseResource) {
		logger.info("Adding student course resource with ID " + courseResource.getId());
		return this.em.merge(courseResource);
	}

	@Override
	public <S extends StudentCourseResource> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCourseResource> findAll() {
		return this.em.createNamedQuery("StudentCourseResource.findAll", StudentCourseResource.class).getResultList();
	}

	@Override
	public List<StudentCourseResource> findByCourses(Course course) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentCourseResource> query = cb.createQuery(StudentCourseResource.class);
		Root<StudentCourseResource> courseResource = query.from(StudentCourseResource.class);
		query.select(courseResource);
		query.where(cb.equal(courseResource.get(StudentCourseResource_.course), course));
		return em.createQuery(query).getResultList();
	}

}
