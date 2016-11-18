package com.bitwise.manageme.rssson.repository.projects;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
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

import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;
import com.bitwise.manageme.rssson.domain.projects.StudentProject_;
import com.bitwise.manageme.rssson.domain.students.Student;

@Repository("studentProjectRepository")
public class JpaStudentProjectRepository implements StudentProjectRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudentProjectRepository.class);
	
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
	public void delete(StudentProject arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends StudentProject> arg0) {
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
	public Iterable<StudentProject> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentProject findOne(Long id) {
		return this.em.createNamedQuery("StudentProject.findById", StudentProject.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudentProject> S save(S studentProject) {
		logger.info("Adding student project with ID " + studentProject.getId());
		studentProject.setCreated(new Date(System.currentTimeMillis()));
		return this.em.merge(studentProject);
	}

	@Override
	public <S extends StudentProject> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentProject> findAll() {
		return this.em.createNamedQuery("StudentProject.findAll", StudentProject.class).getResultList();
	}

	@Override
	public List<StudentProject> findByStudents(Student student) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentProject> query = cb.createQuery(StudentProject.class);
		Root<StudentProject> studentProject = query.from(StudentProject.class);
		query.select(studentProject);
		query.where(cb.and(cb.equal(studentProject.get(StudentProject_.student), student), 
				cb.equal(studentProject.get(StudentProject_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<StudentProject> findByProjects(Project project) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<StudentProject> query = cb.createQuery(StudentProject.class);
		Root<StudentProject> studentProject = query.from(StudentProject.class);
		query.select(studentProject);
		query.where(cb.and(cb.equal(studentProject.get(StudentProject_.project), project), 
				cb.equal(studentProject.get(StudentProject_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}
	//TO DO
	//1. searchProjectsBasic()
	//2. searchProjects()
}
